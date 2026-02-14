package view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import model.Constants;
import model.Employee;
import model.EmployeeDatabase;

public abstract class mainMenuFunctions extends JFrame {
    
    protected JFrame frames;

    public mainMenuFunctions() {
        //initializeBasicFrame();
    }

    protected abstract void initializeBasicFrame();
    protected abstract void setupComponents();
}
