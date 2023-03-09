package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    Sprite frog;
    Texture img;
    float chargeX;
    float chargeY;
    boolean jump;
    float x = 0;
    float y = 0;
    float ySpeed = 0;
    float xSpeed = 0;
    float gravity = -1;
    double friction = -0.3;
    float maxSpeed = 20;

    public Player() {
        img = new Texture("frog.png");
        frog = new Sprite(img, 0, 0, 64, 64);
    }

    public Sprite getSprite() {
        return frog;
    }

    public void update(Sprite right) {
        if (jump) {
            ySpeed += chargeY;
            xSpeed += chargeX;
            chargeX = 0;
            chargeY = 0;
            jump = false;
        }
        if (Gdx.input.isTouched()) {
            if(y == 0) {
                chargeY += 1;
                Rectangle bounds = right.getBoundingRectangle();
                if (bounds.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) //y coordinate is flipped for getY()
                {
                    chargeX += 1;
                }
            }
        }
        if (!Gdx.input.isTouched() && chargeY > 0)
        {
            jump = true;
        }
        if (y > 0) {
            ySpeed += gravity;
        }
        if (xSpeed > maxSpeed) {
            xSpeed = maxSpeed;
        }
        if (xSpeed > 0) {
            xSpeed += friction;
        }
        if (xSpeed < 0) {
            xSpeed -= friction;
        }
        if(Math.abs(xSpeed - friction) < friction + 1)
        {
            xSpeed = 0;
        }
        y += ySpeed;
        x += xSpeed;
        if (y < 0) {
            y = 0;
            ySpeed = 0;
        }
        frog.setRotation(ySpeed);
        frog.setPosition(x, y);
    }
    public void dispose()
    {
        img.dispose();
    }
}
