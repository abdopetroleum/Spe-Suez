package com.example.spesuez.ui.home.magazine;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    public MyHolder(@NonNull CardView cardView) {
        super(cardView);
        this.cardView=cardView;
    }

    public CardView getCardView() {
        return cardView;
    }
}
