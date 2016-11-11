package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class Bullet extends Ball{
  private boolean isBounce = false;
  
  Bullet(Vector2 mePos, float angle) {
    super(mePos, angle, "bullet.png");
    SPEED = 10F;
    sprite.scale(2F);
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
          Vector2 bulletPos = getPosition();
          Vector2 bombPos = bomb.getPosition();
          float btw = new Vector2(bombPos.x - bulletPos.x, bombPos.y - bulletPos.y).angle();
          System.out.println(btw + " " + vector.angle());
          setAngle(-vector.angle() + 2*btw + 180F);
          System.out.println(vector.angle());
          isBounce = true;
        } else {
          bomb.touchBullet();
          isDestroyed = true;
        }
      }
    }
  }
}
