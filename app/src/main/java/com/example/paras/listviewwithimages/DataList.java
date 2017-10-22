package com.example.paras.listviewwithimages;

/**
 * Created by Paras on 12/09/2017.
 */
// class to combine all data into one single object

public class DataList
{
    String title ;
    String description ;
    int image ;

    public String getTitle() {        return title;    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
