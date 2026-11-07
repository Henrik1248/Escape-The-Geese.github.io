package io.github.escapethegeese;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // Constructor, attributes and methods to be filled in

    private Sprite sprite;
    private float speed;
    private int health;
    private float[] location;
    private float startX;
    private float startY;
    private List<Item> inventory;
    private int score;

    public Player(){
        speed = 130f;
        health = 100; // Values to be adjusted in prototyping
        location = new float[]{startX,startY};
        inventory = new ArrayList<>();
        sprite = new Sprite(new Texture("Sprites/player.png"));
    }
    // Update players location in below methods
    public void moveUp(float delta){
        sprite.translateY(speed * delta);
    }
    public void moveDown(float delta){
        sprite.translateY(-speed * delta);
    }
    public void moveLeft(float delta){
        sprite.translateX(-speed * delta);
    }
    public void moveRight(float delta){
        sprite.translateX(speed * delta);
    }
    public void takeDamage(int damage){
        health -= damage;
    }
    public boolean isDead(){
        return health <= 0;
    }
    public int getHealth(){
        return health;
    }
    public float[] getLocation(){
        return location;
    }
    public List<Item> getInventory(){
        return inventory;
    }
    public boolean isInventoryFull(){
        return inventory.size() == 5;
    }
    public void pickUpItem(Item item){
        // Check if inventory is full here or before trying calling pickUpItem
        inventory.add(item);
    }
    public void useItem(int inventorySlot){
        // ToDo
    }
    public int getScore(){
        return score;
    }
    public void increaseScore(int amount){
        score += amount;
    }
    public Sprite getSprite(){return sprite;}
}
