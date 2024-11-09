package iug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenido {
    // creacion de componentes
    private JPanel Bienvenido;
    // ejecuta init
    public Bienvenido(){
        init();
    }
    // configuracion de los componentes
    private void init(){
        // configuracion de la vista
        JFrame jFrame = new JFrame();
        jFrame.setSize(400,400);
        jFrame.setTitle("Bienvenido");
        jFrame.setVisible(true);
        jFrame.add(Bienvenido);
    }
}
