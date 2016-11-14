package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
	
public class WorldRenderer {
  public SpriteBatch batch;
  private OhmyloveGame ohmyloveGame;
  private World world;
  private Me me;
  private Lover lover;
  private BombGenerator bombGenerator;
  private StatusBar statusBar;
   
  WorldRenderer(OhmyloveGame ohmyloveGame, World world) {
    this.ohmyloveGame = ohmyloveGame;
    this.world = world;
    me = world.getMe();
    batch = ohmyloveGame.batch;
    bombGenerator = world.getBombGenerator();
    lover = world.getLover();
    statusBar = world.getStatusBar();
  }
    
  public void render(float delta) {
    batch.begin();
    me.render(delta);
    bombGenerator.render(delta);
    lover.render(delta);
    statusBar.render(delta);
    batch.end();
  }
}
