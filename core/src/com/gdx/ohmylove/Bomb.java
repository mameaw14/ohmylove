package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends Ball{  
  private Timer timer;
  private Random rand = new Random();
  private BitmapFont font;
  private String text;
  int countdown = 30;
  
  Bomb() {
    super("bomb.png");
    SPEED = 2F;
    initVector();
    initLabel();
    
    sprite.setPosition(rand.nextInt(OhmyloveGame.WIDTH - (int)sprite.getWidth() -1), 
        rand.nextInt(OhmyloveGame.HEIGHT - (int)sprite.getHeight() -1) );
    
    timer = new Timer();
    timer.schedule(new SuicideTask(),0,1000);
  }
  
  private void initVector() {
    vector = new Vector2();
    vector.setToRandomDirection();
  }
  
  private void initLabel() {
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ChronoType.ttf"));
    FreeTypeFontParameter parameter = new FreeTypeFontParameter();
    parameter.size = 30;
    parameter.color = Color.WHITE;
    font = generator.generateFont(parameter);
    generator.dispose();
  }
  
  public void touchBullet() {
    isDestroyed = true;
    sprite.setPosition(-200,-200);
  }
  
  @Override
  public void render(float delta) {
    super.render(delta);
    font.draw(batch, text, getPosition().x - 20, getPosition().y);
  }
  
  private class SuicideTask extends TimerTask {

    @Override
    public void run(){
      text = countdown-- + "s";
    }
  }
}
