package com.example.resh.corktouristspots;

import java.io.Serializable;

public class Place implements Serializable {

    private String name;
    private String description;
    private String address;
    private String image;
    private String [] images;
    private String url;
    private String distance;
    private String backgroundImage;

    public Place(String name, String description, String address, String distance, String [] images, String url, String backgroundImage) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.distance = distance;
        this.images = images;
        this.image = images[0];
        this.url = url;
        this.backgroundImage = backgroundImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
