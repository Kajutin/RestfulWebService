package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.boot.SpringApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
    private JButton saveDatabaseButton;
    private String URIString;
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
                sendARequestButton.setVisible(true);
                saveDatabaseButton.setVisible(true);
            }
        });
        //endregion
        //region URI request button code
        sendARequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                URIString = "http://localhost:8080/" + URITextField.getText();
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI(URIString));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (URISyntaxException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        //endregion
        //region Save Database Button
        saveDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //endregion
    }

    //region Form Initialisation code
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    //endregion
}
