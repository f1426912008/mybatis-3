package com.it.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

@Intercepts(value = {
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}
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

        if (target instanceof SimpleExecutor) {
            System.out.println("SimpleExecutor");
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
}
