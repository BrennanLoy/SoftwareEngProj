/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2ridecontroller;

/**
 *
 * @author ypb83
 */
public class Player {
    private final String pName;
    
    Player(String n){
    this.pName = n;
}
    private String getpName(){
        return pName;
    }
    
    class Hand{
        public int DestinationTickets = 3;
        public int LocomotiveCards = 0;
        public int TrainCards = 4;              //16 cards of each train, including locomotive cards
    }
    
}
