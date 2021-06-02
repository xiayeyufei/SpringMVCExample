package com.example.springmvcexample.mybatis.typehandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringJoiner;

public abstract class StringTokenizerTypeHandler<T> extends BaseTypeHandler<T[]> {
    private Class<T> clazz;

    public StringTokenizerTypeHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T[] ts, JdbcType jdbcType) throws SQLException {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (T value : ts) {
            stringJoiner.add(value.toString());
        }
        ps.setString(i, stringJoiner.toString());
    }

    @Override
    public T[] getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return toArray(resultSet.getString(columnName));
    }

    @Override
    public T[] getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return toArray(resultSet.getString(columnIndex));
    }

    @Override
    public T[] getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return toArray(callableStatement.getString(columnIndex));
    }

    private T[] toArray(String columnValue) {
        if (columnValue == null || columnValue.trim().isEmpty()) {
            return createArray(0);
        }
        String[] values = columnValue.split(",");
        T[] array = createArray(values.length);
        for (int i = 0; i < values.length; i++) {
            array[i] = parseString(values[i]);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int size) {
        return (T[]) Array.newInstance(clazz, size);
    }
    public abstract T parseString(String value);

}
