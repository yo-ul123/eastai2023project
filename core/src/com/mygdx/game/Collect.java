package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Collect {
    ArrayList<Sprite> collectibles = new ArrayList<Sprite>();
    public Collect()
    {

    }
    public void update(UI ui)
    {
        //interact with player
        //use ui to update timer -> subtractTime method
    }
    public ArrayList<Sprite> getCollectibles()
    {
        return collectibles;
    }
    public void dispose()
    {
        //dispose textures
    }
}
