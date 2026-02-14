package view;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class UIConstants {
    // Colors
    public static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    public static final Color PRIMARY_COLOR_R = new Color(204, 102, 0);
    public static final Color BACKGROUND_COLOR = Color.WHITE;
    public static final Color TEXT_COLOR = Color.BLACK;

    // Fonts
    public static final Font HEADER_FONT = new Font("SansSerif", Font.BOLD, 18);
    public static final Font LABEL_FONT = new Font("SansSerif", Font.PLAIN, 12);
    public static final Font BUTTON_FONT = new Font("SansSerif", Font.PLAIN, 12);

    // Dimensions
    public static final Dimension LOGIN_WINDOW_SIZE = new Dimension(400, 250);
    public static final Dimension MAIN_WINDOW_SIZE = new Dimension(920, 620);
    public static final Dimension DETAIL_WINDOW_SIZE = new Dimension(600, 600);
    public static final Dimension NEW_EMPLOYEE_WINDOW_SIZE = new Dimension(500, 600);
    public static final Dimension EDIT_EMPLOYEE_WINDOW_SIZE = new Dimension(1280, 720);
    public static final Dimension PAYROLL_WINDOW_SIZE = new Dimension(400, 300);
    public static final Dimension PAYSLIP_WINDOW_SIZE = new Dimension(400, 400);
    public static final int STANDARD_FIELD_WIDTH = 250;

    // Borders
    public static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    public static final Border LINE_BORDER = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
}
