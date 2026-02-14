package view;
/**
 *
 * @author Vladimir Bernardo
 */
import model.Employee;
import javax.swing.*;
import java.awt.*;

public class PayslipFrame extends mainMenuFunctions {
    
    private final Employee employee;
    private final double gross;
    private final double deductions;
    private final double net;
    
    public PayslipFrame(Employee employee, double gross, double deductions, double net) {
        super("Official Payslip");
        
        // grab values from payentryframe
        this.employee = employee;
        this.gross = gross;
        this.deductions = deductions;
        this.net = net;
        
        initUI();
    }
    
    @Override
    protected void initUI() {
        setSize(UIConstants.PAYSLIP_WINDOW_SIZE);
        
        try {
            System.out.println("Loading application icon...");
            java.net.URL iconUrl = PayslipFrame.class.getResource("/view/assets/logo.png");
            if (iconUrl == null) {
                System.err.println("ERROR: Icon resource not found in classpath: /view/assets/logo.png");
                // Try alternate path
                iconUrl = PayslipFrame.class.getResource("assets/logo.png");
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
        
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(new JLabel("MOTOR PH CORPORATION"));
        panel.add(new JLabel("Employee: " + employee.getFirstName() + " " + employee.getLastName()));
        panel.add(new JLabel("Gross Pay: PHP " + String.format("%,.2f", gross)));
        panel.add(new JLabel("Total Deductions: PHP " + String.format("%,.2f", deductions)));
        
        JLabel lblNet = new JLabel("NET PAY: PHP " + String.format("%,.2f", net));
        lblNet.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNet.setForeground(Color.RED);
        panel.add(lblNet);

        add(panel, BorderLayout.CENTER);
        
        JButton btnPrint = new JButton("Print / Close");
        btnPrint.addActionListener(e -> dispose());
        add(btnPrint, BorderLayout.SOUTH);
    }
    
}

