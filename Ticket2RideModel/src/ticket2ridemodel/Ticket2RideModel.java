/*
 * Model portion of the SoftEngProj Ticket to Ride.
 * Group, Brennan, Yax, David
 */
package ticket2ridemodel;

/**
 *
 * @author Brennan
 */


import java.util.ArrayList;


class TrainCard
{
    
    TrainCard(String c){color = c;}
    String color;        
}
    
class LocomotiveCard
{
    String color = "Wild";
}
    
class DestinationTicket
{
    DestinationTicket(String n){
        name = n;
    }
    String name;
}

public class Ticket2RideModel {


    

    private static void ticket2RideSetup(ArrayList<Player> order){
        displayBoard();
        int numPlayers = getNumberOfPlayers();
        for(int i = 0; i < numPlayers; i++)
            order.add(new Player()); 
        }
    
    
    public static void main(String[] args) {
        
        boolean winner = false;
        ArrayList<Player> turnOrder = new ArrayList<>();
        int numPlayers = getNumberOfPlayers();
        int turnNum = 0;
        
        for(int i = 0; i < numPlayers; i++){
                turnNum++;
        }
        
        ticket2RideSetup(turnOrder);
        while(!winner){
            for(int i = 0; i < turnNum; i++)
            {
                turnOrder.E(turnNum);
            }
            
        }
        

    }
    
}
