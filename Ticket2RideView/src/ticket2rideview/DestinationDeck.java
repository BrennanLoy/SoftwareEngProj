/*
 * @author Yax Barillas
 */
package ticket2rideview;

import java.util.ArrayList;
import java.util.Random;

public class DestinationDeck {
    public int desTickets = 30;
    ArrayList<Ticket> ticDeck;
    public int dtCount = 0;
    public int tLeft = 5;

    public DestinationDeck() {
        this.ticDeck = new ArrayList<>();
        ticDeck.add(new Ticket("San Francisco to Salt Lake City"));
        ticDeck.add(new Ticket("San Francisco to Los Angeles"));
        ticDeck.add(new Ticket("San Francisco to Portland"));
        ticDeck.add(new Ticket("Salt Lake City to San Francisco"));
        ticDeck.add(new Ticket("Los Angeles to San Francisco"));
        ticDeck.add(new Ticket("Portland to San Francisco"));
    }
    
    public Ticket dtDraw(){
        while(dtCount<5)
             return ticDeck.get(dtCount);
        return new Ticket();
    }
}