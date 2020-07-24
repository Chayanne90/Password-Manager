import javax.swing.*;

public class PwdManagerGUI {

    /* Labels */
    private static JLabel descriptionLabel;
    private static JLabel emailLabel;
    private static JLabel passwordLabel;
    private static JLabel updateLabel;
    private static JLabel accountsLabel;

    /* Input Fields */
    private static JTextField emailField;
    private static JTextField descriptionField;
    private static JTextField passwordField;
    private static JTextField updateField;

    /* Buttons */
    private static JButton cancelBtn;
    private static JButton updateBtn;
    private static JButton addBtn;


    public PwdManagerGUI() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(550,350);
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
        panel.add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(210,100,80,25);
        panel.add(cancelBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(210,140,80,25);
        panel.add(updateBtn);


        accountsLabel = new JLabel("Account List");
        accountsLabel.setBounds(370,15,160,25);
        panel.add(accountsLabel);























        frame.setVisible(true);
    }

}
