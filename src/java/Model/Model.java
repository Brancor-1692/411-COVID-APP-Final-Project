/**
 * IST 411 Project
 * Author: Phillip Nguyen
 * Description: Model class that will handle logic for information about COVID-19 data for all States
 */
package Model;

public class Model {
    //variables
    private StateArray stateArray;
    
    //constructor
    public Model (){
        stateArray = new StateArray();
    }
    
    //returns stateArray to be used by the controller
    public StateArray getStateArray(){
        return stateArray;
    }
    
}
