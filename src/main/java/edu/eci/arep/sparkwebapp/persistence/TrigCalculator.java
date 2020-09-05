package edu.eci.arep.sparkwebapp.persistence;

import com.google.gson.JsonObject;

/**
 * The type Trig calculator.
 */
public class TrigCalculator {

    /**
     * Create gson json object.
     *
     * @param type   the type
     * @param data   the data
     * @param result the result
     * @return the json object
     */
    public static JsonObject createGson(String type,String data, String result){
        JsonObject innerObject = new JsonObject();
        innerObject.addProperty("function", type);
        innerObject.addProperty("data", data);
        innerObject.addProperty("result", result);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("publisher", innerObject);
        return jsonObject;
    }

    /**
     * Calculate string.
     *
     * @param type the type
     * @param data the data
     * @return the string
     */
    public static String calculate(String type, String data){
        double value = numberOf(data);
        switch (type) {
            case "cos":
                System.out.println("Cos: "+Math.cos(value)+" Value: "+value);
                return String.valueOf(Math.cos(value));
            case "sin":
                return String.valueOf(Math.sin(value));
            case "tan":
                return String.valueOf(Math.tan(value));
            default:
                return "NoCorrectType";
        }
    }

    private static double numberOf(String data) {
        try{
            return Double.parseDouble(data);
        }catch(NumberFormatException e){
            return 0;
        }
    }

    /**
     * Redondea a las cifras necesarias un numero de tipo double
     *
     * @param number numero a redondear
     * @param nDigit numero digitos a redondear
     * @return valor redondeado
     */
    private static String Round(double number, int nDigit) {
        double digits = Math.pow(10, nDigit);
        return String.valueOf((double) Math.round(number * digits) / digits);
    }
}
