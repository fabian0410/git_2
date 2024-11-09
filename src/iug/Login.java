package iug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    // Creacion de componentes
    private JTextField tfCC;
    private JButton iniciar;
    private JPanel main;
    private JPanel login;
    private JPasswordField tfpass;

    // Ejecuta init
    public Login(){
        init();
    }
    // configuracion de los componentes
    private void init(){

        Integer cc = 1234567890;
        String password = "password";

        JFrame jFrame = new JFrame();
        jFrame.setSize(300,300);
        jFrame.setTitle("Git 2");
        jFrame.setVisible(true);
        jFrame.add(main);


        tfCC.setText(String.valueOf(cc));
        tfpass.setText(password);

        // Boton de Validacion
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar que no esté vacio
                if (tfCC.getText().isEmpty() || tfpass.getPassword().length == 0){
                    tfCC.setText("");
                    tfpass.setText("");
                }
                else {
                    // Validar que sean correctos los datos
                    char[] p = tfpass.getPassword();
                    String validarPass = String.valueOf(p);

                    if (Integer.valueOf(tfCC.getText()).equals(cc) && validarPass.equals(password)){
                        System.out.println("Correcto");
                        Bienvenido n = new Bienvenido();
                        jFrame.setVisible(false);
                    }
                    else {
                        System.out.println("Incorrecto");
                    }
                }
            }
        });
    }
}
