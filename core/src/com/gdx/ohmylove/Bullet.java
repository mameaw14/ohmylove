package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class Bullet extends Ball{
  private boolean isBounce = false;
  final float SPEED = 10F;
  
  Bullet(Vector2 mePos, float angle) {
    super(mePos, angle, "bullet.png");
  }
  
  @Override
  public void render(float delta) {
    if (World.isOutOfWorld(getPosition(), radius) ) {
        return;
    }
    checkIsTouch();
    sprite.translate(vector.x * SPEED, vector.y * SPEED);
    sprite.draw(batch);
  }
   
  private void checkIsTouch() {
    ArrayList<Bomb> bombList = World.getBombGenerator().getList();
    for (Bomb bomb : bombList) {
      if (getPosition().dst(bomb.getPosition() ) <= radius + bomb.radius) {
        if (!isBounce) {
          setAngle(vector.angle() + 120F);
          isBounce = true;
        } else {
          bomb.touchBullet();
          isDestroyed = true;
        }
      }
    }
  }
}
