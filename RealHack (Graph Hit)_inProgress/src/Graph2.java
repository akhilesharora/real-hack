import java.io.*;
import java.util.*;
public class Graph2 {
    
    public static void main(String args[]) throws Exception
    {   /*File f=new File("data.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        SQL obj=new SQL();
        Object a[][]=obj.query2D("select * from record;");
        bw.write(a[0][0]+"~"+a[0][1]+"~"+a[0][2]+"~"+a[0][3]+"~"+a[0][4]+"\n");
        for (int i = 1; i < a.length; i++) {
            bw.append(a[i][0]+"~"+a[i][1]+"~"+a[i][2]+"~"+a[i][3]+"~"+a[i][4]+"\n");
        }
        bw.close();
        System.out.println(a.length);*/
        Scanner s=new Scanner(new File("data.dat"));
        int x=(int)System.currentTimeMillis()%10000;
        String var=s.nextLine();
        try{
        while(var!=null)
        {String rec[]=var.split("~");
        if(rec[1].equals("Bangalore")&&rec[2].equals("HAL"))
        {System.out.println(var);break;}
        var=s.nextLine();
        }
        }catch(Exception e){}
        System.out.println(((int)System.currentTimeMillis()%10000-x)+"ms");
        
    }
}
