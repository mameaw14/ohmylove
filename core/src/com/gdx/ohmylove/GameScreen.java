package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter{
  OhmyloveGame ohmyloveGame;
  World world;
  WorldRenderer worldRenderer;
  
  public GameScreen(OhmyloveGame ohmyloveGame) {
    this.ohmyloveGame = ohmyloveGame;
    world = new World(ohmyloveGame);
    worldRenderer = new WorldRenderer(ohmyloveGame,world);
  }
  
  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(37, 40, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    worldRenderer.render(delta);
  }
}
