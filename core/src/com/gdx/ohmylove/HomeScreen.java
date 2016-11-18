package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HomeScreen extends ScreenAdapter {
  private OhmyloveGame ohmyloveGame;
  public SpriteBatch batch;
  private Sprite sprite;
  private Texture img;
  
  HomeScreen(OhmyloveGame ohmyloveGame) {
    this.ohmyloveGame = ohmyloveGame;
    batch = ohmyloveGame.batch;
    
    img = new Texture("open.png");
    sprite = new Sprite(img);
    sprite.setPosition(0, 0);
  }
  
  @Override
  public void render(float delta) {
    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
      ohmyloveGame.newGame();
    }
    batch.begin();
    sprite.draw(batch);
    batch.end();
  }
}
