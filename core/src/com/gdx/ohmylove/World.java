/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author nimo
 */
public class World {
    private Me me;
    private Lover lover;
    private BombGenerator bombGenerator;
    private OhmyloveGame ohmyloveGame;
    final private Vector2 meStartPoint = new Vector2(10,10);
    World(OhmyloveGame ohmyloveGame){
	this.ohmyloveGame = ohmyloveGame;
	bombGenerator = new BombGenerator(6);
	me = new Me((int)meStartPoint.x,(int)meStartPoint.y);
	lover = new Lover();
    }
    public Me getMe(){
	return me;
    }
    public BombGenerator getBombGenerator(){
	return bombGenerator;
    }
}
