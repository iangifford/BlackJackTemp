package com.jackcannon.blackjack;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
    int hit_count;
    Button hitButton;
    Button stopButton;

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
        this.hit_count = 0;
        deck.shuffle();
    }

    public void swapPlayer() {
        hit_count = 0;
        if(!current_player.equals("player")){
            current_player = "dealer";
        }
        else current_player = "player";
    }

    public Card dealCard() {

        //TODO implement method to return the next card from the deck
        return new Card("","",1,3);
    }

    public void executeDealerTurn() {

        //TODO implement logic for random dealer play
        /*
            hitButton.setEnabled(true);
            stopButton.setEnabled(true);
        }
         */

    }

    public boolean isOver() {

        //TODO implement method to determine if the game is over or not, and pick a winner
        return false;
    }

    public void hit(String player) {
        Card hit_card = dealCard();
        int resource = hit_card.image_resource;

        if (player.equals("player")) {
            for (int i = 0; i < 8; i++) {
                if (playerCards[i].getVisibility() == View.INVISIBLE) {
                    playerCards[i].setImageResource(resource);
                    playerScore_int += hit_card.point_value;
                    playerScore.setText(playerScore_int);
                    playerCards[i].setVisibility(View.VISIBLE);
                    return;
                }
            }
        }

        if (player.equals("dealer")){
            for(int i=0; i < 8; i++) {
                if(dealerCards[i].getVisibility() == View.INVISIBLE) {
                    dealerCards[i].setImageResource(resource);
                    dealerScore_int += hit_card.point_value;
                    dealerScore.setText(dealerScore_int);
                    dealerCards[i].setVisibility(View.VISIBLE);
                    return;
                }
            }
        }

        hit_count++;
    }

    public void resetGame() {
        for(int i=0; i < 8; i++) {
            playerCards[i].setVisibility(View.INVISIBLE);
            dealerCards[i].setVisibility(View.INVISIBLE);
            playerCards[i].setImageResource(0);
            dealerCards[i].setImageResource(0);
        }

        playerScore_int = 0;
        dealerScore_int = 0;
        playerScore.setText(playerScore_int);
        dealerScore.setText(dealerScore_int);

        deck = new Deck();
        deck.shuffle();
    }
}
