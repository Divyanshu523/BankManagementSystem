package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class pinchange extends JFrame implements ActionListener {

    String pinnumber;
    JPasswordField pintextfield, repintextfield;
    JButton change, back;

    pinchange(String pinnumber) {
        this.pinnumber=pinnumber;

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 250, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 20);
        image.add(pintext);

        pintextfield = new JPasswordField();
        pintextfield.setFont(new Font("Raleway", Font.BOLD, 19));
        pintextfield.setBounds(320, 320, 180, 25);
        image.add(pintextfield);

        JLabel repintext = new JLabel("Re-Enter New PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 365, 170, 20);
        image.add(repintext);

        repintextfield = new JPasswordField();
        repintextfield.setFont(new Font("Raleway", Font.BOLD, 19));
        repintextfield.setBounds(320, 360, 180, 25);
        image.add(repintextfield);

        change = new JButton("CHANGE");
        change.setBounds(355, 460, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 490, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    // public void actionPerformed(ActionEvent ae){
    // if (ae.getSource() == change){
    // try{
    // String cpin=pintextfield.getText();
    // String crpin= repintextfield.getText();

    // if (cpin.equals("")){
    // JOptionPane.showMessageDialog(null, "Please enter pin");
    // return;
    // }else if (crpin.equals("")){
    // JOptionPane.showMessageDialog(null, "Please Re-enter new pin");
    // return;
    // }else if (!cpin.equals(crpin)){
    // JOptionPane.showMessageDialog(null, "Entered pin does not match");

    // }

    // connection c = new connection();

    // String query1= "update bank SET pin = '"+crpin+"' where pin = '"+pinnumber+"'
    // ";
    // String query2= "update login SET pin = '"+crpin+"' where pin =
    // '"+pinnumber+"' ";
    // String query3= "update signupthree SET pin = '"+crpin+"' where pin =
    // '"+pinnumber+"' ";

    // c.s.executeUpdate(query1);
    // c.s.executeUpdate(query2);
    // c.s.executeUpdate(query3);

    // // String query = "update bank set pin = ? where first_name = ?";
    // // PreparedStatement preparedStmt = c.prepareStatement(query);
    // // preparedStmt.setString (1, crpin);
    // // preparedStmt.setString (2, pinnumber);

    // // String query1 = "update login set pin = ? where first_name = ?";
    // // PreparedStatement prepared = c.prepareStatement(query1);
    // // prepared.setString (1, crpin);
    // // prepared.setString (2, pinnumber);

    // // String query2 = "update signupthree set pin = ? where first_name = ?";
    // // PreparedStatement statement = c.prepareStatement(query2);
    // // statement.setString (1, crpin);
    // // statement.setString (2, pinnumber);

    // //preparedStmt.executeUpdate();
    // // prepared.executeUpdate();
    // // statement.executeUpdate();

    // JOptionPane.showMessageDialog(null, "PIN changed successfully");
    // setVisible(false);
    // new transactions(crpin).setVisible(true);

    // }catch(Exception e){
    // System.out.println(e);
    // }
    // }else{
    // setVisible(false);
    // new transactions(pinnumber).setVisible(true);
    // }
    // }

    public void actionPerformed(ActionEvent ae){
        
        connection c = new connection();
        

        if (ae.getSource() == change){

            try{
                String cpin = pintextfield.getText();
                String crpin = repintextfield.getText();
    
                if (cpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter pin");
                    return;
                } else if (crpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-enter new pin");
                    return;
                } else if (!cpin.equals(crpin)){
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
    
    
              
    
                // Start a transaction
                c.s.getConnection().setAutoCommit(false);
    
                String query1 = "update bank SET pin = '" + crpin + "' where pin = '" + pinnumber + "' ";
                String query2 = "update login SET pin = '" + crpin + "' where pin = '" + pinnumber + "' ";
                String query3 = "update signupthree SET pin = '" + crpin + "' where pin = '" + pinnumber + "' ";
    
            
                
    
                int result1 = c.s.executeUpdate(query1);
                int result2 = c.s.executeUpdate(query2);
                int result3 = c.s.executeUpdate(query3);
    
                // Commit the transaction
                c.s.getConnection().commit();
    
                // Check if updates were successful
                if(result1 > 0 && result2 > 0 && result3 > 0){
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new transactions(crpin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "PIN change failed");
                }
    
            } catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
                try {
                    // Rollback the transaction if any error occurs
                    c.s.getConnection().rollback();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            } finally {
                try {
                    // Reset auto-commit to true
                    c.s.getConnection().setAutoCommit(true);
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        } else {
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new pinchange("");
    }

}
