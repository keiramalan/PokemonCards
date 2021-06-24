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
    
    // fields
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
        

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Add Card", this::addCard);
        UI.addButton("Find Card", this::findCard);
        UI.setMouseListener(this::mouseListener);
        UI.addButton("Clear", UI::clearGraphics);
    }

    public void addCard() {
        // number to increment the current card ID for hashmap placement
        final int INCREMENT = 1;
        
        // Get card's name and number from user
        String name;
        int cardPrice;
        
        // Name must be larger than 0 characters but smaller than 20
        do {
            name = UI.askString("Name: ");
        } while (name.length() < MINNAME || name.length() > MAXNAME);
        
        // price cannot be higher than $300,000 or lower than 1
        do {
            cardPrice = UI.askInt("Card price: ");
        } while (cardPrice < MINPRICE || cardPrice > MAXPRICE);
        
        // add an image of the card
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // increment
        crds.setCardId(INCREMENT);
        crds.addCard(name, cardPrice, imgFileName);
    }
    
    /**
     * Display pokemon card
     * @param Card selected card to display
     */
    public void displayCard(Card selectedCard) {
        // co-ordinates of text
        final int XPOS = 100;
        int yPos = 400;
        int ySpacer = 30;
        
        UI.setColor(Color.black);
        
        // Print name of card underneath image
        UI.drawString(selectedCard.getName(), XPOS, yPos); 
        
        // convert price from int to string for printing purposes
        // CODE SOURCED FROM 
        // https://www.javatpoint.com/java-double-to-string
        String cardPrice = String.valueOf(selectedCard.getValue());
        
        // Print price of card
        UI.drawString("Price: $" + cardPrice, XPOS, yPos+ySpacer);
        
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
        String cardName = UI.askString("Name of card: ");
        
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
    
    // Display All
    // Wipe graphics pane
    // Parameter of hashmap
    // Loop through hashmap and print
    
}
