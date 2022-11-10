package com.company.db.impl;

import com.company.db.DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelperImpl implements DBHelper {
    @Override
    public PreparedStatement getConnection(String sql) {
        try {
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/task_manager_db","postgres","postgres");
            return connection.prepareStatement(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при подключении к базе данных");
        }
    }
}
