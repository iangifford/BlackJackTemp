package com.jackcannon.blackjack;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Main Activity Class
 * This class acts as the Controller for the BlackJack game
 * CS482 Software Engineering
 * Dr. Raunak
 * @author Jack Cannon
 * @author Ian Gifford
 * @version 1.0 Initial Build
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Creates the Model
     */
    Game blackJackGame;

    /**
     * Provides access to the Card objects on the View
     */
    ImageView[] playerCards;
    ImageView[] dealerCards;

    /**
     * Provides access to the score fields on the View
     */
    TextView playerScore;
    TextView dealerScore;
    TextView winnerField;

    /**
     * Provides access to the buttons on the View
     */
    Button hitButton;
    Button stopButton;

    /**
     * On Create Method
     * Initializes the main View and instantiates other view objects for later use
     * @param savedInstanceState android system parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cards assigned to the player
        playerCards = new ImageView[5];
        playerCards[0] = (ImageView) findViewById(R.id.player_card_1);
        playerCards[1] = (ImageView) findViewById(R.id.player_card_2);
        playerCards[2] = (ImageView) findViewById(R.id.player_card_3);
        playerCards[3] = (ImageView) findViewById(R.id.player_card_4);
        playerCards[4] = (ImageView) findViewById(R.id.player_card_5);


        //Cards assigned to the dealer
        dealerCards = new ImageView[5];
        dealerCards[0] = (ImageView) findViewById(R.id.dealer_card_1);
        dealerCards[1] = (ImageView) findViewById(R.id.dealer_card_2);
        dealerCards[2] = (ImageView) findViewById(R.id.dealer_card_3);
        dealerCards[3] = (ImageView) findViewById(R.id.dealer_card_4);
        dealerCards[4] = (ImageView) findViewById(R.id.dealer_card_5);

        //Scores
        playerScore = (TextView) findViewById(R.id.player_score_field);
        dealerScore = (TextView) findViewById(R.id.dealer_score_field);
        winnerField = (TextView) findViewById(R.id.winner_field);

        //Buttons
        hitButton = (Button) findViewById(R.id.hit_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        //Game initialization
        blackJackGame = new Game(playerCards, dealerCards, playerScore, dealerScore, hitButton, stopButton);
        blackJackGame.resetGame();
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
    }

    /**
     * New Game Method
     * Initializes the View with a new game when the new game button is clicked
     * @param view the view from activity_main.xml
     */
    public void new_game(View view) {

        //BlackJack games begin with 2 cards dealt to each player
        blackJackGame.resetGame();
        winnerField.setText("");
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
        blackJackGame.isOver();
        if(blackJackGame.dealerScore_int == 21){
            if(blackJackGame.playerScore_int == 21){
                winnerField.setText("Tie!");
            }else{
                winnerField.setText("Dealer wins!");
            }
            hitButton.setEnabled(false);
            stopButton.setEnabled(false);
        }else if(blackJackGame.playerScore_int == 21){
            winnerField.setText("Player wins!");
            hitButton.setEnabled(false);
            stopButton.setEnabled(false);
        }

    }

    /**
     * Hit Method
     * Allows the View to update by adding another card when the user selects the hit button
     * @param view the view from activity_main.xml
     */
    public void hit(View view) {

        //"player" will be the only user capable of selecting the Hit button
        blackJackGame.hit("player");

        //After every hit, check if the game has been won or tied
        if(blackJackGame.wasBust){
            hitButton.setEnabled(false);
            stopButton.setEnabled(false);
            winnerField.setText(blackJackGame.winner);
        }
    }

    /**
     * Stop Method
     * Allows the user to terminate their turn if they choose
     * @param view the view from activity_main.xml
     */
    public void stop(View view) {

        //Change to the Dealer and deactivate the Hit and Stop buttons
        blackJackGame.executeDealerTurn();
        hitButton.setEnabled(false);
        stopButton.setEnabled(false);
        winnerField.setText(blackJackGame.winner);
    }
}