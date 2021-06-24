
/**
 * Code for creating a new pokemon card
 * with name, monetary value, and image
 *
 * @author Keira Malan
 * @version 22/6/21
 */
public class Card
{
    // instance variables
    private String name;
    private double cardValue;
    private String image;
    
    // backup image
    static final String DEFAULT_IMAGE = "DefaultImage.png";
    
    // co-ordinates to draw pokemon image
    private final double locX = 100;
    private final double locY = 100;
    private final double height = 200;
    private final double width = 200;

    /**
     * Constructor for objects of class Card
     * Takes a name, value, and image
     * @param nm     name
     * @param crdValue  card's monetary value
     * @param img    photo of card
     */
    public Card(String nm, double crdValue, String img)
    {
        // initialise instance variables
        name = nm;
        cardValue = crdValue;
        image = img;
        
        // error checking in case user doesn't upload image 
        if (img == null) {
            image = DEFAULT_IMAGE; 
        }
        
        else {         
            image = img;
        }
    }
    
    // getter methods
    
    /**
     * Getter method for card's name
     * @return String card's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter method for card's value
     * @return double the card's value
     */
    public double getValue() {
        return cardValue;
    }
    
    /**
     * Return image
     */
    public String getImage() {
        return image;
    }
}
