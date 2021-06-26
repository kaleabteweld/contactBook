package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Schema.Accout;
import Schema.Address;
import Schema.Contact;
import Schema.Contact_book_array;
import Schema.User;
import sql_fun.sql_acc_to_con;
import sql_fun.sql_edit_contect;
import sql_fun.sql_get_contect;
import sql_fun.sql_remove_contact;

class profile extends JPanel {

    profile(Accout accout) {

        setBackground(new Color(129, 66, 245));
        setPreferredSize(new Dimension(1, 90));
        setLayout(new FlowLayout(FlowLayout.CENTER, 12, 12));

        // JLabel wIcon = new JLabel(new
        // ImageIcon(getClass().getClassLoader().getResource("../img/ac.png")));
        // wIcon.setPreferredSize(new Dimension(100, 100));
        // add(wIcon);
        String localDir = System.getProperty("user.dir");
        ImageIcon imageIcon = new ImageIcon(localDir + "\\img\\ac.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon icon = new ImageIcon(newimg); // transform it back

        JLabel wIcon = new JLabel(icon);
        wIcon.setPreferredSize(new Dimension(50, 50));
        wIcon.setMaximumSize(new Dimension(50, 50));
        add(wIcon);

        JLabel email_show = new JLabel();
        email_show.setText(accout.getemail());
        add(email_show);

    }
}

class list extends JPanel {

    list(Contact_book_array contact_book, MouseListener ML) {

        setBackground(new Color(232, 228, 240));

        setVisible(true);
        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setPreferredSize(new Dimension(250, (100 * (contact_book.cur + 1))));
        setMaximumSize(new Dimension(250, (100 * (contact_book.cur + 1))));
        setMaximumSize(new Dimension(250, (100 * (contact_book.cur + 1))));
        System.out.println("contact_book size: " + contact_book.cur);
        for (int i = 0; i < contact_book.cur; i++) {

            add(new list_item(contact_book.DATA[i], ML));
        }

    }
}

class list_item extends JPanel {
    String localDir = System.getProperty("user.dir");

    list_item(Contact data, MouseListener ML) {
        setBackground(new Color(232, 228, 240));
        setPreferredSize(new Dimension(250, 100));
        setMinimumSize(new Dimension(250, 100));
        setMaximumSize(new Dimension(250, 100));

        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setName(String.valueOf(data.getContactId()));
        addMouseListener(ML);

        JLabel wIcon = new JLabel();

        ImageIcon imageIcon = new ImageIcon(localDir + "\\img\\ac.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon icon = new ImageIcon(newimg); // transform it back

        wIcon.setIcon(icon);
        wIcon.setPreferredSize(new Dimension(100, 100));
        wIcon.setMaximumSize(new Dimension(100, 100));
        add(wIcon);

        JLabel _show = new JLabel();
        _show.setText(data.getFirst_name());
        _show.setPreferredSize(new Dimension(100, 100));
        _show.setMinimumSize(new Dimension(100, 100));
        _show.setMaximumSize(new Dimension(100, 100));
        _show.setVisible(true);
        add(_show);

    }

}

class more extends JPanel {

    more() {
        setBackground(new Color(77, 79, 105));
        setPreferredSize(new Dimension(200, 90));
    }

