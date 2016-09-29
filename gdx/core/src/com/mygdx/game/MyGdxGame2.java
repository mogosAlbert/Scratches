package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame2 extends ApplicationAdapter {

    public static int nHeight = 300;
    public static int nWidth = 1000;
    int nTempJ, nTempF = 0, nJh = 40;
    SpriteBatch batch;
    Texture img;
    int nX = 0, nY = 0, nSpeed = 2;
    Texture imgRun[] = new Texture[5];
    Texture imgStand[] = new Texture[5];
    Texture imgJump[] = new Texture[5];
    Texture imgB;
    int nCount, nCount2;
    Image img1;
    TextureRegion imgFlip;
    boolean isFlip = false;
    boolean isRun = false;
    boolean isJump = false;
    boolean isJumpD = false;

    @Override
    public void create() {
        batch = new SpriteBatch();
        for (int i = 0; i < imgRun.length; i++) {
            imgRun[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/run/" + i + ".png"));
        }
        for (int i = 0; i < imgStand.length; i++) {
            imgStand[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/standing/" + i + ".png"));
        }
        for (int i = 0; i < imgJump.length; i++) {
            imgJump[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/jump/" + i + ".png"));
        }
        imgB = new Texture(Gdx.files.internal("block.png"));
    }

    @Override
    public void render() {
        int nEWidth = 35, nEHeight = 70, nTempX, nTempY;
        Gdx.gl.glClearColor(2, 0, 0, 2);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            nTempX = nX;
            nX -= 2;
            if (isHitLR(nX, nY, 200, 0, 35, 30, 30)) {
                nX = nTempX;
            }            
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            nTempX = nX;
            nX += 2;
            if (isHitLR(nX, nY, 200, 0, 35, 30, 30)) {
                nX = nTempX;
            }   
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            isJump = true;
            nTempJ = nY + nJh;
        }
        if (isJump) {
            if (nY >= nTempJ) {
                isJump = false;
                isJumpD = true;
            } else {
                nY += 2;
            }
        }
        if (isJumpD) {
            if (isHitLR(nX, nY, 200, 0, 35, 30, 30)) {
                nY += 3;
                nTempF = nY;
            } else {
                nTempF = 0;
            }
            if (nY >= nTempF) {
                System.out.println("check");
                nY -= 2;
            } else {
                nY += 3;
                isJumpD = false;
            }
        }
        batch.begin();
        imgFlip = new TextureRegion(imgRun[nCount2]);
        nCount++;
        if (nCount > 5) {
            nCount = 0;
            nCount2++;
        }
        if (nCount2 > 4) {
            nCount2 = 0;
        }
        batch.draw(imgFlip, nX, nY);
        batch.draw(imgB, 200, 0, 30, 30);
        batch.end();
    }

    public boolean isOffScreen(int nX, int nY, int nEWidth, int nEHeight) {
        if (nX + nEWidth <= nWidth) {
            if (nX >= 0) {
                if (nY + nEHeight <= nHeight) {
                    if (nY >= 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isHitLR(int nX, int nY, int nOx, int nOy, int nW, int nOw, int nOh) {
        if (nX + nW > nOx && nX < nOx + nOw && nY < nOy + nOh) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHitUP(int nY, int nOy, int nOh) {
        if (nY < nOy + nOh) {
            return true;
        } else {
            return false;
        }
    }
}