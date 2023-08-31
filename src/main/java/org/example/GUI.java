package org.example;
// importing the necessary libraries
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// class which inherits the WindowAdapter class
public class GUI extends WindowAdapter {
    EjerciciosDB database = new EjerciciosDB();
    static HashMap<String, String> ejercicios = new HashMap<>();
    Frame frame = new Frame("Generador de Rutinas");
    int posicionTextoAgregado = 210;


    public GUI () {
        frame.addWindowListener (this);

        // creating labels
        Label labelNombreEquipo = new Label("Equipo: ");
        labelNombreEquipo.setBounds(100,70, 70 , 20);

        Label labelEjercicios = new Label("Ejercicios: ");
        labelEjercicios.setBounds(100, 100, 100 ,20);

        Label labelRep = new Label("Repeticiones: ");
        labelRep.setBounds(100, 130 ,100 ,20);

        // creating a button
        Button addButton = new Button("Agregar");
        addButton.setBounds(200, 180, 80, 20);

        Button createPDFButton = new Button("Crear PDF");
        createPDFButton.setBounds(300,180,80, 20);

        // creating texfields
        JTextField textFieldRep = new JTextField(15);
        textFieldRep.setBounds(200, 130, 200, 20);

        JTextField textFieldEquipo = new JTextField(30);
        textFieldEquipo.setBounds(170, 70, 300, 20);

        // creating Choice object
        Choice choice = new Choice();
        choice.setBounds(170, 100, 300, 75);

        //  adding choices to choice object
        for (String ejercicio : database.ejercicios.keySet()) {
            choice.add(ejercicio);
        }

        // adding above components into the frame
        frame.add(choice);
        frame.add(labelNombreEquipo);
        frame.add(labelEjercicios);
        frame.add(labelRep);
        frame.add(textFieldEquipo);
        frame.add(textFieldRep);
        frame.add(addButton);
        frame.add(createPDFButton);

        // setting size, layout and visibility of frame
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setVisible(true);


        // adding event to the button
        // which displays the selected item from the list when button is clicked
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ej = choice.getItem(choice.getSelectedIndex());
                String rep = textFieldRep.getText();
                ejercicios.put(ej, rep);
                textFieldRep.setText(null);
                AddLabelEjercicio(ej, rep, posicionTextoAgregado);
                posicionTextoAgregado += 20;
        }
        });


        createPDFButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PdfManager pdfManager = new PdfManager(textFieldEquipo.getText());
                try {
                    pdfManager.CreatePDF();
                    for (Map.Entry<String, String> ejercicio: ejercicios.entrySet()) {
                        pdfManager.AddText(ejercicio.getKey(), ejercicio.getValue(), database.GetLinkEjercicio(ejercicio.getKey()));
                    }
                } catch (DocumentException | FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                finally {
                    pdfManager.document.close();
                } }
        });
    }

    public void AddLabelEjercicio(String ejercicio, String repeticiones, int posicion){
        Label labelEjercicio = new Label("Agregado: " + ejercicio + ". " + repeticiones );
        labelEjercicio.setBounds(150, posicion, 400, 20);
        frame.add(labelEjercicio);
    }
    public void windowClosing (WindowEvent e) {
        frame.dispose();
    }

}