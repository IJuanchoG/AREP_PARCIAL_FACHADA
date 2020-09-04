package edu.eci.arep.sparkwebapp;


import com.google.gson.JsonObject;
import edu.eci.arep.sparkwebapp.persistence.RestPersistence;
import edu.eci.arep.sparkwebapp.persistence.TrigCalculator;
import spark.Request;
import spark.Response;


import static spark.Spark.*;

/**
 * The type Spark web app.
 */
public class SparkWebApp {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        port(getPort());
        get("/datos", SparkWebApp::inputDataPage);
        get("/results", SparkWebApp::resultsPage);
        get("/getResults",SparkWebApp::putDataPage);
    }


    /**
     * Put the data in a table
     * @param req request on the server
     * @param res response on the server
     * @return String HTML info
     */
    private static JsonObject putDataPage(Request req, Response res) {
        String data = req.queryParams("rad");
        String function = req.queryParams("func");

        String calculate = TrigCalculator.calculate(function, data);
        res.status(200);
        res.type("application/json");
        return TrigCalculator.createGson(function,data,calculate);
    }

    /**
     * Input Data on the server
     * @param req request on the server
     * @param res response on the server
     * @return String HTML info
     */
    private static String inputDataPage(Request req, Response res) {
        return RestPersistence.getInputData();
    }


    /**
     * Result data with info about calculator
     * @param req request on the server
     * @param res response on the server
     * @return String HTML info
     */
    private static String resultsPage(Request req, Response res) {
        String data = req.queryParams("rad");
        String function = req.queryParams("func");
        String calculate = TrigCalculator.calculate(function, data);
        return RestPersistence.getResults(function,data,calculate);
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