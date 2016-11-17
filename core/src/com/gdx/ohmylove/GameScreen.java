package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter{
  OhmyloveGame ohmyloveGame;
  World world;
  WorldRenderer worldRenderer;
  
  Music music = Gdx.audio.newMusic(Gdx.files.internal("sound/bg.mp3"));
  
  public GameScreen(OhmyloveGame ohmyloveGame) {
    this.ohmyloveGame = ohmyloveGame;
    world = new World(ohmyloveGame);
    worldRenderer = new WorldRenderer(ohmyloveGame,world);
   
    music.setLooping(true);
    music.setVolume(0.8F);
    music.play();
  }
  
  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(1F,0.7294F, 0.2863F, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    worldRenderer.render(delta);
  }
  
  @Override
  public void dispose() {
    music.dispose();
  }
}
