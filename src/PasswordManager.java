import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PasswordManager implements ActionListener {
    HashMap<String, String> passwordsMateja = new HashMap<>();
    HashMap<String, String> passwordsMark = new HashMap<>();
    HashMap<String, String> passwordsPoseidon = new HashMap<>();

    HashMap<String, String> emptyHash = new HashMap<>();
    String empty = "account";

    //LoginPage getAccount = new LoginPage();

    String currentUser;
    Object [] column = {"URL", "Password"};

    JFrame frame = new JFrame();
    JButton addPswd = new JButton();
    JButton deletePswd = new JButton();
    JTextField urlField = new JTextField();
    JPasswordField newPswd = new JPasswordField();

    public PasswordManager(String currentUser) {
        this.currentUser = currentUser;

        passwordsMateja.put("amazon", "azerbaidschan");
        passwordsMateja.put("bluewin", "azerbaidschan");
        passwordsMateja.put("allrounder", "azerbaidschan");
        passwordsMateja.put("github", "azerbaidschan");
        passwordsMateja.put("sololearn", "azerbaidschan");
        passwordsMateja.put("mangasite", "azerbaidschan");
        passwordsMateja.put("netflix", "azerbaidschan");
        passwordsMateja.put("honolulu airlines", "azerbaidschan");
        passwordsMark.put("amazon", "markusiusrex");
        passwordsMark.put("yahoo", "markusiusrex");
        passwordsMark.put("allrounder", "markusiusrex");
        passwordsMark.put("github", "markusiusrex");
        passwordsMark.put("sololearn", "markusiusrex");
        passwordsMark.put("mangasite", "markusiusrex");
        passwordsMark.put("netflix", "markusiusrex");
        passwordsMark.put("honolulu airlines", "markusiusrex");

        JLabel titleLabel = new JLabel("Ihr Passwort Manager");
        JLabel title2 = new JLabel("Ihre Passwörter:");
        JTable table = new JTable(getPasswords(), column);
        JScrollPane pswdBox = new JScrollPane(table);

        titleLabel.setBounds(10,0,1000,35);
        titleLabel.setFont(new Font(null, Font.PLAIN, 25));

        title2.setBounds(10,50, 200, 30);
        title2.setFont(new Font(null, Font.PLAIN, 15));

        pswdBox.setBounds(10, 80, 1000, 400);
        pswdBox.setFont(new Font(null, Font.ITALIC, 10));

        addPswd.setText("Add Passwords");
        addPswd.setBounds(1050, 160, 200, 30);
        addPswd.setFocusable(false);

        deletePswd.setText("Delete Passwords");
        deletePswd.setBounds(1050, 200, 200, 30);
        deletePswd.setFocusable(false);

        urlField.setBounds(1050,80, 200, 30);

        newPswd.setBounds(1050, 120, 200, 30);

        frame.add(titleLabel);
        frame.add(title2);
        frame.add(pswdBox);
        frame.add(addPswd);
        frame.add(deletePswd);
        frame.add(urlField);
        frame.add(newPswd);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public String[][] getPasswords(){
        HashMap<String, String> currHashMap = new HashMap<>();

        if (currentUser.equals("Mateja")){
            currHashMap = passwordsMateja;
        } else if (currentUser.equals("Mark")){
            currHashMap = passwordsMark;
        } else if (currentUser.equals("Poseidon")){
            currHashMap = passwordsPoseidon;
        }

       String[][] data = new String[currHashMap.size()][2];
        int count = 0;
        for(HashMap.Entry<String,String> entry : currHashMap.entrySet()){
            data[count][0] = entry.getKey();
            data[count][1] = entry.getValue();
            count++;
        }
        return data;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== addPswd){
            String url = urlField.getText();
            String neuesPswd = String.valueOf(newPswd.getPassword());
            if (currentUser== "Mateja"){
                passwordsMateja.put(url, neuesPswd);
            }else if (currentUser == "Mark"){
                passwordsMark.put(url, neuesPswd);
            }else if (currentUser == "Poseidon"){
                passwordsPoseidon.put(url, neuesPswd);
            }

        }else{}
        if (e.getSource() == deletePswd){

        }else{}
    }
}
