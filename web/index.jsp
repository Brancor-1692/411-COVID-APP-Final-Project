<%-- 
    Document   : newjsp
    Created on : Apr 30, 2023, 9:35:51 PM
    Author     : Alexander Platon(Head Dev) & Phillip Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>COVID-19 Statistics Application</title>
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    </head>
    <body>
        <h1>COVID-19 Statistics</h1>
        <div id="stats-container">
            <p>Specify all DATA by State: 
            <form action="testing" method="post">
                <input type="hidden" name="action" value="stateInfo">
                <select id="state-select" name="selectState">
                    <option value="">-- Select a state --</option>
                    <option value="Alabama">Alabama</option>
                    <option value="Alaska">Alaska</option>
                    <option value="Arizona">Arizona</option>
                    <option value="Arkansas">Arkansas</option>
                    <option value="California">California</option>
                    <option value="Colorado">Colorado</option>
                    <option value="Connecticut">Connecticut</option>
                    <option value="Delaware">Delaware</option>
                    <option value="Florida">Florida</option>
                    <option value="Georgia">Georgia</option>
                    <option value="Hawaii">Hawaii</option>
                    <option value="Idaho">Idaho</option>
                    <option value="Illinois">Illinois</option>
                    <option value="Indiana">Indiana</option>
                    <option value="Iowa">Iowa</option>
                    <option value="Kansas">Kansas</option>                    
                    <option value="Kentucky">Kentucky</option>                    
                    <option value="Louisiana">Louisiana</option>  
                    <option value="Maine">Maine</option>  
                    <option value="Maryland">Maryland</option>  
                    <option value="Massachusetts">Massachusetts</option>  
                    <option value="Michigan">Michigan</option>  
                    <option value="Minnesota">Minnesota</option>  
                    <option value="Mississippi">Mississippi</option>  
                    <option value="Missouri">Missouri</option>  
                    <option value="Montana">Montana</option>  
                    <option value="Nebraska">Nebraska</option>  
                    <option value="Nevada">Nevada</option>  
                    <option value="New Hampshire">New Hampshire</option>  
                    <option value="New Jersey">New Jersey</option>                      
                    <option value="New Mexico">New Mexico</option>  
                    <option value="New York">New York</option>  
                    <option value="North Carolina">North Carolina</option>  
                    <option value="North Dakota">North Dakota</option>  
                    <option value="Ohio">Ohio</option>  
                    <option value="Oklahoma">Oklahoma</option>  
                    <option value="Oregon">Oregon</option>  
                    <option value="Pennsylvania">Pennsylvania</option>  
                    <option value="Rhode Island">Rhode Island</option>  
                    <option value="South Carolina">South Carolina</option>  
                    <option value="South Dakota">South Dakota</option>  
                    <option value="Tennessee">Tennessee</option>  
                    <option value="Texas">Texas</option>  
                    <option value="Utah">Utah</option>                      
                    <option value="Vermont">Vermont</option>  
                    <option value="Virginia">Virginia</option>  
                    <option value="Washington">Washington</option>  
                    <option value="West Virginia">West Virginia</option>  
                    <option value="Wisconsin">Wisconsin</option>  
                    <option value="Wyoming">Wyoming</option>                    
                    
                </select>
                <button type="submit">Submit</button>
            </form>
            </p>
            
            <h2>State: <span id="state-name"></span></h2>
            <p>Number of Cases of COVID: <span id="total-cases"></span></p>
            <p>Number of Deaths from COVID: <span id="total-deaths"></span></p>
            <p>Number of Tests for COVID: <span id="total-tests"></span></p>            

            
            
            
            <h2>Top 10 Highest List</h2>
            <form action="testing" method="post">
                <input type="hidden" name="action" value="topTen">
                <select id="topTenType" name="topTenType">                   
                    <option value="Cases">Cases</option>
                    <option value="Deaths">Deaths</option>
                    <option value="Tests">Tests</option>
                    <!-- Add All 50 States!! -->
                </select>
                <button type="submit">Submit</button>
            </form>                        
            
            <ul id="top-10-list">
            <!-- List of top 10 data based on selected filter will be dynamically added here -->
            </ul>
            
        </div> 
        
        <script>                
            $("#top-10-list").append(${topTen});
            $("#state-name").append(${stateName});
            $("#total-cases").append(${cases});
            $("#total-deaths").append(${deaths});
            $("#total-tests").append(${tests});
        </script>
        
        
    </body>
</html>
