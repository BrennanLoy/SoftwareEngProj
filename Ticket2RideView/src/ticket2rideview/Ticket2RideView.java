/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Fri 7 Dec 2018 @ 11:59 PM
    HW_6
*/

package ticket2rideview;

import java.util.Random;
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
        new Image(Ticket2RideView.class.getResourceAsStream("graphics/pic38674.jpg")));   
    final Label introduction = new Label("                    Alan R. Moon's \n" +
                                          "              Ticket-To-Ride Game \n" +
                                        "The Cross-Country Train Adventure Game");

    // ************************************************************************** INITIALIZE BOARD ELEMENTS
    
    // Variable Initializations
    String Player1, Player2;
    int currentPlayer = 1;
    
    Integer integerScore1 = 0000;
    Integer integerScore2 = 0000;
    String stringScore = "";
    
    String boardPic = "graphics/pic38674.jpg";
    //String boardPic = "graphics/T2R_Swiss.jpg";
    
    Button centerBoardImage = new Button();
    
    // Initialize left_TC Buttons
    Button left_TC_1 = new Button();
    Button left_TC_2 = new Button();   
    Button left_TC_3 = new Button();    
    Button left_TC_4 = new Button();
    
    // Initialize left_DT Buttons
    Button left_DT_1 = new Button();
    Button left_DT_2 = new Button();   
    Button left_DT_3 = new Button();
    
    // Initialize right_TC Buttons
    Button right_TC_1 = new Button();
    Button right_TC_2 = new Button();   
    Button right_TC_3 = new Button();    
    Button right_TC_4 = new Button();
    
    // Initialize right_DT Buttons
    Button right_DT_1 = new Button();
    Button right_DT_2 = new Button();   
    Button right_DT_3 = new Button();
    
    // Initialize bottom_TC Buttons
    Button bottom_TC_1 = new Button();
    Button bottom_TC_2 = new Button();   
    Button bottom_TC_3 = new Button();    
    Button bottom_TC_4 = new Button();    
    Button bottom_TC_5 = new Button();

    // Initialize bottom_LP_Bonus Button
    Button bottom_LP_Bonus = new Button();   

    // Initial Train Card Values: Preset for show / Reset when game starts
    TrainCard player1TrainCard1 = new TrainCard("BOX");  
    TrainCard player1TrainCard2 = new TrainCard("PASSENGER"); 
    TrainCard player1TrainCard3 = new TrainCard("TANKER");
    TrainCard player1TrainCard4 = new TrainCard("REEFER");

    TrainCard player2TrainCard1 = new TrainCard("FREIGHT"); 
    TrainCard player2TrainCard2 = new TrainCard("HOPPER");  
    TrainCard player2TrainCard3 = new TrainCard("COAL");
    TrainCard player2TrainCard4 = new TrainCard("CABOOSE");

    // Initial Ticket Values: Preset for show / Reset when game starts
    Ticket player1Ticket1 = new Ticket();
    Ticket player1Ticket2 = new Ticket();
    Ticket player1Ticket3 = new Ticket();

    Ticket player2Ticket1 = new Ticket();
    Ticket player2Ticket2 = new Ticket();
    Ticket player2Ticket3 = new Ticket();

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
    Control Ctrl = new Control();                                               // new code added for Brennan *********************************************************************
      
    // ************************************************************************** MAIN()
    
    public static void main(String[] args)
    {
        
        launch(Ticket2RideView.class, args); }

    // ************************************************************************** START()
     
    @Override
    public void start(Stage stage)
    {  
        //Controller control = new Controller();
        
        // BorderPane is the scene root
        BorderPane root = new BorderPane();
        
        HBox hbox = addHBoxTop();
        root.setTop(hbox);       
       
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
        // INCLUDES: Player1-Score1-TrainCards1 Buttons + Main Menu + Player2-Score2-TrainCards2 Buttons
    private HBox addHBoxTop() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 7, 15, 7));
        hbox.setSpacing(30);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");
        
        String player1Score = "0000";
        String player2Score = "0000";
        int player1IntScore = 0000;

    // ************************************************************************** GUIDE BUTTON

        //String player1Guide = "GUIDE";
        Button guide = new Button("GUIDE");
        guide.setText("Enter your name to begin!");
        guide.setPrefSize(178, 20);

        DropShadow shadow = new DropShadow();
        guide.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    guide.setEffect(shadow); } });
        
        guide.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Guide Button has been clicked!"); } });       
        
         
    // ************************************************************************** PLAYER1 BUTTON      

        Button player1 = new Button("Player1");
        
        player1.setPrefSize(90, 20);

        player1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    player1.setEffect(shadow); } });
        
        player1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    guide.setText("Hello Player 1");
                    currentPlayer = 1;
                    System.out.println("Player1 Button has been clicked!"); } });

    // ************************************************************************** PLAYER2 BUTTON
        
        Button player2 = new Button("Player2");
        player2.setPrefSize(90, 20);

        player2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    player2.setEffect(shadow); } });
        
        player2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    guide.setText("Hello Player 2");
                    currentPlayer = 2;
                    System.out.println("Player2 Button has been clicked!"); } });

    // ************************************************************************** SCORE1 BUTTON
        
        //player1Score = Integer.toString(player1IntScore);
        Button score1 = new Button(player1Score);
        score1.setPrefSize(50, 20);

        score1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    score1.setEffect(shadow); } });
        
        score1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {                   
                    guide.setText("Score Player 1"); } });                                      
                    //System.out.println("Score 1 Button has been clicked!"); } });

    // ************************************************************************** SCORE2 BUTTON

        Button score2 = new Button(player2Score);
        score2.setPrefSize(50, 20);

        score2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    score2.setEffect(shadow); } });
        
        score2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    guide.setText("Score Player 2"); } });
                    //System.out.println("Score2 Button has been clicked!"); } });       

    // ************************************************************************** TRAINCARDS1 BUTTON
        
        Button trainCards1 = new Button("Train Cards");
        trainCards1.setPrefSize(76, 20);

        trainCards1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    trainCards1.setEffect(shadow); } });
        
        trainCards1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    guide.setText("P1 Traincard ThumbPrints"); } });
    
    // ************************************************************************** TRAINCARDS2 BUTTON

        Button trainCards2 = new Button("Train Cards");
        trainCards2.setPrefSize(76, 20);
        
        trainCards2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    trainCards2.setEffect(shadow); } });
        
        trainCards2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    guide.setText("P2 Traincard ThumbPrints"); } });                   
                    
                    //System.out.println("TrainCards2 Button has been clicked!"); } });           

    // ************************************************************************** Tickets1 BUTTON
        
        Button tickets1 = new Button("Tickets");
        tickets1.setPrefSize(53, 20);

        tickets1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    tickets1.setEffect(shadow); } });
        
        tickets1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Tickets 1 Button has been clicked!"); } });
        
    // ************************************************************************** Tickets2 BUTTON
        
        Button tickets2 = new Button("Tickets");
        tickets2.setPrefSize(53, 20);

        tickets2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    tickets2.setEffect(shadow); } });
        
        tickets2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Tickets 2 Button has been clicked!"); } });                       

    // ************************************************************************** MAIN MENUBAR VBOX
        
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

    // ************************************************************** GAME MENU
        Menu menuGame = new Menu("Game");
        
    // ************************************************************ SET PLAYERS       
        Menu menuSetPlayer = new Menu("Set Player Names");
        
    // ******************************************************* SET PLAYER1 NAME    
    
        MenuItem setNamePlayer1 = new MenuItem("Player 1 Name");
        setNamePlayer1.setOnAction((ActionEvent t) -> {
            //guide.setText("Enter name for Player 1: ");
            
            System.out.println("Enter name for Player 1: ");
            Scanner scan = new Scanner(System.in);
            String player1Name = scan.next();
            Ctrl.setPlayerName(1, player1Name);                                      // ******* GUI IS SENDING PLAYER 1'S NAME TO CONTROLLER/MODEL ******* Control Done !!!
            player1.setText(player1Name);
            Player1 = player1Name;   // for my local Player1 String
            guide.setText("Hello " + player1Name + "!");
            vbox.setVisible(true);
        });
        
    // ******************************************************* SET PLAYER2 NAME
    
        MenuItem setNamePlayer2 = new MenuItem("Player 2 Name");
        setNamePlayer2.setOnAction((ActionEvent t) -> {  
            System.out.println("Enter name for Player 2: ");
            Scanner scan = new Scanner(System.in);
            String player2Name = scan.next();
            Ctrl.setPlayerName(2, player2Name);                                      // ******* GUI IS SENDING PLAYER 2'S NAME TO CONTROLLER/MODEL ******* Control Done!!!
            player2.setText(player2Name);
            Player2 = player2Name;   // for my local Player2 String
            guide.setText("Hello " + player2Name + "!");            
            vbox.setVisible(true);
        });

        menuSetPlayer.getItems().add(setNamePlayer1);
        menuSetPlayer.getItems().add(setNamePlayer2);            
        menuGame.getItems().addAll(menuSetPlayer);             
        
    // ****************************************************** CHOOSE GAME BOARD              
        Menu menuSetGameBoard = new Menu("Select Game Board");
       
    // **************************************************** CHOOSE GAME BOARD 1            
   
        MenuItem setGameBoard1_US_Canada = new MenuItem("US/Canada Game Board");
        setGameBoard1_US_Canada.setOnAction((ActionEvent t) -> {
            guide.setText("You chose US/Canada ");
            Image imageDecline99 = new Image(getClass().getResourceAsStream("graphics/pic38674.jpg"));
            centerBoardImage.setGraphic(new ImageView(imageDecline99));
            //boardPic = "graphics/pic38674.jpg";           
            vbox.setVisible(true);
        });
        
    // **************************************************** CHOOSE GAME BOARD 2            
        
        MenuItem setGameBoard2_Swiss = new MenuItem("Swiss Game Board");
        setGameBoard2_Swiss.setOnAction((ActionEvent t) -> {
            guide.setText("You chose Swiss ");
            Image imageDecline101 = new Image(getClass().getResourceAsStream("graphics/T2R_Swiss.jpg"));
            centerBoardImage.setGraphic(new ImageView(imageDecline101));
            //boardPic = "graphics/T2R_Swiss.jpg";
            vbox.setVisible(true);
        });        
        
        menuSetGameBoard.getItems().add(setGameBoard1_US_Canada);
        menuSetGameBoard.getItems().add(setGameBoard2_Swiss);
        
    // ************************************************************* START GAME
   
        MenuItem startGame = new MenuItem("Start Game");
        startGame.setOnAction((ActionEvent t) -> {  
            System.out.println("THE GAME PLAY BEGINS ");
        
        Ctrl.Start();
        //Ctrl.seeHand(1);                                                          ******Testing purpose
        
       
        TrainCard tempTrainCard = Ctrl.getPlayerCHand(1,0);                        // ******************************************** Control Done
        Image imageDecline_a = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        left_TC_1.setGraphic(new ImageView(imageDecline_a));           
        
        tempTrainCard = Ctrl.getPlayerCHand(1,1);                                  // ******************************************** Control Done
        Image imageDecline_b = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        left_TC_2.setGraphic(new ImageView(imageDecline_b));            
            
        tempTrainCard = Ctrl.getPlayerCHand(1,2);                                  // ******************************************** Control Done
        Image imageDecline_c = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        left_TC_3.setGraphic(new ImageView(imageDecline_c));           
        
        tempTrainCard = Ctrl.getPlayerCHand(1,3);                                  // ******************************************** Control Done
        Image imageDecline_d = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        left_TC_4.setGraphic(new ImageView(imageDecline_d));            
        
        // *******
        
        tempTrainCard = Ctrl.getPlayerCHand(2,0);                                   // ******************************************** Control Done
        Image imageDecline_e = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        right_TC_1.setGraphic(new ImageView(imageDecline_e));           
        
        tempTrainCard = Ctrl.getPlayerCHand(2,1);                                   // ******************************************** Control Done
        Image imageDecline_f = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        right_TC_2.setGraphic(new ImageView(imageDecline_f));            
            
        tempTrainCard = Ctrl.getPlayerCHand(2,2);                                  // ******************************************** Control Done
        Image imageDecline_g = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        right_TC_3.setGraphic(new ImageView(imageDecline_g));           
        
        tempTrainCard = Ctrl.getPlayerCHand(2,3);                                  // ******************************************** Control Done
        Image imageDecline_h = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        right_TC_4.setGraphic(new ImageView(imageDecline_h));               

        // *******
        
        tempTrainCard = Ctrl.D.faceUp5.get(0);                                  // ******************************************** Control Done
        Image imageDecline_i = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        bottom_TC_1.setGraphic(new ImageView(imageDecline_i));           
        
        tempTrainCard = Ctrl.D.faceUp5.get(1);                                  // ******************************************** Control Done
        Image imageDecline_j = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        bottom_TC_2.setGraphic(new ImageView(imageDecline_j));            
            
        tempTrainCard = Ctrl.D.faceUp5.get(2);                                   // ******************************************** Control Done
        Image imageDecline_k = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        bottom_TC_3.setGraphic(new ImageView(imageDecline_k));           
        
        tempTrainCard = Ctrl.D.faceUp5.get(3);                                   // ******************************************** Control Done
        Image imageDecline_l = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        bottom_TC_4.setGraphic(new ImageView(imageDecline_l));       
        
        tempTrainCard = Ctrl.D.faceUp5.get(4);                                   // ******************************************** Control Done
        Image imageDecline_m = new Image(getClass().getResourceAsStream(tempTrainCard.getJPGImage()));           
        bottom_TC_5.setGraphic(new ImageView(imageDecline_l));     

        guide.setText("It is "+ Player1 +"'s turn.");
        
            vbox.setVisible(true);
        });
        
        
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

    // ******************************************************************* QUIT
        MenuItem exit = new MenuItem("Quit");
        exit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });

        menuGame.getItems().addAll(menuSetGameBoard, menuSetPlayer, startGame, showGameRules, clear,
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
            
            // guide.setText("Which card?");
            
            System.out.println("TC1: Take Face-up card\n");
            System.out.println("Which card do you want?\n");
            System.out.println("Choose 1-5");

            Scanner scan = new Scanner(System.in);
            int tcNo = scan.nextInt();
            
            TrainCard faceUp5TrainCardChoice = new TrainCard();
            faceUp5TrainCardChoice = Ctrl.D.drawFaceUp5(tcNo);
            Ctrl.getPlayer(currentPlayer).addToCHand(faceUp5TrainCardChoice);
            
            
            
            if(currentPlayer == 1)  {
                
                Image imageDecline_A = new Image(getClass().getResourceAsStream(faceUp5TrainCardChoice.getJPGImage()));           
                left_TC_1.setGraphic(new ImageView(imageDecline_A));    }
            
            else if(currentPlayer == 2) {
                Image imageDecline_B = new Image(getClass().getResourceAsStream(faceUp5TrainCardChoice.getJPGImage()));           
                right_TC_1.setGraphic(new ImageView(imageDecline_B));    }               

            TrainCard faceUp5TrainCardReplacement = new TrainCard();
            faceUp5TrainCardReplacement = Ctrl.D.draw(); // ******************************** METHOD FOR CONTROLLER !!!           

            
            Image imageDecline_C = new Image(getClass().getResourceAsStream(faceUp5TrainCardReplacement.getJPGImage()));
            
            if(tcNo == 1)
                bottom_TC_1.setGraphic(new ImageView(imageDecline_C)); 
            if(tcNo == 2)
                bottom_TC_2.setGraphic(new ImageView(imageDecline_C));           
            if(tcNo == 3)
                bottom_TC_3.setGraphic(new ImageView(imageDecline_C));            
            if(tcNo == 4)
                bottom_TC_4.setGraphic(new ImageView(imageDecline_C));            
            if(tcNo == 5)
                bottom_TC_5.setGraphic(new ImageView(imageDecline_C));            

            vbox.setVisible(true);
        });

        // PLAYER CHOOSES TO DRAW A TRAIN CARD FROM THE DECK
        MenuItem TC1_Choice2_FromDeck = new MenuItem("Draw from the deck");
        TC1_Choice2_FromDeck.setOnAction((ActionEvent t) -> {
            System.out.println("TC1: Draw from the deck\n");

            
        TrainCard newTrainCard1 = Ctrl.D.draw();                                // ******************************************** METHOD FOR CONTROLLER !!!
        Ctrl.getPlayer(currentPlayer).addToCHand(newTrainCard1);
        
            if(currentPlayer == 1)  {
                Image imageDecline_D = new Image(getClass().getResourceAsStream(newTrainCard1.getJPGImage()));           
                left_TC_1.setGraphic(new ImageView(imageDecline_D));    }
            
            else if(currentPlayer == 2) {
                Image imageDecline_E = new Image(getClass().getResourceAsStream(newTrainCard1.getJPGImage()));           
                right_TC_1.setGraphic(new ImageView(imageDecline_E));    }             

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
            
            TrainCard faceUp5TrainCardChoice = new TrainCard();
            faceUp5TrainCardChoice = Ctrl.D.drawFaceUp5(tcNo);
            Ctrl.getPlayer(currentPlayer).addToCHand(faceUp5TrainCardChoice);
            
            
            if(currentPlayer == 1)  {
                Image imageDecline_F = new Image(getClass().getResourceAsStream(faceUp5TrainCardChoice.getJPGImage()));           
                left_TC_2.setGraphic(new ImageView(imageDecline_F));    }
            
            else if(currentPlayer == 2) {
                Image imageDecline_G = new Image(getClass().getResourceAsStream(faceUp5TrainCardChoice.getJPGImage()));           
                right_TC_2.setGraphic(new ImageView(imageDecline_G));    }               

            if(currentPlayer == 1){
                currentPlayer = 2;
                guide.setText("It is "+ Player2 +"'s turn.");
            }
            else{
                currentPlayer = 1;
                guide.setText("It is "+ Player1 +"'s turn.");
            }
            TrainCard faceUp5TrainCardReplacement = new TrainCard();
            faceUp5TrainCardReplacement = Ctrl.D.draw();                        // ******************************** METHOD FOR CONTROLLER !!!           

            Image imageDecline_H = new Image(getClass().getResourceAsStream(faceUp5TrainCardReplacement.getJPGImage()));
            
            if(tcNo == 1)
                bottom_TC_1.setGraphic(new ImageView(imageDecline_H)); 
            if(tcNo == 2)
                bottom_TC_2.setGraphic(new ImageView(imageDecline_H));           
            if(tcNo == 3)
                bottom_TC_3.setGraphic(new ImageView(imageDecline_H));            
            if(tcNo == 4)
                bottom_TC_4.setGraphic(new ImageView(imageDecline_H));            
            if(tcNo == 5)
                bottom_TC_5.setGraphic(new ImageView(imageDecline_H));            

            vbox.setVisible(true);
        });

        // PLAYER CHOOSES TO DRAW A TRAIN CARD FROM THE DECK
        MenuItem TC2_Choice2_FromDeck = new MenuItem("Draw from the deck");
        TC2_Choice2_FromDeck.setOnAction((ActionEvent t) -> {
            System.out.println("TC2: Draw from the deck\n");

        TrainCard newTrainCard1 = Ctrl.D.draw();                                // ******************************************** METHOD FOR CONTROLLER !!!
        Ctrl.getPlayer(currentPlayer).addToCHand(newTrainCard1);
        
        
            if(currentPlayer == 1)  {
                Image imageDecline_I = new Image(getClass().getResourceAsStream(newTrainCard1.getJPGImage()));           
                left_TC_2.setGraphic(new ImageView(imageDecline_I));    }
            
            else if(currentPlayer == 2) {
                Image imageDecline_J = new Image(getClass().getResourceAsStream(newTrainCard1.getJPGImage()));           
                right_TC_2.setGraphic(new ImageView(imageDecline_J));    } 
            
            if(currentPlayer == 1){
                currentPlayer = 2;
                guide.setText("It is "+ Player2 +"'s turn.");
            }
            else{
                currentPlayer = 1;
                guide.setText("It is "+ Player1 +"'s turn.");
            }
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
            
            if(currentPlayer == 1)
            {   stringScore = increaseScore(1, 5);
                score1.setText(stringScore); }
            
            else if(currentPlayer == 2)
            {   stringScore = increaseScore(2, 5);
                score2.setText(stringScore); }
            
            vbox.setVisible(true);
        });
       
        MenuItem ticket2 = new MenuItem("San Francisco - Salt Lake City");
        ticket2.setOnAction((ActionEvent t) -> {
            System.out.println("You chose San Francisco - Salt Lake City");
           
            if(currentPlayer == 1)
            {   stringScore = increaseScore(1, 10);
                score1.setText(stringScore); }
            
            else if(currentPlayer == 2)
            {   stringScore = increaseScore(2, 10);
                score2.setText(stringScore); }

            vbox.setVisible(true);
        });
        
        MenuItem ticket3 = new MenuItem("San Francisco - Portland");
        ticket3.setOnAction((ActionEvent t) -> {
            System.out.println("You chose San Francisco - Portland");
            
            if(currentPlayer == 1)
            {   stringScore = increaseScore(1, 25);
                score1.setText(stringScore); }
            
            else if(currentPlayer == 2)
            {   stringScore = increaseScore(2, 25);
                score2.setText(stringScore); }            

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
        
        hbox.getChildren().addAll(player1, score1, trainCards1, tickets1, guide, menuBar, player2, score2, trainCards2, tickets2);       
        return hbox;
    } 

    // ************************************************************************** BEGIN LEFT BORDERPANE (FLOWPANE)
    
    // Creates Vertical Display of Train & Destination Cards
    private FlowPane addFlowPaneLeft()  // for left side (Player1er 1)
    {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(7, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(85);
        flow.setStyle("-fx-background-color: DAE6F3;");
        
        // *************************************************** left_TC_1 BUTTON      

        Image imageDecline1 = new Image(getClass().getResourceAsStream(player1TrainCard1.getJPGImage()));
        left_TC_1.setGraphic(new ImageView(imageDecline1));
        
        DropShadow shadow = new DropShadow();
        left_TC_1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    left_TC_1.setEffect(shadow); } });
        
        left_TC_1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player1TrainCard1 Button has been clicked!"); } }); 

        flow.getChildren().add(left_TC_1);
        
        // *************************************************** left_TC_2 BUTTON      

        Image imageDecline2 = new Image(getClass().getResourceAsStream(player1TrainCard2.getJPGImage()));
        left_TC_2.setGraphic(new ImageView(imageDecline2));
        
        left_TC_2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    left_TC_2.setEffect(shadow); } });
        
        left_TC_2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player1TrainCard2 Button has been clicked!"); } }); 

        flow.getChildren().add(left_TC_2);
        
        // *************************************************** left_TC_3 BUTTON      

        Image imageDecline3 = new Image(getClass().getResourceAsStream(player1TrainCard3.getJPGImage()));
        left_TC_3.setGraphic(new ImageView(imageDecline3));

        left_TC_3.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    left_TC_3.setEffect(shadow); } });
        
        left_TC_3.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player1TrainCard3 Button has been clicked!"); } }); 

        flow.getChildren().add(left_TC_3);
        
        // *************************************************** left_TC_4 BUTTON      

        Image imageDecline4 = new Image(getClass().getResourceAsStream(player1TrainCard4.getJPGImage()));
        left_TC_4.setGraphic(new ImageView(imageDecline4));

        left_TC_4.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    left_TC_4.setEffect(shadow); } });
        
        left_TC_4.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player1TrainCard4 Button has been clicked!"); } }); 

        flow.getChildren().add(left_TC_4);

        // *************************************************** left_DT_1 BUTTON      

        Image imageDecline5 = new Image(getClass().getResourceAsStream("graphics/Ticket1_scale70.jpg"));
        left_DT_1.setGraphic(new ImageView(imageDecline5));

        left_DT_1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    left_DT_1.setEffect(shadow); } });
        
        left_DT_1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Destination Ticket 1 Button has been clicked!"); } }); 

        flow.getChildren().add(left_DT_1);
        
        // *************************************************** left_DT_2 BUTTON      

        Image imageDecline6 = new Image(getClass().getResourceAsStream("graphics/Ticket2_scale58.jpg"));
        left_DT_2.setGraphic(new ImageView(imageDecline6));
        
        left_DT_2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    left_DT_2.setEffect(shadow); } });
        
        left_DT_2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Destination Ticket 2 Button has been clicked!"); } }); 

        flow.getChildren().add(left_DT_2);       
        
        // *************************************************** left_DT_3 BUTTON      

        Image imageDecline7 = new Image(getClass().getResourceAsStream("graphics/Ticket3_scale58.jpg"));
        left_DT_3.setGraphic(new ImageView(imageDecline7));

        left_DT_3.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    left_DT_3.setEffect(shadow); } });
        
        left_DT_3.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Destination Ticket 3 Button has been clicked!"); } }); 

        flow.getChildren().add(left_DT_3);       

        return flow;
    }
    
    // ************************************************************************** BEGIN CENTER BORDERPANE
    // ********************************************************** ADD STACKPANE
    
    // StackPane has 2 Children: Child 1 (Board Image), Child 2 (GridPane)
    private StackPane addStackPaneCenter()
    {
        StackPane stack = new StackPane();
        
        //ImageView boardImage = new ImageView(
        
        //new Image(Ticket2RideView.class.getResourceAsStream(boardPic)));
        //new Image(Ticket2RideView.class.getResourceAsStream("graphics/pic38674.jpg")));
        //new Image(Ticket2RideView.class.getResourceAsStream("graphics/T2R_Swiss.jpg")));  

   
        // *******
        // *************************************************** centerBoardImage BUTTON      

        
        
        
        Image imageDecline69 = new Image(getClass().getResourceAsStream(boardPic));       
        //Image imageDecline69 = new Image(getClass().getResourceAsStream(boardPic));
        centerBoardImage.setGraphic(new ImageView(imageDecline69));
        
        DropShadow shadow = new DropShadow();
        centerBoardImage.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    centerBoardImage.setEffect(shadow); } });
        
        centerBoardImage.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player1TrainCard1 Button has been clicked!"); } }); 
      

        // *******
        

        // ***
        GridPane grid = new GridPane();
        grid = addGridPaneCenter(stack);

        stack.getChildren().add(centerBoardImage); 
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
    private FlowPane addFlowPaneRight()  // for right side (Player 2)
    {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(7, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(85);
        flow.setStyle("-fx-background-color: DAE6F3;");
        
        // ************************************************** right_TC_1 BUTTON      

        Image imageDecline8 = new Image(getClass().getResourceAsStream(player2TrainCard1.getJPGImage()));
        right_TC_1.setGraphic(new ImageView(imageDecline8));
        // leftTrainCard_1.setPrefSize(100, 20);
        
        DropShadow shadow = new DropShadow();
        right_TC_1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    right_TC_1.setEffect(shadow); } });
        
        right_TC_1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player2TrainCard1 Button has been clicked!"); } }); 

        flow.getChildren().add(right_TC_1);
        
        // ************************************************** right_TC_2 BUTTON      

        Image imageDecline9 = new Image(getClass().getResourceAsStream(player2TrainCard2.getJPGImage()));
        right_TC_2.setGraphic(new ImageView(imageDecline9));
        // leftTrainCard_2.setPrefSize(100, 20);
        
        //DropShadow shadow = new DropShadow();
        right_TC_2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    right_TC_2.setEffect(shadow); } });
        
        right_TC_2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player2TrainCard2 Button has been clicked!"); } }); 

        flow.getChildren().add(right_TC_2);
        
        // ************************************************** right_TC_3 BUTTON      

        Image imageDecline10 = new Image(getClass().getResourceAsStream(player2TrainCard3.getJPGImage()));
        right_TC_3.setGraphic(new ImageView(imageDecline10));

        right_TC_3.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    right_TC_3.setEffect(shadow); } });
        
        right_TC_3.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player2TrainCard3 Button has been clicked!"); } }); 

        flow.getChildren().add(right_TC_3);
        
        // ************************************************** right_TC_4 BUTTON      

        Image imageDecline11 = new Image(getClass().getResourceAsStream(player2TrainCard4.getJPGImage()));
        right_TC_4.setGraphic(new ImageView(imageDecline11));

        right_TC_4.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    right_TC_4.setEffect(shadow); } });
        
        right_TC_4.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("player2TrainCard4 Button has been clicked!"); } }); 

        flow.getChildren().add(right_TC_4);

        // ************************************************** right_DT_1 BUTTON      

        Image imageDecline12 = new Image(getClass().getResourceAsStream("graphics/Ticket1_scale70.jpg"));
        right_DT_1.setGraphic(new ImageView(imageDecline12));

        right_DT_1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    right_DT_1.setEffect(shadow); } });
        
        right_DT_1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Destination Ticket 1 Button has been clicked!"); } }); 

        flow.getChildren().add(right_DT_1);
        
        // ************************************************** right_DT_2 BUTTON      

        Image imageDecline13 = new Image(getClass().getResourceAsStream("graphics/Ticket2_scale58.jpg"));
        right_DT_2.setGraphic(new ImageView(imageDecline13));

        right_DT_2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    right_DT_2.setEffect(shadow); } });
        
        right_DT_2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Destination Ticket 2 Button has been clicked!"); } }); 

        flow.getChildren().add(right_DT_2);       
        
        // ************************************************** right_DT_3 BUTTON      

        Image imageDecline14 = new Image(getClass().getResourceAsStream("graphics/Ticket3_scale58.jpg"));
        right_DT_3.setGraphic(new ImageView(imageDecline14));

        right_DT_3.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    right_DT_3.setEffect(shadow); } });
        
        right_DT_3.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Destination Ticket 3 Button has been clicked!"); } }); 

        flow.getChildren().add(right_DT_3);       

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
        flow.setPadding(new Insets(5, 0, 5, 155));
        flow.setVgap(4);
        flow.setHgap(0);
        flow.setPrefWrapLength(170);
        flow.setStyle("-fx-background-color: DAE6F3;");

        // ************************************************* bottom_TC_1 BUTTON      

        Image imageDecline15 = new Image(getClass().getResourceAsStream("graphics/Box_scale79.jpg"));
        bottom_TC_1.setGraphic(new ImageView(imageDecline15));
        
        DropShadow shadow = new DropShadow();
        bottom_TC_1.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    bottom_TC_1.setEffect(shadow); } });
        
        bottom_TC_1.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Deck5TrainCard1 Button has been clicked!"); } }); 

        flow.getChildren().add(bottom_TC_1);        

        // ************************************************* bottom_TC_2 BUTTON      

        Image imageDecline16 = new Image(getClass().getResourceAsStream("graphics/Passenger_scale79.jpg"));
        bottom_TC_2.setGraphic(new ImageView(imageDecline16));

        bottom_TC_2.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    bottom_TC_2.setEffect(shadow); } });
        
        bottom_TC_2.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Deck5TrainCard2 Button has been clicked!"); } }); 

        flow.getChildren().add(bottom_TC_2); 
        
        // ************************************************* bottom_TC_3 BUTTON      

        Image imageDecline17 = new Image(getClass().getResourceAsStream("graphics/Reefer_scale79.jpg"));
        bottom_TC_3.setGraphic(new ImageView(imageDecline17));

        bottom_TC_3.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    bottom_TC_3.setEffect(shadow); } });
        
        bottom_TC_3.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Deck5TrainCard3 Button has been clicked!"); } }); 

        flow.getChildren().add(bottom_TC_3); 
        
        // ************************************************* bottom_TC_4 BUTTON      

        Image imageDecline18 = new Image(getClass().getResourceAsStream("graphics/Hopper_scale79.jpg"));
        bottom_TC_4.setGraphic(new ImageView(imageDecline18));

        bottom_TC_4.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    bottom_TC_4.setEffect(shadow); } });
        
        bottom_TC_4.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Deck5TrainCard4 Button has been clicked!"); } }); 

        flow.getChildren().add(bottom_TC_4);         
        
        // ************************************************* bottom_TC_5 BUTTON      

        Image imageDecline19 = new Image(getClass().getResourceAsStream("graphics/Caboose_scale79.jpg"));
        bottom_TC_5.setGraphic(new ImageView(imageDecline19));

        bottom_TC_5.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    bottom_TC_5.setEffect(shadow); } });
        
        bottom_TC_5.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("Deck5TrainCard5 Button has been clicked!"); } }); 

        flow.getChildren().add(bottom_TC_5);         

        // ********************************************* bottom_LP_Bonus BUTTON      

        Image imageDecline20 = new Image(getClass().getResourceAsStream("graphics/LPBonusCard_scale47.jpg"));
        bottom_LP_Bonus.setGraphic(new ImageView(imageDecline20));

        bottom_LP_Bonus.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    bottom_LP_Bonus.setEffect(shadow); } });
        
        bottom_LP_Bonus.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    System.out.println("LP Bonus Button has been clicked!"); } }); 

        flow.getChildren().add(bottom_LP_Bonus);          

        //"graphics/LPBonusCard_scale47.jpg")));        

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
 
    // ************************************************************************** FUNCTION: increaseScore()
        
        public String increaseScore(int playerNo, int claimValue)                                 // DON'T FORGET TO FIX THIS...................................
        {
            if(playerNo == 1)
            { integerScore1 += claimValue;
                stringScore = integerScore1.toString(); }  

            else if(playerNo == 2)
            { integerScore2 += claimValue;
                stringScore = integerScore2.toString(); }
 
            return stringScore;
        }

    // ************************************************************************** INTEGRATION TEST DRIVERS
        // DRIVERS TO TEST INTERFACE BETWEEN VIEW (GUI) AND CONTROLLER
    /*    
     public void setPlayerName(int playerNo, String playerName)
     {
         if(playerNo == 1)
             Player1 = playerName;  // This is "The Controller/Model's Player1
         if(playerNo == 2)
             Player2 = playerName;  // This is "The Controller/Model's Player2
     }    

    public TrainCard dispenseFaceUp5TrainCard(TrainCard faceUp5PlayersPick)
    {   /*  THIS IS A TEMPORARY TEST DRIVER SUBSTITUTE FOR CONTROLLER FUNCTION
    
        Input: "faceUp5PlayersPick":traincard player wants to remove from board
        Controller should add this card to the Player's hand.
    
        Output: The Controller should return a new TrainCard from the Deck
        (So that the GUI can replace the card that was removed from Board)
        */
        
    // Driver Program: Simulates Controller dealing out "random cards"
        /*
        Random rand = new Random();
        int n = rand.nextInt(9) + 1;
        
        TrainCard tcTemp = new TrainCard();
        
        if(n == 1)
            tcTemp.setTrainType("FREIGHT");
        if(n == 2)
            tcTemp.setTrainType("FREIGHT");        
        if(n == 3)
            tcTemp.setTrainType("HOPPER");       
        if(n == 4)
            tcTemp.setTrainType("COAL");        
        if(n == 5)
            tcTemp.setTrainType("CABOOSE");        
        if(n == 6)
            tcTemp.setTrainType("BOX");        
        if(n == 7)
            tcTemp.setTrainType("PASSENGER");        
        if(n == 8)
            tcTemp.setTrainType("TANKER");        
        if(n == 9)
            tcTemp.setTrainType("REEFER");

        return tcTemp;
    }

    // Driver Program: Simulates Controller dealing out "random cards"
    public TrainCard deal_1_CardFromDeck(int owner)
    { 
        Random rand = new Random();
        int n = rand.nextInt(9) + 1;
        
        TrainCard tcTemp = new TrainCard();
        
        if(n == 1)
            tcTemp.setTrainType("LOCOMOTIVE");
        if(n == 2)
            tcTemp.setTrainType("FREIGHT");        
        if(n == 3)
            tcTemp.setTrainType("HOPPER");       
        if(n == 4)
            tcTemp.setTrainType("COAL");        
        if(n == 5)
            tcTemp.setTrainType("CABOOSE");        
        if(n == 6)
            tcTemp.setTrainType("BOX");        
        if(n == 7)
            tcTemp.setTrainType("PASSENGER");        
        if(n == 8)
            tcTemp.setTrainType("TANKER");        
        if(n == 9)
            tcTemp.setTrainType("REEFER");

        return tcTemp;
    }   */
}
    // THE END ******************************************************************