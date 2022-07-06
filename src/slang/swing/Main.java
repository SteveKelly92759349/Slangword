package slang.swing;
import java.awt.EventQueue;


import java.awt.*;
import slang.swing.login.LoginSWFrame;
import slang.swing.login.LoginView;
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                LoginSWFrame controller = new LoginSWFrame(view);
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }

}



