/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Wed 24 Oct 2018 @ 11:59 PM
    HW_4
*/

package ticket2rideview;

public class TrainCard
{
   String trainCarType;
   //int qty;
   //type? trainCarImage; //(class/syntax?)
   
   // Default Constructor
   TrainCard()
   {    trainCarType = "LOCOMOTIVE";
       // jpg image: (class/syntax?)
   }

   // Constructor
   TrainCard(String type)
   {    trainCarType = type;
       // jpg image: (class/syntax?)
   }   
   
   
   
   
   
   
   
   
   
   
   
   
   
    public void setTrainCardType(String trainCardType)
    {   trainCarType = trainCardType;   }
}
