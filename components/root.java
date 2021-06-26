package components;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Schema.Accout;
import Schema.Contact_book_array;

public class root {

    static Accout accout = null;
    static Contact_book_array Contact_book = null;

    static final JFrame frame = new JFrame();

    // ActionListener
    static final ActionListener mh = new logl();
    // components
    static JPanel Show = new show(accout, Contact_book);
    static final JPanel Login = new login(mh);
    static final JPanel signIn = new signIn(mh);

    static final CardLayout cl = new CardLayout();

    public static void render(Accout _Accout, Contact_book_array _Contact_book, String view) {

        if (_Accout != null) {
            accout = _Accout;
        }
        if (_Contact_book != null) {
            Contact_book = _Contact_book;
        }
        System.out.println("root init");

        // UI INIT
        frame.setSize(new Dimension(1000, 700));
        frame.setLocationRelativeTo(null);

        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("../img/3d_bars-wide.jpg"));
        bg.setSize(new Dimension(1000, 700));
        bg.setVisible(true);
        bg.setBounds(0, 0, 1000, 700);
        bg.setBackground(new Color(0, 0, 0));
        frame.add(bg);

        frame.setLayout(cl);

        // accout = new Accout(1, "kaleabteweld3@gmail.com", "kaleab1010");

        // Address ad = new Address("region1", "city1", "sub_city1", "werda1",
        // "houseNo1");
        // User us = new User("First_name1", "last_name1", "telephone_number1",
        // "email1", ad);
        // Contact a = new Contact(us, ad, 1);
        // Contact_book = new Contact_book_array(a);

        // ad = new Address("region2", "city2", "sub_city2", "werda2", "houseNo2");
        // us = new User("First_name2", "last_name2", "telephone_number2", "email2",
        // ad);
        // a = new Contact(us, ad, 2);
        // Contact_book.append(a);

        // ad = new Address("region3", "city3", "sub_city3", "werda3", "houseNo3");
        // us = new User("First_name3", "last_name3", "telephone_number3", "email3",
        // ad);
        // a = new Contact(us, ad, 3);
        // Contact_book.append(a);

        // ad = new Address("region4", "city4", "sub_city4", "werda4", "houseNo4");
        // us = new User("First_name4", "last_name4", "telephone_number4", "email4",
        // ad);
        // a = new Contact(us, ad, 4);
        // Contact_book.append(a);

        frame.add(Login, "Login");
        frame.add(Show, "Show");
        frame.add(signIn, "signIn");

        if (accout != null) {

            Show = new show(accout, Contact_book);
            frame.add(Show, "Show");
            setShow();
        } else {
            if (view == null) {
                setLogin();
            } else {
                setsignIn();
            }

        }

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void setShow() {
        frame.setTitle("show");
        cl.show(frame.getContentPane(), "Show");

        // frame.getContentPane().remove(Login);
        // frame.getContentPane().add(Show);
        // frame.revalidate();
        // frame.repaint();

    }

    static void setLogin() {
        frame.setTitle("login");
        cl.show(frame.getContentPane(), "login");

        // frame.getContentPane().remove(Show);
        // frame.getContentPane().add(Login);
        // frame.revalidate();
        // frame.repaint();
    }

    static void setsignIn() {
        frame.setTitle("signIn");
        cl.show(frame.getContentPane(), "signIn");

        // frame.getContentPane().remove(Show);
        // frame.getContentPane().add(Login);
        // frame.revalidate();
        // frame.repaint();
    }

    static class logl implements ActionListener {

        public String email;
        public String _password;

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println(e.getActionCommand());

            setShow();

            // System.out.println(((JButton) e.getSource()).getText());

        }
    }
}
