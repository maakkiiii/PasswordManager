import javax.swing.*;
import java.awt.*;

public class PasswordManager {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Ihr Passwort Manager");

    PasswordManager(){

        welcomeLabel.setBounds(0,0,1000,35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(welcomeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
