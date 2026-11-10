package io.github.escapethegeese;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {
    // Constructor, attributes and methods to be filled in
    private Player player;
    private int timeElapsed;
    private List<Goose> geese;
    private boolean isPaused;
    private int itemsUsed;
    private int eventsTriggered;

    private int waveNumber;
    final private int numberOfWaves = 5;
    private List<Item> mapItems;
    private List<Event> mapEvents;

    public GooseGame(){
        player = new Player();

        // Testing start geese
        geese = new ArrayList<Goose>();
        geese.add(new Goose(200, 250));
        geese.add(new Goose(300, 250));
        geese.add(new Goose(100, 250));
        isPaused = false;
        eventsTriggered = 0;
        waveNumber = 1;
        mapItems = fillMapItems();
        mapEvents = fillMapEvents();
    }

    private List<Item> fillMapItems(){
        // ToDo
        return new ArrayList<>();
    }
    private List<Event> fillMapEvents(){
        // ToDo
        return new ArrayList<>();
    }
    public Player getPlayer(){
        return player;
    }
    public List<Goose> getGeese(){
        return geese;
    }
    public void pauseGame(){
        isPaused = true;
    }
    public void resumeGame(){
        isPaused = false;
    }
    public boolean isGameOver(){
        return false;
    }
    public List<Event> checkForEvents(){
        for (Event event : mapEvents){
            // Check if player is near/on any events
        }
        return new ArrayList<>();
    }
    public void activateEvent(Event event){

    }
    public List<Goose> getNextWave(){
        waveNumber++;
        return new ArrayList<>();
    }
    public boolean checkForWin(){
        return false;
    }
    public int getItemsUsed(){
        return itemsUsed;
    }
    public int getEventsTriggered(){
        return eventsTriggered;
    }
    public int getTimeElapsed(){
        return timeElapsed;
    }
    public void incrementTimeElapsed(){
        timeElapsed++;
    }
    public List<Item> getMapItems(){
        return mapItems;
    }
    public void removeItemFromMap(int index){
        mapItems.remove(index);
    }
    public boolean finalGeeseWaveDefeated(){
        if (waveNumber == numberOfWaves && !geeseRemaining()){
            return true;
        }
        return false;
    }
    public boolean geeseRemaining(){
        return geese.size() > 0;
    }
}
