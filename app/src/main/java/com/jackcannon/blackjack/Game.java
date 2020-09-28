package com.jackcannon.blackjack;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Game Class
 * This class acts as the main component of the Model for the BlackJack game
 * CS482 Software Engineering
 * Dr. Raunak
 * @author Jack Cannon
 * @author Ian Gifford
 * @version 1.0 Initial Build
 */
public class Game {

    Deck deck;
    String current_player;
    String winner;
    ImageView[] playerCards;
    ImageView[] dealerCards;
    TextView playerScore;
    TextView dealerScore;
    int playerScore_int;
    int dealerScore_int;
    int player_hit_count;
    int dealer_hit_count;
    Button hitButton;
    Button stopButton;

    /**
     * Game Constructor
     * Creates the game object for Main Activity to send all relevant fields to the model for processing
     * @param playerCards list of player cards laid out in the view
     * @param dealerCards list of dealer cards laid out in the view
     * @param playerScore current total value of the cards held by the player
     * @param dealerScore current total value of the cards held by the dealer
     * @param hitButton reference to the hit button for use by the executeDealerTurn() method
     * @param stopButton reference to the stop button for use by the executeDealerTurn() method
     */
    public Game(ImageView[] playerCards, ImageView[] dealerCards, TextView playerScore, TextView dealerScore, Button hitButton, Button stopButton) {
        this.current_player = "player";
        this.deck = new Deck();
        this.playerCards = playerCards;
        this.dealerCards = dealerCards;
        this.playerScore = playerScore;
        this.dealerScore = dealerScore;
        this.hitButton = hitButton;
        this.stopButton = stopButton;
        this.playerScore_int = 0;
        this.dealerScore_int = 0;
        this.player_hit_count = 0;
        this.dealer_hit_count = 0;
        deck.shuffle();
    }

    /**
     * Swap Player method
     * Switches which player has control of the buttons, and where the cards are dealt
     */
    public void swapPlayer() {
        if (current_player.equals("player")) {
            current_player = "dealer";
            hitButton.setEnabled(false);
        } else {
            current_player = "player";
            hitButton.setEnabled(true);
        }


    }

    /**
     * Deal Card Method
     * @return the next card to be played, as selected from the deck
     */
    public Card dealCard() {
        return this.deck.draw();
    }

    /**
     * Execute Dealer Turn Method
     * Randomly selects the next action(s) taken by the dealer, based on the probability of bust
     */
    public void executeDealerTurn() {

        hit("dealer");

        swapPlayer();
    }

    /**
     * Is Over method
     * When called after each game action, analyzes the score and selects a winner (if applicable)
     * @return the current status of the game (true if game is over)
     */
    public boolean isOver() {

        //TODO implement method to determine if the game is over or not, and pick a winner
        return false;
    }

    /**
     * Hit method
     * Selects the next card from the deck and assigns it to the correct view and correct player
     * @param player the player calling the method, and the player to receive the card
     */
    public void hit(String player) {

        //Drawing a card and resolving its image
        Card hit_card = dealCard();
        int resource = hit_card.image_resource;
        //Assign Card to applicable player if 3 less than 3 hits
        if (player.equals("player")) {
            for (int i = 0; i < 5; i++) {
                if (player_hit_count >= 5) {
                    hitButton.setEnabled(false);
                    return;
                }
                System.out.println();
                if (playerCards[i].getVisibility() == View.INVISIBLE) {
                    playerCards[i].setImageResource(resource);
                    playerScore_int += hit_card.point_value;
                    playerScore.setText(Integer.toString(playerScore_int));
                    playerCards[i].setVisibility(View.VISIBLE);
                    player_hit_count++;
                    return;
                }
            }
        }
        if (player.equals("dealer")) {
            for (int i = 0; i < 5; i++) {
                if (dealer_hit_count >= 3) {
                    hitButton.setEnabled(false);
                    return;
                }
                if (dealerCards[i].getVisibility() == View.INVISIBLE) {
                    dealerCards[i].setImageResource(resource);
                    dealerScore_int += hit_card.point_value;
                    dealerScore.setText(Integer.toString(dealerScore_int));
                    dealerCards[i].setVisibility(View.VISIBLE);
                    dealer_hit_count++;
                    return;
                }
            }
        }
    }

    /**
     * Reset Game method
     * As described, resets game to original state when the user requests a new game
     */
    public void resetGame() {
        for (int i = 0; i < 5; i++) {
            playerCards[i].setVisibility(View.INVISIBLE);
            dealerCards[i].setVisibility(View.INVISIBLE);
            playerCards[i].setImageResource(0);
            dealerCards[i].setImageResource(0);
        }

        playerScore_int = 0;
        dealerScore_int = 0;
        player_hit_count = 0;
        dealer_hit_count = 0;
        playerScore.setText(Integer.toString(playerScore_int));
        dealerScore.setText(Integer.toString(dealerScore_int));

        deck = new Deck();
        deck.shuffle();
    }
}
