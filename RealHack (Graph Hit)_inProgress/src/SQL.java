
import java.sql.*;


public class SQL {
    
    public static void create()
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");

      stmt = c.createStatement();
      String sql =  "CREATE TABLE IF NOT EXISTS record " +
                    "(name           text,"+
                    "city            text,"+
                    "dist            text,"+
                    "price           text,"+
                    "area            text);";
               
          
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
  }
     public static void create2()
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");

      stmt = c.createStatement();
      String sql =  "CREATE TABLE IF NOT EXISTS history "+
                    "(email         text,"+
                    "phno           text,"+
                    "city           text,"+
                    "dist           text,"+
                    "op             text,"+
                    "subop          text,"+
                    "minp           text,"+
                    "maxp           text,"+
                    "mreq           text,"+
                    "mxreq          text,"+
                    "bhk            text);";
               
          
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
  }
    
    
    
    public static String[] queryR(String query)
  {
    Connection c = null;
    Statement stmt = null;
    ResultSet rs=null;
    String a[];
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      rs = stmt.executeQuery( query );
      a=extractR(rs);
    rs.close();
    stmt.close();
    c.close();
    return a;
      
    } catch ( Exception e ) {
       e.printStackTrace();
    }
    String b[]=new String[1];
    b[0]="error";
    return b;
    
  }
    
    public static String[][] query2D(String query)
  {
    Connection c = null;
    Statement stmt = null;
    ResultSet rs=null;
    String a[][];
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      rs = stmt.executeQuery( query );
      a=extract2D(rs);
    rs.close();
    stmt.close();
    c.close();
    return a;
      
    } catch ( Exception e ) {
       e.printStackTrace();
    }
    String b[][]=new String[1][1];
    b[0][0]="error";
    return b;
    
  }
    public static String[] queryRH(String query)
  {
    Connection c = null;
    Statement stmt = null;
    ResultSet rs=null;
    String a[];
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      rs = stmt.executeQuery( query );
      a=extractRH(rs);
    rs.close();
    stmt.close();
    c.close();
    return a;
      
    } catch ( Exception e ) {
       e.printStackTrace();
    }
    String b[]=new String[1];
    b[0]="error";
    return b;
    
  }
    
    public static String[] query(String query,String field)
  {String a[];
    Connection c = null;
    Statement stmt = null;
    ResultSet rs=null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      rs = stmt.executeQuery( query );
      a=extract(rs,field);
      rs.close();
      stmt.close();
      c.close();
      return a;
    } catch ( Exception e ) {
       e.printStackTrace();
    }
    String b[]=new String[1];
    b[0]="error";
    return b;
  }
    public static void update(String query)
  {
    Connection c = null;
    Statement stmt = null;
    ResultSet rs=null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      stmt.executeUpdate( query );
      stmt.close();      
      c.commit();
      c.close();
      
    } catch ( Exception e ) {
       e.printStackTrace();
    }
    
  }
    
    
    public static String[] extractR(ResultSet rs)
    {   int i=0;String a[]=new String[5];String b[]=new String[9];
        /*selects most recent record*/
        try{while(rs.next())
            {
            a[0]=rs.getString("Name");
            a[1]=rs.getString("city");
            a[2]=rs.getString("dist");
            a[3]=rs.getString("price");
            a[4]=rs.getString("area");
            i++;
            
            
            }
        
        }
    catch(Exception e)
        {}
       return a;
        
    }
    
    public static String[][] extract2D(ResultSet rs)
    {   int i=0; 
    String a[][]=new String[100][5];
        /*selects most recent record*/
        try{while(rs.next())
            {
            a[i][0]=rs.getString("Name");
            a[i][1]=rs.getString("city");
            a[i][2]=rs.getString("dist");
            a[i][3]=rs.getString("price");
            a[i][4]=rs.getString("area");
            i++;
            
            
            }
        
        }
    catch(Exception e)
        {}
       return a;
        
    }
    
    public static String[] extractRH(ResultSet rs)
    {   int i=0;String a[]=new String[11];
        /*selects most recent record*/
        try{while(rs.next())
            {
            a[0]=rs.getString("email");
            a[1]=rs.getString("phno");
            a[2]=rs.getString("city");
            a[3]=rs.getString("dist");
            a[4]=rs.getString("minp");
            a[5]=rs.getString("maxp");
            a[6]=rs.getString("mreq");
            a[7]=rs.getString("mxreq");
            a[8]=rs.getString("op");
            a[9]=rs.getString("subop");
            a[10]=rs.getString("bhk");
            i++;
            
            
            }
        
        }
    catch(Exception e)
        {}
       return a;
        
    }
    public static void copy(String a[],String b[])
{
    for (int i = 0; i < b.length; i++) {
        b[i]=a[i];
    }
}
    public static String[] extract(ResultSet rs,String field)
    {   String a[]=new String[3000];int i=0;
        
        try{while(rs.next())
            {a[i]=rs.getString(field);   
            i++;
            }
        }
    catch(Exception e)
        {e.printStackTrace();}
        String b[]=new String[i];
        copy(a,b);
        
        try{rs.close();}
        catch(Exception e){e.printStackTrace();}
    return b;
        
    }
    
    public static void insert(String a[])
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "INSERT INTO record "+
                   "VALUES (\""+a[0]+"\", \""+a[1]+"\", \""+a[2]+"\", \""+a[3]+"\", \""+a[4]+"\");";
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
    
  }
    
    public static void insertUser(String a[])
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "INSERT INTO history "+
//              "(ID,date,NAME,AGE,sex,wt,temp,pulse,bp,com,fin,dia,"
//              + "med1,dos1,dur1,med2,dos2,dur2,med3,dos3,dur3,med4,dos4,dur4,med5,dos5,dur5,med6,dos6,dur6) " +
                   "VALUES (\""+a[0]+"\", \""+a[1]+"\", \""+a[2]+"\",\""+a[3]+"\", \""+a[4]+"\", \""+a[5]
              +"\", \""+a[6]+"\", \""+a[7]+"\", \""+a[8]+"\", \""+a[9]+"\", \""+a[10]+"\");";
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
    
  }
    
    
    
     public static void insertS(String a1,String field)
  { a1=a1.trim();
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql;
      try{
      sql = "INSERT INTO "+field+
                   " VALUES (\""+a1+"\");"; 
      stmt.executeUpdate(sql);
      }catch(Exception e){}
      
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
    
  }
            
          public static void main(String args[])
          {
              /*
              insertS("TAB BEPLEX FORTE","med");
              String b[]=query("select * from MED;","med");
//              String a[]=new String[30];           
////              insert(a);
//              String b[]=extract(query("Select * from med;"),"med");
              for (int i = 0; i < b.length; i++) {
                  System.out.println(b[i]);
              }
                      */
          }
            
}
