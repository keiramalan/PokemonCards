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
     * @param name Card's name
     * @param cardValue Card's monetary value 
     * @param imgFileName Location of card image
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
     * Return card with given key
     * Used to display cards in GUI class
     * @param cardId the ID of the card object to be returned
     * @return Card the selected card
     */
    public Card getCard(int cardId) {
        return cardsMap.get(cardId);
    }
    
    /**
     * Finds a card based on name
     * sets the current card instance if found and returns true
     * @return boolean false if not found
     * @param name Name being searched for
     */
    public boolean findCard(String name) {
        // Search hashmap by name for user's input
       
        for (int cardId : cardsMap.keySet()) {
            if (cardsMap.get(cardId).getName().equalsIgnoreCase(name)) {
                currCard = cardsMap.get(cardId);
                return true;
            }
        }
        
        // returns false if no matching results found
        return false;
    }
    
    /**
     * Getter method for the current card
     * @return Card current card
     */
    public Card getCard() {
        return currCard;
    }
    
    /**
     * Returns the length of cardsMap
     * @return int the length of cardsMap hashmap
     */
    public int returnMapLen() {
        int mapLength = cardsMap.size();
        return mapLength;
    }
}
