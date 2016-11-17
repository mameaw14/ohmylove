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
  int countdown;
  
  Bomb() {
    super("bomb.png");
    SPEED = 2F;
    initVector();
    initLabel();
    
    sprite.setPosition(rand.nextInt(OhmyloveGame.WIDTH - (int)sprite.getWidth() -1), 
        rand.nextInt(OhmyloveGame.HEIGHT - (int)sprite.getHeight() -1) );
    
    countdown = (rand.nextInt(20) + 15 );
    timer = new Timer();
    timer.schedule(new SuicideTask(),0,1000);
    timer.schedule(new DieTask(), countdown * 1000);
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
    if (immortal) return;
    die();
  }
  
  private void die() {
    timer.cancel();
    isDestroyed = true;
    sprite.setPosition(-200, -200);
    World.numBomb--;
    System.out.println(World.numBomb);
    
    World.setScore(countdown);
  }
  
  @Override
  public void render(float delta) {
    super.render(delta);
    font.draw(batch, text, getPosition().x - 20, getPosition().y);
  }

  private class DieTask extends TimerTask {

    @Override
    public void run() {
      die();
      World.getLover().loseLive();
    }
  }
  
  private class SuicideTask extends TimerTask {

    @Override
    public void run() {
      text = countdown-- + "s";
    }
  }
}
