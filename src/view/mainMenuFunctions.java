package view;
/**
 *
 * @author Vladimir Bernardo
 */
import javax.swing.*;

public abstract class mainMenuFunctions extends JFrame {
    
    public mainMenuFunctions(String titlebar) {
        setTitle(titlebar);
        setSize(UIConstants.MAIN_WINDOW_SIZE);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(false);
    }
    // windows must implement this to build its UI
    protected abstract void initUI();
}
