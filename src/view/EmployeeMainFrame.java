package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeMainFrame extends regularUI {

    public EmployeeMainFrame() {
        System.out.println("DEBUG: EmployeeMainFrame constructor invoked.");
        System.out.println("EmployeeMainFrame constructor entered."); 
        setResizable(false);
        initializeBasicFrame();
        
        //let us go back to login
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frames.dispose();
                logOUT();
            }
        });
        
    }
    
    private void logOUT() {
        JOptionPane.showMessageDialog(null, "Logged Out");
        this.dispose(); //logout
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }   
}