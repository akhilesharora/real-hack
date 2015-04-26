
import java.io.*;


public class Req {
    
    public void execute() throws Exception
    {
        SQL sql =new SQL();
        String db[][]=sql.query2D("select * from record;");
        Graph graph=new Graph();
        graph.create(db,1200);
        File f=new File("data.xml");
        BufferedReader br=new BufferedReader(new FileReader(f));
        Object a[]=br.readLine().split(">");
        if((""+a[7]).split("<")[0].equals("House"))
        {Housing obj=new Housing();
        obj.getProperty();
        obj.execute();
        }
        else if((""+a[7]).split("<")[0].equals("Land"))
        {Land obj=new Land();
        obj.getProperty();
        obj.execute();}
        else if((""+a[7]).split("<")[0].equals("Office"))
        {Office obj=new Office();
        obj.getProperty();
        obj.execute();}
    }
    
}
