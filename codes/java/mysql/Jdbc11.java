import java.sql.*;

public class Jdbc11 {
  public static void main(String args[]){
    System.out.println(
                  "Conexion a MySQL");
    try {
      Class.forName("com.mysql.jdbc.Driver");        //#1
      String url = "jdbc:mysql://localhost" ;
      Connection con = DriverManager.getConnection(  //#2
                         url, "root", "");
      System.out.println("URL: " + url);
      System.out.println("Connection: " + con);
      Statement stmt = con.createStatement();        //#3
      stmt.executeUpdate(                            //#4
                       "CREATE DATABASE JunkDB");
      stmt.executeUpdate(
          "GRANT SELECT,INSERT,UPDATE,DELETE," +
          "CREATE,DROP " +
          "ON JunkDB.* TO 'auser'@'localhost' " +
          "IDENTIFIED BY 'drowssap';");
      con.close(); // Not necessary to work
      
    }catch( Exception e ) {
      e.printStackTrace();
    }//end catch
  }//end main
}//end class Jdbc11