package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class UI {
    Texture arrow;
    Sprite rightButton;
    Sprite leftButton;
    public UI()
    {
        arrow = new Texture("rightArrow.png");
        rightButton = new Sprite(arrow, 0, 0, 32, 32);
        rightButton.setPosition(500, 10);
    }
    public Sprite getRightButton()
    {
        return rightButton;
    }
    public Sprite getLeftButton()
    {
        return leftButton;
    }
    public void dispose()
    {
        arrow.dispose();
    }
}
