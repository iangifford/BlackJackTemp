package com.jackcannon.blackjack;

/**
 * Card Class
 * This class builds a Card object to associate images with the characteristics of a card
 * CS482 Software Engineering
 * Dr. Raunak
 * @author Jack Cannon
 * @author Ian Gifford
 * @version 1.0 Initial Build
 */
public class Card {

    String suit;
    String face_value;
    int point_value;
    int image_resource;

    /**
     * Card Constructor
     * @param suit the card suit (clubs, spades, hearts, diamonds)
     * @param face_value the face value (1,2, Jack , King, etc.)
     * @param point_value the integer value of a card
     * @param image_resource the image associated with this card
     */
    public Card(String suit, String face_value, int point_value, int image_resource) {
        this.suit = suit;
        this.face_value = face_value;
        this.point_value = point_value;
        this.image_resource = image_resource;
    }
}
