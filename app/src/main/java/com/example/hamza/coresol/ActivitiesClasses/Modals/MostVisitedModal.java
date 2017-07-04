package com.example.hamza.coresol.ActivitiesClasses.Modals;

/**
 * Created by Hamza on 5/17/2017.
 */

public class MostVisitedModal {
    int Image;
    String Title;

    public MostVisitedModal(int image, String title) {
        Image = image;
        Title = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

