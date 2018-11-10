/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2rideview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Brennan Loy
 */
public class ActiveGame {
    Player P1 = new Player();
    Player P2 = new Player();
    Deck D = new Deck();
    ArrayList<Player> turnOrder = new ArrayList<>();
    
    void createTurnOrder(){
        turnOrder.add(P1);
        turnOrder.add(P2);
    }
    void setPlayer1Name(String n){
        P1.pName = n;
    }
    void setPlayer2Name(String n){
        P2.pName = n;
    }
    
    
}
