/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Wed 7 Nov 2018 @ 11:59 PM
    HW_5
*/

package ticket2rideview;

import java.util.Scanner;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ticket2RideView extends Application
{
    final Label name = new Label("\nTicket-To-Ride Game");   
    final ImageView pic = new ImageView(
        new Image(Ticket2RideView.class.getResourceAsStream("pic38674.jpg")));   
    final Label introduction = new Label("                    Alan R. Moon's \n" +
                                          "              Ticket-To-Ride Game \n" +
                                        "The Cross-Country Train Adventure Game");
  
    // TrainCards are "hard-wired" (temporarily)
    TrainCard player1TrainCard1 = new TrainCard();  
    //player1TrainCard1.setTrainCarType("BOX");
    TrainCard player1TrainCard2 = new TrainCard();
    //player1TrainCard2.setTrainCarType("PASSENGER");    
    TrainCard player1TrainCard3 = new TrainCard();
     //player1TrainCard3.setTrainCarType("TANKER");   
    TrainCard player1TrainCard4 = new TrainCard();
    //player1TrainCard4.setTrainCarType("REEFER");
    
    // Tickets are "hard-wired" (temporarily)
    Ticket player1Ticket1 = new Ticket();
    Ticket player1Ticket2 = new Ticket();
    Ticket player1Ticket3 = new Ticket();
    
    Markers player1Marker = new Markers(1, 0);

    // *****   ***   *****

    // TrainCards are "hard-wired" (temporarily)
    TrainCard player2TrainCard1 = new TrainCard();
    //player2TrainCard1.setTrainCarType("FREIGHT");    
    TrainCard player2TrainCard2 = new TrainCard();
    //player2TrainCard2.setTrainCarType("HOPPER");    
    TrainCard player2TrainCard3 = new TrainCard();
    //player2TrainCard3.setTrainCarType("COAL");    
    TrainCard player2TrainCard4 = new TrainCard();
    //player2TrainCard4.setTrainCarType("CABOOSE");    
    
    // Tickets are "hard-wired" (temporarily)
    Ticket player2Ticket1 = new Ticket();
    Ticket player2Ticket2 = new Ticket();
    Ticket player2Ticket3 = new Ticket();
    
    Markers player2Marker = new Markers(2, 0);
 
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
                    player1TrainCard1.setTrainCarType(trainType);
                else if(cardNo == 2)
                    player1TrainCard2.setTrainCarType(trainType);
                else if(cardNo == 3)
                    player1TrainCard3.setTrainCarType(trainType);
                else if(cardNo == 4)
                    player1TrainCard4.setTrainCarType(trainType);
            }
        }
        
        else if(playerNo == 2)
        {
            for(int i = 0; i < 4; i++)
            {
                if(cardNo == 1)
                    player2TrainCard1.setTrainCarType(trainType);
                else if(cardNo == 2)
                    player2TrainCard2.setTrainCarType(trainType);
                else if(cardNo == 3)
                    player2TrainCard3.setTrainCarType(trainType);
                else if(cardNo == 4)
                    player2TrainCard4.setTrainCarType(trainType);
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
            player1Marker.redPosition = pos;
        if(playerNo == 2)
            player2Marker.bluePosition = pos; 
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
    
    public void wannaPlay()
    {
        System.out.println("Come play Ticket to Ride! Press Start. ");  
    }
    
    public int takeATurn()
    {
        System.out.println("Select: \n");
        System.out.println("1. Draw 2 Train Cards\n");
        System.out.println("2. Claim a Route\n");
        System.out.println("3. Draw 3 Destination Tickets\n");
        Scanner sc2 = new Scanner(System.in);
        int playersChoice = sc2.nextInt();
        return playersChoice;
        
    }
    
    public int draw1TrainCard()
    {
        System.out.println("Select a Train Card: ");
        System.out.println("1. Face-up Card #1");
        System.out.println("2. Face-up Card #2");        
        System.out.println("3. Face-up Card #3");        
        System.out.println("4. Face-up Card #4");        
        System.out.println("5. Face-up Card #5");        
        System.out.println("6. Top Card from Deck");       
        
        Scanner sc3 = new Scanner(System.in);
        int trainCardChoice = sc3.nextInt();
        return trainCardChoice;
    }
    
    public void claimARoute(int playerNo, String origin_destination)
    {
        System.out.println("What route do you wish to claim?");
        Scanner sc4 = new Scanner(System.in);
        String route = sc4.next();
        
        if (origin_destination == "San Francisco_Los Angeles")
        {
            // put x's in boxes between origin and destination
        }
    }   
    
    public boolean  returnDestinationTicket()
    {
        System.out.println("Do you wish to return a ticket?");
        System.out.println("Yes or No");
        Scanner sc5 = new Scanner(System.in);
        String answer = sc5.next();
        
        if (answer == "Yes" || answer == "yes" || answer == "Yes"
                            || answer == "Y" || answer == "y")
            return true;
        
        else return false;
    }
    
    // *****   ***   *****   ***   *****   ***   *****   ***   *****   ***   *****
    
    public static void main(String[] args)
    {  launch(Ticket2RideView.class, args); }

    @Override
    public void start(Stage stage)
    {
        
    // *************************************************************************************************************************************************   
        
        Scene scene = new Scene(new VBox(), 400, 350);
        scene.setFill(Color.OLDLACE);

        name.setFont(new Font("Verdana Bold", 22));
        pic.setFitHeight(150);
        pic.setPreserveRatio(true);

        MenuBar menuBar = new MenuBar();

        // *** Menu Box
        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);        
        vbox.setPadding(new Insets(0, 10, 0, 10));
        vbox.getChildren().addAll(name, pic, introduction);

        // *** Game SubMenu
        Menu menuFile = new Menu("Game");
        MenuItem add = new MenuItem("Set Player",
            new ImageView(new Image("ticket2rideview/new.png")));
        
        add.setOnAction((ActionEvent t) -> {
            //setPlayer();
            vbox.setVisible(true);
        });

        MenuItem clear = new MenuItem("Clear");
        clear.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        clear.setOnAction((ActionEvent t) -> {
            vbox.setVisible(false);
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });

        menuFile.getItems().addAll(add, clear, new SeparatorMenuItem(), exit);

        // *** Draw Train Card Menu
        Menu menuTrainCards = new Menu("Draw Train Cards");
        
        // Train Card 1
        Menu menuDrawTrainCard1 = new Menu("Draw Train Card 1");
        MenuItem faceupChoice1 = new MenuItem("Take Face-up card");
        MenuItem deckChoice1 = new MenuItem("Draw from the deck");
        menuDrawTrainCard1.getItems().add(faceupChoice1);
        menuDrawTrainCard1.getItems().add(deckChoice1);            
        menuTrainCards.getItems().addAll(menuDrawTrainCard1);

        // Train Card 2
        Menu menuDrawTrainCard2 = new Menu("Draw Train Card 2");
        MenuItem faceupChoice2 = new MenuItem("Take Face-up card");
        MenuItem deckChoice2 = new MenuItem("Draw from the deck");
        menuDrawTrainCard2.getItems().add(faceupChoice2);
        menuDrawTrainCard2.getItems().add(deckChoice2);            
        menuTrainCards.getItems().addAll(menuDrawTrainCard2);       

        Menu menuClaimARoute = new Menu("Claim-A-Route");
        MenuItem ticket1 = new MenuItem("San Francisco - Los Angeles");
        menuClaimARoute.getItems().add(ticket1);
        menuDrawTrainCard1.getItems().add(deckChoice1);            
        menuClaimARoute.getItems().addAll(ticket1);
 
        Menu menuDrawTickets = new Menu("Draw Tickets");       

        menuBar.getMenus().addAll(menuFile, menuTrainCards, menuClaimARoute, menuDrawTickets);        
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, vbox);

        stage.setScene(scene);
        stage.show();        

    // *************************************************************************************************************************************************   
        
        // BorderPane is the scene root
        BorderPane root = new BorderPane();
        
        HBox hbox = addHBoxTop();
        root.setTop(hbox);
        addStackPaneTop(hbox);         
       
        root.setLeft(addFlowPaneLeft());  
        
        StackPane stack = addStackPaneCenter();
        root.setCenter(stack);
   
        root.setRight(addFlowPaneRight());

        HBox hbox2 = addHBoxBottom();
        root.setBottom(addFlowPaneBottom());
        addStackPaneBottom(hbox2);

        stage.setTitle("Ticket2RideView");
        stage.show();
    }

    // Creates HBox with a Start button (for top region)
    private HBox addHBoxTop() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        Button startButton = new Button("Play");
        startButton.setPrefSize(100, 20);
        
        DropShadow shadow = new DropShadow();
        startButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>()
            {
                @Override public void handle(MouseEvent e)
                {
                    startButton.setEffect(shadow);
                    //startTicket2Ride();   // Uncomment at integration time
                    System.out.println("Controller Method has been called!");
                }
            });
  
        hbox.getChildren().addAll(startButton);
        
        return hbox;
    }

    // Creates HBox to hold StackPane (for bottom region)
    private HBox addHBoxBottom()
    {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        Button tbd = new Button("tbd");
        tbd.setPrefSize(100, 20);
        
        hbox.getChildren().addAll(tbd);
        
        return hbox;
    }

    // Uses stack pane to create a help icon / adds to the right side of HBox
    private void addStackPaneTop(HBox hb)
    {
        StackPane stack = new StackPane();
        
        Rectangle startIcon = new Rectangle(30.0, 25.0);
        startIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
            new Stop[]{
            new Stop(0,Color.web("#4977A3")),
            new Stop(0.5, Color.web("#B0C6DA")),
            new Stop(1,Color.web("#9CB6CF")),}));
        startIcon.setStroke(Color.web("#D0E6FA"));
        startIcon.setArcHeight(3.5);
        startIcon.setArcWidth(3.5);
        
        Text showTCards = new Text("T");
        showTCards.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        showTCards.setFill(Color.WHITE);
        showTCards.setStroke(Color.web("#7080A0")); 
        
        stack.getChildren().addAll(startIcon, showTCards);
        stack.setAlignment(Pos.CENTER_RIGHT);
        // Add offset to right for "T" to compensate for RIGHT 
        // alignment of all nodes
        StackPane.setMargin(showTCards, new Insets(0, 10, 0, 0));
        
        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);        
    }

    // Uses stack pane to create a help icon / adds to the right side of HBox
    private StackPane addStackPaneCenter()
    {
        StackPane stack = new StackPane();
        
        ImageView boardImage = new ImageView(
        new Image(Ticket2RideView.class.getResourceAsStream("pic38674.jpg")));
      
        // ***
        GridPane grid = new GridPane();
        grid = addGridPaneCenter(stack);

        stack.getChildren().add(boardImage); 
        stack.getChildren().add(grid);
        stack.getChildren().addAll();
        stack.setAlignment(Pos.CENTER);
       
        return stack;
    }

    private void addStackPaneBottom(HBox hb)
    {
        StackPane stack = new StackPane();

        stack.setAlignment(Pos.CENTER_RIGHT);
 
        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);        
    }

    private GridPane addGridPaneCenter(StackPane stack)         
    {
        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);

        //No Padding needs to be set for this method
        //grid.setPadding(new Insets(0, 0, 0, 0));        
              
        grid.setColumnSpan(grid, 1025);  
        grid.setRowSpan(grid, 680);
     
        // This code puts a "@" in the middle of the San Franciso to
        // Los Angeles route to show that it has been taken by the player
        Label label1 = new Label("@");
        grid.add(label1, 9, 46);
       
        //grid.setGridLinesVisible(true);
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
            player1TrainCard1.getJPGImage()))); 
            //"Box_scale79.jpg")));
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
        
        String pic = "Hopper_scale79.jpg";
        
        
        trainCards[0] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player2TrainCard1.getJPGImage())));       
        flow.getChildren().add(trainCards[0]);        

        trainCards[1] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            //player2TrainCard2.getJPGImage())));                    
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
}
