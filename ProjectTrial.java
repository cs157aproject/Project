import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectTrial
{
   private static String make;
   private static String model;
   private static String year;
   private static String litres;
   private static String engine;
   private static String cubic;
   private static String RLink;
   private static String desc;
   private Connection con;
   private static String findTable;

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

            System.out.println("Welcome!!!\n");
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
         
         Scanner scIn = new Scanner(System.in);
         System.out.print("Select a Car make: ");
         make = scIn.next();
         
         findTable(con);
      }
      
      
      public static void findTable(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT APLNAME FROM APLLIST WHERE MAKER='"+make.toUpperCase()+"'";
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
               findTable = rs.getString(i);
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
         
         queryModels(con);
      }
      public static void queryModels(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT MODEL FROM " + findTable + " GROUP BY MODEL ORDER BY MODEL ASC";
        

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
         
         Scanner scIn = new Scanner(System.in);
         System.out.print("Select a Model : ");
         model = scIn.next();
         
         queryYears(con);
      }
      
      public static void queryYears(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT YEAR FROM " + findTable + " WHERE MODEL ='" + model.toUpperCase() + "' GROUP BY YEAR ORDER BY YEAR ASC";
        

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
         
         Scanner scIn = new Scanner(System.in);
         System.out.print("Select a Year : ");
         year = scIn.next();
         
         queryLitres(con);
         
      }
      
      public static void queryLitres(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT LITRES FROM " + findTable + " WHERE MODEL ='" + model.toUpperCase() + "' GROUP BY LITRES ORDER BY LITRES ASC";
        

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
         
         Scanner scIn = new Scanner(System.in);
         System.out.print("Select Litres : ");
         litres = scIn.next();
         
         queryEngines(con);
      }
      
      public static void queryEngines(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT ENGINE_TYPE FROM " + findTable + " WHERE MODEL ='" + model.toUpperCase() + "' GROUP BY ENGINE_TYPE ORDER BY ENGINE_TYPE ASC";
        

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
         
         Scanner scIn = new Scanner(System.in);
         System.out.print("Select Engine Type: ");
         engine = scIn.next();
         
         queryCubicInches(con);
                  
      }
      
      public static void queryCubicInches(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT CUBIC_INCHES FROM " + findTable + " WHERE MODEL ='" + model.toUpperCase() + "' GROUP BY CUBIC_INCHES ORDER BY CUBIC_INCHES ASC";
        

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
         
         Scanner scIn = new Scanner(System.in);
         System.out.print("Select Cubic Inches Type: ");
         cubic = scIn.next();
         
         queryDescription(con);
                  
      }
      
      public static void queryDescription(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT DESCRIPTION FROM " + findTable + " WHERE MODEL ='" + model.toUpperCase() + "' GROUP BY DESCRIPTION ORDER BY DESCRIPTION ASC";
        

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
         
         Scanner scIn = new Scanner(System.in);
         System.out.print("Select Description: ");
         desc = scIn.next();
         
         findRLink(con);
                  
      }
     
      public static void findRLink(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT RLINK from " + findTable.toUpperCase() + " WHERE MODEL= '" + model.toUpperCase() + "' AND YEAR='" + year.toUpperCase() + "' AND LITRES='" + litres.toUpperCase() + "' AND ENGINE_TYPE='" + engine.toUpperCase() + "' AND CUBIC_INCHES='" + cubic.toUpperCase() + "' AND DESCRIPTION='" + desc.toUpperCase() + "'";

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
                  RLink = rs.getString(i);
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
         
         listParts(con);
      }
      
      
      
      public static void listParts(Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT * FROM RADCRX WHERE RLINK ='" + RLink.toUpperCase() + "'";
        ArrayList<String> list = new ArrayList<String>();
        list.add("RDIMARS");
        list.add("RDIMARS");
        list.add("RDIMARS");
        list.add("RDIMARS");
        list.add("RDIMMOD");
        list.add("RDIMMOD");
        list.add("RDIMMOD");
        list.add("RDIMMOD");
        list.add("RDIMBEH");
        list.add("RDIMBEH");
        list.add("RDIMBEH");
        list.add("RDIMBEH");
        list.add("RDIMDAN");
        list.add("RDIMDAN");
        list.add("RDIMDAN");
        list.add("RDIMDAN");

         try
         {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);
            while(rs.next())
            try
            {
               int i = 2;
               while(true)
               {
                  if(rs.getString(i) != null) {
                     list(list.get(i-2), rs.getString(i), con);
                  }
                     
                    
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
      
      public static void list(String table, String filter, Connection con)
      {
         ResultSet rs = null;
         String stmntStr = "SELECT * FROM " + table.toUpperCase() + " WHERE P_NUMBER = '" + filter.toUpperCase() + "'";

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
