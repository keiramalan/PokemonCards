import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/**
 * GUI class runs the graphical user interface output.
 *
 * @author Keira Malan
 * @version 22/6/21
 */
public class GUI
{
    // declare Cards instance
    Cards crds = new Cards();
    
    /* fields */
    
    // image dimensions
    int locX = 100;
    int locY = 100;
    final double WIDTH = 200;
    final double HEIGHT = 200;
    
    // max and min prices of cards
    final int MINPRICE = 1;
    final int MAXPRICE = 300000;

    // name length limits
    final int MAXNAME = 20;
    final int MINNAME = 1;
    
    // checker for validity of user's inputted card price
    boolean priceValid;
    
    // stores current card to display
    Card currCard;
    
    // Positions of text when displaying a card
    final int XPOS = 100;
    int yPos;
    // allows text blocks to not stack on top of each other
    final int YSPACER = 30;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        UI.initialise();
        
        // buttons
        UI.addButton("Add Card", this::addCard);
        UI.addButton("Find Card", this::findCard);
        UI.addButton("Hide", UI::clearGraphics);
        UI.addButton("Display All", this::displayAll);
        UI.addButton("Quit", UI::quit);
        
        // mouse listener checks if user has clicked on image
        UI.setMouseListener(this::mouseListener);
    }
    
    public void addCard() {
        // amount to increment card ID for hashmap placement
        final int INCREMENT = 1;
        priceValid = false;
        
        // Get card's name and number from user
        String name;
        int cardPrice = -1;
        
        // Name must be larger than 0 characters but smaller than 20
        do {
            name = UI.askString("Card Name (1-20 chars): ");
            // Remove any uneccessary whitespace
            name = name.strip();
        } while (name.length() < MINNAME || name.length() > MAXNAME);
        
        // Loop for valid card price
        while (priceValid == false) {
            // ask for price as string to check for null values
            String priceString = UI.askString("Card Price: ");
            // Strip any whitespace
            priceString = priceString.strip();
            
            // check user has entered a value
            if (priceString != null) {

                // STRING TO INT CODE SOURCED FROM
                //https://stackoverflow.com/questions/5585779/
                //how-do-i-convert-a-string-to-an-int-in-java
                
                try {
                    cardPrice = Integer.parseInt(priceString);
                    // Check card price is a reasonable number
                    if (cardPrice >= MINPRICE || cardPrice <= MAXPRICE) {
                        // End loop
                        priceValid = true;
                    }
                    else {
                        UI.println("Please enter a number between 1 and 3000000!");
                    }
                }
                catch (NumberFormatException e) {
                    // Error message if user doesn't enter an integer
                    UI.println("Please enter an integer!");
                }
            }
            
        }

        // add an image of the card
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // increment card ID
        crds.setCardId(INCREMENT);
        
        // place new contact in hashmap
        crds.addCard(name, cardPrice, imgFileName);
    }
    
    /**
     * Display a pokemon card
     * @param Card selected card to display
     */
    public void displayCard(Card selectedCard) {
        // clear graphics pane
        UI.clearGraphics();
        
        // co-ordinates of text
        yPos = 400;
        
        UI.setColor(Color.black);
        
        // Print name of card underneath image
        UI.drawString(selectedCard.getName(), XPOS, yPos); 
        
        // convert price from int to string to print
        /* CODE SOURCED FROM */
        // https://www.javatpoint.com/java-double-to-string
        String cardPrice = String.valueOf(selectedCard.getValue());
        
        // Print price of card
        UI.drawString("Price: $" + cardPrice, XPOS, yPos+YSPACER);
        
        // Print card image on canvas
        displayImage(selectedCard.getImage());

    }
    
    /**
     * Display card image
     * @param String image to display
     */
    public void displayImage(String image) {
        UI.drawImage(image, locX, locY, WIDTH, HEIGHT);
    }
    
    /**
     * Finds a card based on its name
     * Displays card if found
     */
    public void findCard() {
        String cardName;
        // Get user's inputted card
        do {
            cardName = UI.askString
            ("Name of card: (1-20 characters) ");
            // Remove any whitespace
            cardName = cardName.strip();
        } while (cardName.length() < MINNAME || // Check input meets name length requirements
        cardName.length() > MAXNAME); 
        
        // Search for card in hashmap
        if (crds.findCard(cardName)) {
            UI.println("Found this card!");
            // retrieve card from hashmap to print
            Card card = crds.getCard();
            // display selected card
            displayCard(card);
        }
        
        else {
            UI.println("Card not found");
        }
    }
    
    /**
     * Wipe image and details if user clicks on image
     */
    public void mouseListener(String action, double x, double y) {  
        // Check if image is currently being displayed
        if (action.equals("clicked")) {
            // Check if user has clicked on the image
            if ((x >= locX) && 
                (x <= locX + WIDTH) &&
                (y >= locY) && (y <= locY + HEIGHT)) {
                // Hide Image and Details
                UI.clearGraphics();
            }
        }
    }
    
    /**
     * Display all cards using a for loop
     */
    public void displayAll() {
        // find how many cards are in hashmap
        int mapLength = crds.returnMapLen();
        
        // Loop through hashmap to display each card's details
        for (int cardId = 1; cardId <= mapLength; cardId++) {
            // retrive card to display
            currCard = crds.getCard(cardId);
            // Print name
            UI.println("Name of card: " + currCard.getName());
            // Print value
            UI.println("Value of card: $" + currCard.getValue());
            
        }
    }

    
}
