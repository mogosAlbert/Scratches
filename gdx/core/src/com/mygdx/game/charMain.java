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
    public int nX = 500, nY = 47, nHeight, nWidth, nSpeed, nJHeight, nCount, nCount2, nJumpH, nFloor, nMapX;
    boolean isJump, isRun, isJumpD = false, isJumpU = false;
    float fTime = 0;

    public charMain() {
        for (int i = 0; i < imgStand.length; i++) {
            imgStand[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/standing/" + i + ".png"));
            imgRun[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/run/" + i + ".png"));
            imgJump[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/jump/" + i + ".png"));
        }
        nHeight = 70;
        nWidth = 35;
        nSpeed = 2;
        nJHeight = 35;
        nCount = 0;
        nCount2 = 0;
    }

    public void update(int nSpeedX, int nSpeedY, boolean isFlip, boolean isJump, boolean isRunM) {
        nX += nSpeedX;
        isRun = isRunM;
        nCount++;
        if (nCount >= 7) {
            nCount = 0;
            nCount2++;
        }
        if (nCount2 == 5) {
            nCount2 = 0;
        }
        if (isJumpU || isJumpD) {
            img = new TextureRegion(imgJump[nCount2]);
        } else {
            if (isRun) {
                img = new TextureRegion(imgRun[nCount2]);
            } else {
                img = new TextureRegion(imgStand[nCount2]);
            }
        }
        img.flip(isFlip, false);
        if (isJump) {
            isJumpU = true;
        }
        if (isJumpU) {
            if (nY <= nJumpH) {
                nY += 2;
            } else {
                isJumpD = true;
                isJumpU = false;
            }
        } else {
            nJumpH = nY + 30;
        }
        if (isJumpD) {
            if (nY >= 47) {
                nY--;
            } else {
                isJumpD = false;
            }
        }
        isRun = false;
    }
}
