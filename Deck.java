/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2ridecontroller;

import java.util.Random;
/**
 *
 * @author ypb83
 */
public class Deck {
    public int purpleNum,whiteNum,blueNum,yellowNum,orangeNum,blackNum,redNum,greenNum = 12;
    public int locoNum = 14;
    public int totalC =  110;
    
    public Card draw(){
        Random rand = new Random();
        int x = rand.nextInt(8);
        
	switch(x){
            case 0:
		if(d.purpleNum == 0)
                    this.draw();
                else{
                    purpleNum--;
                    totalC--;
                    return(new Card("Purple"));}
            case 1:
                if(d.whiteNum == 0)
                   this.draw();
                else{
                    whiteNum--;
                    totalC--;
                    return(new Card("White"));}
            case 2:
                if(d.blueNum == 0)
                    this.draw();
                else{
                    blueNum--;
                    totalC--;
                    return(new Card("Blue"));}
            case 3:
                if(d.yellowNum == 0)
                    this.draw();
                else{
                    yellowNum--;
                    totalC--;
                    return(new Card("Yellow"));}
            case 4:
                if(d.orangeNum == 0)
                    this.draw();
                else{
                    orangeNUm--;
                    totalC--;
                    return(new Card("Orange");}
            case 5:
                if(d.blackNum == 0)
                   this.draw();
                else{
                    blackNum--;
                    totalC--;
                    return(new Card("Black"));}
            case 6:
                if(d.redNum == 0)
                   this.draw();
                else{
                    redNum--;
                    totalC--;
                    return(new Card("Red"));}
            case 7:
                if(d.greenNum == 0)
                    this.draw();
                else{
                    greenNum--;
                    totalC--;
                    return(new Card("Green"));}
            case 8: 
                if(d.locoNum == 0)
                    this.draw();
                else{
                    locoNum--;
                    totalC--;
                    return(new Card("Wild"));}
	}
    }
}
