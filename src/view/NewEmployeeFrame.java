package view;

import java.awt.*;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.swing.*;
import model.Constants;
import model.Employee;
import model.EmployeeDatabase;

public class NewEmployeeFrame extends mainMenuFunctions {
    private final adminUI parentFrame;
    private JTextField 
                        employeeNoField, 
                        lastNameField, 
                        firstNameField, 
                        addressField, 
                        contactField, 
                        sssField, 
                        philhealthField, 
                        tinField, 
                        pagibigField, 
                        statusField, 
                        positionField, 
                        bossField, 
                        basesalaryField, 
                        ricesubField, 
                        phoneallowField, 
                        clothingallowField, 
                        grossemiField, 
                        hourrateField;
    private JSpinner yearSpinner;
    private JSpinner monthSpinner;
    private JSpinner daySpinner;

    public NewEmployeeFrame(adminUI parent) {
        super("Add New Employee");
        this.parentFrame = parent;
        initUI();
    }
    
    @Override
    protected void initUI() {
        setSize(UIConstants.NEW_EMPLOYEE_WINDOW_SIZE);       

        // Create main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(0, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.gridwidth = 1;

        // Add title
        JLabel titleLabel = new JLabel("New Employee");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Initialize fields with hints
        employeeNoField = new JTextField("Enter employee number");
        lastNameField = new JTextField("Enter last name");
        firstNameField = new JTextField("Enter first name");
        addressField = new JTextField("Enter employee's address");
        contactField = new JTextField("Format: 09XXXXXXXXX");
        sssField = new JTextField("Format: XX-XXXXXXX-X");
        philhealthField = new JTextField("Format: XX-XXXXXXXXX-X");
        tinField = new JTextField("Format: XXX-XXX-XXX");
        pagibigField = new JTextField("Format: XXXX-XXXX-XXXX");
        statusField = new JTextField("Enter employee status");
        positionField = new JTextField("Enter employee's position");
        bossField = new JTextField("Enter direct supervisor");
        basesalaryField = new JTextField("Input base salary");
        ricesubField = new JTextField("Input rice subsidy");
        phoneallowField = new JTextField("Input phone allowance");
        clothingallowField = new JTextField("Input clothing allowance");
        grossemiField = new JTextField("Enter gross semi-monthly rate");
        hourrateField = new JTextField("Input hourly rate");

        // put tooltips on hover (same info)
        employeeNoField.setToolTipText("Enter employee number");
        lastNameField.setToolTipText("Enter last name");
        firstNameField.setToolTipText("Enter first name");
        addressField.setToolTipText("Enter employee's address");
        contactField.setToolTipText("Format: 09XXXXXXXXX");
        sssField.setToolTipText("Format: XX-XXXXXXX-X");
        philhealthField.setToolTipText("Format: XX-XXXXXXXXX-X");
        tinField.setToolTipText("Format: XXX-XXX-XXX");
        pagibigField.setToolTipText("Format: XXXX-XXXX-XXXX");
        statusField.setToolTipText("Enter employee status");
        positionField.setToolTipText("Enter employee's position");
        bossField.setToolTipText("Enter direct supervisor");
        basesalaryField.setToolTipText("Input base salary");
        ricesubField.setToolTipText("Input rice subsidy");
        phoneallowField.setToolTipText("Input phone allowance");
        clothingallowField.setToolTipText("Input clothing allowance");
        grossemiField.setToolTipText("Enter gross semi-monthly rate");
        hourrateField.setToolTipText("Input hourly rate");
        
        // Date spinners
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        
        // Year spinner: allow ages 18-65
        yearSpinner = new JSpinner(new SpinnerNumberModel(currentYear - 25, currentYear - 65, currentYear - 18, 1));
        JSpinner.NumberEditor yearEditor = new JSpinner.NumberEditor(yearSpinner, "#");
        yearSpinner.setEditor(yearEditor);
        
        // Month spinner: 1-12
        monthSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        monthSpinner.setEditor(new JSpinner.NumberEditor(monthSpinner, "00"));
        
        // Day spinner: 1-31
        daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        daySpinner.setEditor(new JSpinner.NumberEditor(daySpinner, "00"));

        // Add month change listener to update day spinner maximum
        monthSpinner.addChangeListener(e -> updateDaySpinnerRange());
        yearSpinner.addChangeListener(e -> updateDaySpinnerRange());

        // Add fields in specified order
        int row = 0;
        addField(formPanel, gbc, "Employee No.:", employeeNoField, row++);
        addField(formPanel, gbc, "Last Name:", lastNameField, row++);
        addField(formPanel, gbc, "First Name:", firstNameField, row++);
        addField(formPanel, gbc, "Address:", addressField, row++);
        addField(formPanel, gbc, "Contact No.:", contactField, row++);
        
        addField(formPanel, gbc, "SSS No.:", sssField, row++);
        addField(formPanel, gbc, "PhilHealth No.:", philhealthField, row++);
        addField(formPanel, gbc, "TIN:", tinField, row++);
        addField(formPanel, gbc, "Pag-IBIG No.:", pagibigField, row++);  

        addField(formPanel, gbc, "Status:", statusField, row++);
        addField(formPanel, gbc, "Position:", positionField, row++);
        addField(formPanel, gbc, "Supervisor:", bossField, row++);

        addField(formPanel, gbc, "Base Salary:", basesalaryField, row++);
        addField(formPanel, gbc, "Rice Subsidy:", ricesubField, row++);
        addField(formPanel, gbc, "Phone Allowance:", phoneallowField, row++);
        addField(formPanel, gbc, "Clothing Allowance:", clothingallowField, row++);
        addField(formPanel, gbc, "Gross Semi Monthly Rate:", grossemiField, row++);
        addField(formPanel, gbc, "Hourly Rate:", hourrateField, row++);

        // Add birthday spinners
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        datePanel.add(new JLabel("Year:"));
        datePanel.add(yearSpinner);
        datePanel.add(Box.createHorizontalStrut(10));
        datePanel.add(new JLabel("Month:"));
        datePanel.add(monthSpinner);
        datePanel.add(Box.createHorizontalStrut(10));
        datePanel.add(new JLabel("Day:"));
        datePanel.add(daySpinner);

        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        formPanel.add(new JLabel("Birthday:"), gbc);

        gbc.gridy = row++;
        formPanel.add(datePanel, gbc);

        // Add buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        // Style buttons
        Dimension buttonSize = new Dimension(100, 30);
        saveButton.setPreferredSize(buttonSize);
        cancelButton.setPreferredSize(buttonSize);

        saveButton.addActionListener(e -> saveEmployee());
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add shadow border to main panel
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            mainPanel.getBorder()
        ));

        setContentPane(new JScrollPane(mainPanel));
    }

    private JTextField createField(String tooltip) {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(250, 25));
        field.setToolTipText(tooltip);
        return field;
    }

    private void addField(JPanel panel, GridBagConstraints gbc, String label, JTextField field, int row) {
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("SansSerif", Font.PLAIN, 12));
        labelComponent.setHorizontalAlignment(SwingConstants.RIGHT);
        
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 0.0;
        panel.add(labelComponent, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 5);
        panel.add(field, gbc);
        gbc.insets = new Insets(5, 5, 5, 5);
    }

    private boolean validateFields() {
        // Check if required fields are empty
        if (
                employeeNoField.getText().trim().isEmpty() ||
                firstNameField.getText().trim().isEmpty() ||
                lastNameField.getText().trim().isEmpty() ||
                addressField.getText().trim().isEmpty() ||
                contactField.getText().trim().isEmpty() ||

                statusField.getText().trim().isEmpty() ||
                positionField.getText().trim().isEmpty() ||
                bossField.getText().trim().isEmpty() ||

                basesalaryField.getText().trim().isEmpty() ||
                ricesubField.getText().trim().isEmpty() ||
                phoneallowField.getText().trim().isEmpty() ||
                clothingallowField.getText().trim().isEmpty() ||
                grossemiField.getText().trim().isEmpty() ||
                hourrateField.getText().trim().isEmpty() ||

                sssField.getText().trim().isEmpty() ||
                philhealthField.getText().trim().isEmpty() ||
                tinField.getText().trim().isEmpty() ||
                pagibigField.getText().trim().isEmpty()) {
            
            showError(Constants.REQUIRED_FIELDS_ERROR);
            return false;
        }

        // Check if employee number is unique
        if (EmployeeDatabase.findByEmployeeNumber(employeeNoField.getText().trim()) != null) {
            showError(Constants.DUPLICATE_EMP_NUM_ERROR);
            employeeNoField.requestFocus();
            return false;
        }

        // Validate patterns
        if (!Pattern.matches(Constants.CONTACT_NUMBER_PATTERN, contactField.getText().trim())) {
            showError(Constants.INVALID_CONTACT_ERROR);
            contactField.requestFocus();
            return false;
        }

        if (!Pattern.matches(Constants.SSS_NUMBER_PATTERN, sssField.getText().trim())) {
            showError(Constants.INVALID_SSS_ERROR);
            sssField.requestFocus();
            return false;
        }

        if (!Pattern.matches(Constants.PHILHEALTH_NUMBER_PATTERN, philhealthField.getText().trim())) {
            showError(Constants.INVALID_PHILHEALTH_ERROR);
            philhealthField.requestFocus();
            return false;
        }

        if (!Pattern.matches(Constants.TIN_NUMBER_PATTERN, tinField.getText().trim())) {
            showError(Constants.INVALID_TIN_ERROR);
            tinField.requestFocus();
            return false;
        }

        if (!Pattern.matches(Constants.PAGIBIG_NUMBER_PATTERN, pagibigField.getText().trim())) {
            showError(Constants.INVALID_PAGIBIG_ERROR);
            pagibigField.requestFocus();
            return false;
        }

        return true;
    }

    private void saveEmployee() {
        if (!validateFields()) {
            return;
        }

        try {
            LocalDate birthday = LocalDate.of(
                (Integer) yearSpinner.getValue(),
                (Integer) monthSpinner.getValue(),
                (Integer) daySpinner.getValue()
            );

            Employee newEmployee = new Employee(
                employeeNoField.getText().trim(),
                lastNameField.getText().trim(),
                firstNameField.getText().trim(),
                birthday.toString(),
                addressField.getText().trim(),
                contactField.getText().trim(),

                sssField.getText().trim(),
                philhealthField.getText().trim(),
                tinField.getText().trim(),
                pagibigField.getText().trim(),

                statusField.getText().trim(),
                positionField.getText().trim(),
                bossField.getText().trim(),

                basesalaryField.getText().trim(),
                ricesubField.getText().trim(),
                phoneallowField.getText().trim(),
                clothingallowField.getText().trim(),
                grossemiField.getText().trim(),
                hourrateField.getText().trim()
            );

            EmployeeDatabase.addEmployee(newEmployee);
            parentFrame.refreshTable();
            dispose();
            
            JOptionPane.showMessageDialog(this,
                "Employee added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            showError("Failed to save employee: " + e.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    private void updateDaySpinnerRange() {
        int year = (Integer) yearSpinner.getValue();
        int month = (Integer) monthSpinner.getValue();
        int currentDay = (Integer) daySpinner.getValue();
        
        // Get days in month
        int daysInMonth = LocalDate.of(year, month, 1).lengthOfMonth();
        
        // Update day spinner model
        SpinnerNumberModel model = (SpinnerNumberModel) daySpinner.getModel();
        model.setMaximum(daysInMonth);
        
        // Adjust current value if needed
        if (currentDay > daysInMonth) {
            daySpinner.setValue(daysInMonth);
        }
    }
}
