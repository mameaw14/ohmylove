package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Lover extends Ball {
  private final int LIVE = 9;
  private int remainLive = 9;
  Random rand = new Random();
  
  Lover() {
    super("lover.png");
    SPEED = 5F;
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
    if (World.isOutOfWorld(this) ) {
      setAngle(getAngle() + 90F);
      super.render(delta);
    } else {
      super.render(delta);
    }
  }
  
  public void touchBullet() {
    remainLive--;
    if (remainLive == 0) {
      isDestroyed = true;
    }
  }
}
