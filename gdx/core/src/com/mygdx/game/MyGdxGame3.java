package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.charMain;

public class MyGdxGame3 extends ApplicationAdapter {

    public static int nHeight = 300;
    public static int nWidth = 1000;
    SpriteBatch batch;
    Texture imgB;
    TextureRegion img;
    charMain char1;
    int nFunc = 0;
    boolean isFlip = false, isRun = false;

    @Override
    public void create() {
        char1 = new charMain();
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        int nEWidth = 35, nEHeight = 70, nTempX = 0, nTempY = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            nTempX = 2;
            isFlip = false;
            isRun = true;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            nTempX = -2;
            isFlip = true;
            isRun = true;
        } else {
            isRun = false;
        }
        Gdx.gl.glClearColor(2, 0, 0, 2);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        char1.update(nTempX, nTempY, isFlip, isRun);
        batch.draw(char1.img, char1.nX, char1.nY);
        batch.end();
    }
}