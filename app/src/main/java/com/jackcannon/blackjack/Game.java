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
 *
 * @author Jack Cannon
 * @author Ian Gifford
 * @version 1.0 Initial Build
 */
public class Game {

    Deck deck;
    String current_player;
    String winner;
    ImageView[] playerCardImages;
    ImageView[] dealerCardImages;
    Card[] playerCards;
    Card[] dealerCards;
    TextView playerScore;
    TextView dealerScore;
    int playerScore_int;
    int dealerScore_int;
    int player_hit_count;
    int dealer_hit_count;
    Button hitButton;
    Button stopButton;
    boolean wasBust;

    /**
     * Game Constructor
     * Creates the game object for Main Activity to send all relevant fields to the model for processing
     *
     * @param playerCards list of player cards laid out in the view
     * @param dealerCards list of dealer cards laid out in the view
     * @param playerScore current total value of the cards held by the player
     * @param dealerScore current total value of the cards held by the dealer
     * @param hitButton   reference to the hit button for use by the executeDealerTurn() method
     * @param stopButton  reference to the stop button for use by the executeDealerTurn() method
     */
    public Game(ImageView[] playerCards, ImageView[] dealerCards, TextView playerScore, TextView dealerScore, Button hitButton, Button stopButton) {
        this.current_player = "player";
        this.deck = new Deck();
        this.playerCardImages = playerCards;
        this.dealerCardImages = dealerCards;
        this.playerCards = new Card[5];
        this.dealerCards = new Card[5];
        this.playerScore = playerScore;
        this.dealerScore = dealerScore;
        this.hitButton = hitButton;
        this.stopButton = stopButton;
        this.playerScore_int = 0;
        this.dealerScore_int = 0;
        this.player_hit_count = 0;
        this.dealer_hit_count = 0;
        this.wasBust = false;
        deck.shuffle();
    }

    /**
     * Deal Card Method
     *
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
        hitButton.setEnabled(false);
        stopButton.setEnabled(false);
        while (this.dealerScore_int < 17 && dealer_hit_count <= 5) {
            hit("dealer");
        }


    }

    private int calcScore(Card[] hand) {
        int score = 0;
        int aces = 0;
        for (Card c : hand) {
            if (c != null) {
                score += c.point_value;
                if (c.point_value == 1) {
                    aces++;
                }
            }
        }
        while (aces > 0) {
            if ((score + 10) <= 21) {
                score += 10;
                aces--;
            } else {
                aces = 0;
            }
        }
        return score;

    }

    /**
     * Is Over method
     * When called after each game action, analyzes the score and selects a winner (if applicable)
     *
     * @return the current status of the game (true if game is over via bust)
     */
    public boolean isOver() {
        dealerScore_int = calcScore(dealerCards);
        boolean dealerBust = dealerScore_int > 21;
        playerScore_int = calcScore(playerCards);
        boolean player_bust = playerScore_int > 21;
        if (player_bust && dealerBust) {
            winner = "Tie!";
            wasBust = true;
        } else if (dealerBust && !player_bust) {
            winner = "Player wins!";
            wasBust = true;
        } else if (!dealerBust && player_bust) {
            winner = "Dealer wins!";
            wasBust = true;
        } else if (dealerScore_int > playerScore_int) {
            winner = "Dealer wins!";
        } else if (playerScore_int> dealerScore_int) {
            winner = "Player wins!";
        } else if (playerScore_int== dealerScore_int) {
            winner = "Tie!";
        }
        return wasBust;

    }

    /**
     * Hit method
     * Selects the next card from the deck and assigns it to the correct view and correct player
     *
     * @param player the player calling the method, and the player to receive the card
     */
    public void hit(String player) {

        //Drawing a card and resolving its image
        Card hit_card = dealCard();
        int resource = hit_card.image_resource;
        //Assign Card to applicable player if 3 less than 3 hits
        if (player.equals("player")) {
            for (int i = 0; i < 5; i++) {
                System.out.println();
                if (playerCardImages[i].getVisibility() == View.INVISIBLE) {
                    playerCardImages[i].setImageResource(resource);
                    playerCards[i] = hit_card;
                    playerScore.setText(Integer.toString(playerScore_int));
                    playerCardImages[i].setVisibility(View.VISIBLE);
                    player_hit_count++;
                    if (player_hit_count >= 5) {
                        hitButton.setEnabled(false);
                    }
                    isOver();
                    return;
                }
            }
        }
        if (player.equals("dealer")) {
            for (int i = 0; i < 5; i++) {
                if (dealerCardImages[i].getVisibility() == View.INVISIBLE) {
                    dealerCardImages[i].setImageResource(resource);
                    dealerCards[i] = hit_card;
                    dealerScore.setText(Integer.toString(dealerScore_int));
                    dealerCardImages[i].setVisibility(View.VISIBLE);
                    dealer_hit_count++;
                    isOver();
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
            playerCardImages[i].setVisibility(View.INVISIBLE);
            dealerCardImages[i].setVisibility(View.INVISIBLE);
            playerCardImages[i].setImageResource(0);
            dealerCardImages[i].setImageResource(0);
        }
        wasBust = false;
        playerCards = new Card[5];
        dealerCards = new Card[5];
        playerScore_int = 0;
        dealerScore_int = 0;
        player_hit_count = 0;
        dealer_hit_count = 0;
        playerScore.setText(Integer.toString(playerScore_int));
        dealerScore.setText(Integer.toString(dealerScore_int));
        hitButton.setEnabled(true);
        stopButton.setEnabled(true);

        deck = new Deck();
        deck.shuffle();
    }
}
