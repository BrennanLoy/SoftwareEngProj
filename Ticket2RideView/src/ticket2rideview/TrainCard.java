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
        jpgImage = lookUpJPGImage4TrainCarType(trainCarType);
   }
   
   // Constructor
   TrainCard(String type)
   {    trainCarType = type;
        jpgImage = lookUpJPGImage4TrainCarType(type);
   }   
   
   // Mutator Function
    private String lookUpJPGImage4TrainCarType(String trainCarType)
    {
        if ("LOCOMOTIVE".equals(trainCarType))
            jpgImage = "graphics/Locomotive_scale79.jpg";
        else if ("FREIGHT".equals(trainCarType))
            jpgImage = "graphics/Freight_scale79.jpg";
        else if ("HOPPER".equals(trainCarType))
            jpgImage = "graphics/Hopper_scale79.jpg";
        else if ("COAL".equals(trainCarType))
            jpgImage = "graphics/Coal_scale79.jpg";        
        else if ("CABOOSE".equals(trainCarType))
            jpgImage = "graphics/Caboose_scale79.jpg";    
        else if ("BOX".equals(trainCarType))
            jpgImage = "graphics/Box_scale79.jpg";    
        else if ("PASSENGER".equals(trainCarType))
            jpgImage = "graphics/Passenger_scale79.jpg";    
        else if ("TANKER".equals(trainCarType))
            jpgImage = "graphics/Tanker_scale79.jpg";    
        else if ("REEFER".equals(trainCarType))
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
    
    @Override
    public String toString(){
        //System.out.println(this.trainCarType);
        return(this.trainCarType);
    }
    
}
