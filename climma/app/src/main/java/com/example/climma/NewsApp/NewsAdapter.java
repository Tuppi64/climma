package com.example.climma.NewsApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.climma.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mContext;
    private List<NewsItems> headlines;

    public NewsAdapter(Context mContext, List<NewsItems> headlines) {
        this.mContext = mContext;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);
        return new NewsAdapter.NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        holder.TitleTV.setText(headlines.get(position).getTitle());
        holder.SourceTV.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.imgHeadline);
        }
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView TitleTV, SourceTV;
        ImageView imgHeadline;
        CardView cardView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            TitleTV = itemView.findViewById(R.id.TitleTV);
            SourceTV = itemView.findViewById(R.id.SourceTV);
            imgHeadline = itemView.findViewById(R.id.imgHeadline);
            cardView = itemView.findViewById(R.id.main_container);


        }
    }
}