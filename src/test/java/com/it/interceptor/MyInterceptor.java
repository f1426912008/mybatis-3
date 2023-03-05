package com.it.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Intercepts(value = {
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
        ),
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        ),
        @Signature(
                type = ParameterHandler.class,
                method = "setParameters",
                args = {PreparedStatement.class}
        ),
        @Signature(
                type = ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class}
        ),
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        ),
})
public class MyInterceptor implements Interceptor {

    // 自定义的属性赋值
    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Object target = invocation.getTarget();
        Method method = invocation.getMethod();

        if (target instanceof Executor) {
            System.out.println("SimpleExecutor");
            return appendLimit((Executor) target, args);
        } else if (target instanceof DefaultParameterHandler) {
            System.out.println("DefaultParameterHandler");
        } else if (target instanceof DefaultResultSetHandler) {
            System.out.println("DefaultResultSetHandler");
        } else if (target instanceof RoutingStatementHandler) {
            System.out.println("RoutingStatementHandler");
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        // 官方推荐使用的方法，为目标对象生成代理对象
        return Plugin.wrap(target, this);
        // return target;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * 拼接分页语句，替换原始sql
     *
     * @param executor
     * @param args
     * @return
     * @throws SQLException
     */
    private List<Object> appendLimit(Executor executor, Object[] args) throws SQLException {
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];
        CacheKey cacheKey;
        BoundSql boundSql;
        if (args.length == 4) {
            System.out.println("四参数查询");
            boundSql = ms.getBoundSql(parameter);
            cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
        } else {
            System.out.println("六参数查询");
            cacheKey = (CacheKey) args[4];
            boundSql = (BoundSql) args[5];
        }
        String sql = boundSql.getSql();
        if (sql.endsWith(";")) sql = sql.replace(";", " ");

        String pageNum = Optional.ofNullable(properties.getProperty("pageNum")).orElse("1");
        String pageSize = Optional.ofNullable(properties.getProperty("pageSize")).orElse(new BigDecimal(Integer.MAX_VALUE).toString());
        String limitSql = sql + " LIMIT " + pageNum + ", " + pageSize + ";";
        BoundSql limitBoundSql = new BoundSql(ms.getConfiguration(), limitSql, ms.getParameterMap().getParameterMappings(), parameter);
        return executor.query(ms, parameter, rowBounds, resultHandler, cacheKey, limitBoundSql);
    }

}
