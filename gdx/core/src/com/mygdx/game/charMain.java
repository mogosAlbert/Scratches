package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class charMain {

    Texture imgRun[] = new Texture[5];
    Texture imgStand[] = new Texture[5];
    Texture imgJump[] = new Texture[5];
    TextureRegion img;
    TextureRegion imgOut;
    public int nX = 0, nY = 0, nHeight, nWidth, nSpeed, nJHeight, nCount, nCount2;
    boolean isJump;
    float fTime = 0;

    public void charMain() {
        for (int i = 0; i < imgStand.length; i++) {
            imgStand[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/standing/" + i + ".png"));
            imgRun[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/run/" + i + ".png"));
        }
        nHeight = 70;
        nWidth = 35;
        nSpeed = 2;
        nJHeight = 35;
        nCount = 0;
        nCount2 = 0;
    }

    public void update(int nSpeedX, int nSpeedY, boolean isFlip, boolean isRun) {

        nX += nSpeedX;
        if (nSpeedX != 0) {
            isRun = true;
        }
        nCount++;
        if (nCount >= 10) {
            nCount = 0;
            nCount2++;
        }
        if (nCount2 == 5) {
            nCount2 = 0;
        }
        if (isRun) {
            img = new TextureRegion(imgRun[nCount2]);
        } else {
            img = new TextureRegion(imgStand[nCount2]);
        }
        img.flip(isFlip, false);
    }

    private void methJump() {
        int nMax = nY + nJHeight;
        int nMin = nY;
        boolean isJumpU = true, isJumpD = false;
        if (nY < nMax) {
            nY += nSpeed;
            isJumpU = false;
            isJumpD = true;
        }
        if (!isJumpD || nY <= nMin) {
            nY -= nSpeed;
        }
    }
}
