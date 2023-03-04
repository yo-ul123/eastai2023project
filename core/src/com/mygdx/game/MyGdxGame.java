package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture arrow;

	private Sprite sprite;
	private Sprite right;

	float x = 0;
	float y = 0;
	float ySpeed = 0;
	float xSpeed = 0;
	float gravity = -1;
	float friction = -1;
	float maxSpeed = 20;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("frog.png");
		arrow = new Texture("rightArrow.png");
		sprite = new Sprite(img, 0, 0, 64, 64);
		right = new Sprite(arrow, 0, 0, 32, 32);
		right.setPosition(500, 10);
	}

	@Override
	public void render () {
		if(Gdx.input.justTouched())
		{
			if(y == 0) {
				ySpeed += 10;
			}
		}
		if(Gdx.input.isTouched())
		{
			Rectangle bounds = right.getBoundingRectangle();
			if(bounds.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) //y coordinate is flipped for getY()
			{
				xSpeed += 2;
			}
		}
		if(y > 0)
		{
			ySpeed += gravity;
		}
		if(xSpeed > maxSpeed)
		{
			xSpeed = maxSpeed;
		}
		if(xSpeed > 0)
		{
			xSpeed += friction;
		}
		if(xSpeed < 0)
		{
			xSpeed -= friction;
		}
		y += ySpeed;
		x += xSpeed;
		if(y<0) {
			y = 0;
			ySpeed = 0;
		}
		sprite.setRotation(ySpeed);
		sprite.setPosition(x, y);
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		sprite.draw(batch);
		right.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
