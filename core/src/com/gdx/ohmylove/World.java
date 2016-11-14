package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;

public class World {
  private Me me;
  private static Lover lover;
  private static BombGenerator bombGenerator;
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
  
  public static Lover getLover() {
    return lover;
  }

  public static BombGenerator getBombGenerator() {
    return bombGenerator;
  }
  
  public static boolean isOutOfWorld(Ball ball){
    Vector2 pos = ball.getPosition();
    float radius = ball.radius;
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
}
