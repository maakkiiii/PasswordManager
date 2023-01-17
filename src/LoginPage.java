import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    public String account;

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPswdField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Benutzername: ");
    JLabel userPswdLabel = new JLabel("Passwort: ");
    JLabel messageLabel = new JLabel();

    HashMap <String, String> loginInfo = new HashMap<>();

    LoginPage(HashMap<String, String> loginInfo1){
        loginInfo = loginInfo1;
        userIDLabel.setBounds(30,100, 100, 25);
        userPswdLabel.setBounds(60,150, 100, 25);
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPswdField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

        frame.add(userIDLabel);
        frame.add(userPswdLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPswdField);
        frame.add(loginButton);
        frame.add(resetButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton){
            userIDField.setText("");
            userPswdField.setText("");
            messageLabel.setText("");
        }

        if (e.getSource() == loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPswdField.getPassword());
            if (loginInfo.containsKey(userID)){
                if (loginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    PasswordManager passwordManager = new PasswordManager(userID);
                }else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Login not successful");
                }
            }else {
                messageLabel.setForeground(Color.orange);
                messageLabel.setText("User not found");
            }
        }
    }
}
