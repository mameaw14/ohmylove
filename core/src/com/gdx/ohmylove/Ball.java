/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
  float radius;
  Sprite sprite;
  private Texture Img;
  SpriteBatch batch = OhmyloveGame.batch;;
  Vector2 vector;
  boolean isDestroyed = false;
  private float SPEED;
  
  Ball(Vector2 mePos, float angle, String imgStr) {
    vector = new Vector2(1,0);
    vector.setAngle(angle);
    vector.nor();
    
    Img = new Texture(imgStr);
    sprite = new Sprite(Img);
    sprite.setOriginCenter();
    sprite.setPosition(mePos.x - sprite.getOriginX(), mePos.y - sprite.getOriginY());
    sprite.setRotation(angle);
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
  
  public void setAngle(float angle) {
    vector.setAngle(angle);
  }
  
  public boolean isDestroyed() {
    return isDestroyed;
  }
  
  public void setSpeed(float speed) {
    SPEED = speed;
  }
}
