/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author nimo
 */
public class Bullet {
    private Sprite bulletSprite;
    private Texture bulletImg;
    public SpriteBatch batch;
    private Vector2 vector;
    final float SPEED = 10f;
    
    Bullet(Vector2 mePos, float angle){
	vector = new Vector2();
	vector.set((float)Math.cos(angle * Math.PI / 180),(float)Math.sin(angle * Math.PI / 180));
	this.batch = OhmyloveGame.batch;
	bulletImg = new Texture("bullet.png");
	bulletSprite = new Sprite(bulletImg);
	bulletSprite.setOriginCenter();
	bulletSprite.setPosition(mePos.x+40,mePos.y+40);
	bulletSprite.setRotation(angle);
    }
    
    public void render(float delta){
	bulletSprite.translate(vector.x * SPEED, vector.y * SPEED);
	batch.begin();
	bulletSprite.draw(batch);
	batch.end();
    }
    
}
