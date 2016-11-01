/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author nimo
 */
public class GameScreen extends ScreenAdapter{
    OhmyloveGame ohmyloveGame;
    World world;
    WorldRenderer worldRenderer;
    public GameScreen(OhmyloveGame ohmyloveGame) {
	this.ohmyloveGame = ohmyloveGame;
	world = new World(ohmyloveGame);
	worldRenderer = new WorldRenderer(ohmyloveGame,world);
    }
    
    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(37, 40, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    }
    
}
