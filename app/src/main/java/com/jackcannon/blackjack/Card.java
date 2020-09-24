package com.jackcannon.blackjack;

public class Card {

    String suit;
    String face_value;
    int point_value;
    int image_resource;

    public Card(String suit, String face_value, int point_value, int image_resource) {
        this.suit = suit;
        this.face_value = face_value;
        this.point_value = point_value;
        this.image_resource = image_resource;
    }
}
