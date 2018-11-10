/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Fri 9 Nov 2018 @ 11:59 PM
    HW_5
*/

package ticket2rideview;

public class TrainCard
{
   String trainCarType;
   String jpgImage;
   
   // Default Constructor
   TrainCard()
   {    trainCarType = "CABOOSE";
        jpgImage = "Caboose_scale79.jpg";
   }
   
   // Constructor
   TrainCard(String type)
   {    trainCarType = type;
        jpgImage = lookUpJPGImage4TrainCarType(type);
   }   
   
   // Mutator Function
    public String lookUpJPGImage4TrainCarType(String trainType)
    {
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
        
        return jpgImage;
    }

    // Getters   
    public String getTrainType()
    {
        return trainCarType;
    }

    public String getJPGImage()
    {
        return jpgImage;
    }    
}