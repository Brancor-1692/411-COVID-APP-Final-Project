
/** 
 * IST 411 MVC Lab
 * ControllerServlet.java 
 * Purpose: The purpose of this class is to act as a controller between
 * the jsp and servlet to display state COVID 19 information 
 *
 * @author Alex Platon & Phillip Nguyen
 * @version 1.0 4/2/23
 */ 

// Package
package Controller;

// Imports

import Model.Model;
import Model.State;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ControllerServlet extends HttpServlet {


    /**
     * Controls POST responses.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        // variables
        String url = "/index.jsp";                
        Model model = new Model();
        ArrayList<State> topTen;
        String action = request.getParameter("action");

        System.out.println("POSTED");
        
        //checks if form is the individual state data
        //if not, then check if its the top ten form
        if (action != null && action.equals("stateInfo")){
            //if select option is NOT default
            if (0 != (request.getParameter("selectState").compareTo("-- Select a state --"))){
                System.out.println("request recieved");
                // get parameters from the request (single state name)
                String stateName = request.getParameter("selectState");
                State state = model.getStateArray().getStateInfo(stateName);
                System.out.println("State Info: " + state);

                // Send state COVID info to jsp
                request.setAttribute("stateName", "\"" + state.getState() + "\"");
                request.setAttribute("cases", "\"" + state.getCases() + "\"");
                request.setAttribute("deaths", "\"" + state.getDeaths() + "\"");
                request.setAttribute("tests", "\""+ state.getTests()+ "\""); 
                System.out.println("attributes set for " + stateName);                
            }
        } 
        
        //FOR TOP TEN STATE INFO
        else if (action.equals("topTen")){ 
            String topTenString = "\"";        //contains HTML do be added with JQuery
            
            //checks for what top ten data will be displayed cased on dropdown selection
            //then, get the corresponding top ten array list and store it in a string
            //to be used by JQuery
            if (0 == request.getParameter("topTenType").compareTo("Cases")){
                topTen = model.getStateArray().getTopTenCases();   
                //create string to add to jsp/html with JQuery
                for (int i = 0; i < 10; i++){
                    topTenString = topTenString + "<li>State: " + topTen.get(i).getState() + " | Cases: " + topTen.get(i).getCases() + "</li>";
                }
            } else if (0 == request.getParameter("topTenType").compareTo("Deaths")){
                topTen = model.getStateArray().getTopTenDeaths(); 
                //create string to add to jsp/html with JQuery
                for (int i = 0; i < 10; i++){
                    topTenString = topTenString + "<li>State: " + topTen.get(i).getState() + " | Deaths: " + topTen.get(i).getDeaths() + "</li>";
                }
            } else if (0 == request.getParameter("topTenType").compareTo("Tests")){
                topTen = model.getStateArray().getTopTenTests(); 
                //create string to add to jsp/html with JQuery
                for (int i = 0; i < 10; i++){
                    topTenString = topTenString + "<li>State: " + topTen.get(i).getState() + " | Tests: " + topTen.get(i).getTests() + "</li>";                    
                }
                
            }            
            
            topTenString += "\"";
            request.setAttribute("topTen", topTenString);
        }
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }   
    
    

    /**
     * Controls GET responses.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    } 
}
