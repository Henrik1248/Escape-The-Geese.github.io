package io.github.escapethegeese;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    @Override
    public void create() {
        setScreen(new FirstScreen());
    }

    @Override
    public void render(){
        gameLoop();
    }

    private void gameLoop(){
        // Main game logic in here

        //checkPlayerMovementInputs(player);  Uncomment when player object exists
    }

    private void checkPlayerMovementInputs(Player player){
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)){
            player.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            player.moveDown();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.moveRight();
        }
    }
}
