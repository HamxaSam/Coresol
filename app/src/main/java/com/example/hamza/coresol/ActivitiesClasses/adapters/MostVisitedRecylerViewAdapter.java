package com.example.hamza.coresol.ActivitiesClasses.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hamza.coresol.ActivitiesClasses.Modals.MostVisitedModal;
import com.example.hamza.coresol.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Hamza on 5/17/2017.
 */

public class MostVisitedRecylerViewAdapter extends RecyclerView.Adapter<MostVisitedRecylerViewAdapter.MyViewHolder> {
    Activity activity;
    ArrayList<MostVisitedModal> arrayListMostVisited = new ArrayList<>();
    LayoutInflater inflater;

    public MostVisitedRecylerViewAdapter(Activity activity, ArrayList<MostVisitedModal> arrayListMostVisited) {
        this.activity = activity;
        this.arrayListMostVisited = arrayListMostVisited;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public MostVisitedRecylerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.home_fragment_mostvisited,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MostVisitedRecylerViewAdapter.MyViewHolder holder, int position) {
        MostVisitedModal Modal = arrayListMostVisited.get(position);
        holder.title.setText(Modal.getTitle());
        Glide.with(activity)

                .load(Modal.getImage())
                .centerCrop()
                .into( holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayListMostVisited.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView  title;
        public MyViewHolder(View itemView) {
            super(itemView);
          image = (ImageView)itemView.findViewById(R.id.imageView_MostVisited);
          title = (TextView)itemView.findViewById(R.id.textView_TitleMostVisited);


        }
    }
}
