package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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

    @Override
    public void create() {
        char1 = new charMain();
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        int nEWidth = 35, nEHeight = 70, nTempX, nTempY;
        Gdx.gl.glClearColor(2, 0, 0, 2);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        char1.update();
        batch.begin();
        img = char1.imgOut;
        batch.draw(img, char1.nX, char1.nY);
        batch.end();
    }
}