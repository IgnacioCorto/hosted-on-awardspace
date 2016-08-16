import java.sql.*;

public class PrintDB {

	public static void main(String args[]) {

		Connection con; 
		
		try{

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Temp");
			Statement stmt = con.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stmt.executeQuery("SELECT * FROM COFFEES");

			System.out.println(
				"Fetch Size: " + rst.getFetchSize() + "\n\n" 
			);

			// if ( rst.isBeforeFirst() )
			// System.out.println( "-Before First-");

			int ii = 0;
			rst.next() ;

			while( rst.isAfterLast()==false ) {
				ii++;
				System.out.println(
				"=== Record #" + ii + " ===\n" +
				"Coffe Name : " + rst.getString("COF_NAME") + "\n" +
				"Coffe Id   : " + rst.getString("SUP_ID") + "\n" +
				"Coffe Price: " + rst.getString("PRICE") + "\n" +
				"Coffe Sales: " + rst.getString("SALES") + "\n" +
				"Coffe Total: " + rst.getString("TOTAL") + "\n\n"
				);
				rst.next() ;
			}

		}

		catch(ClassNotFoundException e){

			System.out.println(e.toString());

		}
		catch(SQLException e){

			System.out.println(e.toString());

		}

	}

}