    more(Contact data) {
        setBackground(new Color(77, 79, 105));
        setPreferredSize(new Dimension(200, 90));
        setLayout(new GridLayout(2, 1));

        // user
        JPanel user = new JPanel();
        user.setLayout(new BoxLayout(user, BoxLayout.Y_AXIS));
        user.setBackground(new Color(77, 79, 105));

        JPanel user_sub = new JPanel();
        user_sub.setLayout(new FlowLayout(12, 30, 20));
        user_sub.setBackground(new Color(77, 79, 105));

        String localDir = System.getProperty("user.dir");
        ImageIcon imageIcon = new ImageIcon(localDir + "\\img\\ac.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon icon = new ImageIcon(newimg); // transform it back

        JLabel wIcon = new JLabel(icon);
        wIcon.setPreferredSize(new Dimension(100, 100));
        wIcon.setMaximumSize(new Dimension(100, 100));
        user_sub.add(wIcon);

        JLabel text = new JLabel();
        text.setText(data.getFirst_name());
        text.setVisible(true);
        user_sub.add(text);

        text = new JLabel();
        text.setText(data.getlast_name());
        text.setVisible(true);
        user_sub.add(text);

        text = new JLabel();
        text.setText(data.getEmail());
        text.setVisible(true);
        user_sub.add(text);

        text = new JLabel();
        text.setText(data.getTelephone_number());
        text.setVisible(true);
        user_sub.add(text);

        user.add(user_sub);
        add(user);
        // adders
        JPanel adders = new JPanel();
        adders.setLayout(new BoxLayout(adders, BoxLayout.PAGE_AXIS));
        adders.setBackground(new Color(77, 79, 105));

        JPanel adders_sub = new JPanel();
        adders_sub.setLayout(new FlowLayout(12, 30, 20));
        adders_sub.setBackground(new Color(77, 79, 105));

        text = new JLabel();
        text.setText(data.getCity());
        text.setVisible(true);
        adders_sub.add(text);

        text = new JLabel();
        text.setText(data.getSub_city());
        text.setVisible(true);
        adders_sub.add(text);

        text = new JLabel();
        text.setText(data.getRegion());
        text.setVisible(true);
        adders_sub.add(text);

        text = new JLabel();
        text.setText(data.getWerda());
        text.setVisible(true);
        adders_sub.add(text);

        text = new JLabel();
        text.setText(data.getHouseNo());
        text.setVisible(true);
        adders_sub.add(text);

        adders.add(adders_sub);
        add(adders);
        adders = null;
    }

}

class addNew extends JPanel implements ActionListener {

    JTextField City;
    JTextField Sub_city;
    JTextField Region;
    JTextField Werda;
    JTextField HouseNo;

    JTextField First_name;
    JTextField last_name;
    JTextField Email;
    JTextField Telephone_number;

    Accout accout;

    addNew() {
        setBackground(new Color(77, 79, 105));
        setPreferredSize(new Dimension(200, 90));
    }

    addNew(String type, Accout accout) {
        this.accout = accout;
        setBackground(new Color(77, 79, 105));
        setPreferredSize(new Dimension(200, 90));
        setLayout(new GridLayout(3, 1));

        addUser_Input();
        addadders_input();

        addUser_cont_butt(type);

    }

