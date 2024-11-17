package bankmanagementsystem;



//importing all the important libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//creating the class where everthing is being made\done
public class signupTwo extends JFrame implements ActionListener{
    //making global textfields that may be needed by other programs at some point
    JTextField  pantextfield, aadhartextfield,pincodetextfield,educationtextfield ;
    
    
    JButton next;
    JRadioButton seniorcitizen_yes,seniorcitizen_no ,account_yes, account_no;
    JComboBox relegionbox,incomebox,occupationbox,categorybox,educationbox;
    String formno;

    //creating the constructor that is being called at defaut when main calss is being execited
    signupTwo(String formno){
        this.formno =formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2 ");


        JLabel additionaldetails = new JLabel("Page2 : Additional Details" );
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add (additionaldetails);

        //adding label name with required parameters for placement and appeaarnce
        JLabel relegion = new JLabel("Relegion :" );
        relegion.setFont(new Font("Raleway",Font.BOLD,20));
        relegion.setBounds(100,140,100,30);
        add (relegion);

        String valrelegion[]= {"Hindu","Muslim","Christian","Other"};
        relegionbox= new JComboBox(valrelegion);
        relegionbox.setBounds(300,140,400,30);
        relegionbox.setBackground(Color.WHITE);
        add(relegionbox);
        

       
        JLabel category= new JLabel("Category :" );
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add (category);

        String valcategory[]={"General","OBC","SC","ST"};
        categorybox= new JComboBox(valcategory);
        categorybox.setBounds(300,190,400,30);
        categorybox.setBackground(Color.WHITE);
        add(categorybox);


        JLabel income= new JLabel("Income :" );
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add (income);

        String valincome[]={"NULL","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomebox= new JComboBox(valincome);
        incomebox.setBounds(300,240,400,30);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);

        //adding label gender with required parameters for placement and appearance

        JLabel education= new JLabel("Educational Qual. :" );
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add (education);

        String valeducation[]={"Non-Graduation","Graduation","Post-Graduate","Doctrate","Others"};
        educationbox= new JComboBox(valeducation);
        educationbox.setBounds(300,290,400,30);
        educationbox.setBackground(Color.WHITE);
        add(educationbox);


        JLabel occupation = new JLabel("Occupation :" );
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add (occupation);

        String valoccupation[]={"Salaried","Self-Employed","Bussiness","Student","Retire","others"};
        occupationbox= new JComboBox(valoccupation);
        occupationbox.setBounds(300,340,400,30);
        occupationbox.setBackground(Color.WHITE);
        add(occupationbox);


        //adding label address with required parameters for placement and appearance
        JLabel pannumber= new JLabel("PAN number :" );
        pannumber.setFont(new Font("Raleway",Font.BOLD,20));
        pannumber.setBounds(100,390,200,30);
        add (pannumber);

        //creatung a textfield for the label address with all the required parameters

        pantextfield =new JTextField();
        pantextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        pantextfield.setBounds(300,390,400,30);
        add(pantextfield);

        //creating a label city with all the required parameters for placement and parameters

        JLabel aadharnumber= new JLabel("Aadhar number : " );
        aadharnumber.setFont(new Font("Raleway",Font.BOLD,20));
        aadharnumber.setBounds(100,440,200,30);
        add (aadharnumber);

        //creating a textfield for the label city with all the required parameters

        aadhartextfield =new JTextField();
        aadhartextfield.setFont(new Font ("Raleway", Font.BOLD ,20));
        aadhartextfield.setBounds(300,440,400,30);
        add(aadhartextfield);

        //adding a label state with all the required parameters for placement and appearance 
        JLabel seniorcitizen = new JLabel("Senior Citizen :" );
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,490,200,30);
        add (seniorcitizen);


        seniorcitizen_yes= new JRadioButton("YES");
        seniorcitizen_yes.setBounds(300,490,60,30);
        seniorcitizen_yes.setBackground(Color.WHITE);
        add(seniorcitizen_yes);
        //female radio button
        seniorcitizen_no= new JRadioButton("NO");
        seniorcitizen_no.setBounds(450,490,70,30);
        seniorcitizen_no.setBackground(Color.WHITE);
        add(seniorcitizen_no);


        ButtonGroup yesorno = new ButtonGroup();
        yesorno.add(seniorcitizen_yes);
        yesorno.add(seniorcitizen_no);

        JLabel existingaccount= new JLabel("Existing Account" );
        existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingaccount.setBounds(100,540,200,30);
        add (existingaccount);

        account_yes= new JRadioButton("YES");
        account_yes.setBounds(300,540,60,30);
        account_yes.setBackground(Color.WHITE);
        add(account_yes);
        
        account_no= new JRadioButton("NO");
        account_no.setBounds(450,540,70,30);
        account_no.setBackground(Color.WHITE);
        add(account_no);


        ButtonGroup accountornot = new ButtonGroup();
        accountornot.add(account_yes);
        accountornot.add(account_no);

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

        
        String relegion= (String) relegionbox.getSelectedItem();       

        String category = (String) categorybox.getSelectedItem();
        String income = (String) incomebox.getSelectedItem();
        String education = (String) educationbox.getSelectedItem();
        String occupation = (String) occupationbox.getSelectedItem();
        String pannumber = pantextfield.getText();
        String aadharnumber= aadhartextfield.getText();
        String Seniorcitizen=null;
        if(seniorcitizen_yes.isSelected()){
            Seniorcitizen =" Yes";
        
        }else if  (seniorcitizen_no.isSelected()){
            Seniorcitizen ="No";

        }

        String existingaccount = null;
        if( account_yes.isSelected()){
            existingaccount="Yes";
        
        }else if (account_no.isSelected()){
            existingaccount="No";
        }

        

       try{
          
                connection c=new connection();
               
                String query= "insert into signuptwo values('"+formno+"' , '"+relegion+"', '"+category+"','"+income+"','"+education+"','"+occupation+"','"+pannumber+"' ,'"+aadharnumber+"' , '"+Seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);


                setVisible(false);
                new signupthree(formno).setVisible(true);

        }catch (Exception e) {
            System.out.println(e);


        }
    
    }








    public static void main(String args[]){

        new signupTwo("");

    }
    
    
}








