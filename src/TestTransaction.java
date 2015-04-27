import com.mysql.jdbc.Driver;
import java.sql.*;

/**
 * Created by lei.chen on 4/27/2015.
 *
 * Transaction 业务同步
 */
public class TestTransaction {

private static final String URL = "jdbc:mysql://127.0.0.1:3306/words";
    private static final String USER = "root";
    private static final String PASSWORD = "system";

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

        Connection conn =getConnection();
        Statement stmt = null;

        try {
            //关闭自动提交
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.addBatch("INSERT INTO user VALUES (null,'abc1','abc')");
            stmt.addBatch("INSERT INTO user VALUES (null,'abc2','abc')");
            stmt.addBatch("INSERT INTO user VALUES (null,'abc3','abc')");
            stmt.executeBatch();
            //手动提交
            conn.commit();
            //恢复自动提交
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                if(conn != null){
                    //如果数据出错不同步回滚
                    conn.rollback();
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
          try {
              if (stmt != null) {
                  stmt.close();
              }
              if (conn != null) {
                  conn.close();
              }
          }catch (SQLException e){
         e.printStackTrace();
          }
        }

    }
}
