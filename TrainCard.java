/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Fri 7 Dec 2018 @ 11:59 PM
    HW_6
 */

package ticket2rideview;

public class TrainCard {

    String trainCarType;
    String jpgImage;
    String jpgThumbImage;
    String cardColor;
    String owner;

    // Default Constructor
    TrainCard() {
        trainCarType = "CABOOSE";
        jpgImage = "graphics/Caboose_scale79.jpg";
        jpgThumbImage = "graphics/Caboose_thumb.jpg";
    }

    // Constructor
    TrainCard(String type, String color) {
        trainCarType = type;
        jpgImage = lookUpJPGImage4TrainCarType(type);
        jpgThumbImage = lookUpJPGThumbImage4TrainCarType(type);
        cardColor = color;
        owner = "tcDeck";
    }

    // Mutator Function
    private String lookUpJPGImage4TrainCarType(String trainType) {
        if (trainCarType == "LOCOMOTIVE") {
            jpgImage = "graphics/Locomotive_scale39.jpg";
        } else if (trainCarType == "FREIGHT") {
            jpgImage = "graphics/Freight_scale79.jpg";
        } else if (trainCarType == "HOPPER") {
            jpgImage = "graphics/Hopper_scale79.jpg";
        } else if (trainCarType == "COAL") {
            jpgImage = "graphics/Coal_scale79.jpg";
        } else if (trainCarType == "CABOOSE") {
            jpgImage = "graphics/Caboose_scale79.jpg";
        } else if (trainCarType == "BOX") {
            
            // jpgImage = "graphics/824968717912.jpg";  // Locomotive          
            //jpgImage = "graphics/Ticket1.jpg";
            jpgImage = "graphics/Box_scale79.jpg";
            
            
            
            //jpgImage = "graphics/Box_scale79.jpg";
        } else if (trainCarType == "PASSENGER") {
            jpgImage = "graphics/Passenger_scale79.jpg";
        } else if (trainCarType == "TANKER") {
            jpgImage = "graphics/Tanker_scale79.jpg";
        } else if (trainCarType == "REEFER") {
            jpgImage = "graphics/Reefer_scale79.jpg";
        }

        return jpgImage;
    }

    // Mutator Function
    private String lookUpJPGThumbImage4TrainCarType(String trainType) {
        if (trainCarType == "LOCOMOTIVE") {
            jpgThumbImage = "graphics/Locomotive_thumb.jpg";
        } else if (trainCarType == "FREIGHT") {
            jpgThumbImage = "graphics/Freight_thumb.jpg";
        } else if (trainCarType == "HOPPER") {
            jpgThumbImage = "graphics/Hopper_thumb.jpg";
        } else if (trainCarType == "COAL") {
            jpgThumbImage = "graphics/Coal_thumb.jpg";
        } else if (trainCarType == "CABOOSE") {
            jpgThumbImage = "graphics/Caboose_thumb.jpg";
        } else if (trainCarType == "BOX") {
            jpgThumbImage = "graphics/Box_thumb.jpg";
        } else if (trainCarType == "PASSENGER") {
            jpgThumbImage = "graphics/Passenger_thumb.jpg";
        } else if (trainCarType == "TANKER") {
            jpgThumbImage = "graphics/Tanker_thumb.jpg";
        } else if (trainCarType == "REEFER") {
            jpgThumbImage = "graphics/Reefer_thumb.jpg";
        }

        return jpgThumbImage;
    }

    // Getters   
    public String getTrainType() {
        return trainCarType;
    }

    public String getJPGImage() {
        return jpgImage;
    }

    public String getJPGThumbImage() {
        return jpgThumbImage;
    }
    
    public String getOwner() {
        return owner;
    }

    // Setters
    public void setTrainType(String trainType) {
        trainCarType = trainType;
        jpgImage = lookUpJPGImage4TrainCarType(trainCarType);
        jpgThumbImage = lookUpJPGThumbImage4TrainCarType(trainCarType);
    }
    
    public void setOwner(String owner)
    {
        this.owner = owner;
    }
}
