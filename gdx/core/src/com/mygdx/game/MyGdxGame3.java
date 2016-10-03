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
    Texture imgMap;
    charMain char1;
    int nFunc = 0, nMapX = 0;
    public boolean isFlip = false, isJump = false, isRun = true;

    @Override
    public void create() {
        char1 = new charMain();
        batch = new SpriteBatch();
        imgMap = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/map.png"));
    }

    @Override
    public void render() {
        int nEWidth = 35, nEHeight = 70, nTempX = 0, nTempY = 0;
        isJump = false;
        isRun = false;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (char1.nX > 800) {
                nMapX -= 2;
                
            } else {
                nTempX = 2;
            }
            isRun = true;
            isFlip = false;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (char1.nX < 200) {
                nMapX += 2;
                
            } else {
                nTempX = -2;
            }
            isRun = true;
            isFlip = true;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            isJump = true;
        }
        Gdx.gl.glClearColor(2, 0, 0, 2);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        char1.update(nTempX, nTempY, isFlip, isJump, isRun);
        batch.draw(imgMap, nMapX, 0, 4800, 700);
        batch.draw(char1.img, char1.nX, char1.nY);
        batch.end();
    }
}