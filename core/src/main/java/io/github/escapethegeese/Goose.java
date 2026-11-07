package io.github.escapethegeese;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Goose {
    // Constructor, attributes and methods to be filled in
    private int health; // Are we having health or is this just something to represent how close they are to being dispersed
    private float speed;
    private Sprite sprite;

    public Goose(int x, int y){
        health = 10;
        speed = 100f; // Values to be adjusted in prototyping
        sprite = new Sprite(new Texture("Sprites/goose.png"));
        sprite.setPosition(x, y);
    }

    public int getHealth(){
        return health;
    }
    public void moveGoose(Player player){
        pathFindToPlayer(player.getLocation());
        // Use information to move goose accordingly
    }
    public void pathFindToPlayer(float[] playerLocation){
        // A* or something, remember to avoid buildings
    }
    public void disperse(){
        // probably decrement goose health by some amount
        // decrementHealth(5);
    }
    public boolean isDispersed(){
        return health <= 0;
        // remove goose in code that calls this if goose is dispersed
    }
    public void decrementHealth(int amount){
        health -= amount;
    }
    public Sprite getSprite(){return sprite;}
}
