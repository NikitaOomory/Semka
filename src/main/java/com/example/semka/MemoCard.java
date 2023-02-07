package com.example.semka;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemoCard implements Serializable {
    String tegCard;
    String nameCard;
    String textFromFrontSideCard;
    String textFromBackSideCard;
    String dateCreateCard;

    public MemoCard(String tegCard,String nameCard, String textFromFrontSideCard, String textFromBackSideCard, String dateCreateCard) {
        this.tegCard = tegCard;
        this.nameCard = nameCard;
        this.textFromFrontSideCard = textFromFrontSideCard;
        this.textFromBackSideCard = textFromBackSideCard;
        this.dateCreateCard = dateCreateCard;
    }

    public MemoCard() {
    }
}
