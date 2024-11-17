package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class transactions  extends JFrame implements ActionListener{

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber ;
    transactions( String pinnumber){
        this.pinnumber = pinnumber;



        ImageIcon i1 =new ImageIcon(getClass().getResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);


        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        

        JLabel text =new JLabel("Please select your Transacion");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit :");
        deposit.setBounds(170,420,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl:");
        withdrawl.setBounds(355,420,150,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash:");
        fastcash.setBounds(170,455,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,455,150,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,490,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(355,490,150,25);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,25);
        exit.addActionListener(this);
        image.add(exit);

        

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }




    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()== withdrawl){
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()== fastcash){
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        }else if (ae.getSource()== pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if (ae.getSource()== balance){
            setVisible(false);
            new balanceenquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()== ministatement){
            new ministatement(pinnumber).setVisible(true);
        }

        
    }




    public static void main(String args[]){

        new transactions("");
    }

}




