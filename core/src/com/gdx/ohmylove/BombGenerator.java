package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class BombGenerator {
  public SpriteBatch batch;
  ArrayList<Bomb> bombList = new ArrayList<Bomb>();
    
  BombGenerator(int n) {
    this.batch = OhmyloveGame.batch;
    for (int i = 0; i < n; i++) {
      bombList.add(new Bomb());
    }
  }
    
  public void render(float delta) {
    
    for (Bomb bomb : bombList) {
      if (World.isOutOfWorld(bomb.getPosition(), bomb.radius) ) {
        bomb.setAngle(bomb.getAngle() + 180F);
        bomb.render(delta);
        
        //System.out.println("out");
      } else {
        bomb.render(delta);
      }
    }
  }
}
