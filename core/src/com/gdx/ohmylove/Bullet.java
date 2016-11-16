package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class Bullet extends Ball{
  private boolean isBounce = false;
  
  Bullet(Vector2 mePos, float angle) {
    super(mePos, angle, "bullet.png");
    SPEED = 15F;
    sprite.setScale(1.4F);
  }
  
  @Override
  public void render(float delta) {
    if (World.isOutOfWorld(this) ) {
      return;
    }
    checkIsTouch();
    sprite.setRotation(vector.angle());
    sprite.translate(vector.x * SPEED, vector.y * SPEED);
    sprite.draw(batch);
  }
   
  private void checkIsTouch() {
    checkTouchBomb();
    checkTouchLover();
  }
  
  private void checkTouchBomb() {
    ArrayList<Bomb> bombList = World.getBombGenerator().getList();
    for (Bomb bomb : bombList) {
      if (getPosition().dst(bomb.getPosition() ) <= radius + bomb.radius) {
        if (!isBounce) {
          Vector2 bulletPos = getPosition();
          Vector2 bombPos = bomb.getPosition();
          float btw = new Vector2(bombPos.x - bulletPos.x, bombPos.y - bulletPos.y).angle();
          setAngle(-vector.angle() + 2*btw + 180F);
          isBounce = true;
        } else {
          bomb.touchBullet();
          isDestroyed = true;
        }
      }
    }
  }
  
  private void checkTouchLover() {
    Lover lover = World.getLover();
    if (getPosition().dst(lover.getPosition() ) <= radius + lover.radius) {
      if (!isBounce) {
        Vector2 bulletPos = getPosition();
        Vector2 loverPos = lover.getPosition();
        float btw = new Vector2(loverPos.x - bulletPos.x, loverPos.y - bulletPos.y).angle();
        setAngle(-vector.angle() + 2*btw + 180F);
        isBounce = true;
      } else {
        lover.touchBullet();
        isDestroyed = true;
      }
    }
  }
}
