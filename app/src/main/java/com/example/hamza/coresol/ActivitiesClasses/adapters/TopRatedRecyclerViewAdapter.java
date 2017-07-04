package com.example.hamza.coresol.ActivitiesClasses.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hamza.coresol.ActivitiesClasses.Modals.TopRatedMoviesModal;
import com.example.hamza.coresol.R;
import java.util.ArrayList;

/**
 * Created by Hamza on 5/17/2017.
 */

public class TopRatedRecyclerViewAdapter extends RecyclerView.Adapter<TopRatedRecyclerViewAdapter.MyViewHolder> {
    public Activity activity;
    public ArrayList<TopRatedMoviesModal> ArrayListTopRatedMovies;
    LayoutInflater inflater;

    public TopRatedRecyclerViewAdapter(Activity activity, ArrayList<TopRatedMoviesModal> arrayListTopRatedMovies) {
        this.activity = activity;
        this.ArrayListTopRatedMovies = arrayListTopRatedMovies;
        inflater = activity.getLayoutInflater();

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.home_fragment_topratedmovies, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TopRatedMoviesModal Modal = ArrayListTopRatedMovies.get(position);
        //holder.image.setImageResource();
          holder.title.setText(Modal.getName());
        Glide.with(activity)
                .load(Modal.getImage())
                .centerCrop()
                .into( holder.image);
    }

    @Override
    public int getItemCount() {
        return ArrayListTopRatedMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView  title;

        public MyViewHolder(View itemView) {
            super(itemView);
            image =(ImageView) itemView.findViewById(R.id.imageView_TopRated);
            title = (TextView) itemView.findViewById(R.id.textView_titleTopRated);



        }
    }
}
