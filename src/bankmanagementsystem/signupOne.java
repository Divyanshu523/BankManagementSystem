package bankmanagementsystem;
//importing all the important libraries
import javax.swing.*;
import java.awt.*;
import java .util.*;
//for calendar library you have to additionally add external library that is to downloaded and it should be added to the libraries included from left corner all teh way to javaprojects and then adding the library
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

//creating the class where everthing is being made\done
public class signupOne extends JFrame implements ActionListener{
    //making global textfields that may be needed by other programs at some point
    JTextField nametextfield,fnametextfield, mailtextfield, addresstextfield, citytextfield,statetextfield, pincodetextfield;
    
    long random;
    JButton next;
    JRadioButton male ,female,yes ,no,other ;
    JDateChooser datechooser;


    //creating the constructor that is being called at defaut when main calss is being execited
    signupOne(){

        setLayout(null);//allows to make custom changes to the content of the frame
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000) + 1000L; //giving any random number between the given parameters which is used for form number 

        JLabel formno = new JLabel("Application form number "+ random );//giving the heading with the random number created above and then setting the parameters for its placement and it's appearance
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add (formno);

        //giving the heading "page:1 personal details" that is a subheading for the frame and it's dimensions are set by us as per convience
        JLabel personaldetails = new JLabel("Page1: Personal Details" );
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add (personaldetails);

        //adding label name with required parameters for placement and appeaarnce
        JLabel name = new JLabel("Name :" );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add (name);
        //adding textfield for the name label with required parameters
        nametextfield =new JTextField();
        nametextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        //adding label fathers name with required parameters for placement and appearance

        JLabel fname= new JLabel("Father's Name :" );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add (fname);

        //adding textfield for the fathers name label with required parameters

        fnametextfield =new JTextField();
        fnametextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        fnametextfield.setBounds(300,190,400,30);
        add(fnametextfield);

        //adding label dob with required parameters for placement and appearance

        JLabel dob= new JLabel("Date Of Birth :" );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add (dob);

        //adding date chooser for the dob label that is impored from the library "com.toedter.calendar.JDateChooser" that we havee added seperately .it is created by making an object for one of the class of the library and then giving the parameters required

        datechooser = new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(Color.WHITE);
        add(datechooser);

        //adding label gender with required parameters for placement and appearance

        JLabel gender= new JLabel("Gender :" );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add (gender);

        //creating radio buttons for all the options available here(male,female) with the class JRadioButton. Here we make an object of the mentoned class and then add al the required parameters for them 
        //Mlae radio button
        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        //female radio button
        female= new JRadioButton("Female");
        female.setBounds(450,290,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        //now adding functionality to the radiobuttons we created (only select one at a time)

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        //adding a label email with required parameters for placement and apperance
    
        
        JLabel email= new JLabel("Email :" );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add (email);

        //creating a textfield for the email label with the required parameters 
        mailtextfield =new JTextField();
        mailtextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        mailtextfield.setBounds(300,340,400,30);
        add(mailtextfield);


        //creating a label marital status with required parameters for placement and appearance 

        JLabel maritalstatus = new JLabel("Marital Status :" );
        maritalstatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalstatus.setBounds(100,390,200,30);
        add (maritalstatus);


        //creating the radio buttons for all the options that are possible with the required parameters(married,unmarried,other)
        //married radio button 
        yes= new JRadioButton("Married");
        yes.setBounds(300,390,80,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        //unmarried radiobutton
        no= new JRadioButton("Unmarried");
        no.setBounds(390,390,100,30);
        no.setBackground(Color.WHITE);
        add(no);
        //other radio button
        other= new JRadioButton("Other");
        other.setBounds(500,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        //adding functionality to the radio buttons that we just created above (only chose one of the following)

        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(yes);
        maritalgroup.add(no);
        maritalgroup.add(other);

        //adding label address with required parameters for placement and appearance
        JLabel address= new JLabel("Address :" );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add (address);

        //creatung a textfield for the label address with all the required parameters

        addresstextfield =new JTextField();
        addresstextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);

        //creating a label city with all the required parameters for placement and parameters

        JLabel city= new JLabel("City :" );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add (city);

        //creating a textfield for the label city with all the required parameters

        citytextfield =new JTextField();
        citytextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);

        //adding a label state with all the required parameters for placement and appearance 
        JLabel state= new JLabel("state :" );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add (state);

        //creating atext field for the label state with all the required parameters 
        statetextfield =new JTextField();
        statetextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);

        //adding a label pincode with all the required parameters for placement and appearance
        JLabel pincode= new JLabel("Pincode :" );
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add (pincode);

        //adding a textfield for the label pincode with all the required parameters 
        pincodetextfield =new JTextField();
        pincodetextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        pincodetextfield.setBounds(300,590,400,30);
        add(pincodetextfield);

        //creating a Buttion "next" for navigating to the database and storing the data into the database
        next =new JButton("Next");
        next.setBounds(450,640,70,50);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        


        //this is the size for the frame in which all the above work is being done
        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    //this is a method in ActionListner interface and we need to implement it 
    public void actionPerformed(ActionEvent ae) {

        //creating all the label objects to store the data that we are getting from the user 
        String formno= "" + random ;
        String name=nametextfield.getText();
        String fname= fnametextfield.getText();
        String dob= ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();

        //setting the value of the gender as per given by the user and converting them into string
        String gender= null;
        if (male.isSelected()){
            gender="Male";
        
        } else if (female.isSelected()){
            gender="Female";
        }
        String email= mailtextfield.getText();

        //setting the maritalstatus as per given by the user 

        String maritalstatus=null;
        if(yes.isSelected()){

            maritalstatus = "Married";
        }else if (no.isSelected()){

            maritalstatus= "Unmarried";

        }else if (other.isSelected()){
            maritalstatus="Other";
        }
        //getting the data user have entered and converting it into string 
        String address = addresstextfield.getText();

        String city = citytextfield.getText();
        String state = statetextfield.getText();
        String pincode = pincodetextfield.getText();

        try{
            //giving example for handling the situation when the user have not given any specfied value 
            if (name.equals("")) {

                JOptionPane.showMessageDialog(null, "Name is Required");

            } //if all the values are given by the user than this part is executed(here only name will work aas we haev only created for name )
            else {
                //making an object for connection to databse 
                connection c=new connection();
                //this query is used to add data to the database 
                String query= "insert into signup values('"+formno+"' , '"+name+"', '"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalstatus+"' ,'"+address+"' , '"+city+"', '"+state+"','"+pincode+"')";
                //execute the query that is written to enter the data into the databse
                c.s.executeUpdate(query);

                setVisible(false);
                new signupTwo(formno).setVisible(true);



            }




        }catch (Exception e) {
            System.out.println(e);


        }








    }








    public static void main(String args[]){

        new signupOne();

    }
    
    
}
