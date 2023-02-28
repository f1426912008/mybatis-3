package com.it.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * SQL语句构建器。通过代码动态生成sql语句
 */
public final class StudentProvider {

    /**
     * 根据条件查询学生表
     * @return
     */
    public String queryByCondition() {
        return new SQL()
                .SELECT("*")
                .FROM("student")
                .WHERE("1 = 1")
                .WHERE("name = #{name}")
                .ORDER_BY("grade desc")
                .toString();
    }
}
