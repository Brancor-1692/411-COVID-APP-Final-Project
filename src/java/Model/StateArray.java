/**
 * IST 411 Project
 * Author: Phillip Nguyen(Head Dev) & Alexander Platon
 * Description: Contains all ArrayLists for State COVID-19 Data
 */
package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StateArray {
    private ArrayList<State> sortingList = new ArrayList<State>();
    private ArrayList<State> statesList;       //this list is in alphabetical order
    private ArrayList<State> topTenDeaths;
    private ArrayList<State> topTenCases;
    private ArrayList<State> topTenTests;
    private ArrayList<State> topTenVaccinations;
    
    public StateArray() {
        try {
            //retrieve data from FillData/API
            FillData data = new FillData();
            sortingList = data.loadStatesToArrayList();
            System.out.println("Sorting List: " + sortingList);

            //set array lists to be sent through controller
            setStatesList();
            setTopTests();
            setTopTenDeaths();
            setTopTenCases();   
        } catch (Exception e) {
            
        }
    }
    
    private void setStatesList() {
        Collections.sort(sortingList, new Comparator<State>() {
            public int compare(State x, State y) {
                return x.getState().compareTo(y.getState());
            }
        });
        statesList = new ArrayList<State>(sortingList);
        System.out.println("States List: " + statesList);
    }
    
    public State getStateInfo(String stateName){
        State requestedState;        
        //searches for State that matches requested stateName
            for (int i = 0; i < statesList.size(); i++){
                if (0 == statesList.get(i).getState().compareTo(stateName)){
                    requestedState = statesList.get(i);
                    return requestedState;
                }
            }
        return null;
    }
    
    private void setTopTenDeaths(){
        // sort the list by the int field in descending order
        Collections.sort(sortingList, new Comparator<State>() {
            public int compare(State x, State y) {
                return Integer.compare(y.getDeaths(), x.getDeaths());
            }
        });
        
        // get the top 10 objects with the highest int values
        topTenDeaths = new ArrayList<State>(sortingList.subList(0, 10)); 
    }
    
    //return array list of top ten deaths
    public ArrayList<State> getTopTenDeaths(){
        return topTenDeaths;
    }
    
    private void setTopTenCases(){
        // sort the list by the int field in descending order
        Collections.sort(sortingList, new Comparator<State>() {
            public int compare(State x, State y) {
                return Integer.compare(y.getCases(), x.getCases());
            }
        });
        
        // get the top 10 objects with the highest int values
        topTenCases = new ArrayList<State>(sortingList.subList(0, 10));        
    }
    
    public ArrayList<State> getTopTenCases(){
        return topTenCases;
    }
    
    private void setTopTests(){
        // sort the list by the int field in descending order
        Collections.sort(sortingList, new Comparator<State>() {
            public int compare(State x, State y) {
                return Integer.compare(y.getTests(), x.getTests());
            }
        });
        
        // get the top 10 objects with the highest int values
        topTenTests = new ArrayList<State>(sortingList.subList(0, 10));        
    }
    
    public ArrayList<State> getTopTenTests(){
        return topTenTests;
    }  
}
