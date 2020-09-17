package com.example.spesuez.ui.home.events;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyEventHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    public MyEventHolder(@NonNull CardView cardView) {
        super(cardView);
        this.cardView=cardView;
    }

    public CardView getCardView() {
        return cardView;
    }
}
