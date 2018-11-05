/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2ridecontroller;

import java.util.ArrayList;

/**
 *
 * @author ypb83
 */
public class Player {
    public final String pName;
    public String pChoice;
    Deck t;
    
    Player(String n){
    this.pName = n;
    t.draw();
    }
    private String getpName(){
        return pName;
    }
    
    public String pTurn(String c){
        this.pChoice = c;
        return pChoice;
    }
    
    boolean ValidMove(){           //default true just for testing
        return true;
    }
    
    ArrayList<Card> THand = new ArrayList<>();
    ArrayList<DestinationTicket> DHand = new ArrayList<>();
    
    @Test
    public void validmoveOption(){
        assertTrue(ValidMove(), true);
    }
    
     @Test
    public void NvalidmoveOption(){
        assertTrue(ValidMove(), false);
    }
}
