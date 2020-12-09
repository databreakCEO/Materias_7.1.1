/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materias;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import jroundborder.JLabelRound;

/**
 *
 * @author Daniel Gonzalez Cabrera
 */
public class Loggin extends javax.swing.JFrame {

    /**
     * Creates new form Loggin
     */
    int contador = 0;
    Cuenta c;
    File carpeta;
    String[] listado;
    String directorio;
    ImageIcon icon;
    Image image;
    JLabelRound labelCircular = new JLabelRound();
    boolean cambiar = false;
    RoundedBorder rb;
    Conexiones con;
    String carrera, numControl;
    String alu[];

    public Loggin() {
        initComponents();
        try {
            this.setTitle("Inicio de sesión");
            try {
                this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/rayo.jpg")).getImage());
            } catch (Exception e) {

            }//        jLabImagenFondo.setSize(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
            int size = 100;
//            rb=new RoundedBorder(40);
//            jLabEntrar.setBorder(rb);
            con = new Conexiones("ITLDB", "root", "", "localhost");
//            Font font = jLabNuevaCuenta.getFont();
//            Map attributes = new HashMap<>(font.getAttributes());
//            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//            jLabNuevaCuenta.setFont(font.deriveFont(attributes));
//
//            font = jLabEliminar.getFont();
//            attributes = new HashMap<>(font.getAttributes());
//            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//            jLabEliminar.setFont(font.deriveFont(attributes));

            labelCircular.setBounds(0, 0, size, size);
            icon = new ImageIcon(getClass().getResource("/Imagenes/ITL.png"));
            image = Imagenes.getScaledImage(icon.getImage(), this.labelCircular.getWidth(), this.labelCircular.getHeight());
            this.labelCircular.setIcon(new ImageIcon(image));
            jPanel1.add(labelCircular);

//            icon = new ImageIcon(getClass().getResource("/Imagenes/cancelar.jpg"));
//            image = Imagenes.getScaledImage(icon.getImage(), this.jLabCancelar.getWidth(), this.jLabCancelar.getHeight());
//            this.jLabCancelar.setIcon(new ImageIcon(image));
            this.setLocationRelativeTo(null);
//            this.jTextNick.setVisible(false);
//            this.jLabel1.setVisible(false);
//            jLabCancelar.setVisible(false);

            carpeta = new File("Materias por carrera");
            listado = carpeta.list();
            for (int i = 0; i < listado.length; i++) {
                crearArchivos(listado[i]);

            }
        } catch (Exception e) {

        }
    }

