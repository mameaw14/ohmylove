package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
	
public class WorldRenderer {
  public SpriteBatch batch;
  private OhmyloveGame ohmyloveGame;
  private World world;
  private Me me;
  private BombGenerator bombGenerator;
   
  WorldRenderer(OhmyloveGame ohmyloveGame, World world) {
    this.ohmyloveGame = ohmyloveGame;
    this.world = world;
    me = world.getMe();
    batch = ohmyloveGame.batch;
    bombGenerator = world.getBombGenerator();
  }
    
  public void render(float delta) {
    batch.begin();
    me.render(delta);
    bombGenerator.render(delta);
    batch.end();
  }
}
