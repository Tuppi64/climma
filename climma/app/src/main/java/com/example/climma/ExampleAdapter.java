package com.example.climma;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context  context, ArrayList<ExampleItem> exampleList){
        mContext = context;
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
       return new ExampleViewHolder(v);
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTempTV, mCondTV, mCityTV, mHumdtTV, mFeelTV, mPrecipTV, mTimeTV ;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mCityTV = itemView.findViewById(R.id.city_TV);
            mTempTV = itemView.findViewById(R.id.temperature_TV);
            mCondTV = itemView.findViewById(R.id.Cond_TV);
            mHumdtTV = itemView.findViewById(R.id.Humdt_TV);
            mFeelTV = itemView.findViewById(R.id.FeelTV);
            mTimeTV = itemView.findViewById(R.id.TimeTV);
            mPrecipTV = itemView.findViewById(R.id.PrecipTV);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getmImageUrl();
        String city = currentItem.getmCity();
        String temp = currentItem.getmTemp();
        String feelsLike = currentItem.getmFeel();
        String humdt = currentItem.getmHumdt();
        String precip = currentItem.getmPrecip();
        String timeZone = currentItem.getmTime();
        String cond = currentItem.getmCond();

      /*  if(currentItem.getmCond() == "Clear"){
            Picasso.get().load().fit().centerInside().into(R.id.image_view);
        }*/

        holder.mCityTV.setText(city);
        holder.mTempTV.setText(temp);
        holder.mHumdtTV.setText(humdt);
        holder.mFeelTV.setText(feelsLike);
        holder.mCondTV.setText(cond);
        holder.mTimeTV.setText(timeZone);
        holder.mPrecipTV.setText(precip);

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }



}
