import java.sql.*;
import java.util.Scanner;

public class ProjectTrial
{
   private static String make;
   private String model;
   private String year;
   private String litres;
   private String engine;
   private String cubic;
   private Connection con;

   private final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
   private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:oraDB";
   private final String USER_ID = "scott";
   private final String PASSWORD = "tiger";

   public ProjectTrial()
   {
         try
         {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER_ID, PASSWORD);

            System.out.println("Welcome!!!");
         }

         catch (SQLException ex)
         {
            System.err.println(ex.getMessage());
         }
         catch (ClassNotFoundException ex)
         {
            System.err.println(ex.getMessage());
         }

      }

      /** get the database connection object */
      public Connection getDBConnection()
      {
         return this.con;
      }

      /** Disconnect from the database */
      public void disconnectFromDB()
      {
         try
         {
            con.close();
            System.out.println("Disconnected from DB!");
         }
         catch (SQLException e)
         {
            System.err.println(e.getMessage());
         }
      }

      public static void queryMakes(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT MAKER from APLLIST";

         try
         {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);
            while(rs.next())
            try
            {
               int i = 1;
               while(true)
               {
                  System.out.print(rs.getString(i) + " ");
                  i++;
               }
            }
            catch(Exception e)
            {

            }
            finally
            {
               System.out.println();
            }

         }
         catch (SQLException ex)
         {
            System.err.println(ex.getMessage());
         }
      }
   public static void main(String args[])
   {
      ProjectTrial dbc = new ProjectTrial();
      Connection con = dbc.getDBConnection();

      queryMakes(con);

   }


}
