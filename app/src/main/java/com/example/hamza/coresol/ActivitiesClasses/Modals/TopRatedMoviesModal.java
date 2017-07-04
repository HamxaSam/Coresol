package com.example.hamza.coresol.ActivitiesClasses.Modals;

/**
 * Created by Hamza on 5/17/2017.
 */

public class TopRatedMoviesModal {
    String Name;
    int Image;

    public TopRatedMoviesModal(String name, int image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
