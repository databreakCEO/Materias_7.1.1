/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materias;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frodo
 */
public class Cuenta extends javax.swing.JFrame {

    /**
     * Creates new form Cuenta
     */
    DefaultListModel listaTotal, listaPendientes;
    MateriasFrame mf;
    String nombre;
    String carrera;
    Archivo a1;
    Archivo kardex;
    DefaultListModel auxiliar = new DefaultListModel();
    Object carreraID = 0;
    File carpeta;
    String[] listado;
    String directorio;
    boolean cargando = true;
    Conexiones con;

    public Cuenta(String carrera, String nombre, String cuenta, String alu[]) {
        initComponents();
        try {
            try {
                this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/rayo.jpg")).getImage());
            } catch (Exception e) {

            }
            Alumno.Alumno(alu[0], alu[1], alu[2], alu[3], alu[4], alu[5], alu[6], alu[7]);
//        jLabImagenFondo.setSize(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
            this.setTitle("Cuenta");
            con = new Conexiones("ITLDB", "root", "", "localhost");
            switch (carrera) {

                case "Administracion":
                    carreraID = 7;
                    break;

                case "Electrica":
                    carreraID = 3;
                    break;

                case "Electronica":
                    carreraID = 6;
                    break;

                case "Energias Renovables":
                    carreraID = 9;
                    break;

                case "Gestion":
                    carreraID = 'Z';
                    break;

                case "Industrial":
                    carreraID = 2;
                    break;

                case "Mecanica":
                    carreraID = 4;
                    break;

                case "Mecatronica":
                    carreraID = 8;
                    break;

                case "Quimica":
                    carreraID = 5;
                    break;

                case "Sistemas":
                    carreraID = 1;
                    break;

            }
            ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/recargar.jpg"));
            Image image = Imagenes.getScaledImage(icon.getImage(), this.jLabRecargar.getWidth(), this.jLabRecargar.getHeight());
            this.jLabRecargar.setIcon(new ImageIcon(image));

            this.setLocationRelativeTo(null);
            this.nombre = nombre;
            this.carrera = carrera;
            listaTotal = new DefaultListModel();
            listaPendientes = new DefaultListModel();
//        String direccion = "";
            a1 = new Archivo(nombre + "\\materiasEstado.txt");
            kardex = new Archivo(nombre + "\\kardex.txt");
            a1.crearLectura();
            kardex.crearLectura();
            jLabAct.setText(carrera);
            jLabAct.setText(Alumno.activo);
            jLabCuenta.setText(Alumno.numControl + " " + Alumno.apPat + " " + Alumno.apMat + " " + Alumno.nombres);
//        jSpinner1.setValue(1);
            int con = 0;
            String line = a1.LeerLinea();
            listaTotal.addElement(line);
            boolean band = true;
            while (line != null) {
                band = true;
                for (int i = 0; i < listaTotal.size(); i++) {
                    if (line.equals(listaTotal.get(i)) || line.equals("RESIDENCIA")) {
                        band = false;
                    }
                }
                if (band == true) {
                    listaTotal.addElement(line);
                    con++;
                }
                line = a1.LeerLinea();
            }

            
            
            
//            listaAprobadas.addElement(line);
            a1.CerrarLectura();
            auxiliar = listaTotal;
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            //Object [] o = new Object[2];
            for (int i = 0; i < listaTotal.size(); i++) {
                modelo.setRowCount(i + 1);
                String cadena = listaTotal.get(i).toString();
                jTable1.setValueAt(cadena, i, 0);
//                if (listaTotal.get(i).toString().charAt(listaTotal.get(i).toString().length() - 1) == "t".charAt(0)) {
//                    //o[1]=true;
//                    jTable1.setValueAt(true, i, 0);
//                } else {
//                    //o[1]=false;
//                    jTable1.setValueAt(false, i, 0);
//                }

            }
        } catch (Exception e) {

        }
        String linea = kardex.LeerLinea();
            String [] datosKardex;
            int ind = 0;
            DefaultTableModel modeloKar = (DefaultTableModel)jTableKardex.getModel();
            while (linea != null) {
                datosKardex=linea.split(" - ");
                    modeloKar.addRow(datosKardex);
                    linea = kardex.LeerLinea();
            }
                        kardex.CerrarLectura();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabCuenta = new javax.swing.JLabel();
        jLabAct = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKardex = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabPromedio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxSeleccionarTodo = new javax.swing.JCheckBox();
        jLabRecargar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabCarrera = new javax.swing.JLabel();
        jLabImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Crear horarios");
        jButton3.setToolTipText("Oprima para empezar a crear sus pre-horarios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 150, -1));

        jLabCuenta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 550, 28));

