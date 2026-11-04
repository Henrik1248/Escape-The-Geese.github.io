package io.github.escapethegeese;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
    // Constructor, attributes and methods to be filled in

    private Sprite sprite;
    private float speed;
    private float delta;

    public Player(){
        delta = Gdx.graphics.getDeltaTime();
    }

    public void moveUp(){
        sprite.translateY(speed * delta);
    }
    public void moveDown(){
        sprite.translateY(-speed * delta);
    }
    public void moveLeft(){
        sprite.translateX(-speed * delta);
    }
    public void moveRight(){
        sprite.translateX(speed * delta);
    }
}
