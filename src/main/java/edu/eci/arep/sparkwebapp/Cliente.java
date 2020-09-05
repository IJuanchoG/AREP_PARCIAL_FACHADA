package edu.eci.arep.sparkwebapp;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import static spark.Spark.port;

/**
 * The type Cliente.
 */
public class Cliente {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


        String getFacade = "https://ancient-chamber-26329.herokuapp.com/results?rad=0.5&func=cos";
        String putJson  = "https://damp-mesa-00919.herokuapp.com/datos?rad=0.8&func=cos";
        HttpResponse<String> jsonResponse
                = null;
        try {
            jsonResponse = Unirest.get(getFacade).asString();
            System.out.println("Esta es la info de la fachada: ");
            System.out.println(jsonResponse.getBody()+'\n');
            jsonResponse = Unirest.get(putJson).asString();
            System.out.println("Este es el objeto solicitado por la otra parte: ");
            System.out.println(jsonResponse.getBody()+'\n');
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }


}
