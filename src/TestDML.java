import java.sql.*;
import com.mysql.jdbc.Driver;

/**
* Created by lei.chen on 4/27/2015.
*/
public class TestDML {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/words";
    private static final String USER="root";
    private static final String PASSWORD="system";

    public static Connection getConnection(){
        try {
            new Driver();
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Statement stmt= null;
        Connection conn = null;

         try {
            conn = getConnection();
            stmt = conn.createStatement();
             //插入
            String sql = "insert into user values (null,'chen','chen' )";
            stmt.executeUpdate(sql);

       }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                stmt.close();}
                if(conn != null){
                    conn.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        }
}
