/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Fri 9 Nov 2018 @ 11:59 PM
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
    // THIS CODE WILL MOVE INTO "ABOUT" SUBMENU .... LATER!
    final Label name = new Label("\nTicket-To-Ride Game");   
    final ImageView pic = new ImageView(
        new Image(Ticket2RideView.class.getResourceAsStream("pic38674.jpg")));   
    final Label introduction = new Label("                    Alan R. Moon's \n" +
                                          "              Ticket-To-Ride Game \n" +
                                        "The Cross-Country Train Adventure Game");

    // ************************************************************************** INITIALIZE BOARD ELEMENTS
    
    String Player1, Player2;
    ActiveGame G;
    
    // Initial Train Card Values: Preset for show / Reset when game starts

    TrainCard player1TrainCard1 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());  
    TrainCard player1TrainCard2 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());
    TrainCard player1TrainCard3 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());
    TrainCard player1TrainCard4 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());

    TrainCard player2TrainCard1 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());
    TrainCard player2TrainCard2 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());
    TrainCard player2TrainCard3 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());
    TrainCard player2TrainCard4 = TrainCard.lookUpJPGImage4TrainCarType(G.D.draw());

    // Initial Ticket Values: Preset for show / Reset when game starts
    Ticket player1Ticket1 = Player1.DHand.get(1);
    Ticket player1Ticket2 = Player1.DHand.get(2);
    Ticket player1Ticket3 = Player1.DHand.get(3);

    Ticket player2Ticket1 = Player2.DHand.get(1);
    Ticket player2Ticket2 = Player2.DHand.get(2);
    Ticket player2Ticket3 = Player2.DHand.get(3);

    // Markers are at start position (Initially)
    Markers player1Marker = new Markers(1, 0);
    Markers player2Marker = new Markers(2, 0);
 
    // Initial Deck5 Train Card Values: Preset for show / Reset when game starts
    TrainCard deck5TrainCard1 = new TrainCard("BOX");
    TrainCard deck5TrainCard2 = new TrainCard("PASSENGER");    
    TrainCard deck5TrainCard3 = new TrainCard("REEFER");    
    TrainCard deck5TrainCard4 = new TrainCard("HOPPER");    
    TrainCard deck5TrainCard5 = new TrainCard("CABOOSE");    
    
    LPBonus longestPathBonus = new LPBonus();  
   
    // ************************************************************************** MAIN()
    
    public static void main(String[] args)
    {  launch(Ticket2RideView.class, args); }

    // ************************************************************************** START()
     
    @Override
    public void start(Stage stage)
    {  
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
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Ticket2RideView");
        stage.show();
    }

    // ************************************************************************** BEGIN TOP BORDERPANE 
    
        // CREATES HBOX FOR TOP PANE:
        // INCLUDES: Player1 Button - Main Menu - Player2 Button - T Button
    private HBox addHBoxTop() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

    // ********************************************************* PLAYER1 BUTTON      

        Button player1 = new Button("Player1");
        player1.setPrefSize(100, 20);
        
        DropShadow shadow = new DropShadow();
        player1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    player1.setEffect(shadow); } });
        
        player1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Player1 Button has been clicked!"); } });       
  
    // ****************************************************** MAIN MENUBAR VBOX
    
        // Note: not needed anymore? .... deal with it later
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
        
    // *********************************************************** GAME SUBMENU

        Menu menuGame = new Menu("Game");
        
        Menu menuSetPlayer = new Menu("Set Player");
        
    // ******************************************************* SET PLAYER1 NAME
    
        MenuItem setNamePlayer1 = new MenuItem("Player 1 Name");
        setNamePlayer1.setOnAction((ActionEvent t) -> {  
            System.out.println("Enter name for Player 1: ");   
            Scanner scan = new Scanner(System.in);
            String p1 = scan.next();
            G.setPlayer1Name(p1);        // ************************************************************************************** METHOD FOR CONTROLLER !!!
            Player1 = p1;   // for my local Player1 String
            vbox.setVisible(true);
        });
        
    // ******************************************************* SET PLAYER2 NAME
    
        MenuItem setNamePlayer2 = new MenuItem("Player 2 Name");
        setNamePlayer2.setOnAction((ActionEvent t) -> {  
            System.out.println("Enter name for Player 2: ");
            Scanner scan = new Scanner(System.in);
            String p2 = scan.next();
            G.setPlayer2Name(p2);        // ************************************************************************************** METHOD FOR CONTROLLER !!!           
            vbox.setVisible(true);
        });

        menuSetPlayer.getItems().add(setNamePlayer1);
        menuSetPlayer.getItems().add(setNamePlayer2);            
        menuGame.getItems().addAll(menuSetPlayer);         
    
    // ************************************************************* GAME RULES
    
            // THIS IS FOR FUTURE DEVELOPMENT
        MenuItem showGameRules = new MenuItem("Game Rules");
        showGameRules.setOnAction((ActionEvent t) -> {  
            System.out.println("Game Rules (For Future Development) ");
            vbox.setVisible(true);
        });

    // ************************************************************ RESET BOARD
    
            // THIS WILL BECOME "RESET BOARD"
        MenuItem clear = new MenuItem("Reset Board");
        clear.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        clear.setOnAction((ActionEvent t) -> {
            vbox.setVisible(false);
        });

    // ****************************************************************** QUIT
        MenuItem exit = new MenuItem("Quit");
        exit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });

        menuGame.getItems().addAll(menuSetPlayer, showGameRules, clear,
                                            new SeparatorMenuItem(), exit);

    // ************************************************** DRAW TRAIN CARDS MENU
 
        // *** Draw Train Cards Menu
        Menu menuTrainCards = new Menu("Draw Train Cards");

    // ****************************************************** DRAW TRAIN CARD 1
    
        // PLAYER SELECTS HIS FIRST TRAIN CARD (TRAIN CARD 1)
        Menu menuDrawTrainCard1 = new Menu("Draw Train Card 1");
        
        // PLAYER CHOOSES TO TAKE FACE-UP TRAIN CARD
        MenuItem TC1_Choice1_FaceUp = new MenuItem("Take Face-up card");
        TC1_Choice1_FaceUp.setOnAction((ActionEvent t) -> {
            //drawFaceUp();                                       // **********************************    ******* METHOD FOR CONTROLLER !!!
            vbox.setVisible(true);
        });

        // PLAYER CHOOSES TO DRAW A TRAIN CARD FROM THE DECK
        MenuItem TC1_Choice2_FromDeck = new MenuItem("Draw from the deck");
        TC1_Choice2_FromDeck.setOnAction((ActionEvent t) -> {
            System.out.println("TC1: Draw from the deck\n");
            
            G.D.draw();                      // *********************************     ******* METHOD FOR CONTROLLER !!!

            vbox.setVisible(true);
        });
        
        menuDrawTrainCard1.getItems().add(TC1_Choice1_FaceUp);
        menuDrawTrainCard1.getItems().add(TC1_Choice2_FromDeck);            
        menuTrainCards.getItems().addAll(menuDrawTrainCard1);
 
    // ****************************************************** DRAW TRAIN CARD 2
    
        // PLAYER SELECTS HIS SECOND TRAIN CARD (TRAIN CARD 2)
        Menu menuDrawTrainCard2 = new Menu("Draw Train Card 2");
        
        // PLAYER CHOOSES TO TAKE FACE-UP TRAIN CARD       
        MenuItem TC2_Choice1_FaceUp = new MenuItem("Take Face-up card");
        TC2_Choice1_FaceUp.setOnAction((ActionEvent t) -> {
            
            System.out.println("TC2: Take Face-up card\n");
            System.out.println("Which card do you want?\n");
            System.out.println("Choose 1-5");

            Scanner scan = new Scanner(System.in);
            int tcNo = scan.nextInt();
            
            TrainCard tcTemp = new TrainCard();
            tcTemp = int2TCObject(tcNo);

            TrainCard deck5TrainCardReplacement = new TrainCard();
            deck5TrainCardReplacement = dispenseFaceUpTrainCard(tcTemp);        // ***************************************** METHOD FOR CONTROLLER !!!
            player1TrainCard1 = deck5TrainCardReplacement;
            vbox.setVisible(true);
        });
        
        // PLAYER CHOOSES TO DRAW A TRAIN CARD FROM THE DECK        
        MenuItem TC2_Choice2_FromDeck = new MenuItem("Draw from the deck");
        TC2_Choice2_FromDeck.setOnAction((ActionEvent t) -> {
           
            System.out.println("TC1: Draw from the deck\n");
            
            // player1TrainCard2 = deal_1_CardFromDeck(); g.P1.THand.add(g.d.draw)                      // ***************************************** METHOD FOR CONTROLLER !!!

            vbox.setVisible(true);
        });
        
        menuDrawTrainCard2.getItems().add(TC2_Choice1_FaceUp);
        menuDrawTrainCard2.getItems().add(TC2_Choice2_FromDeck);            
        menuTrainCards.getItems().addAll(menuDrawTrainCard2);
        
    // ***************************************************** CLAIM-A-ROUTE MENU
   
        // Claim-A-Route Menu
        Menu menuClaimARoute = new Menu("Claim-A-Route");
        MenuItem ticket1 = new MenuItem("San Francisco - Los Angeles");
       ticket1.setOnAction((ActionEvent t) -> {
            System.out.println("You chose San Francisco - Los Angeles");
            vbox.setVisible(true);
        });          
        MenuItem ticket2 = new MenuItem("San Francisco - Salt Lake City");
        ticket2.setOnAction((ActionEvent t) -> {
            System.out.println("You chose San Francisco - Salt Lake City");
            vbox.setVisible(true);
        });          
        MenuItem ticket3 = new MenuItem("San Francisco - Portland");
        ticket3.setOnAction((ActionEvent t) -> {
            System.out.println("You chose San Francisco - Portland");
            vbox.setVisible(true);
        });                 
        menuClaimARoute.getItems().addAll(ticket1, ticket2, ticket3);
     
    // ****************************************************** DRAW TICKETS MENU        

        Menu menuDrawTickets = new Menu("Draw Tickets");
        MenuItem draw3Tickets = new MenuItem("Draw 3 Destination Tickets");
        draw3Tickets.setOnAction((ActionEvent t) -> {
            System.out.println("You chose to draw 3 Destination Tickets");
            vbox.setVisible(true);
        });

    // ***************************************************** RETURN TICKET MENU         
      
        MenuItem returnTicket = new MenuItem("Return Ticket");
        returnTicket.setOnAction((ActionEvent t) -> {
            System.out.println("You chose to return one destination Ticket");
            vbox.setVisible(true);
        }); 
        menuDrawTickets.getItems().addAll(draw3Tickets, returnTicket);
        
        menuBar.getMenus().addAll(menuGame, menuTrainCards, menuClaimARoute,
                                                            menuDrawTickets);        
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, vbox);   

    // ********************************************************* PLAYER2 BUTTON
        
        Button player2 = new Button("Player2");
        player1.setPrefSize(100, 20);
        
        DropShadow shadow2 = new DropShadow();
        player1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    player1.setEffect(shadow2); } });
        
        player1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Player1 Button has been clicked!"); } });         
  
        hbox.getChildren().addAll(player1, menuBar, player2);       
        return hbox;
    }
  
    // ****************************************************** ADD STACKPANE TOP
    
    // Uses stack pane to create the "T" Button / adds to the right side of HBox
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

    // ************************************************************************** BEGIN LEFT BORDERPANE (FLOWPANE)
    
    // Creates Vertical Display of Train & Destination Cards
    private FlowPane addFlowPaneLeft()  // for left side (Player1er 1)
    {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(20, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(85);
        flow.setStyle("-fx-background-color: DAE6F3;");

        // Array for 4 Train Cards for Player1er #1 (on left)
        ImageView trainCards[] = new ImageView[4];
        
        trainCards[0] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player1TrainCard1.getJPGImage())));
        flow.getChildren().add(trainCards[0]);        

        trainCards[1] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player1TrainCard2.getJPGImage())));      
        flow.getChildren().add(trainCards[1]);             
            
        trainCards[2] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player1TrainCard3.getJPGImage())));       
        flow.getChildren().add(trainCards[2]);              
            
        trainCards[3] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player1TrainCard4.getJPGImage())));   
        flow.getChildren().add(trainCards[3]);              
        
        // Array for 3 Destination Cards for Player1er #1 (on left)
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
    
    // ************************************************************************** BEGIN CENTER BORDERPANE
    // ********************************************************** ADD STACKPANE
    
    // StackPane has 2 Children: Child 1 (Board Image), Child 2 (GridPane)
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

    // *********************************************************** ADD GRIDPANE
    
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
      
    // ************************************************************************** BEGIN RIGHT BORDERPANE (FLOWPANE)
    
    // Creates Vertical Display of Train & Destination Cards
    private FlowPane addFlowPaneRight()  // for right side (Player1er 2)
    {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(20, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(85);
        flow.setStyle("-fx-background-color: DAE6F3;");

        // Array for 4 Train Cards for Player1er #1 (on left)
        ImageView trainCards[] = new ImageView[4];   
        trainCards[0] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player2TrainCard1.getJPGImage())));       
        flow.getChildren().add(trainCards[0]);        
        trainCards[1] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player2TrainCard2.getJPGImage())));                           
        flow.getChildren().add(trainCards[1]);                         
        trainCards[2] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player2TrainCard3.getJPGImage())));       
        flow.getChildren().add(trainCards[2]);                          
        trainCards[3] = new ImageView(
            new Image(Ticket2RideView.class.getResourceAsStream(
            player2TrainCard4.getJPGImage())));       
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

    // ************************************************************************** BEGIN BOTTOM BORDERPANE
    
    // CREATES HBOX TO HOLD STACKPANE (FOR BOTTOM REGION)
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

    // ********************************************************** ADD STACKPANE
    
    private void addStackPaneBottom(HBox hb)
    {
        StackPane stack = new StackPane();

        stack.setAlignment(Pos.CENTER_RIGHT);
 
        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);        
    }

    // *********************************************************** ADD FLOWPANE
    
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
                "Passenger_scale79_vert.jpg")));                               
            flow.getChildren().add(pages[1]);           
            
             pages[2] = new ImageView(
                new Image(Ticket2RideView.class.getResourceAsStream(
                "Reefer_scale79_vert.jpg")));              
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
    
    // ************************************************************************** FUNCTION: int2TCObject()
    
        public TrainCard int2TCObject(int tcNo)
        {
            TrainCard tcTemp = new TrainCard();
                
            if(tcNo == 1)
                tcTemp = deck5TrainCard1;
            if(tcNo == 2)
                tcTemp = deck5TrainCard2;           
            if(tcNo == 3)
                tcTemp = deck5TrainCard3;            
            if(tcNo == 4)
                tcTemp = deck5TrainCard4;           
            if(tcNo == 5)
                tcTemp = deck5TrainCard5;
            if(tcNo == 6)
                tcTemp = player1TrainCard1;           
            if(tcNo == 7)
                tcTemp = player1TrainCard2;            
            if(tcNo == 8)
                tcTemp = player2TrainCard1;           
            if(tcNo == 9)
                tcTemp = player2TrainCard2;           
   
            return tcTemp;
        }

    // ************************************************************************** INTEGRATION TEST DRIVERS
        // DRIVERS TO TEST INTERFACE BETWEEN VIEW (GUI) AND CONTROLLER
        
     public void setPlayer1Name(String p1)
     {
         Player1 = p1;  // This is "The Controller/Model's Player1
     }
        
     public void setPlayer2Name(String p2)
     {
         Player2 = p2;  // This is "The Controller/Model's Player2
     }       

    public TrainCard dispenseFaceUpTrainCard(TrainCard tcTemp)
    {   /*  
            THIS IS A TEMPORARY TEST DRIVER
        This function should go into the Controller.
    
        Input: "tcTemp" ... a TrainCard that the GUI wants to remove from board
        This card should be added to the Player1er's hand.
    
        Output: The Controller should return a new TrainCard from the Deck
        (So that the GUI can replace the card that was removed from Board)
        */

        return deck5TrainCard5;         // Bogus: just a test experiment
    }

    public TrainCard deal_1_CardFromDeck()
    {   /*
            THIS IS A TEMPORARY TEST DRIVER
        This function should go into the Controller.
    
        Input: no input parameters
    
        Output: The Controller should return a new TrainCard from the Deck
        This card should also be added to the Player1er's hand.
        */        

        return deck5TrainCard5;         // Bogus: just a test experiment
    }       
}
    // THE END ******************************************************************