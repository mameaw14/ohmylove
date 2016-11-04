package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class Me {
    private Vector2 position;
    private float angle;
    private ArrayList<Bullet> bulletList;
    public static final int DIRECTION_UP = 3;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 1;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    
    Me(int x,int y) {
	position = new Vector2(x,y);
	bulletList = new ArrayList<Bullet>();
    }
    
    public Vector2 getPosition() {
	return position;
    }
    
    private void move(int dir) { 
	position.x = position.x + SPEED * DIR_OFFSETS[dir][0];
	position.y =  position.y + SPEED * DIR_OFFSETS[dir][1];
    }
    
    private void updateMeDirection() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
	    move(Me.DIRECTION_LEFT);
        }
	else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
	    move(Me.DIRECTION_RIGHT);
        }
	else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
	    move(Me.DIRECTION_UP);
	}
	else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
	    move(Me.DIRECTION_DOWN);
	}
	else move(Me.DIRECTION_STILL);
    }
    
    public void render(float delta) {
	updateMeDirection();
	updateAngle();
	if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.justTouched()) {
	    shoot();
	}
	for (Bullet bullet : bulletList) {
	    bullet.render(1);
	}
    }
    
    private void shoot() {
	bulletList.add(new Bullet(position,angle));
    }
    
    private void updateAngle() {
	Vector2 cursorPosition = new Vector2(Gdx.input.getX(),OhmyloveGame.HEIGHT-Gdx.input.getY());
	Vector2 centerPos = new Vector2(position.x+40,position.y+40);
	//cursorPosition.x -= centerPos.x;
	//cursorPosition.y -= centerPos.y;
	Vector2 center = new Vector2(1,0);
	angle = -90 + (float) ( (float) Math.atan2(cursorPosition.x - centerPos.x, -(cursorPosition.y - centerPos.y) ) * (180 / Math.PI) );
    }
    
    public float getAngle(){
	return angle;
    }
}
