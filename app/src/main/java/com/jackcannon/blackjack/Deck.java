package com.jackcannon.blackjack;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
public class Deck {

    Stack<Card> deck;
    Random rand;
    public Deck() {  //do index + 1 get the cards_## file name
        Card[] arrayDeck = new Card[52];
        arrayDeck[0] = new Card("Clubs", "Ace", 1, R.drawable.cards_01);
        arrayDeck[1] = new Card("Clubs", "2", 2, R.drawable.cards_02);
        arrayDeck[2] = new Card("Clubs", "3", 3, R.drawable.cards_03);
        arrayDeck[3] = new Card("Clubs", "4", 4, R.drawable.cards_04);
        arrayDeck[4] = new Card("Clubs", "5", 5, R.drawable.cards_05);
        arrayDeck[5] = new Card("Clubs", "6", 6, R.drawable.cards_06);
        arrayDeck[6] = new Card("Clubs", "7", 7, R.drawable.cards_07);
        arrayDeck[7] = new Card("Clubs", "8", 8, R.drawable.cards_08);
        arrayDeck[8] = new Card("Clubs", "9", 9, R.drawable.cards_09);
        arrayDeck[9] = new Card("Clubs", "10", 10, R.drawable.cards_10);
        arrayDeck[10] = new Card("Clubs", "Jack", 10, R.drawable.cards_11);
        arrayDeck[11] = new Card("Clubs", "King", 10, R.drawable.cards_12);
        arrayDeck[12] = new Card("Clubs", "Queen", 10, R.drawable.cards_13);

        arrayDeck[13] = new Card("Spades", "Ace", 1, R.drawable.cards_14);
        arrayDeck[14] = new Card("Spades", "2", 2, R.drawable.cards_15);
        arrayDeck[15] = new Card("Spades", "3", 3, R.drawable.cards_16);
        arrayDeck[16] = new Card("Spades", "4", 4, R.drawable.cards_17);
        arrayDeck[17] = new Card("Spades", "5", 5, R.drawable.cards_18);
        arrayDeck[18] = new Card("Spades", "6", 6, R.drawable.cards_19);
        arrayDeck[19] = new Card("Spades", "7", 7, R.drawable.cards_20);
        arrayDeck[20] = new Card("Spades", "8", 8, R.drawable.cards_21);
        arrayDeck[21] = new Card("Spades", "9", 9, R.drawable.cards_22);
        arrayDeck[22] = new Card("Spades", "10", 10, R.drawable.cards_23);
        arrayDeck[23] = new Card("Spades", "Jack", 10, R.drawable.cards_24);
        arrayDeck[24] = new Card("Spades", "King", 10, R.drawable.cards_25);
        arrayDeck[25] = new Card("Spades", "Queen", 10, R.drawable.cards_26);

        arrayDeck[26] = new Card("Hearts", "Ace", 1, R.drawable.cards_27);
        arrayDeck[27] = new Card("Hearts", "2", 2, R.drawable.cards_28);
        arrayDeck[28] = new Card("Hearts", "3", 3, R.drawable.cards_29);
        arrayDeck[29] = new Card("Hearts", "4", 4, R.drawable.cards_30);
        arrayDeck[30] = new Card("Hearts", "5", 5, R.drawable.cards_31);
        arrayDeck[31] = new Card("Hearts", "6", 6, R.drawable.cards_32);
        arrayDeck[32] = new Card("Hearts", "7", 7, R.drawable.cards_33);
        arrayDeck[33] = new Card("Hearts", "8", 8, R.drawable.cards_34);
        arrayDeck[34] = new Card("Hearts", "9", 9, R.drawable.cards_35);
        arrayDeck[35] = new Card("Hearts", "10", 10, R.drawable.cards_36);
        arrayDeck[36] = new Card("Hearts", "Jack", 10, R.drawable.cards_37);
        arrayDeck[37] = new Card("Hearts", "King", 10, R.drawable.cards_38);
        arrayDeck[38] = new Card("Hearts", "Queen", 10, R.drawable.cards_39);

        arrayDeck[39] = new Card("Diamonds", "Ace", 1, R.drawable.cards_40);
        arrayDeck[40] = new Card("Diamonds", "2", 2, R.drawable.cards_41);
        arrayDeck[41] = new Card("Diamonds", "3", 3, R.drawable.cards_42);
        arrayDeck[42] = new Card("Diamonds", "4", 4, R.drawable.cards_43);
        arrayDeck[43] = new Card("Diamonds", "5", 5, R.drawable.cards_44);
        arrayDeck[44] = new Card("Diamonds", "6", 6, R.drawable.cards_45);
        arrayDeck[45] = new Card("Diamonds", "7", 7, R.drawable.cards_46);
        arrayDeck[46] = new Card("Diamonds", "8", 8, R.drawable.cards_47);
        arrayDeck[47] = new Card("Diamonds", "9", 9, R.drawable.cards_48);
        arrayDeck[48] = new Card("Diamonds", "10", 10, R.drawable.cards_49);
        arrayDeck[49] = new Card("Diamonds", "Jack", 10, R.drawable.cards_50);
        arrayDeck[50] = new Card("Diamonds", "King", 10, R.drawable.cards_51);
        arrayDeck[51] = new Card("Diamonds", "Queen", 10, R.drawable.cards_52);

        for (Card c : arrayDeck){
            this.deck.push(c);
        }
    }

    public void shuffle(){
        Collections.shuffle(this.deck);

    }

    public Card draw(){
        this.shuffle();
        return this.deck.pop();
    }
}
