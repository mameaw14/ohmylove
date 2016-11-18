package com.gdx.ohmylove;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OhmyloveGame extends Game {
  public static SpriteBatch batch;
  public static final int HEIGHT = 620;
  public static final int WIDTH = 800;
  
  @Override
  public void create() {
    batch = new SpriteBatch();
    setScreen(new HomeScreen(this));
  }
  
  public void gameOver() {
    getScreen().dispose();
    setScreen(new GameOverScreen(this));
  }
  
  public void newGame() {
    setScreen(new GameScreen(this));
  }
  
  @Override
  public void render() {
    super.render();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}