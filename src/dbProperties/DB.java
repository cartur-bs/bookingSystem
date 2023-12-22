package dbProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    //database info
    private static final String url = "jdbc:mysql://localhost:3306/Bookings"; //database name at the end
    private static final  String uname = "root";
    private static final String password="root1234";
    private static Connection con = null;
    public static Connection getConnection() throws SQLException {
        if(con==null){
            try{
            con = DriverManager.getConnection(url, uname, password);
        }catch(SQLException e){
          throw new dbException(e.getMessage());
        }}
        return con;
    }
    public static void closeConnection(){
        if(con != null){
            try{
                con.close();
            }catch (SQLException e){
                throw new dbException(e.getMessage());
            }
        }
    }
   /* private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("jdbcConnector")){
            Properties prop = new Properties();
            prop.load(fs);
            return prop;
        }  catch (IOException e) {
            throw new dbException(e.getMessage());
        }
    }*/
}