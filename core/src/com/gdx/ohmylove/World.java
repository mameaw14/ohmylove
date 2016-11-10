package com.gdx.ohmylove;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class World {
  private Me me;
  private Lover lover;
  private BombGenerator bombGenerator;
  private OhmyloveGame ohmyloveGame;
  final private Vector2 meStartPoint = new Vector2(10,10);
  
  World(OhmyloveGame ohmyloveGame) {
    this.ohmyloveGame = ohmyloveGame;
    bombGenerator = new BombGenerator(10);
    me = new Me((int)meStartPoint.x,(int)meStartPoint.y);
    lover = new Lover();
  }

  public Me getMe() {
    return me;
  }

  public BombGenerator getBombGenerator() {
    return bombGenerator;
  }
  
  public static boolean isOutOfWorld(Vector2 pos, float radius){
    if (pos.x - 0 < radius) {
      return true;
    }
    if (pos.x - OhmyloveGame.WIDTH > -radius) {
      return true;
    }
    if (pos.y - 0 < radius) {
      return true;
    }
    if (pos.y - OhmyloveGame.HEIGHT > -radius) {
      return true;
    }
    return false;
  }
  
  public static boolean isOutOfWorld(float x, float y, float radius){
    return isOutOfWorld(new Vector2(x,y), radius);
  }
}
