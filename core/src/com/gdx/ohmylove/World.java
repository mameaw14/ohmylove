/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.ohmylove;

/**
 *
 * @author nimo
 */
public class World {
    private Me me;
    private Lover lover;
    private BombGenerator bombgenerator;
    private OhmyloveGame ohmylovegame;
    World(OhmyloveGame ohmylovegame){
	this.ohmylovegame = ohmylovegame;
	bombgenerator = new BombGenerator(1);
	me = new Me();
	lover = new Lover();
    }
}
