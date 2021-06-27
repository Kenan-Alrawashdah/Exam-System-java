
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class concat {

    
    
    public static Connection connectD(){
        try{
            System.out.println("kenanhhhhhhhhhhhh");
          Class.forName("org.sqlite.JDBC");
         Connection conn=DriverManager.getConnection("jdbc:sqlite:Datab.db");
              //JOptionPane.showMessageDialog(null,"connect");
               return conn;
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
   
    
}
