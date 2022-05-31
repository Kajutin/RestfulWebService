package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.boot.SpringApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class GUI {
    private JButton startSpringButton;
    private JPanel panelMain;
    public GUI() {
        startSpringButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SpringApplication.run(RestfulwebserviceApplication.class);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
