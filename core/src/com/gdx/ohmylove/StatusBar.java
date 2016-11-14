package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class StatusBar { 
  
  SpriteBatch batch = OhmyloveGame.batch;
  private BitmapFont font;
  private String text;
  
  StatusBar() {
    initLabel();
  }
  
  public void render(float delta) {
    setText();
    font.draw(batch, text, OhmyloveGame.WIDTH - 160, OhmyloveGame.HEIGHT - 20);
  }
  
  private void setText() {
    text = "live: ";
    int live = World.getLover().getLive();
    
    for (int i = 0; i < live; i++) {
      text += "*";
    }
  }
  private void initLabel() {
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("typewcond_regular.otf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    parameter.size = 18;
    parameter.color = Color.RED;
    font = generator.generateFont(parameter);
    generator.dispose();
  }
}

