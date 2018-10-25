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
   String jpgImage;
   
   // Default Constructor
   TrainCard()
   {    trainCarType = "FREIGHT";
        jpgImage = "Freight_scale79.jpg";
   }
   
   // Constructor
   TrainCard(String type)
   {    trainCarType = type;
        System.out.println("I AM HERE");
       // jpg image: (class/syntax?)
   }   
   
   // Setter
    public void setTrainCarType(String trainType)
    {   trainCarType = trainType;
    
        if (trainCarType == "LOCOMOTIVE")
            jpgImage = "Locomotive_scale79.jpg";
        else if (trainCarType == "FREIGHT")
            jpgImage = "Freight_scale79.jpg";
        else if (trainCarType == "HOPPER")
            jpgImage = "Hopper_scale79.jpg";
        else if (trainCarType == "COAL")
            jpgImage = "Coal_scale79.jpg";        
        else if (trainCarType == "CABOOSE")
            jpgImage = "Caboose_scale79.jpg";    
        else if (trainCarType == "BOX")
            jpgImage = "Box_scale79.jpg";    
        else if (trainCarType == "PASSENGER")
            jpgImage = "Passenger_scale79.jpg";    
        else if (trainCarType == "TANKER")
            jpgImage = "Tanker_scale79.jpg";    
        else if (trainCarType == "REEFER")
            jpgImage = "Reefer_scale79.jpg";
    }
    
    // Getter
    public String getJPGImage()
    {
        return jpgImage;
    }    
}
