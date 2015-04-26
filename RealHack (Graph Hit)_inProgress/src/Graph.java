
public class Graph {
    Node start=new Node();
        
    public void create(Object db[][],int no)
    {
        for (int i = 0; i < 2; i++) {
                Object tem_obj = db[i][1];
                process_row(start,db[i],tem_obj);
        }
        for (int i = 1;i <= 3; i++)
        {
           int j=0;
           Node group = start;
           Subnode sub_group;
           while(j<i-1)
           {
               group = group.link;
           }
           sub_group = group.level;
           Object tem_obj = "";
           while(sub_group != null)
           {
               process_row(group.link,sub_group,tem_obj);
               sub_group = sub_group.getNext();
           }
               
        }
  
    }
    private void process_row(Node head ,Object db[],Object tem_obj)
    {
        if(head==null)
        {
            Subnode obj=new Subnode(db);
            Node temp = new Node(tem_obj,obj);
        }
        else
        {
            Node temp = start;
            Subnode sub_node = new Subnode();
            //Object tem_obj = db[1];
            int flag = 0;
            while(temp!=null)
            {
                if(tem_obj.equals(temp.data))
                {
                    sub_node = temp.level;
                    flag = 1;
                    break;
                }
                temp = temp.getNext();
            }
            if(flag == 0)
            {
              temp = start;
              temp.add_node(temp, tem_obj, sub_node);
            }
            else
            {
               Subnode sub_temp = sub_node;
               sub_temp.add_node(sub_node, db);
            }
        }
    }
    
    
    private void process_row(Node head ,Subnode sub_group,Object tem_obj)
    {
        if(head==null)
        {
            Subnode obj=new Subnode(sub_group);
            Node temp = new Node(tem_obj,obj);
        }
        else
        {
            Node temp = start;
            Subnode sub_node = new Subnode();
            //Object tem_obj = db[1];
            int flag = 0;
            while(temp!=null)
            {
                if(tem_obj.equals(temp.data))
                {
                    sub_node = temp.level;
                    flag = 1;
                    break;
                }
                temp = temp.getNext();
            }
            if(flag == 0)
            {
              temp = start;
              temp.add_node(temp, tem_obj, sub_node);
            }
            else
            {
               Subnode sub_temp = sub_node;
               sub_temp.add_node(sub_node, sub_group);
            }
        }
    }

}

class Subnode{
     Subnode next;
        
        static Object name="",city="",area="",price="",req="";
        
        
        public Subnode()
        {}
        
        public Subnode(Object[] dataValue) {
            next = null;
            name=dataValue[0];
            city=dataValue[1];
            area=dataValue[2];
            price=dataValue[3];
            req=dataValue[4];
        }
        
        public Subnode(Subnode dataValue) {
            next = null;
            name=dataValue.name;
            city=dataValue.city;
            area=dataValue.area;
            price=dataValue.price;
            req=dataValue.req;
        }
    
     public Subnode(Object dataValue[], Subnode nextValue) {
            next = nextValue;
            name=dataValue[0];
            city=dataValue[1];
            area=dataValue[2];
            price=dataValue[3];
            req=dataValue[4];
        }
 
        // these methods should be self-explanatory
        public Subnode getData() {
            return this;
        }
 
        public void setData(Object[] dataValue) {
            name=dataValue[0];
            city=dataValue[1];
            area=dataValue[2];
            price=dataValue[3];
            req=dataValue[4];
        }
 
        public void newnode(Object[] dataValue) {
            name=dataValue[0];
            city=dataValue[1];
            area=dataValue[2];
            price=dataValue[3];
            req=dataValue[4];
            next = null;
        }
        
        public Subnode getNext() {
            return next;
        }
        
        public void setNext(Subnode nextValue) {
            next = nextValue;
        }
        
        public void add_node(Subnode node,Object[] data)
        {
            Subnode Temp = new Subnode(data);
            Subnode Current = node;
            // crawl to the requested index or the last element in the list,
            // whichever comes first
            while (Current.getNext() != null) {
            Current = Current.getNext();
            }
                
            // now set this node's next-node reference to the new node
            Current.setNext(Temp);
        }
        
        public void add_node(Subnode node,Subnode Temp)
        {
            //Subnode Temp = new Subnode(data);
            Subnode Current = node;
            // crawl to the requested index or the last element in the list,
            // whichever comes first
            while (Current.getNext() != null) {
            Current = Current.getNext();
            }
                
            // now set this node's next-node reference to the new node
            Current.setNext(Temp);
        }
    
}

class Node{
    Object data="";
    Subnode level=new Subnode();
    Node next,link;
    public Node()
    {}
     public Node(Object dataValue) {
            next = null;
            link = null;
            data = dataValue;
        }
     public Node(Object dataValue,Subnode obj) {
            next = null;
            link = null;
            data = dataValue;
            level = obj;
        }
    
     public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }
 
        // these methods should be self-explanatory
        public Object getData() {
            return data;
        }
 
        public void setData(Object dataValue) {
            data = dataValue;
        }
        
        public void setData(Object dataValue,Subnode obj) {
            data = dataValue;
            level = obj;
        }
        
        public void newnode(Object dataValue,Subnode obj) {
            data = dataValue;
            level = obj;
            next = null;
            link = null;
        }
 
        public Node getNext() {
            return next;
        }
        
        public void setNext(Node nextValue) {
            next = nextValue;
        }
        
        public void add_node(Node node,Object data,Subnode obj)
        {
            Node Temp = new Node(data,obj);
            Node Current = node;
            // crawl to the requested index or the last element in the list,
            // whichever comes first
            while (Current.getNext() != null) {
            Current = Current.getNext();
            }
                
            // now set this node's next-node reference to the new node
            Current.setNext(Temp);
        }
        
        }