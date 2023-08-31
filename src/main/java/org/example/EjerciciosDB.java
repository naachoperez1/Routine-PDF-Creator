package org.example;

import java.util.HashMap;

public class EjerciciosDB {
    HashMap <String, String> ejercicios = new HashMap<>();

    public EjerciciosDB(){
        this.ejercicios.put("Diagonales con disco arrodillado", "https://youtube.com/shorts/NbHuUoKLIvA");
        this.ejercicios.put("Flexiones de brazos inestables con anillas o trx", "https://youtube.com/shorts/-wJUElE4CZE");
        this.ejercicios.put("Empujé de trineo o cajon", "https://youtube.com/shorts/PYtZUgb-yIQ");
        this.ejercicios.put("Traccion con soga", "https://youtube.com/shorts/N9XwdH4co68");
        this.ejercicios.put("Sentadillas sumo con agarre punta de barra", "https://youtube.com/shorts/QktPza3EYWY");
        this.ejercicios.put("Saltos al cajón con dos piernas", "https://youtube.com/shorts/Xei4QNBqN8c");
        this.ejercicios.put("Tijeras inestables sobre bozu", "https://youtube.com/shorts/UMcR8SH0eRY");
        this.ejercicios.put("Press paloff", "https://youtube.com/shorts/V37MCJrYIIE");
    }

    public void AddEjercicio (String nombreEjercicio, String link){
        this.ejercicios.put(nombreEjercicio,link);
    }

    public HashMap<String, String> GetAllEjercicios(){
        return this.ejercicios;
    }

    public String GetLinkEjercicio (String nombreEjercicio){
       return this.ejercicios.get(nombreEjercicio);
    }


}
