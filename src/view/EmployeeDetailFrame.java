package view;

import java.awt.*;
import javax.swing.*;
import model.Employee;

public class EmployeeDetailFrame extends JFrame {
    private final Employee employee;
    public EmployeeDetailFrame(Employee employee) {
        
        //check if valid
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        
        this.employee = employee;
        
        //window properties
        setTitle("View Employee: " + employee.getFirstName() + " " + employee.getLastName());
        setSize(UIConstants.DETAIL_WINDOW_SIZE);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(UIConstants.EMPTY_BORDER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;

        // Add employee details
        int row = 0;
        addField(mainPanel, gbc, "Employee No.:", employee.getEmployeeNumber(), row++);
        addField(mainPanel, gbc, "First Name:", employee.getFirstName(), row++);
        addField(mainPanel, gbc, "Last Name:", employee.getLastName(), row++);
        addField(mainPanel, gbc, "Birthday:", employee.getBirthday(), row++);
        addField(mainPanel, gbc, "Contact No.:", employee.getContactInfo(), row++);
        addField(mainPanel, gbc, "Address:", employee.getAddress(), row++);
        addField(mainPanel, gbc, "Employee Status:", employee.getStatus(), row++);        
        addField(mainPanel, gbc, "Position:", employee.getPosition(), row++);
        addField(mainPanel, gbc, "Direct Supervisor:", employee.getSupervisor(), row++);
        addField(mainPanel, gbc, "SSS No.:", employee.getSssNumber(), row++);
        addField(mainPanel, gbc, "PhilHealth No.:", employee.getPhilhealthNumber(), row++);
        addField(mainPanel, gbc, "TIN:", employee.getTinNumber(), row++);
        addField(mainPanel, gbc, "Pag-IBIG No.:", employee.getPagibigNumber(), row++);
        addField(mainPanel, gbc, "Basic Salary:", employee.getBaseSalary(), row++);
        addField(mainPanel, gbc, "Rice Subsidy:", employee.getRiceSubsidy(), row++);
        addField(mainPanel, gbc, "Phone Allowance:", employee.getPhoneAllowance(), row++);
        addField(mainPanel, gbc, "Clothing Allowance:", employee.getClothingAllowance(), row++);
        addField(mainPanel, gbc, "Gross Semi-monthly Rate:", employee.getSemiRate(), row++);
        addField(mainPanel, gbc, "Hourly Rate:", employee.getHourlyRate(), row++);

        // Add the main panel to a scroll pane
        add(new JScrollPane(mainPanel));
        
    }
    
    private void addField(JPanel panel, GridBagConstraints gbc, String label, String value, int row) {
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(UIConstants.LABEL_FONT);
        
        JLabel valueComponent = new JLabel(value);
        valueComponent.setFont(UIConstants.LABEL_FONT);
        
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        panel.add(labelComponent, gbc);

        gbc.gridx = 1;
        panel.add(valueComponent, gbc);
    }
    
}
