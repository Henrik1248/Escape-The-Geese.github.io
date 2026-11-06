package io.github.escapethegeese;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    private SpriteBatch drawingBatch;
    private BitmapFont font;
    private GooseGame game;
    private float timer = 0f;
    private float delta;

    @Override
    public void create() {
        setScreen(new FirstScreen());
        drawingBatch = new SpriteBatch();
        font = new BitmapFont();
        game = new GooseGame();
    }

    @Override
    public void render(){
        gameLoop();
        delta = Gdx.graphics.getDeltaTime();
        font.setColor(Color.BLACK);
    }

    private void gameLoop(){
        ScreenUtils.clear(255, 255, 255, 1);

        // Main game logic in here

        //checkPlayerMovementInputs(player);  Uncomment when player object exists

        // Draw the statistics

        drawingBatch.begin();
        font.draw(drawingBatch, "Events triggered: " + String.valueOf(game.getEventsTriggered()), 0, 450);
        font.draw(drawingBatch, "Items used: " + String.valueOf(game.getItemsUsed()), 0, 425);
        font.draw(drawingBatch, "Timer: " + String.valueOf(game.getTimeElapsed()), 0, 400); // Adjust y values once game UI is finalized

        timer += delta;
        if (timer >= 1.0f){
            game.incrementTimeElapsed();
            timer = 0f;
        }

        drawingBatch.end();
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
