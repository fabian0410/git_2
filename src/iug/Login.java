package iug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField tfcc;
    private JButton iniciar;
    private JPanel main;
    private JPanel login;
    private JPasswordField tfpass;

    public Login(){
        init();
    }
    private void init(){

        Integer cc = 1234567890;
        String password = "password";

        JFrame jFrame = new JFrame();
        jFrame.setSize(300,300);
        jFrame.setTitle("Git 2");
        jFrame.setVisible(true);
        jFrame.add(main);

        tfcc.setText(String.valueOf(cc));
        tfpass.setText(password);


        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bienvenido n = new Bienvenido();
                jFrame.setVisible(false);
            }
        });
    }
}
