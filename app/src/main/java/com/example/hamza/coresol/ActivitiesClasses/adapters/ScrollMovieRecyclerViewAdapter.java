package com.example.hamza.coresol.ActivitiesClasses.adapters;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hamza.coresol.ActivitiesClasses.Modals.MovieModal;
import com.example.hamza.coresol.R;

import java.util.ArrayList;

/**
 * Created by Hamza on 5/16/2017.
 */

public class ScrollMovieRecyclerViewAdapter extends RecyclerView.Adapter<ScrollMovieRecyclerViewAdapter.MyViewHolder>{
    Activity activity;
    ArrayList<MovieModal> arrayListMovieScroll;
    LayoutInflater inflater;

    public ScrollMovieRecyclerViewAdapter(Activity activity, ArrayList<MovieModal> arrayListMovieScroll) {
        this.activity = activity;
        this.arrayListMovieScroll = arrayListMovieScroll;
        inflater = activity.getLayoutInflater();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = inflater.inflate(R.layout.home_fragment_moviescroll,parent,false);

        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieModal ModalScroll = arrayListMovieScroll.get(position);
        Glide.with(activity)
                .load(ModalScroll.getImage())
                .centerCrop()
                .into(holder.imageView);
//                holder.imageView.setImageResource(ModalScroll.getImage());
    }
    @Override
    public int getItemCount() {
        return arrayListMovieScroll.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       public ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
         imageView = (ImageView)itemView.findViewById(R.id.imageView_MovieScroll);
        }
    }
}
