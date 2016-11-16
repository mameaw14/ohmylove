package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;

public class World {
  private Me me;
  private static Lover lover;
  private static BombGenerator bombGenerator;
  private OhmyloveGame ohmyloveGame;
  private static StatusBar statusBar;
  final private Vector2 meStartPoint = new Vector2(10,10);
  public static int numBomb = 3;
  private static int level = 3;
  
  World(OhmyloveGame ohmyloveGame) {
    this.ohmyloveGame = ohmyloveGame;
    bombGenerator = new BombGenerator(level);
    me = new Me((int)meStartPoint.x,(int)meStartPoint.y);
    lover = new Lover();
    statusBar = new StatusBar();
  }

  public void update() {
    if(numBomb == 0) {
      bombGenerator = null;
      bombGenerator = new BombGenerator(++level);
      numBomb = level;
    }
  }
  public Me getMe() {
    return me;
  }
  
  public static Lover getLover() {
    return lover;
  }
  
  public static StatusBar getStatusBar() {
    return statusBar;
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
