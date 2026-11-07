package io.github.escapethegeese;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    private SpriteBatch drawingBatch;
    private BitmapFont font;
    private GooseGame game;
    private Player player;
    private float timer = 0f;
    private float delta;
    private Texture background;

    @Override
    public void create() {
        setScreen(new FirstScreen());
        drawingBatch = new SpriteBatch();
        font = new BitmapFont();
        game = new GooseGame();
        background = new  Texture("map.png");
    }

    @Override
    public void render(){
        gameLoop();
        font.setColor(Color.BLACK);
    }

    private void gameLoop(){
        ScreenUtils.clear(255, 255, 255, 1);

        // Main game logic in here
        delta = Gdx.graphics.getDeltaTime();

        player = game.getPlayer();

        checkPlayerMovementInputs(player);

        drawingBatch.begin();

        //Draw the map, should be first thing drawn

        drawingBatch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Draw the statistics

        font.draw(drawingBatch, "Events triggered: " + String.valueOf(game.getEventsTriggered()), 0, 450);
        font.draw(drawingBatch, "Items used: " + String.valueOf(game.getItemsUsed()), 0, 425);
        font.draw(drawingBatch, "Timer: " + String.valueOf(game.getTimeElapsed()), 0, 400); // Adjust y values once game UI is finalized

        // Draw the player

        drawingBatch.draw(player.getSprite().getTexture(), player.getSprite().getX(), player.getSprite().getY(), player.getSprite().getWidth(), player.getSprite().getHeight());

        // Display inventory

        int count = 0;
        for (Item item : player.getInventory()){
            drawingBatch.draw(item.getImage(), 100 + (50 * count), 50);
            count++;
        }

        drawingBatch.end();


        timer += delta;
        if (timer >= 1.0f){
            game.incrementTimeElapsed();
            timer = 0f;
        }
    }

    private void checkPlayerMovementInputs(Player player){
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)){
            player.moveUp(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.moveLeft(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            player.moveDown(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.moveRight(delta);
        }
    }
}
