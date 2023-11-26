package com.pj.sayyo.webCrawling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class HowToSaveCrawler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public void insertData(Map<String, String> data) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        String sql = "INSERT INTO your_table(title, content, link, pressInfo, time, image) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, data.get("title"));
        pstmt.setString(2, data.get("content"));
        pstmt.setString(3, data.get("link"));
        pstmt.setString(4, data.get("pressInfo"));
        pstmt.setString(5, data.get("time"));
        pstmt.setString(6, data.get("image"));

        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }
}
