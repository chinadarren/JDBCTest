import com.mysql.jdbc.Driver;
import java.sql.*;

/**
 * Created by lei.chen on 4/27/2015.
 *
 * PreparedStatement
 */
public class TestDML2 {
    private static final String  URL = "jdbc:mysql://127.0.0.1:3306/words";
    private static final String  USER = "root";
    private static final String  PASSWORD = "system";

    public static Connection getConnection(){

        try {
            new Driver();
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Connection conn = null;
        //使用PreaparedStatement
        PreparedStatement pstmt = null;
        String name = "liu";
        String pwd = "liu";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("insert into user VALUES (NULL ,?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2,pwd);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt !=null){
                pstmt.close();}
                if(conn !=null){
                conn.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
