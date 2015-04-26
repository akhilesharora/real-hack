
import java.io.*;


public class Land {
    static Object city="",area="",minp="",maxp="",mreq="",mxreq="",purpose="";
    public static void getProperty() throws Exception
    {   File f=new File("data.xml");
        BufferedReader br=new BufferedReader(new FileReader(f));
        Object a[]=br.readLine().split(">");
//        if((""+a[7]).split("<")[0].equals("House"))
//        {
//        
//        }
        city=(""+a[9]).split("<")[0];
        area=(""+a[11]).split("<")[0];
        minp=(""+a[13]).split("<")[0];
        maxp=(""+a[15]).split("<")[0];
        mreq=(""+a[17]).split("<")[0];
        mxreq=(""+a[19]).split("<")[0];
        purpose=(""+a[21]).split("<")[0];
        
    }
    
    public static void print()
    {System.out.println("City = "+city+"\nArea = "+area+"\nMinPrice = "+minp+"\nMaxPrice = "
            +maxp+"\nMinReqa = "+mreq+"\nMaxReq = "+mxreq+"\nPurpose = "+purpose);}
    
    public static void execute()
{System.out.println("Land");}
    
}
