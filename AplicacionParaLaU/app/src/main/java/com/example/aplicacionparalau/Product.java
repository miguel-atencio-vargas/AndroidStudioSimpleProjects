package com.example.aplicacionparalau;

import java.io.Serializable;

public class Product implements Serializable {
    private String title;
    private int likes;
    private String img;

    public Product(String title, int likes, String img) {
        super();
        this.title = title;
        this.likes = likes;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
