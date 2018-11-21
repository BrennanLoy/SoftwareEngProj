/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Fri 7 Dec 2018 @ 11:59 PM
    HW_6
*/

package ticket2rideview;

public class TrainCard
{
   String trainCarType;
   String jpgImage;
   
   // Default Constructor
   TrainCard()
   {    trainCarType = "CABOOSE";
        jpgImage = "graphics/Caboose_scale79.jpg";
   }
   
   // Constructor
   TrainCard(String type)
   {    trainCarType = type;
        jpgImage = lookUpJPGImage4TrainCarType(type);
   }   
   
   // Mutator Function
    private String lookUpJPGImage4TrainCarType(String trainType)
    {
        if (trainCarType == "LOCOMOTIVE")
            jpgImage = "graphics/Locomotive_scale79.jpg";
        else if (trainCarType == "FREIGHT")
            jpgImage = "graphics/Freight_scale79.jpg";
        else if (trainCarType == "HOPPER")
            jpgImage = "graphics/Hopper_scale79.jpg";
        else if (trainCarType == "COAL")
            jpgImage = "graphics/Coal_scale79.jpg";        
        else if (trainCarType == "CABOOSE")
            jpgImage = "graphics/Caboose_scale79.jpg";    
        else if (trainCarType == "BOX")
            jpgImage = "graphics/Box_scale79.jpg";    
        else if (trainCarType == "PASSENGER")
            jpgImage = "graphics/Passenger_scale79.jpg";    
        else if (trainCarType == "TANKER")
            jpgImage = "graphics/Tanker_scale79.jpg";    
        else if (trainCarType == "REEFER")
            jpgImage = "graphics/Reefer_scale79.jpg";
        
        return jpgImage;
    }

    // Getters   
    public String getTrainType() {
        return trainCarType; }

    public String getJPGImage() {
        return jpgImage;    }
    
    // Setters
    public void setTrainType(String trainType)
    {
        trainCarType = trainType;
        jpgImage = lookUpJPGImage4TrainCarType(trainCarType);
    }   
}
