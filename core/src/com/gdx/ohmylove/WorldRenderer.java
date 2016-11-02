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
public class WorldRenderer{
    public SpriteBatch batch;
    private OhmyloveGame ohmyloveGame;
    private World world;
    private Texture meImg;
    private Me me;
    private BombGenerator bombGenerator;
    private Sprite meSprite;
    
    WorldRenderer(OhmyloveGame ohmyloveGame, World world){
	this.ohmyloveGame = ohmyloveGame;
	this.world = world;
	me = world.getMe();
	batch = ohmyloveGame.batch;
	bombGenerator = world.getBombGenerator();
	
	meImg = new Texture("me.png");
	meSprite = new Sprite(meImg);
	meSprite.setOriginCenter();
    }
    public void render(float delta){
	me.render(delta);
	bombGenerator.render(delta);
        batch.begin();
	Vector2 mePosition = me.getPosition();
	meSprite.setPosition(mePosition.x, mePosition.y);
        meSprite.draw(batch);
	float angle = me.getAngle();
	meSprite.setRotation(angle);
        batch.end();
    }
}
