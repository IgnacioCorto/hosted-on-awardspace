import java.sql.*;

public class Jdbc11 {
  public static void main(String args[]){
    System.out.println(
                  "Copyright 2004, R.G.Baldwin");
    try {
      Statement stmt;
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://localhost";
      Connection con =
                     DriverManager.getConnection(
                                 url,"root", "");
      System.out.println("URL: " + url);
      System.out.println("Connection: " + con);
      stmt = con.createStatement();
      stmt.executeUpdate(
                       "CREATE DATABASE JunkDB");
      stmt.executeUpdate(
          "GRANT SELECT,INSERT,UPDATE,DELETE," +
          "CREATE,DROP " +
          "ON JunkDB.* TO 'auser'@'localhost' " +
          "IDENTIFIED BY 'drowssap';");
      con.close();
    }catch( Exception e ) {
      e.printStackTrace();
    }//end catch
  }//end main
}//end class Jdbc11