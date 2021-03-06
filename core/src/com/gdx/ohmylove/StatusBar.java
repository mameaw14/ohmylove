package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class StatusBar { 
  
  SpriteBatch batch = OhmyloveGame.batch;
  private BitmapFont liveFont;
  
  private BitmapFont heartFont;
  private String liveText;
  private String heartText;
  private String scoreText;
  private static int score;
  
  StatusBar() {
    initLabel();
    score = 0;
  }
  
  public void render(float delta) {
    setText();
    
    liveFont.draw(batch, scoreText, 20, OhmyloveGame.HEIGHT - 30);
    liveFont.draw(batch, liveText, OhmyloveGame.WIDTH - 270, OhmyloveGame.HEIGHT - 30);
    heartFont.draw(batch, heartText, OhmyloveGame.WIDTH - 220, OhmyloveGame.HEIGHT - 20);
  }
  
  public void updateScore(int diff) {
    score += diff;
  }
  
  public static int getScore() {
    return score;
  }
  
  private void setText() {
    liveText = "Live: ";
    heartText = "";
    scoreText = "Score: ";
    scoreText += score;
    int live = World.getLover().getLive();
    
    for (int i = 0; i < 9; i++) {
      if (i < live) {
        heartText += "B ";
      } else {
        heartText += "A ";
      }
    }
    if (live == 0) {
      World.gameOver();
    }
  }
  
  private void initLabel() {
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ChronoType.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    parameter.size = 24;
    parameter.color = Color.valueOf("ff3b3b");
    liveFont = generator.generateFont(parameter);
    
    generator = new FreeTypeFontGenerator(Gdx.files.internal("webdings.ttf"));
    heartFont = generator.generateFont(parameter);
    generator.dispose();
  }
}

