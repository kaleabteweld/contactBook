
import components.root;
import sql_fun.sql_main;

public class app {

    public static void main(String[] args) {
        sql_main.connect();
        root.render(null, null, null);
        // new main();
    }
}

// class main {

// Accout Accout = null;
// boolean login_check = false;

// final JFrame frame = new JFrame();
// final JPanel Show = new show();

// final ActionListener mh = new logl();
// final JPanel Login = new login(mh);

// final CardLayout cl = new CardLayout();

// main() {
// // UI INIT
// frame.setSize(new Dimension(1000, 700));
// frame.setLocationRelativeTo(null);
// frame.setLayout(cl);

// frame.add(Login, "Login");
// frame.add(Show, "Show");

// if (Accout != null) {
// setShow();
// } else {
// setLogin();
// }

// frame.setVisible(true);
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// }

// void setShow() {
// frame.setTitle("show");
// cl.show(frame.getContentPane(), "Show");

// // frame.getContentPane().remove(Login);
// // frame.getContentPane().add(Show);
// // frame.revalidate();
// // frame.repaint();

// }

// void setLogin() {
// frame.setTitle("login");
// cl.show(frame.getContentPane(), "login");

// // frame.getContentPane().remove(Show);
// // frame.getContentPane().add(Login);
// // frame.revalidate();
// // frame.repaint();
// }

// void reRender() {
// System.out.println("reRender");
// }

// class logl implements ActionListener {

// public String email;
// public String _password;

// @Override
// public void actionPerformed(ActionEvent e) {

// System.out.println(e.getActionCommand());

// setShow();

// // System.out.println(((JButton) e.getSource()).getText());

// }
// }

// }
