package view;
/**
 *
 * @author Vladimir Bernardo
 */
import model.Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PayrollEntryFrame extends mainMenuFunctions {
    private final Employee employee;
    private JTextField txtHours;
    private JButton btnCompute;

    public PayrollEntryFrame(Employee employee) {
        super("Compute Payroll for " +  employee.getFirstName() + " " + employee.getLastName());
        this.employee = employee;
        initUI();
    }

    @Override
    protected void initUI() {
        setSize(UIConstants.PAYROLL_WINDOW_SIZE);
        
        try {
            System.out.println("Loading application icon...");
            java.net.URL iconUrl = PayrollEntryFrame.class.getResource("/view/assets/logo.png");
            if (iconUrl == null) {
                System.err.println("ERROR: Icon resource not found in classpath: /view/assets/logo.png");
                // Try alternate path
                iconUrl = PayrollEntryFrame.class.getResource("assets/logo.png");
                if (iconUrl == null) {
                    System.err.println("ERROR: Icon not found in alternate path: assets/logo.png");
                }
            }
            if (iconUrl != null) {
                System.out.println("Icon found at: " + iconUrl);
                ImageIcon icon = new ImageIcon(iconUrl);
                setIconImage(icon.getImage());
            }
        }
        catch (Exception e) {
            System.err.println("ERROR loading application icon: " + e.getMessage());
            e.printStackTrace();
        }
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Input Label
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Hours Worked:"), gbc);

        // Input Field
        txtHours = new JTextField(10);
        gbc.gridx = 1;
        add(txtHours, gbc);

        // Initialize Compute Button
        btnCompute = new JButton("Generate Payslip");

        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 2;
        add(btnCompute, gbc);

        btnCompute.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                computePayroll();
            }
        });
    }

    private void computePayroll() {
        try {
            // Hours are manually provided from the textinput field
            String s_hours = txtHours.getText();
            double hours = Double.parseDouble(s_hours);
            double gross = hours * Double.parseDouble(employee.getHourlyRate());
            
            // Every Government Deduction in a package: Witholding Tax, SSS, PhilHealth, Pag-ibig
            double all_deductions = employee.calc_witholding(gross) + employee.calc_SSS(gross) + employee.calc_philhealth(gross) + employee.calc_pagibig(gross);
            
            // Remove this for now... and add it later maybe... currently it causes an exception due to the original csv formatting.
            // Every Company Allowance: Rice Subsidy, Phone Allowance and Clothing Allowance
            //double all_allowances = Double.parseDouble(employee.getRiceSubsidy()) + Double.parseDouble(employee.getPhoneAllowance()) + Double.parseDouble(employee.getClothingAllowance());
            
            // NetPay is lacking allowances for now.
            double netPay = gross - all_deductions; // + all_allowances;

            // Open the final Payslip View
            new PayslipFrame(employee, gross, all_deductions, netPay).setVisible(true);
            this.dispose();
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for hours.");
        }
    }
    
}
