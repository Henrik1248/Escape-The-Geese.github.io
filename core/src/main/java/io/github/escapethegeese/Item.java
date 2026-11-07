package io.github.escapethegeese;

public class Item {
    // Constructor, attributes and methods to be filled in

    private String name;
    private String effectType;
    private double strength;
    private int duration;
    private String spriteAddress;
    public Item(){

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
    public String getSpriteAddress() {
        return spriteAddress;
    }
}
