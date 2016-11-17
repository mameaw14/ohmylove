package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class GameOverScreen extends ScreenAdapter{
  private OhmyloveGame ohmyloveGame;
  private BitmapFont font;
  private BitmapFont restartFont;
  public SpriteBatch batch;
  private String text;
  
  public GameOverScreen(OhmyloveGame ohmyloveGame) {
    this.ohmyloveGame = ohmyloveGame;
    batch = ohmyloveGame.batch;
    initFont();
    
    int score = StatusBar.getScore();
    text = "Score: " + score + "\nGame Over";
  }
  
  @Override
  public void render(float delta) {
    
    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
      ohmyloveGame.newGame();
    }
    
    Gdx.gl.glClearColor(32F / 255F, 21F / 255F, 17F / 255F, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
    batch.begin();
    font.draw(batch, text, OhmyloveGame.WIDTH / 2F - 100F, OhmyloveGame.HEIGHT / 2F + 50F);
    restartFont.draw(batch, "press spacebar to restart", OhmyloveGame.WIDTH / 2F - 110F, OhmyloveGame.HEIGHT / 2F - 30F);
    batch.end();
  }
  
  private void initFont() {
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ChronoType.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    parameter.size = 56;
    parameter.color = Color.valueOf("fff9e6");
    font = generator.generateFont(parameter);
    
    parameter.size = 24;
    restartFont = generator.generateFont(parameter);
    
    generator.dispose();
  }
}
