import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/**
 * Collection of Pokemon cards
 * Allows user to view, retrieve, add cards
 *
 * @author Keira Malan
 * @version 22/6/21
 */
public class Cards
{
    // instance variables
    
    // initalise hashmap which will store Card objects
    private HashMap<Integer, Card> cardsMap;
    
    // card ID used to place new contacts into the correct part
    // of the hashmap
    private int currCardId;
    // y position of text
    private int yPos;
    // current card
    private Card currCard;

    /**
     * Constructor for objects of class Cards
     */
    public Cards()
    {
        // initialise hashmap and pokemon ID
        cardsMap = new HashMap<Integer, Card>();
        
        // Initialise current card ID
        currCardId = 0;
    }
    
    /**
     * Add a card to hashmap with its name, image, and value
     */
    public void addCard(String name, double cardValue, String imgFileName) {
        // add new card to hashmap
        cardsMap.put(currCardId, new Card(name, cardValue, imgFileName));
    }
    
    /**
     * Set Card Id
     * @param incrementor Amount to increase card ID by
     */
    public void setCardId(int incrementor) {
        currCardId = currCardId + incrementor;
    }
    
    /**
     * Finds a card based on name
     * sets the current card instance if found and returns true
     * @return boolean false if not found
     */
    public boolean findCard(String name) {
       // Search hashmap for card
       
       for (int cardId : cardsMap.keySet()) {
           if (cardsMap.get(cardId).getName().equalsIgnoreCase(name)) {
               currCard = cardsMap.get(cardId);
               return true;
           }
        }
        return false;
    }
    
    /**
     * Getter method for the current card
     * @return Card current card
     */
    public Card getCard(){
        return currCard;
    }
    
    // Display All
    // Return hashmap
    // https://stackoverflow.com/questions/37971533/
    //is-it-possible-to-return-a-hashmap-object-in-java/37971561
    public Map<Integer, Card> returnMap() {
        
        return cardsMap;
    }
    // How tf?
}
