package bankmanagementsystem;

// adding all the required libraries 

//hello deepanshu sahil here
import java.sql.*;

public class connection {
    
    //making global objects for c,s and connecton and statement 
    Connection c;
    Statement s;
    public connection(){

        //error handling is important here because mysql is an external software which is more likely to give error 
        try {
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","2004");//connection to mysqldatabase
            s=c.createStatement();//this is used when we need to use some mysql statements



        }catch (Exception e) {
            System.out.println(e);//giving the error that may have occured


        }

    }
    public PreparedStatement prepareStatement(String query){
        return null;
        
    }
    
  


}











