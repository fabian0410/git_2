package iug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenido {
    private JPanel Bienvenido;

    public Bienvenido(){
        init();
    }
    private void init(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(400,400);
        jFrame.setTitle("Bienvenido");
        jFrame.setVisible(true);
        jFrame.add(Bienvenido);
    }
}
