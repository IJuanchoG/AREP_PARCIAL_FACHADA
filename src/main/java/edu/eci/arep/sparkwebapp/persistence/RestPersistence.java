package edu.eci.arep.sparkwebapp.persistence;


import java.util.HashMap;
import java.util.List;

/**
 * The type Rest persistence.
 */
public class RestPersistence {


    /**
     * Gets data.
     *
     * @return the data
     */
    public static String getInputData() {
        return "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>CALCULATOR TRIGONOMETRIC FUNCTIONS</h2><br>"
                + "<form action=\"/results\">"
                + "  <h3>COLUMN'S DATA</h3>"
                + "  <p>Please, put the data in follow space like the example say:</p>"
                + "<label for=\"data\">data:</label>"
                + "  <input type=\"text\" name=\"rad\" placeholder=\"0.5  0.7  1\">"
                + "  <br><br>"
                + "<label for=\"func \">Choose a trigonometric service:</label>"
                + "<label for=\"data\">data:</label>"
                + "  <input type=\"text\" name=\"func\" placeholder=\"cos sin tan\">"
                + "  <br>"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Continue\">"
                + "</form>"
                + "<p>If you click the \"Continue\" button, you will see the data table.</p>"
                + "</body>"
                + "</html>";
    }


    /**
     * Gets results.
     *
     * @param type   the type
     * @param data   the data
     * @param result the result
     * @return the results
     */
    public static String getResults(String type, String data, String result) {
        StringBuilder pageContent
                = new StringBuilder("<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>CALCULATOR TRIGONOMETRIC FUNCTIONS: CALCULATIONS</h2><br>"
                + "<h3>HTML Results in Data Type " + type + "</h3>"
                + "<form action=\"/datos\">"
                + "<h4> Result: "+type+"(" + data+") = "+result+"</h4>");
        pageContent.append("  <br><br>" + "  <input type=\"submit\" value=\"New Calculation\">" + "</form>" + "<p>If you click the \"New Calculation\" button, you could do a new calculation. </p>" + "</body>" + "</html>");
        return pageContent.toString();
    }




}
