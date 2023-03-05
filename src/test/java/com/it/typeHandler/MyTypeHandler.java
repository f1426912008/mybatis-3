package com.it.typeHandler;

import com.it.bean.Address;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Address.class)
@MappedJdbcTypes(value = JdbcType.VARCHAR)
public class MyTypeHandler extends BaseTypeHandler<Address> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Address parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, getAddress(parameter));
    }

    @Override
    public Address getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getAddress(rs.getString(columnName));
    }

    @Override
    public Address getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getAddress(rs.getString(columnIndex));
    }

    @Override
    public Address getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getAddress(cs.getString(columnIndex));
    }

    /**
     * Address --> String
     *
     * @param parameter Address
     * @return String
     */
    private String getAddress(Address parameter) {
        return parameter.getCountry() + "-" + parameter.getProvince() + "-" + parameter.getCity();
    }

    /**
     * String --> Address
     *
     * @param parameter String
     * @return Address
     */
    private Address getAddress(String parameter) {
        Address address = new Address();
        if (parameter != null) {
            String[] split = parameter.split("-");
            address.setCountry(split[0]);
            address.setProvince(split[1]);
            address.setCity(split[2]);
        }
        return address;
    }

}
