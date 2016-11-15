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
  
  StatusBar() {
    initLabel();
  }
  
  public void render(float delta) {
    setText();
    liveFont.draw(batch, liveText, OhmyloveGame.WIDTH - 270, OhmyloveGame.HEIGHT - 30);
    heartFont.draw(batch, heartText, OhmyloveGame.WIDTH - 220, OhmyloveGame.HEIGHT - 20);
    
  }
  
  private void setText() {
    liveText = "Live: ";
    heartText = "";
    int live = World.getLover().getLive();
    
    for (int i = 0; i < 9; i++) {
      if (i < live) {
        heartText += "B ";
      } else {
        heartText += "A ";
      }
    }
  }
  private void initLabel() {
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ChronoType.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    parameter.size = 24;
    parameter.color = Color.RED;
    liveFont = generator.generateFont(parameter);
    
    generator = new FreeTypeFontGenerator(Gdx.files.internal("webdings.ttf"));
    heartFont = generator.generateFont(parameter);
    generator.dispose();
  }
}

