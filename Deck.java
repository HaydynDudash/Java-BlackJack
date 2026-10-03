import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList <Cards> deck;
//deck constructor
    public Deck() {
        this.deck = new ArrayList<>();
        createDeck();
    }
// creates 52 card deck
    public void createDeck(){
        int[] realValues = new int[] {1,2,3,4,5,6,7,8,9,10,10,10,10};
        String[] shownValues = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suites = new String[] {"Diamonds","Spades","Clubs","Hearts"};
        this.deck = new ArrayList<>();
        for (int i = 0; i < shownValues.length; i++){
            for (int j = 0; j < suites.length; j++){
                deck.add(new Cards(realValues[i],shownValues[i],suites[j]));
            }
        }
    }
    public void shuffleDeck(){
        Random rng = new Random();
        //fisher yates shuffle
        for(int i = 0; i < deck.size(); ++i) {
            int swapIndex = i + rng.nextInt(deck.size() - i);
            Cards temp = deck.get(i);
            deck.set(i, deck.get(swapIndex));
            deck.set (swapIndex, temp);
        }
    }
    //removes first card from stack
    public Cards drawCard(){
        return deck.removeFirst();
    }

    public ArrayList<Cards> getDeck(){
        return deck;
    }


}
