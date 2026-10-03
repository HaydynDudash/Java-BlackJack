import java.util.ArrayList;

public class Hand {
    private ArrayList <Cards> hand;
//hand constructor
public Hand(){
    hand = new ArrayList<>();
}
//adds card to hand
public void addCard(Cards card){
    hand.add(card);
}
public ArrayList<Cards> getHand(){
    return hand;
}
public int getValue(){
    int cardValue = 0;
    int aces = 0; // counter for aces

    for (int i = 0; i < hand.size(); i++){
        cardValue = cardValue + hand.get(i).getRealValue();

        if (hand.get(i).getShownValue().equals("A")){
            aces++;
        }
    }
    //ace 1 or 11
    while (aces > 0 && cardValue + 10 <= 21){
        cardValue = cardValue + 10;
        aces--;
    }
    return cardValue;
}
public void showHand(){
    for (int i = 0; i < hand.size(); i++){
        System.out.println(hand.get(i).getShownValue()+ " of "+ hand.get(i).getSuite());
    }
}
public void clearHand(){
    hand.clear(); //clears arraylist elements to restart
}
}
