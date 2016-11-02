/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nimo
 */
public class BombGenerator {
    public SpriteBatch batch;
    ArrayList<Bomb> bombList = new ArrayList<Bomb>();
    BombGenerator(int n){
	this.batch = OhmyloveGame.batch;
	for(int i=0;i<n;i++){
	    bombList.add(new Bomb());
	}
    }
    
    public void render(float delta){
	for(Bomb bomb : bombList){
	    bomb.render(delta);
	}
    }
    
}
