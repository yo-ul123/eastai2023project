package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture arrow;
	private Player player;
	private Sprite right;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		arrow = new Texture("rightArrow.png");
		right = new Sprite(arrow, 0, 0, 32, 32);
		right.setPosition(500, 10);
	}

	@Override
	public void render () {
		player.update(right);
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.getSprite().draw(batch);
		right.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
	}
}
