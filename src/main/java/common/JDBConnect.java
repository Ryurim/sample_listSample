package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBConnect {
    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public JDBConnect() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url="jdbc:mariadb://localhost:3306/sample";
            String dbId = "root";
            String dbPwd = "1234";

            conn = DriverManager.getConnection(url, dbId, dbPwd);

        } catch(Exception e) {
            System.out.println("db 연결 실패");
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
