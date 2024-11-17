package bankmanagementsystem;
//importing all the important libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


//declaring the class and then using extends to use Jframe(present in other defalut class) and using implements to access ActionListner(it is a interface)
public class Login extends JFrame implements ActionListener{

    //making buttos ,textfields and password field globally available as we require them also in other functions or code of same project and also to give them implementation
    JButton login,clear,signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;

   Login(){
        setTitle("AUTOMATED TELLER MACHINE");//giving title to the frame 


        setLayout(null);//used when we want to give our own parametrs to tae effect like x,y,height,width of button ,textfield etc.
        ImageIcon i1=new ImageIcon(getClass().getResource("icons/logo.jpg"));//new object for ImageIcon class which is used to add photo to our frame ,here we give the path to our photo that is to be used 
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //setting dimensions of the photo that we are using in the frame
        ImageIcon i3=new ImageIcon(i2);//creatng because object of Image class can not be passed in JLabel ,it takes objects of ImageIcon class as input 
        JLabel label=new JLabel(i3);//creating the label that is used to enter the image into the frame 
        label.setBounds(70,10,100,100); //setting the dimensions that is used to place the image at correct place in the frame 
        add(label); //adding the label to the frame

        //creating the label that is used to add the written text to the frame and also defining it's dimesions and also its placement in the frame 
        JLabel text =new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        //Creating another label and also adding it's dimension and placemnt in the frame 
        JLabel cardno =new JLabel("Card no:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        //creating a text field where user can enter data and also specifying it's dimensions and placement in the frame 
        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,250,30);
        cardtextfield.setFont(new Font("Arial",Font.BOLD ,14));
        add(cardtextfield);

        //Creating another label and also adding it's dimension and placemnt in the frame 
        JLabel pin =new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,400,30);
        add(pin);

        //creating a password field (here the input data is not visible to the user )where user can enter data and also specifying it's dimensions and placement in the frame 
        pintextfield=new JPasswordField();
        pintextfield.setBounds(300,220,250,30);
        pintextfield.setFont(new Font("Arial",Font.BOLD ,14));
        add(pintextfield);



        //creating the sign in button with required dimensions and parameters
        //also adding the action listener that is a part of the interface 
        login =new JButton("Sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);
       
        //creating the clear button with required dimensions and parameters
        //also adding the action listener that is a part of the interface 
        clear = new JButton("Clear");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);

        //creating the sign up button with required dimensions and parameters
        //also adding the action listener that is a part of the interface 
        signup = new JButton("Sign UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);


        //setting the dimensions ,properties for the frame that is being created
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    // function actionperformed is of the interface that is important to be overrided as if not done so ,the code can not execute
    public void actionPerformed(ActionEvent ae){
        //settign function for clear button we have created above 
        if (ae.getSource()==clear){
            cardtextfield.setText("");
            pintextfield.setText("");

        }else if (ae.getSource()== login){
            connection conn =new connection();
            String Cardnumber = cardtextfield.getText();
            String pinnumber= pintextfield.getText();
            String query = "select * from login where cardnumber = '"+Cardnumber+"' and pin = '"+pinnumber+"' ";
            try {
               ResultSet rs = conn.s.executeQuery(query);
               if (rs.next ()) {
                setVisible(false);
                new transactions(pinnumber).setVisible(true);
               }else {
                JOptionPane.showMessageDialog(null,"Incorrect Cardnumber or Pin");
               }
            }catch (Exception e){
                System.out.println(e);
                
            }

        }//setting function for signup button we have created (here when clicked on the signup button it closes the panel from loginclass and then start the frame we haev created in the signupOne button)
         else if (ae.getSource()== signup){
            setVisible(false);
            new signupOne().setVisible(true);      


        }

    }

//declaring the main function ehich is necessary for running the program  
    public static void main(String args[]){

    new Login();

    }
    
}



