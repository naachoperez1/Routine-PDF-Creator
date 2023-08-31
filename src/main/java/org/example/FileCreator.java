package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    // Ruta y nombre del archivo a crear
    String rutaArchivo ;
    public FileCreator(String nombreEquipo){
        this.rutaArchivo = "C:/Users/NoteBook/Downloads/Rutinas Creadas/Rutina " + nombreEquipo+ ".docx";
        this.CreateFile();
    }

    public void AddText(String nombreEjercicio, String repeticiones, String linkVideo) {
        try {
            // Crear instancia de FileWriter en modo de adjuntar (append)
            FileWriter fileWriter = new FileWriter(this.rutaArchivo, true);

            // Crear instancia de BufferedWriter para escribir en el archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir en una nueva línea
            bufferedWriter.newLine();

            // Escribir contenido en el archivo
            bufferedWriter.write("Ejercicio : " + nombreEjercicio + "\n" + "Series: " + repeticiones + "\n" + "Video: " + linkVideo + "\n\n");
            bufferedWriter.write("-----------------------------------------------------------------------------------------------------------");

            // Cerrar BufferedWriter
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CreateFile () {
        try {
            // Crear instancia de FileWriter
            FileWriter fileWriter = new FileWriter(this.rutaArchivo);

            // Cerrar FileWriter
            fileWriter.close();

            System.out.println("Archivo de texto creado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


