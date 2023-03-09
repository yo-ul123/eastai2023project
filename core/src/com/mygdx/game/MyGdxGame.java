package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Player player;
	private UI ui;
	private Enemy enemy;
	private Collect collect;
	private Level level;
	private OrthographicCamera camera;
	private float w;
	private float h;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		ui = new UI();
		enemy = new Enemy();
		collect = new Collect();
		level = new Level();
		camera = new OrthographicCamera(w, h);
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
	}

	@Override
	public void render () {
		player.update(ui.getRightButton());
		//camera.position.set(player.getSprite().getX(), player.getSprite().getY(), 0);
		//camera.update();
		enemy.update();
		collect.update(ui);
		ScreenUtils.clear(0, 0, 0, 1);
		//batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.getSprite().draw(batch);
		ui.getRightButton().draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
		ui.dispose();
		enemy.dispose();
		level.dispose();
		collect.dispose();
	}
}