        jLabAct.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabAct.setText("Activo: ");
        getContentPane().add(jLabAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 140, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ver horarios guardados");
        jButton1.setToolTipText("Oprima para visualizar los horarios guardados.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de materia"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1000);
        }

        jTabbedPane1.addTab("Materias para horarios", jScrollPane3);

        jTableKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Calificacion", "Semestre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableKardex);

        jTabbedPane1.addTab("Kardex", jScrollPane1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable3);

        jTabbedPane1.addTab("Materias Cursando", jScrollPane2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabPromedio.setText("Promedio: ");
        jPanel1.add(jLabPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 30));

        jLabel2.setText("Numero de control: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setText("Genero: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setText("Activo: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jTabbedPane1.addTab("Datos", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 470, 480));

        jCheckBoxSeleccionarTodo.setText("Seleccionar todo");
        jCheckBoxSeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSeleccionarTodoActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxSeleccionarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabRecargar.setBackground(new java.awt.Color(0, 0, 0));
        jLabRecargar.setToolTipText("Oprima este botón para descargar los horarios de la página oficial.");
        jLabRecargar.setOpaque(true);
        jLabRecargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabRecargarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabRecargarMouseEntered(evt);
            }
        });
        getContentPane().add(jLabRecargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 38, 38));

        jLabel1.setText("Marque las casillas de las materias que no usará para hacer los horarios.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 420, -1));

        jLabCarrera.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(jLabCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 30));

        jLabImagen.setBackground(new java.awt.Color(255, 255, 255));
        jLabImagen.setOpaque(true);
        getContentPane().add(jLabImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public void Guardar() {
//        try {
//            String nombreArchivo = jLabCuenta.getText();
//            nombreArchivo = nombreArchivo.toUpperCase();
//            a1.crearEscritura();
//
//            for (int i = 0; i < listaTotal.size(); i++) {
//                char b = 'f';
//                if ((boolean) jTable1.getValueAt(i, 0) == true) {
//                    b = 't';
//                }
//                String cadena = listaTotal.get(i).toString().substring(0, (listaTotal.get(i).toString().length() - 2));
//                a1.EscribirLinea(cadena + "-" + b);
//                if (i < listaTotal.size() - 1) {
//                    a1.NuevaLinea();
//                }
//            }
//            a1.CerrarEscritura();
//        } catch (Exception e) {
//
//        }
//    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
//            Guardar();
            listaPendientes.clear();

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String cadena = listaTotal.get(i).toString();
                listaPendientes.addElement(cadena);

            }

            mf = new MateriasFrame(listaPendientes, carrera, nombre);
            mf.setVisible(true);
            mf.c = this;
            this.setVisible(false);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        try {
            Loggin loggin = new Loggin();
            loggin.setVisible(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
//        try {
//            Guardar();
//        } catch (Exception e) {
//
//        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            VisualizarHorarios vh = new VisualizarHorarios(carrera, nombre);
            vh.setVisible(true);
            vh.c = this;
            this.setVisible(false);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxSeleccionarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSeleccionarTodoActionPerformed
        // TODO add your handling code here:
        try {
            if (jCheckBoxSeleccionarTodo.isSelected()) {
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    jTable1.setValueAt(true, i, 0);
                }
            } else {
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    jTable1.setValueAt(false, i, 0);
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jCheckBoxSeleccionarTodoActionPerformed

    private void jLabRecargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabRecargarMouseClicked
        // TODO add your handling code here:
//        ArrayList<Archivo> archivos = new ArrayList<>();
        Archivo a1 = new Archivo("Materias por carrera\\" + carrera + ".txt");
        a1.crearEscritura();
        Object[][] datos = con.showAllData("Sistemas", "Select * from Sistemas");
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                System.out.print(datos[i][j] + " ");
                if (j < datos[0].length - 1 && j != 1) {
                    a1.EscribirLinea(datos[i][j] + " ");
                } else {
                    a1.EscribirLinea(datos[i][j] + "");
                }

            }
            if (i < datos.length - 1) {
                a1.NuevaLinea();
            }

            System.out.println("");
        }
        a1.CerrarEscritura();
        /*
        try {
            try {
                try {
                    
                    crearArchivos(carrera + ".txt");
                    Archivo a1 = new Archivo(carrera + "\\NombreMaterias.txt");
                    Archivo a2 = new Archivo(nombre + "\\materiasEstado.txt");
                    boolean band;
                    a2.crearLectura();
                    if (a1.crearLectura()) {

                        ArrayList<String> lista = new ArrayList<>();
                        ArrayList<String> lista2 = new ArrayList<>();
                        ArrayList<String> listaAGuardar = new ArrayList<>();
                        String line = a1.LeerLinea();
                        String line2 = a2.LeerLinea();
                        while (line2 != null) {

                            lista2.add(line2);
                            line2 = a2.LeerLinea();
                        }
                        band = true;
                        String materia;
                        boolean bandera = true;

                        while (line != null) {
                            bandera = true;
                            if (!line.equals("RESIDENCIA") && !line.equals("RESIDENCIA PROFESIONAL") && !line.equals("TUTORIA")) {
                                for (int i = 0; i < lista.size(); i++) {
                                    if (line.equals(lista.get(i))) {
                                        bandera = false;
                                        break;
                                    }
                                }
                                if (bandera) {
                                    lista.add(line);
                                }
                            }
                            line = a1.LeerLinea();

                        }

                        String linea = "";
                        for (int j = 0; j < lista.size(); j++) {
                            bandera = true;
                            for (int i = 0; i < lista2.size(); i++) {

                                String[] split = lista2.get(i).split("-");
                                materia = split[0];
                                if (materia.equals(lista.get(j))) {
                                    linea = lista2.get(i);
                                    bandera = false;
                                    break;
                                }
                            }
                            if (bandera) {
                                listaAGuardar.add(lista.get(j) + "-f");
                            } else {
                                listaAGuardar.add(linea);
                            }
                        }

                        a1.CerrarLectura();
                        a2.CerrarLectura();
                        a2.crearEscritura();

                        for (int j = 0; j < listaAGuardar.size(); j++) {
                            if (j > 0) {
                                a2.NuevaLinea();
                            }
                            a2.EscribirLinea(listaAGuardar.get(j));
                        }
                        a2.CerrarEscritura();
                    }

                    listaTotal = new DefaultListModel();
                    listaPendientes = new DefaultListModel();
                    a1 = new Archivo(nombre + "\\materiasEstado.txt");
                    a1.crearLectura();
                    int con = 0;
                    String line = a1.LeerLinea();
                    listaTotal.addElement(line);
                    band = true;
                    while (line != null) {
                        band = true;
                        for (int i = 0; i < listaTotal.size(); i++) {
                            if (line.equals(listaTotal.get(i)) || line.equals("RESIDENCIA f")) {
                                band = false;
                            }
                        }
                        if (band == true) {
                            listaTotal.addElement(line);
                            con++;
                        }
                        line = a1.LeerLinea();
                    }

//            listaAprobadas.addElement(line);
                    a1.CerrarLectura();
                    auxiliar = listaTotal;
                    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                    //Object [] o = new Object[2];
                    for (int i = 0; i < listaTotal.size(); i++) {
                        modelo.setRowCount(i + 1);
                        String cadena = listaTotal.get(i).toString().substring(0, (listaTotal.get(i).toString().length() - 2));
                        jTable1.setValueAt(cadena, i, 1);
                        if (listaTotal.get(i).toString().charAt(listaTotal.get(i).toString().length() - 1) == "t".charAt(0)) {
                            //o[1]=true;
                            jTable1.setValueAt(true, i, 0);
                        } else {
                            //o[1]=false;
                            jTable1.setValueAt(false, i, 0);
                        }

                    }
                    JOptionPane.showMessageDialog(this, "Horarios de materias actualizados.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error en actualización, asegúrese de que tiene acceso a internet. Si el problema persiste pongase en contacto con el creador del programa.");
                }
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
         */
    }//GEN-LAST:event_jLabRecargarMouseClicked

    private void jLabRecargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabRecargarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabRecargarMouseEntered

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
            java.util.logging.Logger.getLogger(Cuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuenta("", "", "", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBoxSeleccionarTodo;
    private javax.swing.JLabel jLabAct;
    private javax.swing.JLabel jLabCarrera;
    private javax.swing.JLabel jLabCuenta;
    private javax.swing.JLabel jLabImagen;
    private javax.swing.JLabel jLabPromedio;
    private javax.swing.JLabel jLabRecargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableKardex;
    // End of variables declaration//GEN-END:variables

}
