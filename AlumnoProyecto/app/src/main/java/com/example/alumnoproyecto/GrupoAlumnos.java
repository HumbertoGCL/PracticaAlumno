package com.example.alumnoproyecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GrupoAlumnos {
    private ArrayList<Alumno> listaAlumnos;
    private static GrupoAlumnos grupo = new GrupoAlumnos();

    private GrupoAlumnos(){
        listaAlumnos = new ArrayList<Alumno>();

        for (int  i = 0 ; i<20; i++){
            Alumno alumno = new Alumno();
            alumno.setMatricula(i);
            alumno.setNombre("Alumno #" + i);
            alumno.setActivo(i%2==0);
            listaAlumnos.add(alumno);
            try {
            ObjectInputStream readFichero = new ObjectInputStream(new FileInputStream("archivoAlumnos.dat") );
            listaAlumnos = ( ArrayList <Alumno> )readFichero.readObject();
            ///leer archivo
            readFichero.close();

        } catch (IOException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
        }

    }



    public static GrupoAlumnos getGrupo(){
        return grupo;
    }

    public ArrayList<Alumno> getListaAlumnos(){
        return listaAlumnos;
    }


    public Alumno getAlumno(int matricula){
        for(Alumno alumno: listaAlumnos){
            if(alumno.getMatricula() == matricula){
                return alumno;
            }
        }
        return null;
    }
}
