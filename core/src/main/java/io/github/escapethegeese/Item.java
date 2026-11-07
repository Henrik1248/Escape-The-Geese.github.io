package io.github.escapethegeese;

import com.badlogic.gdx.graphics.Texture;

public class Item {
    // Constructor, attributes and methods to be filled in

    private String name;
    private String effectType;
    private double strength;
    private int duration;
    private Texture image;
    public Item(String path){
        image = new Texture(path);
    }
    public String getName(){
        return name;
    }

    public String getEffectType() {
        return effectType;
    }
    public double getStrength() {
        return strength;
    }
    public int getDuration() {
        return duration;
    }
    public void applyToGeese(){

    }
    public void applyToPlayer(){

    }
    public Texture getImage() {
        return image;
    }
}
