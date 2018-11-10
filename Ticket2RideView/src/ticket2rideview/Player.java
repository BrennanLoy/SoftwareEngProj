
package ticket2rideview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Brennan
 */
public class Player {
    
    public String pName;
    Deck D;
    DestinationDeck O;
    
    ArrayList<TrainCard> THand = new ArrayList<>();
    ArrayList<Ticket> DHand = new ArrayList<>();
    
    Player(){
        this.pName = "Blank";
    }
    Player(String name){
        this.pName = name;
        for(int i = 0; i < 4; i++){
            THand.add(D.draw());
        }
        O.dtDraw();
    }
    
    public String getpName(){
        return pName;
    }
}