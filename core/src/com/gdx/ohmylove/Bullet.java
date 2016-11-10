package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Circle{
  private Sprite bulletSprite;
  private Texture bulletImg;
  public SpriteBatch batch;
  private Vector2 vector;
  final float SPEED = 10F;
  
  Bullet(Vector2 mePos, float angle) {
    super(mePos, 5f);
    this.batch = OhmyloveGame.batch;
    vector = new Vector2(1,0);
    vector.setAngle(angle);
    vector.nor();
    
    bulletImg = new Texture("bullet.png");
    bulletSprite = new Sprite(bulletImg);
    bulletSprite.setOriginCenter();
    bulletSprite.scale(2.0f);
       
    setPosition(mePos.x - bulletSprite.getOriginX(), mePos.y - bulletSprite.getOriginY() );
       
    bulletSprite.setPosition(x,y);
    bulletSprite.setRotation(angle);
  }
  
  public void render(float delta) {
    bulletSprite.translate(vector.x * SPEED, vector.y * SPEED);
    bulletSprite.draw(batch);
  }
  
  public Vector2 getPosition() {
    return new Vector2(bulletSprite.getX() + bulletSprite.getOriginX(), bulletSprite.getY() + bulletSprite.getOriginY() );
  }
  
  public float getAngle() {
    return vector.angle();
  }
  
  public void setAngle(float angle) {
    vector.setAngle(angle);
  }
}
