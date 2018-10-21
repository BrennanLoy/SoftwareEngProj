/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Wed 24 Oct 2018 @ 11:59 PM
    HW_4
*/

package ticket2rideview;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ticket2RideView extends Application
{
    
    TrainCard player1TrainCard1 = new TrainCard();
    TrainCard player1TrainCard2 = new TrainCard();
    TrainCard player1TrainCard3 = new TrainCard();
    TrainCard player1TrainCard4 = new TrainCard();
    
    Ticket player1Ticket1 = new Ticket();
    Ticket player1Ticket2 = new Ticket();
    Ticket player1Ticket3 = new Ticket();
    
    Marker player1Marker = new Marker(1);

    // *****   ***   *****
    
    TrainCard player2TrainCard1 = new TrainCard();
    TrainCard player2TrainCard2 = new TrainCard();
    TrainCard player2TrainCard3 = new TrainCard();
    TrainCard player2TrainCard4 = new TrainCard();
    
    Ticket player2Ticket1 = new Ticket();
    Ticket player2Ticket2 = new Ticket();
    Ticket player2Ticket3 = new Ticket();
    
    Marker player2Marker = new Marker(2);
 
    TrainCard deck5TrainCard1 = new TrainCard();
    TrainCard deck5TrainCard2 = new TrainCard();    
    TrainCard deck5TrainCard3 = new TrainCard();    
    TrainCard deck5TrainCard4 = new TrainCard();    
    TrainCard deck5TrainCard5 = new TrainCard();    
    
    LPBonus longestPathBonus = new LPBonus();   
 
    // *****   ***   *****

    /*
    // When I uncomment this constructor, I have a runtime problem.
    // even if the Constructor body is empty!
    // Constructor
    Ticket2RideView()
    {
        player1TrainCard1.trainCarType = "BOX";        
        player1TrainCard2.trainCarType = "CABOOSE";        
        player1TrainCard3.trainCarType = "COAL";
        player1TrainCard4.trainCarType = "FREIGHT";


        player1Ticket1.origin_destination = "Montreal_Chicago";
        player1Ticket2.origin_destination = "Vancouver_Portland";     
        player1Ticket3.origin_destination = "Boston_Washington";
        
        player2TrainCard1.trainCarType = "BOX";        
        player2TrainCard2.trainCarType = "CABOOSE";        
        player2TrainCard3.trainCarType = "COAL";
        player2TrainCard4.trainCarType = "FREIGHT";

        player2Ticket1.origin_destination = "Montreal_Chicago";
        player2Ticket2.origin_destination = "Vancouver_Portland";     
        player2Ticket3.origin_destination = "Boston_Washington";
    }
    */
    
    // Setter
    public void setPlayerTrainCard(int playerNo, int cardNo, String trainType)
    {
        
        if(playerNo == 1)
        {
            for(int i = 0; i < 4; i++)
            {
                if(cardNo == 1)
                    player1TrainCard1.trainCarType = trainType;
                else if(cardNo == 2)
                    player1TrainCard2.trainCarType = trainType;
                else if(cardNo == 3)
                    player1TrainCard3.trainCarType = trainType;
                else if(cardNo == 4)
                    player1TrainCard4.trainCarType = trainType;
            }
        }
        
        else if(playerNo == 2)
        {
            for(int i = 0; i < 4; i++)
            {
                if(cardNo == 1)
                    player2TrainCard1.trainCarType = trainType;
                else if(cardNo == 2)
                    player2TrainCard2.trainCarType = trainType;
                else if(cardNo == 3)
                    player2TrainCard3.trainCarType = trainType;
                else if(cardNo == 4)
                    player2TrainCard4.trainCarType = trainType;
            }       
        }  
    }
    
    // Setter
    public void setDestinationTicket(int playerNo, int cardNo, String orig_des)
    {
        if(playerNo ==1)
        {
            for(int i = 0; i < 3; i++)
            {
                if(cardNo == 1)
                    player1Ticket1.origin_destination = orig_des;
                if(cardNo == 2)
                    player1Ticket2.origin_destination = orig_des;               
                if(cardNo == 3)
                    player1Ticket3.origin_destination = orig_des;              
            }
        }
        
        if(playerNo ==2)
        {
            for(int i = 0; i < 3; i++)
            {
                if(cardNo == 1)
                    player2Ticket1.origin_destination = orig_des;
                if(cardNo == 2)
                    player2Ticket2.origin_destination = orig_des;               
                if(cardNo == 3)
                    player2Ticket3.origin_destination = orig_des;              
            }
        }            
    }
    
    // Setter
    public void setMarker(int playerNo, int pos)
    {
        if(playerNo == 1)
            player1Marker.position = pos;
        if(playerNo == 2)
            player2Marker.position = pos; 
    }
 
    // Setter
    public void setDeck5TrainCards(int cardNo, String trainType)
    {
        if(cardNo == 1)
            deck5TrainCard1.trainCarType = trainType;
        if(cardNo == 2)
            deck5TrainCard2.trainCarType = trainType;       
        if(cardNo == 3)
            deck5TrainCard3.trainCarType = trainType;
        if(cardNo == 4)
            deck5TrainCard4.trainCarType = trainType;        
        if(cardNo == 5)
            deck5TrainCard5.trainCarType = trainType;         
    }

    // *****   ***   *****   ***   *****   ***   *****   ***   *****
    
    public static void main(String[] args)
    {   launch(Ticket2RideView.class, args);    }

    @Override
    public void start(Stage stage)
    {
        // Set up BorderPane as scene root
        BorderPane border = new BorderPane();
        
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addFlowPaneLeft());  
        
        // Add stack to HBox (top region)
        addStackPane(hbox);  
     
        border.setCenter(addGridPane());
        // border.setCenter(addAnchorPane(addGridPane()));
        
        border.setRight(addFlowPaneRight());
        // border.setRight(addTilePane());

        HBox hbox2 = addHBox();
        border.setBottom(addFlowPaneBottom());
        
        // Add stack to HBox (bottom region)
        addStackPane(hbox2);

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("Ticket2RideView");
        stage.show();
    }

    // Creates HBox with two buttons (for top region)
    private HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonPlayer1 = new Button("Player1");
        buttonPlayer1.setPrefSize(100, 20);

        Button buttonPlayer2 = new Button("Player2");
        buttonPlayer2.setPrefSize(100, 20);
        
        hbox.getChildren().addAll(buttonPlayer1, buttonPlayer2);
        
        return hbox;
    }
    
    // Uses stack pane to create a help icon / adds to the right side of HBox
    private void addStackPane(HBox hb) {

        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
            new Stop[]{
            new Stop(0,Color.web("#4977A3")),
            new Stop(0.5, Color.web("#B0C6DA")),
            new Stop(1,Color.web("#9CB6CF")),}));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);
        
        Text helpText = new Text("?");
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0")); 
        
        stack.getChildren().addAll(helpIcon, helpText);
        stack.setAlignment(Pos.CENTER_RIGHT);
        // Add offset to right for question mark to compensate for RIGHT 
        // alignment of all nodes
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));
        
        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);        
    }
    
    private GridPane addGridPane() {

        GridPane grid = new GridPane();
        // grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        
        grid.setColumnSpan(grid, 1025);
        //grid.setColumnSpan(grid, 1025);       
        grid.setRowSpan(grid, 680);

        // House icon in column 1, rows 1-2
        ImageView imageBoard = new ImageView(
        new Image(Ticket2RideView.class.getResourceAsStream("pic38674.jpg")));
        grid.add(imageBoard, 0, 0, 1, 2);       

        // grid.setGridLinesVisible(true);
        return grid;
    }    

    // Creates Vertical Display of Train & Destination Cards
    private FlowPane addFlowPaneLeft()  // for left side (Player 1)
    {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(20, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(85);
        flow.setStyle("-fx-background-color: DAE6F3;");

        // Array for 4 Train Cards for Player #1 (on left)
        ImageView trainCards[] = new ImageView[4];
        
        trainCards[0] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Box_scale79.jpg")));        
        flow.getChildren().add(trainCards[0]);        

        trainCards[1] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Passenger_scale79.jpg")));        
        flow.getChildren().add(trainCards[1]);             
            
        trainCards[2] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Tanker_scale79.jpg")));        
        flow.getChildren().add(trainCards[2]);              
            
        trainCards[3] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Reefer_scale79.jpg")));        
        flow.getChildren().add(trainCards[3]);              
        
        // Array for 3 Destination Cards for Player #1 (on left)
        ImageView destinationCards[] = new ImageView[3];
        
        destinationCards[0] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Ticket1_scale58.jpg")));        
        flow.getChildren().add(destinationCards[0]);              
            
        destinationCards[1] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Ticket2_scale58.jpg")));        
        flow.getChildren().add(destinationCards[1]);              
            
        destinationCards[2] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Ticket3_scale58.jpg")));        
        flow.getChildren().add(destinationCards[2]);              
      
        return flow;
    }

    // Creates Vertical Display of Train & Destination Cards
    private FlowPane addFlowPaneRight()  // for right side (Player 2)
    {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(20, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(85);
        flow.setStyle("-fx-background-color: DAE6F3;");

        // Array for 4 Train Cards for Player #1 (on left)
        ImageView trainCards[] = new ImageView[4];
        
        trainCards[0] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Freight_scale79.jpg")));        
        flow.getChildren().add(trainCards[0]);        

        trainCards[1] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Hopper_scale79.jpg")));        
        flow.getChildren().add(trainCards[1]);             
            
        trainCards[2] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Coal_scale79.jpg")));        
        flow.getChildren().add(trainCards[2]);              
            
        trainCards[3] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Caboose_scale79.jpg")));        
        flow.getChildren().add(trainCards[3]);              
        
        // Array for 3 Destination Cards for Player #1 (on left)
        ImageView destinationCards[] = new ImageView[3];
        
        destinationCards[0] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Ticket1_scale58.jpg")));        
        flow.getChildren().add(destinationCards[0]);              
            
        destinationCards[1] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Ticket2_scale58.jpg")));        
        flow.getChildren().add(destinationCards[1]);              
            
        destinationCards[2] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            "Ticket3_scale58.jpg")));        
        flow.getChildren().add(destinationCards[2]);              
      
        return flow;
    }   

    // FlowPane is displaying the Train & Destination Cards
    private FlowPane addFlowPaneBottom()    // for bottom strip
    {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 213));
        flow.setVgap(4);
        flow.setHgap(40);
        flow.setPrefWrapLength(170);
        flow.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[6];
            pages[0] = new ImageView(
                new Image(Ticket2RideView.class.getResourceAsStream(
                "Box_scale79_vert.jpg")));        
            flow.getChildren().add(pages[0]);
            
            pages[1] = new ImageView(
                new Image(Ticket2RideView.class.getResourceAsStream(
                "Freight_scale79_vert.jpg")));        
            flow.getChildren().add(pages[1]);           
            
             pages[2] = new ImageView(
                new Image(Ticket2RideView.class.getResourceAsStream(
                "Tanker_scale79_vert.jpg")));        
            flow.getChildren().add(pages[2]);
            
             pages[3] = new ImageView(
                new Image(Ticket2RideView.class.getResourceAsStream(
                "Hopper_scale79_vert.jpg")));        
            flow.getChildren().add(pages[3]);
            
            pages[4] = new ImageView(
                new Image(Ticket2RideView.class.getResourceAsStream(
                "Caboose_scale79_vert.jpg")));        
            flow.getChildren().add(pages[4]);
            
            pages[5] = new ImageView(
                new Image(Ticket2RideView.class.getResourceAsStream(
                "LPBonusCard_scale47.jpg")));        
            flow.getChildren().add(pages[5]);

        return flow;
    }

/*
    private TilePane addTilePane() {
        
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(5, 0, 5, 0));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(2);
        tile.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        for (int i=0; i<8; i++) {
            pages[i] = new ImageView(
                    new Image(Ticket2RideView.class.getResourceAsStream(
                    "graphics/chart_"+(i+1)+".png")));
            tile.getChildren().add(pages[i]);
        }

        return tile;
    }
*/ 

    // Creates an anchor pane using the provided grid and an HBox with buttons
    // @param grid Grid to anchor to the top of the anchor pane
    /*
    private AnchorPane addAnchorPane(GridPane grid) {

        AnchorPane anchorpane = new AnchorPane();
        
        Button buttonSave = new Button("Save");
        Button buttonCancel = new Button("Cancel");

        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(buttonSave, buttonCancel);

        anchorpane.getChildren().addAll(grid,hb);
        // Anchor buttons to bottom right, anchor grid to top
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }
    */
}
