package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Lover extends Ball {
  private final int LIVE = 9;
  private int remainLive;
  Random rand = new Random();
  Sound meow = Gdx.audio.newSound(Gdx.files.internal("sound/meow.mp3"));
  
  Lover() {
    super("lover.png");
    SPEED = 1F;
    remainLive = LIVE;
    initVector();
    
    sprite.setPosition(rand.nextInt(OhmyloveGame.WIDTH - (int)sprite.getWidth() -1), 
        rand.nextInt(OhmyloveGame.HEIGHT - (int)sprite.getHeight() -1) );
  }
    
  private void initVector() {
    vector = new Vector2();
    vector.setToRandomDirection();
  }

  @Override
  public void render(float delta) {
    World.isOutOfWorld(this);
    super.render(delta);
  }
  
  public void touchBullet() {
    if (immortal) return;
    loseLive();
  }
  
  public void loseLive() {
    if (remainLive < 0) return;
    
    remainLive--;
    if (remainLive == 0) {
      isDestroyed = true;
    }
    meow.play();
  }
  
  public int getLive() {
    return remainLive;
  }
}
