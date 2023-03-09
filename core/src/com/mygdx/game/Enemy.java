package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Enemy {
    ArrayList<Sprite> enemies = new ArrayList<Sprite>();

    public Enemy()
    {

    }
    public void update()
    {
        //movement/animations
    }

    public ArrayList<Sprite> getSprites()
    {
        return enemies;
    }
    public void dispose()
    {
        //dispose textures
    }
}
