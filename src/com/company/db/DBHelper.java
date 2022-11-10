package com.company.db;

import java.sql.PreparedStatement;

public interface DBHelper {
    PreparedStatement getConnection(String sql);
}
