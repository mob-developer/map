package com.mob.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder {
}
class BookmarkViewHolder extends RecyclerView.ViewHolder {
    private final TextView locNameItemView;
    private final TextView locLatItemView;
    private final TextView locLongItemView;
    private final TextView deleteItemView;

    private BookmarkViewHolder(View itemView) {
        super(itemView);
        locNameItemView = itemView.findViewById(R.id.locName);
        locLatItemView = itemView.findViewById(R.id.locLat);
        locLongItemView = itemView.findViewById(R.id.locLong);
        deleteItemView = itemView.findViewById(R.id.delete);
    }

    public void bind(String locName,String locLat,String locLong) {
        locNameItemView.setText(locName);
        locLatItemView.setText(locLat);
        locLongItemView.setText(locLong);
    }

    static BookmarkViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bookmark_item, parent, false);
        return new BookmarkViewHolder(view);
    }
}
