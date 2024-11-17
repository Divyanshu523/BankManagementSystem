package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;

import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class fastcash extends JFrame implements ActionListener{

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balance,back;
    String pinnumber ;
    fastcash( String pinnumber){
        this.pinnumber = pinnumber;



        ImageIcon i1 =new ImageIcon(getClass().getResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);


        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        

        JLabel text =new JLabel("Select Withdrawl Amount");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs-100");
        deposit.setBounds(170,390,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs-500");
        withdrawl.setBounds(355,390,150,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs-1000");
        fastcash.setBounds(170,425,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs-2000");
        ministatement.setBounds(355,425,150,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs-5000");
        pinchange.setBounds(170,460,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Rs-10000");
        balance.setBounds(355,460,150,25);
        balance.addActionListener(this);
        image.add(balance);

        back = new JButton("Back");
        back.setBounds(355,495,150,25);
        back.addActionListener(this);
        image.add(back);

        

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }




    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            connection conn = new connection();
            try{
                ResultSet rs= conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int bal= 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else  {
                        bal-= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && bal < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance ");
                    return;
                }

                Date date = new Date();
                String query1="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl' ,'"+amount+"')";
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Rs" +amount+ "Debited Successfully");
                setVisible(false);
                new transactions(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }

        }

        
    }








    public static void main(String args[]){

        new fastcash("");
    }

}




