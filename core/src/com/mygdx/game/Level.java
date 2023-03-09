package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Level {
    ArrayList<Sprite> platforms = new ArrayList<Sprite>();

    public Level()
    {

    }

    public ArrayList<Sprite> getPlatforms()
    {
        return platforms;
    }

    public void dispose()
    {
        //dispose textures
    }
}
