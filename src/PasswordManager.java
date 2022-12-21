import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;

public class PasswordManager {
    JFrame frame = new JFrame();
    JLabel titleLabel = new JLabel("Ihr Passwort Manager");
    JLabel title2 = new JLabel("Ihre Passwörter:");
    JScrollPane pswdBox = new JScrollPane();
    JButton managePswd = new JButton();
    JButton addPswd = new JButton();
    JButton deletePswd = new JButton();


    PasswordManager(){

        titleLabel.setBounds(10,0,1000,35);
        titleLabel.setFont(new Font(null, Font.PLAIN, 25));

        title2.setBounds(10,50, 200, 30);
        title2.setFont(new Font(null, Font.PLAIN, 15));

        pswdBox.setBounds(10, 80, 1000, 400);
        pswdBox.setFont(new Font(null, Font.ITALIC, 10));

        managePswd.setText("Manage Passwords");
        managePswd.setBounds(1050, 80, 200, 30);
        managePswd.setFocusable(false);

        addPswd.setText("Add Passwords");
        addPswd.setBounds(1050, 120, 200, 30);
        addPswd.setFocusable(false);

        deletePswd.setText("Delete Passwords");
        deletePswd.setBounds(1050, 160, 200, 30);
        deletePswd.setFocusable(false);

        frame.add(titleLabel);
        frame.add(title2);
        frame.add(pswdBox);
        frame.add(managePswd);
        frame.add(addPswd);
        frame.add(deletePswd);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
