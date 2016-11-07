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
import java.util.Random;

public class Bomb extends Circle{
  private Sprite bombSprite;
  private Texture bombImg;
  public SpriteBatch batch;
  private float SPEED = 1F;
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
    
    y = rand.nextInt(OhmyloveGame.HEIGHT+1);
    x = rand.nextInt(OhmyloveGame.WIDTH+1);
    bombSprite.setPosition(x, y);
  }
  
  private void initVector(){
    int angle = rand.nextInt(361);
    vector = new Vector2();
    vector.set((float)Math.cos(angle * Math.PI / 180), (float)Math.sin(angle * Math.PI / 180));
  }
  
  public void render(float delta) {
    bombSprite.translate(vector.x * SPEED, vector.y * SPEED);
    bombSprite.draw(batch);
  }
}
