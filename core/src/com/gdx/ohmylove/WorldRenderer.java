/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.graphics.Texture;
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
    
    WorldRenderer(OhmyloveGame ohmyloveGame, World world){
	this.ohmyloveGame = ohmyloveGame;
	this.world = world;
	batch = ohmyloveGame.batch;
	meImg = new Texture("me.png");
    }
    public void render(float delta){
        batch.begin();
        batch.draw(meImg, 30, 30);
        batch.end();
    }
}
