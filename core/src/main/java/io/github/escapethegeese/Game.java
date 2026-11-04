package io.github.escapethegeese;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // Constructor, attributes and methods to be filled in
    Player player;
    int timeElapsed;
    List<Goose> geese;
    boolean isPaused;
    int eventsTriggered;
    int waveNumber;
    List<Item> mapItems;
    List<Event> mapEvents;

    public Game(){
        player = new Player();
        geese = new ArrayList<>();
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
}
