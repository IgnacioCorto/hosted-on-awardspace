import java.sql.*;

public class Temp {

    public static void main(String args[]) {

        Connection con; // The connection to the database.
        // The following code can throw errors, so they must be caught.
        try{

              // First, tell Java what driver to use and where to find it.
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              // Next, create a connection to your data source.
              // Specify that you are using the ODBC-JDBC Bridge.
              // And specify the data source from ODBC.
              con = DriverManager.getConnection("jdbc:odbc:Temp");
              // Create an SQL statement.
              Statement stmt = con.createStatement();
              // Execute some SQL to create a table in your database.
              // If the table already exists, an exception is thrown!
              stmt.executeUpdate("CREATE TABLE COFFEES " +
              "(COF_NAME VARCHAR(32), SUP_ID INTEGER, PRICE FLOAT, " +
              "SALES INTEGER, TOTAL INTEGER)");

        }
        // Catch any exceptions that are thrown.
        catch(ClassNotFoundException e){

              System.out.println(e.toString());

        }
        catch(SQLException e){

              System.out.println(e.toString());

        }

    }

}