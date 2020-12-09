/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materias;

import java.awt.Color;

/**
 *
 * @author Daniel Gonzalez Cabrera
 */
public class Materia {

    String nombreMat;
    String codigoMat;
    String[] horarioMat;
    String maestroMat;
    String[] salon = {"", "", "", "", ""};
    int hora;
    int horaInicio = 0;
    int horaTermino = 0;
    String[] horaInicios = new String[5];
    String[] horaFinales = new String[5];
    boolean aprobado = true;
    Color color = Color.GRAY;
    Materia materiaCombinada;
//    
//    public Materia(String nombreMat, String codigoMat, String[] horarioMat, String maestroMat) {
//        this.nombreMat = nombreMat;
//        this.codigoMat = codigoMat;
//        this.horarioMat = horarioMat;
//        this.maestroMat = maestroMat;
////        System.out.println(nombreMat + " - "+codigoMat+" - "+horarioMat[0]+" "+horarioMat[1]+" "+horarioMat[2]+" "
////                                     +horarioMat[3]+" "+horarioMat[4]+" "+" - "+maestroMat);
//        String hora = "";
//
//        int index = 0;
//
//        for (int n = 0; n < 5; n++) {
//            for (int i = 0; i < horarioMat[n].length(); i++) {
//                if (horarioMat[n].charAt(i) == "/".charAt(0)) {
//                    for (int j = i + 1; j < horarioMat[n].length(); j++) {
//                        salon[index] += horarioMat[n].charAt(j);
//                    }
//                    switch (hora.length()) {
//                        case 1:
//                            horaInicios[index] = 0;
//                            horaFinales[index] = 0;
//                            break;
//                        case 3:
//                            horaInicios[index] = Integer.valueOf(hora.charAt(0) + "");
//                            horaFinales[index] = Integer.valueOf((hora.charAt(1) + "" + hora.charAt(2)));
//                            break;
//                        default:
//                            horaInicios[index] = Integer.valueOf(hora.charAt(0) + "" + hora.charAt(1));
//                            horaFinales[index] = Integer.valueOf(hora.charAt(2) + "" + hora.charAt(3));
//                            break;
//                    }
//                    index++;
//                    hora = "";
//                    break;
//                } else {
//                    hora += horarioMat[n].charAt(i);
//
//                }
//            }
//        }
//        int n = 0;
//        /*for (int i = 0; i < 5; i++) {
//            System.out.println(nombreMat+i + " - " + horaInicios[i] + " " + horaFinales[i]);
//        }*/
//        while ("".equals(hora)) {
//            for (int i = 0; i < horarioMat[n].length(); i++) {
//                if (horarioMat[n].charAt(i) == "/".charAt(0)) {
//                    break;
//                } else {
//                    hora += horarioMat[n].charAt(i);
//
//                }
//            }
//            if (hora.length() == 1) {
//                hora = "";
//                n++;
//            }
//        }
//        if (hora.length() == 3) {
//            horaInicio = Integer.valueOf(hora.charAt(0) + "");
//            horaTermino = Integer.valueOf((hora.charAt(1) + "" + hora.charAt(2)));
//        } else {
//            horaInicio = Integer.valueOf(hora.charAt(0) + "" + hora.charAt(1));
//            horaTermino = Integer.valueOf(hora.charAt(2) + "" + hora.charAt(3));
//        }
//
//        this.hora = Integer.valueOf(hora);
//    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }

    public void unirMateria(Materia m) {
        materiaCombinada = m;
    }

