package io.github.escapethegeese;

import com.badlogic.gdx.Game;

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
    }
}
