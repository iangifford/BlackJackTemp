package com.jackcannon.blackjack;

public class Deck {

    Card[] deck = new Card[52];

    public Deck() {  //do index + 1 get the cards_## file name

        deck[0] = new Card("Clubs", "Ace", 1, R.drawable.cards_01);
        deck[1] = new Card("Clubs", "2", 2, R.drawable.cards_02);
        deck[2] = new Card("Clubs", "3", 3, R.drawable.cards_03);
        deck[3] = new Card("Clubs", "4", 4, R.drawable.cards_04);
        deck[4] = new Card("Clubs", "5", 5, R.drawable.cards_05);
        deck[5] = new Card("Clubs", "6", 6, R.drawable.cards_06);
        deck[6] = new Card("Clubs", "7", 7, R.drawable.cards_07);
        deck[7] = new Card("Clubs", "8", 8, R.drawable.cards_08);
        deck[8] = new Card("Clubs", "9", 9, R.drawable.cards_09);
        deck[9] = new Card("Clubs", "10", 10, R.drawable.cards_10);
        deck[10] = new Card("Clubs", "Jack", 10, R.drawable.cards_11);
        deck[11] = new Card("Clubs", "King", 10, R.drawable.cards_12);
        deck[12] = new Card("Clubs", "Queen", 10, R.drawable.cards_13);

        deck[13] = new Card("Spades", "Ace", 1, R.drawable.cards_14);
        deck[14] = new Card("Spades", "2", 2, R.drawable.cards_15);
        deck[15] = new Card("Spades", "3", 3, R.drawable.cards_16);
        deck[16] = new Card("Spades", "4", 4, R.drawable.cards_17);
        deck[17] = new Card("Spades", "5", 5, R.drawable.cards_18);
        deck[18] = new Card("Spades", "6", 6, R.drawable.cards_19);
        deck[19] = new Card("Spades", "7", 7, R.drawable.cards_20);
        deck[20] = new Card("Spades", "8", 8, R.drawable.cards_21);
        deck[21] = new Card("Spades", "9", 9, R.drawable.cards_22);
        deck[22] = new Card("Spades", "10", 10, R.drawable.cards_23);
        deck[23] = new Card("Spades", "Jack", 10, R.drawable.cards_24);
        deck[24] = new Card("Spades", "King", 10, R.drawable.cards_25);
        deck[25] = new Card("Spades", "Queen", 10, R.drawable.cards_26);

        deck[26] = new Card("Hearts", "Ace", 1, R.drawable.cards_27);
        deck[27] = new Card("Hearts", "2", 2, R.drawable.cards_28);
        deck[28] = new Card("Hearts", "3", 3, R.drawable.cards_29);
        deck[29] = new Card("Hearts", "4", 4, R.drawable.cards_30);
        deck[30] = new Card("Hearts", "5", 5, R.drawable.cards_31);
        deck[31] = new Card("Hearts", "6", 6, R.drawable.cards_32);
        deck[32] = new Card("Hearts", "7", 7, R.drawable.cards_33);
        deck[33] = new Card("Hearts", "8", 8, R.drawable.cards_34);
        deck[34] = new Card("Hearts", "9", 9, R.drawable.cards_35);
        deck[35] = new Card("Hearts", "10", 10, R.drawable.cards_36);
        deck[36] = new Card("Hearts", "Jack", 10, R.drawable.cards_37);
        deck[37] = new Card("Hearts", "King", 10, R.drawable.cards_38);
        deck[38] = new Card("Hearts", "Queen", 10, R.drawable.cards_39);

        deck[39] = new Card("Diamonds", "Ace", 1, R.drawable.cards_40);
        deck[40] = new Card("Diamonds", "2", 2, R.drawable.cards_41);
        deck[41] = new Card("Diamonds", "3", 3, R.drawable.cards_42);
        deck[42] = new Card("Diamonds", "4", 4, R.drawable.cards_43);
        deck[43] = new Card("Diamonds", "5", 5, R.drawable.cards_44);
        deck[44] = new Card("Diamonds", "6", 6, R.drawable.cards_45);
        deck[45] = new Card("Diamonds", "7", 7, R.drawable.cards_46);
        deck[46] = new Card("Diamonds", "8", 8, R.drawable.cards_47);
        deck[47] = new Card("Diamonds", "9", 9, R.drawable.cards_48);
        deck[48] = new Card("Diamonds", "10", 10, R.drawable.cards_49);
        deck[49] = new Card("Diamonds", "Jack", 10, R.drawable.cards_50);
        deck[50] = new Card("Diamonds", "King", 10, R.drawable.cards_51);
        deck[51] = new Card("Diamonds", "Queen", 10, R.drawable.cards_52);
    }

    public void shuffle(){

        //TODO WRITE A SHUFFLE ALGORITHM FOR THE CARDS

    }
}
