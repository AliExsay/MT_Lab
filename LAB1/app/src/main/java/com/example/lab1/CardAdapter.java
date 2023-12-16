package com.example.lab1;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;



public class CardAdapter extends BaseAdapter {
    private Context context;
    private List<Card> cards;
    private Card firstOpenedCard = null;
    private int numberOfMoves = 0;
    private GameActivity gameActivity;

    public CardAdapter(Context context, List<Card> cards, GameActivity gameActivity) {
        this.context = context;
        this.cards = cards;
        this.gameActivity = gameActivity;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        }

        final ImageView cardImageView = convertView.findViewById(R.id.cardImageView);

        final Card currentCard = cards.get(position);

        if (currentCard.isRemoved()) {
            cardImageView.setImageDrawable(null);
        } else if (currentCard.isOpen()) {
            int cardImageResource = context.getResources().getIdentifier(
                    currentCard.getValue(), "drawable", context.getPackageName());
            cardImageView.setImageResource(cardImageResource);
        } else {
            cardImageView.setImageResource(R.drawable.card);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentCard.isOpen()&&!currentCard.isRemoved() ) {
                    currentCard.setOpen(true);
                    notifyDataSetChanged();
                    numberOfMoves++;
                    if (firstOpenedCard == null) {
                        firstOpenedCard = currentCard;
                    } else {
                        if (firstOpenedCard.getValue().equals(currentCard.getValue())) {
                            firstOpenedCard.setRemoved(true);
                            currentCard.setRemoved(true);
                            if (areAllCardsRemoved()) {
                                gameActivity.showCongratulationsDialog(numberOfMoves);
                            }
                        } else {
                            firstOpenedCard.setOpen(false);
                            firstOpenedCard = currentCard;
                            notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        return convertView;
    }
    protected boolean areAllCardsRemoved() {
        for (Card card : cards) {
            if (!card.isRemoved()) {
                return false;
            }
        }
        return true;
    }
    protected int getNumberOfMoves(){
        return numberOfMoves;
    }
    protected void resetGame() {
        for (Card card : cards) {
            card.setOpen(false);
            card.setRemoved(false);
        }
        numberOfMoves = 0;
        Collections.shuffle(cards);
        notifyDataSetChanged();
    }
}





