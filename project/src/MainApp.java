import cosOder.MCOder;
import java.sql.SQLException;
import javax.swing.JFrame;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        // Create a new JFrame
        JFrame frame = new JFrame("Manage Customer Orders");
        
        // Set the default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create an instance of MCOder (your JPanel)
        MCOder mcOderPanel = new MCOder();
        
        // Add the panel to the frame
        frame.add(mcOderPanel);
        
        // Set the size of the frame
        frame.setSize(400, 500);  // Adjust the size as needed
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
