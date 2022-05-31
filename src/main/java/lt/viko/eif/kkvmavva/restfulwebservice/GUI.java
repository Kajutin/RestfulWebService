package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.boot.SpringApplication;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI
// Launch this class to start and control the web service
public class GUI {
    //region GUI declarations
    private JButton startSpringButton;
    private JPanel panelMain;
    private JTextArea textStatusArea;
    private JButton sendARequestButton;
    private JTextField URITextField;
    private JLabel URILabel;
    private JLabel SpringStatusLabel;
    private JLabel ListeningLabel;
    //endregion

    public GUI() {
        //region Start Spring button code
        startSpringButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Launches Spring listener
                // By default it's running on localhost:8080
                SpringApplication.run(RestfulwebserviceApplication.class);
                SpringStatusLabel.setText("Spring has started.");
                ListeningLabel.setText("Listening on localhost:8080");
                startSpringButton.setVisible(false);
            }
        });
        //endregion
    }

    // Form initialisation code
    // Needed to activate the form and make it display when run
    //region Form Init
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    //endregion
}
