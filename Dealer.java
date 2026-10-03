
import java.util.ArrayList;
import java.util.Scanner;

public class Dealer {
    // dealers cards and hit or stay
    private Deck deck;
    private Hand hand;
    private ArrayList<Player> players;

    //dealer constructor
    public Dealer(ArrayList<Player> players,Deck deck) {
        this.players = players;
        this.deck = deck;
        this.hand = new Hand();
    }

    //dealer dealing first card to players
    public void dealCards() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getStatus()) {
                Cards card = deck.drawCard();
                players.get(i).getHand().addCard(card);
            }
        }
        //same thing for other card
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getStatus()) {
                Cards card = deck.drawCard();
                players.get(i).getHand().addCard(card);
            }
        }
    }
    //dealer dealing his hand
    public void dealerHand(){
        hand.addCard(deck.drawCard());
        hand.addCard(deck.drawCard());

    }
    //dealer hitting
    public void dealerPlay(){
        while (hand.getValue() < 17){
            Cards card = deck.drawCard();
            hand.addCard(card);
        }
    }
    //display dealer first card
    public void showDealerCard(){
        System.out.println("Dealers first card: " + hand.getHand().get(0).getShownValue() + " of " + hand.getHand().get(0).getSuite());
    }
    //displaying his whole hand
    public void showDealerHand(){
        for (int i = 0; i < hand.getHand().size(); i++){
            System.out.println(hand.getHand().get(i).getShownValue() + " of " + hand.getHand().get(i).getSuite());
        }
        System.out.println("Dealer's hand value: " + hand.getValue());
    }
    public int getHandValue(){
        return hand.getValue();
    }
    public void clearHand() {
        hand.clearHand(); //clears dealers hand
    }
    //players choice for more cards
    public void playerChoice(){
        for (int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            while(player.getActive()){
                System.out.println(player.getName() + "'s hand:");
                player.getHand().showHand();
                System.out.println("Hand value: " + player.getHand().getValue());
                String choice = player.yourChoice();

               //hit choice
                if (choice.equalsIgnoreCase("Hit")){
                    Cards card = deck.drawCard();
                    player.getHand().addCard(card);

                    if (player.getHand().getValue() > 21) {
                        System.out.println("You busted.");
                        player.setActive(false);
                    }
                }
                //stay choice
                else if (choice.equalsIgnoreCase("Stay")) {
                    player.setActive(false);
                }
                //double choice
                else if (choice.equalsIgnoreCase("Double")) {
                    if(player.doubleBet()) {

                        Cards card = deck.drawCard();
                        player.getHand().addCard(card);
                        if (player.getHand().getValue() > 21) {
                            System.out.println("You busted.");
                        }
                        player.setActive(false);
                    }

                }
                else {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }

}
