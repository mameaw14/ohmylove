/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import static java.lang.Math.ceil;
import java.util.Random;

public class Bomb extends Circle{
  private Sprite bombSprite;
  private Texture bombImg;
  public SpriteBatch batch;
  private float SPEED = 5F;
  private Vector2 vector;
  Random rand = new Random();
  
  Bomb() {
    super();
    radius = 50F;
    initVector();
    
    this.batch = OhmyloveGame.batch;
    bombImg = new Texture("bomb.png");
    bombSprite = new Sprite(bombImg);
    bombSprite.setOriginCenter();
    
    y = rand.nextInt(OhmyloveGame.HEIGHT - (int)bombSprite.getHeight() -1);
    x = rand.nextInt(OhmyloveGame.WIDTH - (int)bombSprite.getWidth() -1);
    bombSprite.setPosition(x, y);
    System.out.println("x = " + x + "y = " + y);
  }
  
  private void initVector(){
    vector = new Vector2();
    vector.setToRandomDirection();
  }
  
  public void render(float delta) {
    bombSprite.translate(vector.x * SPEED, vector.y * SPEED);
    bombSprite.draw(batch);
  }
  
  public Vector2 getPosition(){
    return new Vector2(bombSprite.getX() + bombSprite.getOriginX(), bombSprite.getY() + bombSprite.getOriginY());
  }
  
  public float getAngle(){
    return vector.angle();
  }
  
  public void setAngle(float angle) {
    vector.setAngle(angle);
  }
}
