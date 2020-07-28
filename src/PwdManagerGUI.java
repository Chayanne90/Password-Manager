import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PwdManagerGUI implements ActionListener {

    /* Labels */
    private static JLabel descriptionLabel;
    private static JLabel emailLabel;
    private static JLabel passwordLabel;
    private static JLabel updateLabel;
    private static JLabel accountsLabel;
    private static JLabel accounts;

    /* Input Fields */
    public static JTextField emailField;
    public static JTextField descriptionField;
    public static JTextField passwordField;
    public static JTextField updateField;

    /* Buttons */
    public static JButton cancelBtn;
    public static JButton updateBtn;
    public static JButton addBtn;

    Manager manager = new Manager();
    public PwdManagerGUI() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        frame.setSize(600,350);
        frame.setTitle("Password Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        descriptionLabel = new JLabel("Account Description");
        descriptionLabel.setBounds(25, 15 ,160,25);
        panel.add(descriptionLabel);

        descriptionField = new JTextField(50);
        descriptionField.setBounds(20,40,160,25);
        panel.add(descriptionField);

        emailLabel = new JLabel("Email Address");
        emailLabel.setBounds(25,70,160,25);
        panel.add(emailLabel);

        emailField = new JTextField(50);
        emailField.setBounds(20,95, 160,25);
        panel.add(emailField);

        passwordLabel = new JLabel("Email Password");
        passwordLabel.setBounds(25,125,160,25);
        panel.add(passwordLabel);

        passwordField = new JTextField(50);
        passwordField.setBounds(20,150,160,25);
        panel.add(passwordField);

        updateLabel = new JLabel("Update Account");
        updateLabel.setBounds(25,180,160,25);
        panel.add(updateLabel);

        updateField = new JTextField(50);
        updateField.setBounds(20,205,160,25);
        panel.add(updateField);

        addBtn = new JButton("Add");
        addBtn.setBounds(210,60, 80,25);
        addBtn.addActionListener(this);
        panel.add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(210,100,80,25);
        cancelBtn.addActionListener(this);
        panel.add(cancelBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(210,140,80,25);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        accountsLabel = new JLabel("Account List");
        accountsLabel.setBounds(370,15,160,20);
        panel.add(accountsLabel);

        int y = 40;
        for (String i : manager.displayAccounts()){

            accounts = new JLabel();
            accounts.setText(i);
            accounts.setBounds(370,y,160,25);
            panel.add(accounts);

            y +=25;
        }

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Add") {
            System.out.println("Adding...");


            manager.insertAccount(descriptionField.getText());
            String id  = manager.getAccounts(descriptionField.getText());
            manager.insertCredentials(id, emailField.getText(), passwordField.getText());

            descriptionField.setText("");
            emailField.setText("");
            passwordField.setText("");

        }

        if (e.getActionCommand() == "Update") {
            System.out.println("Updating");
            
        }

        if (e.getActionCommand() == "Cancel") {
            System.out.println("Cancel...");

            descriptionField.setText("");
            emailField.setText("");
            passwordField.setText("");
        }


    }
}
