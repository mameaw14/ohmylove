package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Bomb extends Ball{
  Random rand = new Random();
  
  Bomb() {
    super("bomb.png");
    SPEED = 0F;
    initVector();
    
    sprite.setPosition(rand.nextInt(OhmyloveGame.WIDTH - (int)sprite.getWidth() -1), 
        rand.nextInt(OhmyloveGame.HEIGHT - (int)sprite.getHeight() -1) );
  }
  
  private void initVector(){
    vector = new Vector2();
    vector.setToRandomDirection();
  }
  
  public void touchBullet(){
    isDestroyed = true;
    sprite.setPosition(-200,-200);
  }
}