    public void crearArchivos(String nombre) {
        try {
            Archivo archivo = new Archivo("Materias por carrera\\" + nombre);
            archivo.crearLectura();
            String line = archivo.LeerLinea();
            ArrayList<String> materias = new ArrayList<>();
            ArrayList<String> claves = new ArrayList<>();
            ArrayList<String> horarios = new ArrayList<>();
            ArrayList<String> maestros = new ArrayList<>();
            while (line != null) {
                String cadena = "";
                String cadenaTotal = "";
                String lineNueva = "";
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != " ".charAt(0) && line.charAt(i) != "\t".charAt(0) && i < line.length()) {
                        if (((int) line.charAt(i)) < 47 || ((int) line.charAt(i)) > 58) {
                            cadena += line.charAt(i) + "";

                        } else {

                            break;
                        }
                    } else {
                        cadenaTotal += cadena + " ";
                        cadena = "";

                    }
                }
                materias.add(cadenaTotal);

                for (int i = cadenaTotal.length(); i < line.length(); i++) {
                    lineNueva += line.charAt(i);
                }
                line = lineNueva;
                cadena = "";
                cadenaTotal = "";
                lineNueva = "";
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != " ".charAt(0) && line.charAt(i) != "\t".charAt(0)) {
                        cadena += line.charAt(i);
                    } else {
                        break;
                    }
                }
                claves.add(cadena);
                for (int i = cadena.length(); i < line.length(); i++) {
                    lineNueva += line.charAt(i);
                }
                line = lineNueva;
                cadena = "";
                cadenaTotal = "";
                lineNueva = "";
                int con = 0;
                for (int i = 1; i < line.length(); i++) {

                    if (line.charAt(i) == " ".charAt(0) || line.charAt(i) == "\t".charAt(0)) {
                        con++;
                        if (con == 5) {
                            cadenaTotal += cadena;
                            break;
                        } else {
                            cadena += line.charAt(i);
                        }
                    } else {
                        cadena += line.charAt(i);
                    }
                }

                horarios.add(cadena);
                for (int i = cadena.length() + 2; i < line.length(); i++) {
                    lineNueva += line.charAt(i);
                }
                line = lineNueva;
                maestros.add(line);

                line = archivo.LeerLinea();

            }
            String n = "";
            for (int i = 0; i < nombre.length() - 4; i++) {
                n += nombre.charAt(i) + "";
            }
            String materia = "";
            for (int i = 0; i < materias.size(); i++) {
                for (int j = 0; j < materias.get(i).length() - 1; j++) {
                    materia += materias.get(i).charAt(j);
                }
                materias.set(i, materia);
                materia = "";
            }
            nombre = n;
            Archivo NombreMaterias = new Archivo(n + "\\NombreMaterias.txt");
            Archivo ClaveMaterias = new Archivo(n + "\\ClaveMaterias.txt");
            Archivo HorarioMaterias = new Archivo(n + "\\HorarioMaterias.txt");
            Archivo MaestroMaterias = new Archivo(n + "\\MaestroMaterias.txt");
            NombreMaterias.crearEscritura();
            ClaveMaterias.crearEscritura();
            HorarioMaterias.crearEscritura();
            MaestroMaterias.crearEscritura();
            for (int i = 0; i < materias.size(); i++) {
                NombreMaterias.EscribirLinea(materias.get(i));
                ClaveMaterias.EscribirLinea(claves.get(i));
                HorarioMaterias.EscribirLinea(horarios.get(i));
                MaestroMaterias.EscribirLinea(maestros.get(i));
                if (i < materias.size() - 1) {
                    NombreMaterias.NuevaLinea();
                    ClaveMaterias.NuevaLinea();
                    HorarioMaterias.NuevaLinea();
                    MaestroMaterias.NuevaLinea();

                }
            }

            NombreMaterias.CerrarEscritura();
            ClaveMaterias.CerrarEscritura();
            HorarioMaterias.CerrarEscritura();
            MaestroMaterias.CerrarEscritura();
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabEntrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextUser = new javax.swing.JTextField();
        jTextPass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(340, 365));
        setResizable(false);
        setSize(new java.awt.Dimension(341, 320));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabEntrar.setBackground(new java.awt.Color(102, 102, 255));
        jLabEntrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jLabEntrar.setText("          ENTRAR");
        jLabEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabEntrar.setOpaque(true);
        jLabEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabEntrarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 240, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 120, 120));

        jTextUser.setToolTipText("Usuario");
        jTextUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jTextUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 240, 30));

        jTextPass.setToolTipText("Contraseña");
        jTextPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jTextPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 240, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void crearListado() {
        try {
            c = new Cuenta(this.carrera, this.carrera + "\\Usuarios\\" + numControl, numControl, alu);

//                c.cuenta = this.jComboBox1.getSelectedItem().toString();
            c.setVisible(true);
            this.setVisible(false);

        } catch (Exception e) {

        }
    }

    private void jLabEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabEntrarMouseClicked
        // TODO add your handling code here:

