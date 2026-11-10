package io.github.escapethegeese;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    private SpriteBatch drawingBatch;
    private BitmapFont font;
    private GooseGame game;
    private Player player;
    private Rectangle playerRectangle;
    private Rectangle itemRectangle;
    private Rectangle gooseRectangle;
    private Rectangle obstacleRectangle;
    private float timer = 0f;
    private float delta;
    private Texture background;
    private List<Item> items;
    private List<Goose> geese;
    private List<Sprite> obstacles;

    @Override
    public void create() {
        setScreen(new FirstScreen());
        drawingBatch = new SpriteBatch();
        font = new BitmapFont();
        game = new GooseGame();
        obstacles = new ArrayList<>();
        obstacles.add(new Sprite(new Texture("Sprites/obstacle.png")));
        obstacles.get(0).setPosition(500, 300);
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

        playerRectangle = player.getSprite().getBoundingRectangle();

        // Check if player is near an item and can pick it up

        items = game.getMapItems();
        for (int i = 0; i < items.size(); i++) {
            itemRectangle = items.get(i).getRectangle();
            if (playerRectangle.overlaps(itemRectangle) && !player.isInventoryFull()){
                player.pickUpItem(items.get(i));
                game.removeItemFromMap(i);
            }
        }

        // Check if player is near a goose

        geese = game.getGeese();
        for (Goose goose : geese){
            gooseRectangle = goose.getSprite().getBoundingRectangle();
            if (playerRectangle.overlaps(gooseRectangle)){
                // Player is touching a goose
            }
        }

        // Check for win / loss

        if (game.getTimeElapsed() == 300){
            // Player ran out of time - Lose
        }
        if (player.isDead()){
            // Player ran out of health - Lose
        }
        if (game.finalGeeseWaveDefeated()){
            // Player dispersed all the geese - Win
        }
//        if (game.nicheEscapeEventHasOccured){
//            // Player escaped somehow - Win
//        }
        if (!game.geeseRemaining()){
            game.getNextWave();
        }

        drawingBatch.begin();

        //Draw the map, should be first thing drawn

        drawingBatch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Draw the statistics

        font.draw(drawingBatch, "Score: " + String.valueOf(player.getScore()), 0, 475);
        font.draw(drawingBatch, "Events triggered: " + String.valueOf(game.getEventsTriggered()), 0, 450);
        font.draw(drawingBatch, "Items used: " + String.valueOf(game.getItemsUsed()), 0, 425);
        font.draw(drawingBatch, "Timer: " + String.valueOf(getCountdownClock(game.getTimeElapsed())), 0, 400); // Adjust y values once game UI is finalized

        // Draw the player

        drawingBatch.draw(player.getSprite().getTexture(), player.getSprite().getX(), player.getSprite().getY(), player.getSprite().getWidth(), player.getSprite().getHeight());

        // Draw the obstacles

        for (Sprite obstacle : obstacles){
            drawingBatch.draw(obstacle.getTexture(), obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
        }

        // Draw the geese

        for (Goose goose : game.getGeese()){
            drawingBatch.draw(goose.getSprite().getTexture(), goose.getSprite().getX(), goose.getSprite().getY(), goose.getSprite().getWidth(), goose.getSprite().getHeight());
        }

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
        float initialx = player.getSprite().getX();
        float initialy  = player.getSprite().getY();
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
        if (!canPlayerMove(player)){
            player.getSprite().setPosition(initialx, initialy);
        }
    }
    private String getCountdownClock(int timeElapsed){
        int timeRemaining = 300 - timeElapsed;
        int minutes = timeRemaining / 60;
        int seconds = timeRemaining % 60;
        if (seconds < 10){
            return "0" + String.valueOf(minutes) + ":0" + String.valueOf(seconds);
        }
        else {
            return "0" + String.valueOf(minutes) + ":" + String.valueOf(seconds);
        }
    }
    private boolean canPlayerMove(Player player){
        playerRectangle = player.getSprite().getBoundingRectangle();
        for (Sprite obstacle : obstacles){
            if (playerRectangle.overlaps(obstacle.getBoundingRectangle())){
                return false;
            }
        }
        return true;
    }
}
