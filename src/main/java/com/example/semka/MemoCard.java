package com.example.semka;

import lombok.Data;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
public class MemoCard implements Serializable {
    String tagCard;
    String nameCard;
    String textFromFrontSideCard;
    String textFromBackSideCard;
    String dateCreateCard;

    public MemoCard(String tagCard,
                    String nameCard,
                    String textFromFrontSideCard,
                    String textFromBackSideCard) {
        this.tagCard = tagCard;
        this.nameCard = nameCard;
        this.textFromFrontSideCard = textFromFrontSideCard;
        this.textFromBackSideCard = textFromBackSideCard;
        this.dateCreateCard = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime());;
    }

    public MemoCard() {
    }
}