//        alu = con.Log(jTextUser.getText(), jTextPass.getText());
        alu = con.Log("16130809", "fullcounter");

        for (String alu1 : alu) {
            System.out.println(alu1);
        }
        if (!alu[0].equals("null") && !alu[1].equals("null")) {
            String[] split = alu[1].split(" ");
            carrera = split[0];
            numControl = alu[0];

            try {
                boolean band = false, user = false;
                carpeta = new File(carrera + "\\Usuarios");
                System.out.println(Arrays.toString(carpeta.list()));
                listado = carpeta.list() == null ? null : carpeta.list();
                try {
                    System.out.println(listado);
                } catch (Exception ex) {
                    listado = null;
                }
                if (listado != null) {
                    for (String listado1 : listado) {
                        if (numControl.equals(listado1)) {
                            user = true;
                            break;
                        }
                    }
                }
                System.out.println(user);
                if (!user) {
                    String nombreArchivo = numControl;
                    nombreArchivo = nombreArchivo.toUpperCase();
                    carpeta = new File(carrera + "\\Usuarios");
//                carpeta = new File(PathComplemento.substring(0, PathComplemento.length()-5)+carrera + "\\Usuarios");

//                    try {
//                        listado = carpeta.list();
//                        if (listado.length > 0) {
//                            for (int i = 0; i < listado.length; i++) {
//                                if (nombreArchivo.equals(listado[i])) {
//                                    band = true;
//                                    break;
//                                }
//                            }
//                        }
//                    } catch (Exception e) {
//
//                    }
                    if (band == false) {

                        try {
                            System.out.println(carrera);
                            Archivo a1 = new Archivo(carrera + "\\NombreMaterias.txt");
                            if (a1.crearLectura()) {

                                File direct = new File(carrera + "\\Usuarios\\" + nombreArchivo);
                                direct.mkdir();
                                direct.createNewFile();
                                Archivo datos = new Archivo(direct + "\\datos.txt");
                                datos.crearEscritura();
                                Archivo kardex = new Archivo(direct + "\\kardex.txt");
                                kardex.crearEscritura();
                                Archivo a2 = new Archivo(direct + "\\materiasEstado.txt");
                                a2.crearEscritura();
                                Archivo guardar = new Archivo(direct + "\\horariosGuardados.txt");
                                guardar.crearEscritura();
                                ArrayList<String> lista = new ArrayList<>();
                                String line = a1.LeerLinea();
                                band = true;
                                int cont=0;
                                while (line != null) {
                                    band = true;
                                    for (int j = 0; j < lista.size(); j++) {
                                        if (line.equals(lista.get(j)) || line.equals("RESIDENCIA") || line.equals("RESIDENCIA PROFESIONAL") || line.equals("TUTORIA")) {
                                            band = false;
                                        }
                                    }
                                    if (band == true) {
                                        lista.add(line);
                                    }
                                    line = a1.LeerLinea();
                                }
                                String[][] kard = con.Kardex(numControl);
                                boolean coincide = false;
                                for (int j = 0; j < lista.size(); j++) {
                                    coincide = false;
                                    for (String[] kard1 : kard) {
                                        System.out.println(lista.get(j) + ".equals" + (kard1[1]));
                                        if (lista.get(j).equals(kard1[1])) {
                                            coincide = true;
//                                            System.out.println(lista.get(j) + ".equals" + (kard1[1]));
                                            break;
                                        }
                                        
                                    }
                                    System.out.println("");
                                    if (j < lista.size() - 1 && cont > 0 && coincide == false) {
                                        a2.NuevaLinea();
                                    }
                                    if (coincide == false) {
                                        a2.EscribirLinea(lista.get(j));
                                        cont++;
                                    }

                                }
                                for (int i = 0; i < kard.length; i++) {
                                    kardex.EscribirLinea(kard[i][0] + " - " + kard[i][1] + " - " + kard[i][2] + " - "+ kard[i][3]);
                                    if (i < kard.length - 1) {
                                        kardex.NuevaLinea();
                                    }
                                }

                                for (int i = 0; i < alu.length; i++) {
                                    datos.EscribirLinea(alu[i]);
                                    if (i < alu.length - 1) {
                                        datos.NuevaLinea();
                                    }
                                }
                                a1.CerrarLectura();
                                a2.CerrarEscritura();
                                datos.CerrarEscritura();
                                kardex.CerrarEscritura();
                                guardar.CerrarEscritura();

                                cambiar = false;
                            } else {
                                JOptionPane.showMessageDialog(this, "Lo sentimos, aun no existen horarios para esta carrera");
                            }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(this, "Lo sentimos, aun no existen horarios para esta carrera");
                        }

                    } else {
                        contador--;
                        JOptionPane.showMessageDialog(this, "Elija una carrera y escriba un nombre de cuenta");
                    }
                }
                crearListado();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jLabEntrarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        Main I = new Main();
//        I.setVisible(true);
//        try {
//            Thread.sleep(3500);
//        } catch (Exception e) {
//
//        }
//        I.setVisible(false);
//        I.dispose();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Loggin().setVisible(true);
            }
        }
        );

    }

    class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextPass;
    private javax.swing.JTextField jTextUser;
    // End of variables declaration//GEN-END:variables
}
