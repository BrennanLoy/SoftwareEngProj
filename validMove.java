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
public class validMove {
    public int tdeck;
    public int dtdeck;
    Player p;
    public static String choice;
    public static String drawChoice;
    
    public validMove(String c) {
        this.tdeck = 144;
        tdeck = tdeck - (getNumberOfPlayers() * 4) - 5;
        this.choice = c;
    }
    
    switch(choice){
        case "DrawTrainCards" :
            switch(drawChoice){
            case "TopOfDeck" :
                p.Hand.Traincards++;
                tdeck--;
                break;
            case "Draw2" : 
                p.Hand.TrainCards++;        //can draw one card from the deck (blind) and then one from the random pile
                randomCards--;              //if player chooses to draw one locomotive card from the pile, that is the only card they get
                randomCards++;              //if card is drawn, and replacement is locomotive, player may not have that card
                p.Hand.TrainCards++;
                break;
            }
        case "ClaimRoute" :
            
            break;
        case "DrawDestinationTicket" :
            p.Hand.DestinationTickets--;
            p.Hand.DestinationTickets++;
            break;
    }
}
