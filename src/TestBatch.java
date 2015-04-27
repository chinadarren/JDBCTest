import com.mysql.jdbc.Driver;
import java.sql.*;

/**
 * Created by lei.chen on 4/27/2015.
 *
 * Batch
 *  批处理
 */
public class TestBatch {


    private static final String  URL = "jdbc:mysql://127.0.0.1:3306/words";
    private static final String  USER = "root";
    private static final String  PASSWORD = "system";

    public static Connection getConnection(){
        try {
            new Driver();
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
       Connection conn=null;
        conn=getConnection();

   /* try {
            Statement stmt = conn.createStatement();
            stmt.addBatch("INSERT INTO user VALUES (null,'liu1','liu')");
            stmt.addBatch("INSERT INTO user VALUES (null,'liu2','liu')");
            stmt.addBatch("INSERT INTO user VALUES (null,'liu3','liu')");
            stmt.executeBatch();
            stmt.close();
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    */
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES (null,?,?) ");
            ps.setString(1,"haha1");
            ps.setString(2,"haha");
            ps.addBatch();

            ps.setString(1,"haha2");
            ps.setString(2,"haha");
            ps.addBatch();

            ps.setString(1,"haha3");
            ps.setString(2,"haha");
            ps.addBatch();

            ps.executeBatch();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}