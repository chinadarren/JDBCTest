import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Created by lei.chen on 4/27/2015.
 */
//数据库连接
public class TestJDB {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/words";
    private static final String USER = "root";
    public static final String PASSWORD = "system";

    public static Connection getConnection() {

        try {
            new Driver();
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//输出连接信息
    public static void main(String[] args) throws Exception{
        //测试数据库连接
        System.out.println(getConnection());
        //Create Connection Entity
        Connection conn = getConnection();
        //Create Statement Entity
        Statement stmt = conn.createStatement();
        //通过Statemnet 执行SQL语句 返回给ResultSet
        ResultSet rs = stmt.executeQuery("select * from user");
        //遍历ResultSet取出数据
        while (rs.next()){
            System.out.println(rs.getString("id"));
        }
        //关闭连接
        rs.close();
        stmt.close();
        conn.close();
    }
}