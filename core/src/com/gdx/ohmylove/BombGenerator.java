/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author nimo
 */
public class BombGenerator {
    public SpriteBatch batch;
    private Sprite bombSprite;
    private Texture bombImg;
    BombGenerator(int n,SpriteBatch batch){
	this.batch = batch;
	bombImg = new Texture("bomb.png");
	bombSprite = new Sprite(bombImg);
	bombSprite.setOriginCenter();
    }
    
    public void render(float delta){
	batch.begin();
	bombSprite.setPosition(200, 400);
        bombSprite.draw(batch);
        batch.end();
    }
    
}
