package org.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class PdfManager {
    Document document = new Document();
    Boolean pdfCreado = false;
    String rutaArchivo;

    public PdfManager(String nombreEquipo){
        this.rutaArchivo = "C:/Users/NoteBook/Downloads/Rutinas Creadas/Rutina " + nombreEquipo+ ".pdf";
    }

    /**
     * Crea el documento PDF con el nombre "Rutina + nombreEquipo" y lo abre para su posterior edicion.
     *
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    public void CreatePDF () throws DocumentException, FileNotFoundException {

        PdfWriter.getInstance(this.document, new FileOutputStream(rutaArchivo));


        this.document.open();
    }


    /**
     * Agrega un bloque de texto al pdf con el nombre del ejercicio, el numero de repeticiones y el link al video.
     *
     * @param nombreEjercicio --> el nombre del ejercicio a agregar.
     * @param repeticiones --> numero de repeticiones por ejercicio, p.ej = 3 x 5.
     * @param linkVideo --> link del video con el nombre del ejercicio en Youtube.
     * @throws DocumentException si ocurre algun error relacionado al documento
     */
    public void AddText( String nombreEjercicio,String repeticiones, String linkVideo) throws DocumentException {
        try {
            if (pdfCreado){
                this.document.add(new Paragraph("-----------------------------------------------------------------" +
                        "----------------------------------------\n\n"));

            }
            else this.pdfCreado = true;

            Paragraph ejercicio = new Paragraph("Ejercicio: " + nombreEjercicio + ".");
            Paragraph series = new Paragraph("Repeticiones: " + repeticiones + ".");
            Paragraph video = new Paragraph("Video: " + linkVideo + ".");

            this.document.add(ejercicio);
            this.document.add(series);
            this.document.add(video);
        }
        catch (DocumentException e){
            throw new DocumentException();
        }

    }


}