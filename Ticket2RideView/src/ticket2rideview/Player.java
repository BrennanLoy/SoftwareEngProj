
package ticket2rideview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Yax Barillas
 */
public class Player {
    
    public String pName;
    
    ArrayList<TrainCard> THand = new ArrayList<>();
    ArrayList<Ticket> DHand = new ArrayList<>();
    
    Player(){
        this.pName = "Blank";
    }
    Player(String name){
        this.pName = name;
        for(int i = 0; i < 4; i++){
        }
    }
    

    public String getpName(){
        return pName;
    }
}