    public Materia(String nombreMat, String codigoMat, String[] horarioMat, String maestroMat) {
        this.nombreMat = nombreMat;
        this.codigoMat = codigoMat;
        this.horarioMat = horarioMat;
        this.maestroMat = maestroMat;
//        System.out.println(nombreMat + " - "+codigoMat+" - "+horarioMat[0]+" "+horarioMat[1]+" "+horarioMat[2]+" "
//                                     +horarioMat[3]+" "+horarioMat[4]+" "+" - "+maestroMat);
        String hora = "";

        int index = 0;

        for (int n = 0; n < 5; n++) {
//            System.out.println(horarioMat[n]);
            for (int i = 0; i < horarioMat[n].length(); i++) {
                if (horarioMat[n].charAt(i) == "/".charAt(0)) {
//                    System.out.println(horarioMat[n]);
                    for (int j = i + 1; j < horarioMat[n].length(); j++) {
                        salon[index] += horarioMat[n].charAt(j);

                    }
//                    System.out.println(salon[index]);
//                    System.out.println(hora.length());
                    switch (hora.length()) {
                        case 1:
//                            System.out.println("1");
                            horaInicios[index] = 0 + "";
                            horaFinales[index] = 0 + "";
                            break;
                        case 11:
//                            System.out.println("2");
                            try {
                                if (Integer.valueOf(hora.charAt(0) + "" + hora.charAt(1)) == 0 && Integer.valueOf(hora.charAt(3) + "" + hora.charAt(4)) > 0) {
                                    horaInicios[index] = hora.charAt(3) + "" + hora.charAt(4) + "" + hora.charAt(2) + "" + hora.charAt(0) + "" + hora.charAt(1);
                                    System.out.println("cambiada ini "+codigoMat+" "+nombreMat);
                                } else {
                                    horaInicios[index] = hora.charAt(0) + "" + hora.charAt(1) + "" + hora.charAt(2) + "" + hora.charAt(3) + "" + hora.charAt(4);
                                }

                                if (Integer.valueOf(hora.charAt(6) + "" + hora.charAt(7)) == 0 && Integer.valueOf(hora.charAt(9) + "" + hora.charAt(10)) > 0) {

                                    horaFinales[index] = hora.charAt(9) + "" + hora.charAt(10) + "" + hora.charAt(8) + "" + hora.charAt(6) + "" + hora.charAt(7);
                                    System.out.println("cambiada fin "+codigoMat+" "+nombreMat);

                                } else {
                                    horaFinales[index] = hora.charAt(6) + "" + hora.charAt(7) + "" + hora.charAt(8) + "" + hora.charAt(9) + "" + hora.charAt(10);
                                }
//                                System.out.println(horaInicios[index] + "  -  " + horaFinales[index]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                    }
                    index++;
                    hora = "";
                    break;
                } else {
                    hora += horarioMat[n].charAt(i);

                }
            }
        }
        int n = 0;
        /*for (int i = 0; i < 5; i++) {
            System.out.println(nombreMat+i + " - " + horaInicios[i] + " " + horaFinales[i]);
        }*/
        while ("".equals(hora)) {
//            System.out.println(hora);
            if (n < 5) {
                for (int i = 0; i < horarioMat[n].length(); i++) {
//                    System.out.println(horarioMat[n]);
                    if (horarioMat[n].charAt(i) == "/".charAt(0)) {
                        break;
                    } else {
                        hora += horarioMat[n].charAt(i);

                    }
                }
                if (hora.length() == 1) {
                    hora = "";
                    n++;
                }
            } else {
                break;
            }
        }
//        System.out.println("llego aqui");
        if (hora.length() == 11) {
            horaInicio = Integer.valueOf(hora.charAt(0) + "" + hora.charAt(1));
//            System.out.println(horaInicio);
            horaTermino = Integer.valueOf(hora.charAt(6) + "" + hora.charAt(7));
//            System.out.println(horaTermino);
        }

//        this.hora = Integer.valueOf(hora);
    }

    public String getNombreMat() {
        return nombreMat;
    }

    public void setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
    }

    public String getCodigoMat() {
        return codigoMat;
    }

    public void setCodigoMat(String codigoMat) {
        this.codigoMat = codigoMat;
    }

    public String[] getHorarioMat() {
        return horarioMat;
    }

    public void setHorarioMat(String[] horarioMat) {
        this.horarioMat = horarioMat;
    }

    public String getMaestroMat() {
        return maestroMat;
    }

    public void setMaestroMat(String maestroMat) {
        this.maestroMat = maestroMat;
    }

    public void Mostrar() {
        String horario = "";
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                horario += horarioMat[i];
            } else {
                horario += horarioMat[i] + " - ";
            }
        }
        System.out.println(horario);
    }

    public Materia() {
    }

    public String ProfeHora() {
        String result = codigoMat + " " + maestroMat + " - " + horarioMat[0];
        return result;
    }

    public String mandarTodo() {
        return nombreMat + " " + codigoMat + " " + horarioMat[0] + " " + horarioMat[1] + " " + horarioMat[2] + " " + horarioMat[3] + " " + horarioMat[4] + " "
                + maestroMat;
    }

    public String insertarAsignatura() {
        String MateriaRecortada = codigoMat.substring(0, codigoMat.length() - 1);
        return "insert into asignatura values('" + MateriaRecortada + "', '" + nombreMat + ");";
    }

    public String insertarDocente(int i) {

        String[] split = maestroMat.split(" ");
        try {
            return "insert into docente values(" + i + ",'" + split[0] + "','" + split[1] + "','" + split[2] + " " + split[3] + "');";
        } catch (Exception ex) {
            return "insert into docente values(" + i + ",'" + split[0] + "','" + split[1] + "','" + split[2] + "');";
        }
    }

    public String insertarGrupo(int ID) {
        String MateriaRecortada = codigoMat.substring(0, codigoMat.length() - 1);

        return "insert into grupo values('" + codigoMat + "', '" + MateriaRecortada + "'," + ID + ",'"
                + horarioMat[0] + " " + horarioMat[1] + " " + horarioMat[2] + " " + horarioMat[3] + " " + horarioMat[4] + "'," + "35, " + "'si'" + ");";
    }
//     ID_Grupo varchar(10) primary key, S
//    Clave varchar(8), S
//    ID_Docente int, S
//    Horario varchar(10) not null,
//	espacioAlumnos int,
//	Disponibilidad char(2),
}
