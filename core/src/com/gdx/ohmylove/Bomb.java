/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class Bomb {
    private Sprite bombSprite;
    private Texture bombImg;
    public SpriteBatch batch;
    Random rand = new Random();
    
    Bomb() {
	this.batch = OhmyloveGame.batch;
	bombImg = new Texture("bomb.png");
	bombSprite = new Sprite(bombImg);
	bombSprite.setOriginCenter();
	
	int y = rand.nextInt(OhmyloveGame.HEIGHT+1); 
	int x = rand.nextInt(OhmyloveGame.WIDTH+1); 
	bombSprite.setPosition(x, y);
    }
    
    public void render(float delta) {
	batch.begin();
        bombSprite.draw(batch);
        batch.end();
    }
}