    void addUser_Input() {

        // user
        JPanel user = new JPanel();
        user.setLayout(new BoxLayout(user, BoxLayout.Y_AXIS));
        user.setBackground(new Color(77, 79, 105));

        JLabel wIcon = new JLabel(new ImageIcon(("../img/#.png")));
        wIcon.setPreferredSize(new Dimension(100, 100));
        user.add(wIcon);

        JPanel user_sub = new JPanel();
        // user_sub.setLayout(new GridLayout(2, 4, 20, 20));
        // user_sub.setLayout(new FlowLayout(12, 30, 20));

        user_sub.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        user_sub.setBackground(new Color(77, 79, 105));

        JLabel text = new JLabel("First name: ");
        First_name = new JTextField();
        First_name.setPreferredSize(new Dimension(200, 20));
        // First_name.setSize(new Dimension(100, 10));
        // First_name.setMaximumSize(new Dimension(100, 10));

        gbc.gridx = 0;
        gbc.gridy = 0;
        user_sub.add(text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 19, 19, 0);
        user_sub.add(First_name, gbc);

        text = new JLabel("last name: ");
        last_name = new JTextField();
        last_name.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 0;
        gbc.gridy = 2;
        user_sub.add(text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        user_sub.add(last_name, gbc);

        text = new JLabel("Email: ");
        Email = new JTextField();
        Email.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 1;
        gbc.gridy = 0;

        user_sub.add(text, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        user_sub.add(Email, gbc);

        text = new JLabel("Telephone number: ");
        Telephone_number = new JTextField();
        Telephone_number.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 1;
        gbc.gridy = 2;

        user_sub.add(text, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        user_sub.add(Telephone_number, gbc);

        user.add(user_sub);
        add(user);
    }

    void addadders_input() {
        // adders
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel adders = new JPanel();
        adders.setLayout(new BoxLayout(adders, BoxLayout.PAGE_AXIS));
        adders.setBackground(new Color(77, 79, 105));

        JPanel adders_sub = new JPanel();
        adders_sub.setLayout(new GridBagLayout());
        adders_sub.setBackground(new Color(77, 79, 105));

        JLabel text = new JLabel("City: ");
        City = new JTextField();
        City.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        adders_sub.add(text, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 19, 19, 0);
        adders_sub.add(City, gbc);

        text = new JLabel("Sub city: ");
        Sub_city = new JTextField();
        Sub_city.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        adders_sub.add(text, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        adders_sub.add(Sub_city, gbc);

        text = new JLabel("Region: ");
        Region = new JTextField();
        Region.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 1;
        gbc.gridy = 0;
        adders_sub.add(text, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        adders_sub.add(Region, gbc);

        text = new JLabel("Werda: ");
        Werda = new JTextField();
        Werda.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        adders_sub.add(text, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        adders_sub.add(Werda, gbc);

        text = new JLabel("HouseNo: ");
        HouseNo = new JTextField();
        HouseNo.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 2;
        gbc.gridy = 2;
        adders_sub.add(text, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        adders_sub.add(HouseNo, gbc);

        adders.add(adders_sub);
        add(adders);
        adders = null;
    }

    void addUser_cont_butt(String type) {
        // kaleabteweld3@gmail.com

        // sava or add button
        JPanel conter = new JPanel();
        conter.setBackground(new Color(77, 79, 105));
        conter.setLayout(new GridBagLayout());

        JButton saAdd = new JButton(type + " a new contect");
        saAdd.setName("add_new");
        saAdd.setPreferredSize(new Dimension(200, 20));
        saAdd.addActionListener(this);
        conter.add(saAdd);
        add(conter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getName() == "add_new") {

            Address ad = new Address(Region.getText(), City.getText(), Sub_city.getText(), Werda.getText(),
                    HouseNo.getText());
            User su = new User(First_name.getText(), last_name.getText(), Telephone_number.getText(), Email.getText(),
                    ad);
            Contact contact = new Contact(su, ad, -1);
            int AccoutId = accout.getAccoutId();

            sql_fun.sql_add_new_contect.addData(contact, AccoutId);

            Accout newAccout_info = sql_fun.sql_get_accout.getData(AccoutId);
            Contact_book_array newContact_book = sql_fun.sql_acc_to_con.getData(AccoutId);

            if (newAccout_info != null && newContact_book != null) {
                root.render(newAccout_info, newContact_book, null);
            }

        }

    }
}

class Editc extends JPanel implements ActionListener {

    JTextField City;
    JTextField Sub_city;
    JTextField Region;
    JTextField Werda;
    JTextField HouseNo;

    JTextField First_name;
    JTextField last_name;
    JTextField Email;
    JTextField Telephone_number;

    int ContactId;
    int AccoutId;
    Contact contact;

    Editc() {
        setBackground(new Color(77, 79, 105));
        setPreferredSize(new Dimension(200, 90));
    }

    Editc(String type, int ContactId, int AccoutId) {
        this.ContactId = ContactId;
        this.AccoutId = AccoutId;
        contact = sql_get_contect.getData(ContactId);

        setBackground(new Color(77, 79, 105));
        setPreferredSize(new Dimension(200, 90));
        setLayout(new GridLayout(3, 1));

        addUser_Input();
        addadders_input();

        addUser_cont_butt(type);

    }

    void addUser_Input() {

        // user
        JPanel user = new JPanel();
        user.setLayout(new BoxLayout(user, BoxLayout.Y_AXIS));
        user.setBackground(new Color(77, 79, 105));

        JLabel wIcon = new JLabel(new ImageIcon(("../img/#.png")));
        wIcon.setPreferredSize(new Dimension(100, 100));
        user.add(wIcon);

        JPanel user_sub = new JPanel();
        // user_sub.setLayout(new GridLayout(2, 4, 20, 20));
        // user_sub.setLayout(new FlowLayout(12, 30, 20));

        user_sub.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        user_sub.setBackground(new Color(77, 79, 105));

        JLabel text = new JLabel("First name: ");
        First_name = new JTextField(contact.getFirst_name());
        First_name.setPreferredSize(new Dimension(200, 20));
        // First_name.setSize(new Dimension(100, 10));
        // First_name.setMaximumSize(new Dimension(100, 10));

        gbc.gridx = 0;
        gbc.gridy = 0;
        user_sub.add(text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 19, 19, 0);
        user_sub.add(First_name, gbc);

        text = new JLabel("last name: ");
        last_name = new JTextField(contact.getlast_name());
        last_name.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 0;
        gbc.gridy = 2;
        user_sub.add(text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        user_sub.add(last_name, gbc);

        text = new JLabel("Email: ");
        Email = new JTextField(contact.getEmail());
        Email.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 1;
        gbc.gridy = 0;

        user_sub.add(text, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        user_sub.add(Email, gbc);

        text = new JLabel("Telephone number: ");
        Telephone_number = new JTextField(contact.getTelephone_number());
        Telephone_number.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 1;
        gbc.gridy = 2;

        user_sub.add(text, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        user_sub.add(Telephone_number, gbc);

        user.add(user_sub);
        add(user);
    }

    void addadders_input() {
        // adders
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel adders = new JPanel();
        adders.setLayout(new BoxLayout(adders, BoxLayout.PAGE_AXIS));
        adders.setBackground(new Color(77, 79, 105));

        JPanel adders_sub = new JPanel();
        adders_sub.setLayout(new GridBagLayout());
        adders_sub.setBackground(new Color(77, 79, 105));

        JLabel text = new JLabel("City: ");
        City = new JTextField(contact.getCity());
        City.setPreferredSize(new Dimension(200, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        adders_sub.add(text, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 19, 19, 0);
        adders_sub.add(City, gbc);

        text = new JLabel("Sub city: ");
        Sub_city = new JTextField(contact.getSub_city());
        Sub_city.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        adders_sub.add(text, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        adders_sub.add(Sub_city, gbc);

        text = new JLabel("Region: ");
        Region = new JTextField(contact.getRegion());
        Region.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 1;
        gbc.gridy = 0;
        adders_sub.add(text, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        adders_sub.add(Region, gbc);

        text = new JLabel("Werda: ");
        Werda = new JTextField(contact.getWerda());
        Werda.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        adders_sub.add(text, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        adders_sub.add(Werda, gbc);

        text = new JLabel("HouseNo: ");
        HouseNo = new JTextField(contact.getHouseNo());
        HouseNo.setPreferredSize(new Dimension(200, 20));
        gbc.gridx = 2;
        gbc.gridy = 2;
        adders_sub.add(text, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        adders_sub.add(HouseNo, gbc);

        adders.add(adders_sub);
        add(adders);
        adders = null;
    }

    void addUser_cont_butt(String type) {
        // kaleabteweld3@gmail.com

        // sava or add button
        JPanel conter = new JPanel();
        conter.setBackground(new Color(77, 79, 105));
        conter.setLayout(new GridBagLayout());

        JButton saAdd = new JButton(type + " this contect");
        saAdd.setName("edit_new");
        saAdd.setPreferredSize(new Dimension(200, 20));
        saAdd.addActionListener(this);
        conter.add(saAdd);
        add(conter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getName() == "edit_new") {

            Address ad = new Address(Region.getText(), City.getText(), Sub_city.getText(), Werda.getText(),
                    HouseNo.getText());
            User su = new User(First_name.getText(), last_name.getText(), Telephone_number.getText(), Email.getText(),
                    ad);
            Contact newContact = new Contact(su, ad, -1);

            sql_edit_contect.editData(ContactId, newContact);
            Contact_book_array data = sql_acc_to_con.getData(AccoutId);
            if (data != null) {
                root.render(root.accout, data, null);
            } else {
                JOptionPane.showMessageDialog(root.frame, "error geting data");
            }

        }

    }
}

public class show extends JPanel implements ActionListener, MouseListener {

    JMenuItem add;
    JMenuItem remove;
    JMenuItem edit;

    Accout accout;
    Contact_book_array Contact_book;

    JPanel Profile;
    list List;
    more More;
    addNew AddNew;
    Editc editc;

    int curr = -1;

    public show(Accout accout, Contact_book_array Contact_book) {
        this.accout = accout;
        this.Contact_book = Contact_book;
        render();
    }

    public void render() {
        System.out.print("show: ");
        System.out.print("accout: ");
        if (accout == null || Contact_book == null) {
            System.out.println("not set");

        } else {
            accout.a();
            addMenuBar();

            Profile = new profile(accout);
            List = new list(Contact_book, (MouseListener) this);
            More = new more();
            JScrollPane scrollp = new JScrollPane(List, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            setLayout(new BorderLayout());
            add(Profile, BorderLayout.NORTH);
            add(scrollp, BorderLayout.WEST);
            add(More, BorderLayout.CENTER);

            // setLayout(new GridBagLayout());
            // GridBagConstraints gbc = new GridBagConstraints();

            // gbc.fill = GridBagConstraints.HORIZONTAL;

            // gbc.gridx = 0;
            // gbc.gridy = 0;
            // add(Profile, gbc);

            // gbc.fill = GridBagConstraints.NONE;
            // gbc.gridx = 1;
            // gbc.gridy = 0;
            // add(scrollp, gbc);

            // gbc.fill = GridBagConstraints.NONE;
            // gbc.gridx = 1;
            // gbc.gridy = 1;
            // add(More, gbc);

        }
    }

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu contact = new JMenu("contact");

        add = new JMenuItem("add");
        add.addActionListener(this);
        contact.add(add);

        remove = new JMenuItem("remove");
        remove.addActionListener(this);
        contact.add(remove);

        edit = new JMenuItem("edit");
        edit.addActionListener(this);
        contact.add(edit);

        menuBar.add(contact);
        root.frame.setJMenuBar(menuBar);
        root.frame.revalidate();
        root.frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            curr = -1;
            System.out.println("add mun");
            if (More != null) {
                remove(More);
            }
            if (AddNew != null) {
                remove(AddNew);
            }
            if (editc != null) {
                remove(editc);
            }
            AddNew = new addNew("add", this.accout);
            add(AddNew, BorderLayout.CENTER);
            revalidate();
            repaint();
        }
        if (e.getSource() == remove) {
            System.out.println("remove mun");

            if (curr < 0) {
                JOptionPane.showMessageDialog(root.frame, "select a contact,like how u will select to see more info");
            } else {

                int ContactId = curr;
                int AccoutId = accout.getAccoutId();

                sql_remove_contact.RemoveData(ContactId, AccoutId);

                Contact_book_array newContact_book = sql_acc_to_con.getData(AccoutId);
                root.render(root.accout, newContact_book, null);

            }

        }
        if (e.getSource() == edit) {
            System.out.println("edit mun");

            if (curr < 0) {
                JOptionPane.showMessageDialog(root.frame, "select a contact,like how u will select to see more info");
            } else {

                int ContactId = curr;
                int AccoutId = accout.getAccoutId();

                if (More != null) {
                    remove(More);
                }
                if (AddNew != null) {
                    remove(AddNew);
                }
                if (editc != null) {
                    remove(editc);
                }
                editc = new Editc("edit", ContactId, AccoutId);
                add(editc, BorderLayout.CENTER);
                revalidate();
                repaint();

            }

            // if (More != null) {
            // remove(More);8
            // }
            // if (AddNew != null) {
            // remove(AddNew);
            // }
            // AddNew = new addNew("add", this.accout);
            // add(AddNew, BorderLayout.CENTER);
            // revalidate();
            // repaint();
        }
        // if (((JButton) e.getSource()).getName() == "add_new") {
        // System.out.println("sava");

        // }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int id = Integer.parseInt(((JPanel) e.getSource()).getName());
        curr = id;
        // System.out.println("mouseClicked : " + ((JPanel) e.getSource()).getName());
        Contact data = sql_fun.sql_get_contect.getData(id);
        if (data == null) {
            System.out.println("error geting data");
        } else {
            if (More != null) {
                remove(More);
            }
            if (AddNew != null) {
                remove(AddNew);
            }
            if (editc != null) {
                remove(editc);
            }
            More = new more(data);
            add(More, BorderLayout.CENTER);
            revalidate();
            repaint();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
