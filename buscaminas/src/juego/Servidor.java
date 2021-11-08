package juego;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
       
        MarcoServidor mimarco = new MarcoServidor();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoServidor extends JFrame implements Runnable {

    public MarcoServidor() {

        setBounds(1200, 300, 280, 350);
        JPanel milamina = new JPanel();
        milamina.setLayout(new BorderLayout());
        areatexto = new JTextArea();
        milamina.add(areatexto, BorderLayout.CENTER);
        add(milamina);
        setVisible(true);
        Thread hilo = new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {
        try {
            System.out.println("Servidor en uso");
            ServerSocket serv = new ServerSocket(9999);

            while (true) {
                Socket conn = serv.accept();
                DataInputStream flujo_entrada = new DataInputStream(conn.getInputStream());
                String mensaje = flujo_entrada.readUTF();
                areatexto.append("\n" + mensaje);
                conn.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JTextArea areatexto;
}
