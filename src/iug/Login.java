package iug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import persistencia.Conexion;

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

//        Integer cc = 1122334455;
//        String password = "pass123";

        // Configuracion de la vista
        JFrame jFrame = new JFrame();
        jFrame.setSize(400,400);
        jFrame.setTitle("Login");
        jFrame.setVisible(true);
        jFrame.add(main);


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

                    String consulta = "SELECT * FROM usuario Where cc = "+Integer.valueOf(tfCC.getText())+" and contraseña = '"+validarPass+"'";
                    Conexion conexion = new Conexion();
                    Connection con = conexion.getConexion();
                    String[] result = conexion.validar(consulta);
                    conexion.cerrarConec();

                    Integer cc = Integer.valueOf(result[0]);
                    String password = result[2];

                    if (Integer.valueOf(tfCC.getText()).equals(cc) && validarPass.equals(password)){
                        System.out.println("Correcto");
                        Bienvenido n = new Bienvenido();
                        n.setNombre(result[1]);
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
