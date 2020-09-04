package edu.eci.arep.sparkwebapp;

import static spark.Spark.port;

public class Cliente {

    public static void main(String[] args) {
        port(getPort());

    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
