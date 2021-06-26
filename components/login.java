package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sql_fun.*;
import Schema.*;
// import components.events.*;

class user_input_dev extends JPanel implements ActionListener {

    public ActionListener login_buttin;
    JTextField email;
    JPasswordField password;

    public user_input_dev(ActionListener login_buttin) {

        this.login_buttin = login_buttin;

        setPreferredSize(new Dimension(600, 400));
        setBackground(new Color(129, 66, 245));

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // JPanel temp = new JPanel();

        gbc.gridy = 0;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(-1, 10, 30, 20);
        add(new JLabel("email: "), gbc);
        email = new JTextField();

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.6;
        gbc.weighty = 0.3;
        gbc.gridy = 1;
        add(email, gbc);

        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.weighty = 0.1;
        add(new JLabel("password: "), gbc);
        password = new JPasswordField();

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.6;
        gbc.weighty = 0.3;
        gbc.gridy = 3;
        add(password, gbc);

        JButton go = new JButton("go");

        gbc = new GridBagConstraints();
        gbc.gridy = 4;
        gbc.weighty = 0.2;
        add(go, gbc);

        JButton goo = new JButton("new accout");
        goo.addActionListener((ActionListener) this);

        gbc = new GridBagConstraints();
        gbc.gridy = 5;
        gbc.weighty = 0.2;
        add(goo, gbc);

        go.addActionListener((ActionListener) this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "go") {
            Accout accout = sql_fun.sql_login.logIN(email.getText(), password.getText());
            if (accout != null) {
                accout.a();
                Contact_book_array Contact_book = sql_acc_to_con.getData(accout.getAccoutId());
                if (Contact_book.cur >= 1) {
                    root.render(accout, Contact_book, null);
                } else {
                    root.render(accout, Contact_book, null);
                }

            } else {
                // error login
                JOptionPane.showMessageDialog(root.frame, "login error");
            }
        } else {
            root.render(null, null, "");
        }

    }

}

public class login extends JPanel {

    public ActionListener login_buttin;

    public login(ActionListener login_buttin) {
        this.login_buttin = login_buttin;

        setLayout(null);

        // JLabel wIcon = new JLabel();

        // String localDir = System.getProperty("user.dir");
        // ImageIcon imageIcon = new ImageIcon(localDir + "\\img\\3d_bars-wide.jpg"); //
        // load the image to a imageIcon
        // Image image = imageIcon.getImage(); // transform it
        // Image newimg = image.getScaledInstance(1000, 700,
        // java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        // ImageIcon icon = new ImageIcon(newimg); // transform it back

        // wIcon.setIcon(icon);
        // wIcon.setPreferredSize(new Dimension(1000, 700));
        // wIcon.setMaximumSize(new Dimension(1000, 700));
        // wIcon.setBounds(0, 0, 1000, 700);
        // add(wIcon);

        JPanel jp = new JPanel();
        jp.setLayout(new GridBagLayout());
        jp.setBackground(new Color(66, 135, 245));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        jp.add(new user_input_dev(login_buttin), gbc);

        jp.setBounds(0, 0, 1000, 700);
        add(jp);

        // gbc = new GridBagConstraints();
        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // add(new g_f_t(), gbc);

        // add(new user_input_dev(), BorderLayout.CENTER);
        // add(new g_f_t(), BorderLayout.SOUTH);
        // add(new g_f_t(), BorderLayout.NORTH);
        // add(new temp(), BorderLayout.EAST);
        // add(new temp(), BorderLayout.WEST);

    }

}
