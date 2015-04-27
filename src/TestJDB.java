import java.sql.*;
import com.mysql.jdbc.Driver;
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
//关闭连接
    public static void close(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection) {

        if(resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ((preparedStatement != null)){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
//输出连接信息
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}