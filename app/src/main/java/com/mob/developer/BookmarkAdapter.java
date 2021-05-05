package com.mob.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder> {
    private ArrayList<Bookmark> listdata;

    // RecyclerView recyclerView;
    public BookmarkAdapter(ArrayList<Bookmark> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.bookmark_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Bookmark current = listdata.get(position);
        holder.bind(current.getbName(),current.getbLat(),current.getbLong());
        holder.deleteItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "click on item: " + current.getId(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView locNameItemView;
        private final TextView locLatItemView;
        private final TextView locLongItemView;
        private final Button deleteItemView;

        private ViewHolder(View itemView) {
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

    }
}