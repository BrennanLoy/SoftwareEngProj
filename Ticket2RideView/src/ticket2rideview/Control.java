/*
 * Brennan Loy / Yax Barillas 
 * This class will hold all information for the current game and will handle 
 * how turns are taken.
 */
package ticket2rideview;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Brennan
 */
public class Control{
    
    public class Player{
        
        String name;
        ArrayList<TrainCard> CHand = new ArrayList<>();
        ArrayList<Ticket> THand = new ArrayList<>();
        
        Player(){
            name = "Player";
        }
        
        void setName(String s){
            name = s;
        }
        
        void addToCHand(TrainCard t){
            this.CHand.add(t);
        }
        
        void createHand(Deck D, TDeck T){
            for(int i = 0; i < 4; i++){
                CHand.add(D.draw());
            }
            
            for(int i = 0; i < 3; i++){
                THand.add(T.draw());
            }
        
        }    
    }
    
    public class Deck{
        
        public int purpleNum,whiteNum,blueNum,yellowNum,orangeNum,blackNum,redNum,greenNum = 12;
        public int locoNum = 14;
        public int totalC =  110;
        //ArrayList<TrainCard> faceUp5 = new ArrayList<>();
        String card;
        
        
        
        public TrainCard draw(){
            Random rand = new Random();
            int x = rand.nextInt(8);
            System.out.println(x);
            switch(x){
                case 0:
                    card = "REEFER";
                    break;
                case 1:
                    card = "TANKER";
                    break;
                case 2:
                    card = "PASSENGER";
                    break;
                case 3:
                    card = "BOX";
                    break;
                case 4:
                    card = "CABOOSE";
                    break;
                case 5:
                    card = "COAL";
                    break;
                case 6:
                    card = "HOPPER";
                    break;
                case 7:
                    card = "FREIGHT";
                    break;
                case 8: 
                    card = "LOCOMOTIVE";
                    break;
                default:
                    card = "LOCOMOTIVE";
                    break;
            }
            return(new TrainCard(card));
        }
        public TrainCard draw(String t){
            return(new TrainCard(t));
        }
    }
    
    public class TDeck{
        ArrayList<Ticket> TDeck = new ArrayList<>();
        TDeck(){
            TDeck.add(new Ticket("SanFrancisco_LosAngeles"));
            TDeck.add(new Ticket("SanFrancisco_LosAngeles"));
            TDeck.add(new Ticket("Salt Lake City"));
            TDeck.add(new Ticket("Salt Lake City"));
            TDeck.add(new Ticket("Portland"));
            TDeck.add(new Ticket("Portland"));
            TDeck.add(new Ticket("Los Angeles"));
            TDeck.add(new Ticket("Los Angeles"));
        }
        
        public Ticket draw(){
            return(new Ticket());
        }
        
        
    }
    
    public class Ticket{
        String origin_destination;
        int points;
        
        // Default Constructor
        Ticket(){   
            origin_destination = "SanFrancisco_LosAngeles";
            points = 4; 
        }
        
        // Constructor w/1 argument
        Ticket(String orig_des){
            origin_destination = orig_des;

            if(orig_des == "Salt Lake City")
                points = 1;
            else if(orig_des == "Portland")
                points = 1;
            else if(orig_des == "Los Angeles")
                points = 1;          
        }
    }
    
    Player cplayer1 = new Player();
    Player cplayer2 = new Player();
    Deck D = new Deck();
    TDeck T = new TDeck();
    
    void Start(){
        cplayer1.createHand(D, T);
        cplayer2.createHand(D, T);
        
        
    }
    
    String seeHand(int p){
        if(p == 1){
            for(int i = 0; i < cplayer1.CHand.size(); i++){
                System.out.println(cplayer1.CHand.get(i).toString());
            }
        }
        else 
            for(int i = 0; i < cplayer2.CHand.size(); i++){
                System.out.println(cplayer2.CHand.get(i).toString());
            }
        return("Done!");
    }
    
    Player getPlayer(int p){
        if(p == 1){
            return cplayer1;
        }
        else 
            return cplayer2;
    }
    TrainCard getPlayerCHand(int p, int i){
        if(p == 1){
            return cplayer1.CHand.get(i);
        }
        else
            return cplayer2.CHand.get(i);
            
    }
    
    Ticket getPlayerTHand(int p, int i){
            if(p == 1){
            return cplayer1.THand.get(i);
        }
        else
            return cplayer2.THand.get(i);
            
    }
    
    void setPlayerName(int i, String s){
            switch(i){
                case 1:
                    cplayer1.setName(s);
                    break;
                case 2:
                    cplayer2.setName(s);
                    break;
                default:
                    break;
            }
        }
    
    
}
