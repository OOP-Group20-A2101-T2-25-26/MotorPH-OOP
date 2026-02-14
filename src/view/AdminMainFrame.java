package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminMainFrame extends adminUI {

    public AdminMainFrame() {
        System.out.println("DEBUG: AdminMainFrame constructor invoked.");
        System.out.println("AdminMainFrame constructor entered.");
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
        this.dispose(); //logout or kill the Main App
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}