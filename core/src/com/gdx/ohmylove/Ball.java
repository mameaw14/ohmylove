package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author nimo
 */
public class Ball {
  protected float radius;
  protected Sprite sprite;
  private Texture Img;
  protected SpriteBatch batch = OhmyloveGame.batch;;
  protected Vector2 vector;
  protected boolean isDestroyed = false;
  protected float SPEED;
  
  Ball(String imgStr){
    Img = new Texture(imgStr);
    sprite = new Sprite(Img);
    sprite.setOriginCenter();
    radius = sprite.getOriginX();
  }
  
  Ball(Vector2 mePos, float angle, String imgStr) {
    vector = new Vector2(1,0);
    vector.setAngle(angle);
    vector.nor();
    
    Img = new Texture(imgStr);
    sprite = new Sprite(Img);
    sprite.setOriginCenter();
    sprite.setPosition(mePos.x - sprite.getOriginX(), mePos.y - sprite.getOriginY());
    sprite.setRotation(angle);
    radius = sprite.getOriginX();
  }
  
  public void render(float delta) {
    sprite.translate(vector.x * SPEED, vector.y * SPEED);
    sprite.draw(batch);
  }
  
  public Vector2 getPosition() {
    return new Vector2(sprite.getX() + sprite.getOriginX(), sprite.getY() + sprite.getOriginY() );
  }
  
  public float getAngle() {
    return vector.angle();
  }
  
  public float getRadius() {
    return radius;
  }
  
  protected void setAngle(float angle) {
    vector.setAngle(angle);
  }
  
  public boolean isDestroyed() {
    return isDestroyed;
  }
  
  protected void setSpeed(float speed) {
    SPEED = speed;
  }
}
