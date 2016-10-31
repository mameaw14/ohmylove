/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author nimo
 */
public class Me {
    private Vector2 position;
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
    Me(int x,int y){
	position = new Vector2(x,y);
    }
    public Vector2 getPosition(){
	return position;
    }
    private void move(int dir) { 
	position.x = position.x + SPEED * DIR_OFFSETS[dir][0];
	position.y =  position.y + SPEED * DIR_OFFSETS[dir][1];
    }
    private void updateMeDirection(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
	    move(Me.DIRECTION_LEFT);
        }
	else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
	    move(Me.DIRECTION_RIGHT);
        }
	else if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
	    move(Me.DIRECTION_UP);
	}
	else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
	    move(Me.DIRECTION_DOWN);
	}
	else move(Me.DIRECTION_STILL);
    }
    public void update(){
	updateMeDirection();
    }
}
