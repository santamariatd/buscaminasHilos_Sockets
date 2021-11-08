package juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.net.InetAddress;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


/**
 *
 * @author Daniel Santamaría Tavera & Jonathan Ríos Gómez
 */
public class frm_juego extends javax.swing.JFrame {

    tablero tbl;
    int dimension = 0;
    int numMinas = 0;
    JButton[][] botones;
    int estadoJuego = 0;
    int puntajeMaximo = 0;
    int puntos = 0;
    Socket conn;

    public frm_juego() {
        initComponents();
        pintarTablero(10);
       this.btn_fondo1.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_botones = new javax.swing.JPanel();
        btn_nuevoJuego = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        cmb_cuadricula = new javax.swing.JComboBox<>();
        lbl_cuadricula = new javax.swing.JLabel();
        lbl_cantidadMinas = new javax.swing.JLabel();
        cmb_cantidadMinas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_puntos = new javax.swing.JTextField();
        lbl_puntos = new javax.swing.JLabel();
        lbl_puntajeMaximo = new javax.swing.JLabel();
        txt_puntajeMaximo = new javax.swing.JTextField();
        btn_fondo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscaminas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_botones.setOpaque(false);

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 790, 440));

        btn_nuevoJuego.setText("Nuevo juego");
        btn_nuevoJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevoJuegoMouseClicked(evt);
            }
        });
        getContentPane().add(btn_nuevoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 51, -1, -1));

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_aceptarMouseClicked(evt);
            }
        });
        getContentPane().add(btn_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        cmb_cuadricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8x8", "9x9", "10x10" }));
        getContentPane().add(cmb_cuadricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 52, 109, -1));

        lbl_cuadricula.setText("Cuadricula");
        getContentPane().add(lbl_cuadricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        lbl_cantidadMinas.setText("Minas");
        getContentPane().add(lbl_cantidadMinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        cmb_cantidadMinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "15", "20", "25", "30", "35", "40" }));
        getContentPane().add(cmb_cantidadMinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 52, 147, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("PUNTAJE:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 38, -1, -1));

        txt_puntos.setEditable(false);
        getContentPane().add(txt_puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 52, 81, -1));

        lbl_puntos.setText("Tienes:");
        getContentPane().add(lbl_puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 32, -1, -1));

        lbl_puntajeMaximo.setText("Necesitas");
        getContentPane().add(lbl_puntajeMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 32, -1, -1));

        txt_puntajeMaximo.setEditable(false);
        getContentPane().add(txt_puntajeMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 52, 81, -1));

        btn_fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/background_2.jpg"))); // NOI18N
        btn_fondo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_fondo1MouseClicked(evt);
            }
        });
        getContentPane().add(btn_fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 760, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aceptarMouseClicked
        this.cmb_cuadricula.setEnabled(false);
        this.cmb_cantidadMinas.setEnabled(false);
        this.btn_aceptar.setEnabled(false);
        crearTablero();
        estadoJuego = 1;
    }//GEN-LAST:event_btn_aceptarMouseClicked

    private void btn_nuevoJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoJuegoMouseClicked
        frm_juego nuevo = new frm_juego();
        this.setVisible(false);
        nuevo.setVisible(true);
    }//GEN-LAST:event_btn_nuevoJuegoMouseClicked

    private void btn_fondo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fondo1MouseClicked
        
    }//GEN-LAST:event_btn_fondo1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_juego().setVisible(true);
            }
        });
    }

    public void crearTablero() {
        int Index = this.cmb_cuadricula.getSelectedIndex();
        switch (Index) {
            case 0:
                dimension = 8;
                break;

            case 1:
                dimension = 9;
                break;

            case 2:
                dimension = 10;
                break;

            default:
                dimension = 8;
                break;
        }

        Index = this.cmb_cantidadMinas.getSelectedIndex();
        numMinas = Integer.parseInt(this.cmb_cantidadMinas.getItemAt(Index));

        tbl = new tablero(dimension, numMinas);
        tbl.ubicarMinas();
        tbl.calcularMinasAlrededor();
        tbl.imprimirTabla();
        
        usoSocket("Tabla generada");
        usoSocket("Dimensión: "+dimension+"x"+dimension);
        usoSocket("Cantidad de minas: "+numMinas);
        
        habilitarBotones(dimension);
        puntajeMaximo = dimension * dimension - numMinas;
        txt_puntajeMaximo.setText(String.valueOf(puntajeMaximo));
        txt_puntos.setText(String.valueOf(puntos));
    }

    public void pintarTablero(int dm) {
        botones = new JButton[dm][dm];
        int x = 10;
        int y = 10;
        for (int i = 0; i < dm; i++) {
            for (int j = 0; j < dm; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setVisible(false);
                botones[i][j].setEnabled(false);
                botones[i][j].setBounds(x, y, 50, 40);
                botones[i][j].setName("boton" + i + j);

                ControladorBotones cb = new ControladorBotones();
                botones[i][j].addActionListener(cb);
                pnl_botones.add(botones[i][j]);

                x += 50;
            }
            y += 40;
            x = 10;
        }
    }

    public void habilitarBotones(int dm) {
        for (int i = 0; i < dm; i++) {
            for (int j = 0; j < dm; j++) {
                botones[i][j].setVisible(true);
                botones[i][j].setEnabled(true);
            }
        }
    }

    public void deshabilitarBotones() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                botones[i][j].setEnabled(false);
            }
        }
    }

    public void verificarJuego() {
        cuentaPuntos();
        txt_puntos.setText(String.valueOf(puntos));
        if (puntos == puntajeMaximo && estadoJuego!=2) {
            deshabilitarBotones();
            estadoJuego = 3;
            JOptionPane.showMessageDialog(null, "En hora buena, usted ha ganado :D", "Felicitaciones", INFORMATION_MESSAGE);
            usoSocket("Juego ganado con "+puntos+" puntos");
        }

        if (estadoJuego == 2) {
            deshabilitarBotones();
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    String valor = tbl.entregarValor(i, j);
                    if (valor.equals("X")) {
                        botones[i][j].setText(valor);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Lo sentimos, ha perdido :(", "Fin del juego", ERROR_MESSAGE);
            usoSocket("Juego perdido con "+puntos+" puntos de "+puntajeMaximo);
        }
    }

    public void cuentaPuntos() {
        puntos = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (!tbl.entregarValor(i, j).equals("X") && !botones[i][j].isEnabled()) {
                    puntos++;
                }
            }
        }
    }

    public void adyacentesAbajo(int f, int c) {
        verificarJuego();
        if ((f >= 0 && f < (dimension)) && (c >= 0 && c < dimension)) {
            try {
                if (tbl.entregarValor(f + 1, c).equals("0")) {
                    botones[f + 1][c].setBackground(Color.cyan);
                    botones[f + 1][c].setEnabled(false);
                    adyacentesAbajo(f + 1, c);
                }
            } catch (Exception e) {
            }
        }
    }

    public void adyacentesDerecha(int f, int c) {
        verificarJuego();
        if ((f >= 0 && f < (dimension)) && (c >= 0 && c < dimension)) {
            try {
                if (tbl.entregarValor(f, c + 1).equals("0")) {
                    botones[f][c + 1].setBackground(Color.cyan);
                    botones[f][c + 1].setEnabled(false);
                    adyacentesDerecha(f, c + 1);
                    adyacentesArriba(f, c + 1);
                    adyacentesAbajo(f - 1, c);
                }
            } catch (Exception e) {

            }
        }
    }

    public void adyacentesIzquierda(int f, int c) {
        verificarJuego();
        if ((f >= 0 && f < (dimension)) && (c >= 0 && c < dimension)) {
            try {
                if (tbl.entregarValor(f, c - 1).equals("0")) {
                    botones[f][c - 1].setBackground(Color.cyan);
                    botones[f][c - 1].setEnabled(false);
                    adyacentesIzquierda(f, c - 1);
                }
            } catch (Exception e) {

            }
        }
    }

    public void adyacentesArriba(int f, int c) {
        verificarJuego();
        if ((f >= 0 && f < (dimension)) && (c >= 0 && c < dimension)) {
            try {
                if (tbl.entregarValor(f - 1, c).equals("0")) {
                    botones[f - 1][c].setBackground(Color.cyan);
                    botones[f - 1][c].setEnabled(false);
                    adyacentesArriba(f - 1, c);
                    adyacentesDerecha(f - 1, c);
                    adyacentesIzquierda(f - 1, c);
                }
            } catch (Exception e) {

            }
        }
    }

    public void adyacentes(int f, int c) {
        adyacentesArriba(f, c);
        adyacentesAbajo(f, c);
        adyacentesDerecha(f, c);
        adyacentesIzquierda(f, c);
    }
    
    public void usoSocket(String texto){
        
        try {
                InetAddress address = InetAddress.getLocalHost();
                conn = new Socket(address.getHostAddress(),9999);
                DataOutputStream flujo_salida = new DataOutputStream(conn.getOutputStream());
                flujo_salida.writeUTF(texto);
                flujo_salida.close();
                
            } catch (IOException ex) {
                System.out.println("Error al conectarse con el servidor");
            }

    }
   
    private class ControladorBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (e.getSource().equals(botones[i][j])) {
                        String valorCelda = tbl.entregarValor(i, j);
                        usoSocket("Boton presionado: "+i+","+j+" - "+valorCelda);
                        botones[i][j].setEnabled(false);
                        if (valorCelda.equals("0")) {
                            botones[i][j].setBackground(Color.cyan);
                            verificarJuego();
                            adyacentes(i, j);
                        } else {
                            botones[i][j].setText(valorCelda);
                            if (tbl.existeMina(i, j) == true) {
                                botones[i][j].setBackground(Color.RED);
                                estadoJuego = 2;
                                verificarJuego();
                            } else {
                                botones[i][j].setBackground(Color.cyan);
                                verificarJuego();
                            }
                        }

                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_fondo1;
    private javax.swing.JButton btn_nuevoJuego;
    private javax.swing.JComboBox<String> cmb_cantidadMinas;
    private javax.swing.JComboBox<String> cmb_cuadricula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_cantidadMinas;
    private javax.swing.JLabel lbl_cuadricula;
    private javax.swing.JLabel lbl_puntajeMaximo;
    private javax.swing.JLabel lbl_puntos;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JTextField txt_puntajeMaximo;
    private javax.swing.JTextField txt_puntos;
    // End of variables declaration//GEN-END:variables
}
