package com.bounce.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bounce.game.States.GameStateManager;
import com.bounce.game.States.StartMenu;

public class Main extends ApplicationAdapter {

	private SpriteBatch batch;
	private GameStateManager gsm;

	@Override
	public void create() {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new StartMenu(gsm));
	}

	@Override
	public void render() {
		ScreenUtils.clear(0.43f, 1, 0.98f, 1);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}
}