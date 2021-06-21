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
    
    
    
    // mouse listener
    // return true if user has clicked
    // allow GUI to wipe image
}
