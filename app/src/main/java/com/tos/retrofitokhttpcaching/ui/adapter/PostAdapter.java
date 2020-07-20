package com.tos.retrofitokhttpcaching.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.model.post.PostData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private List<PostData> items;


    public PostAdapter(Context context, List<PostData> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostData item = items.get(position);
        holder.tvText.setText(item.getTitle());
        holder.tvText.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvText;

        ViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);

        }

    }
}
