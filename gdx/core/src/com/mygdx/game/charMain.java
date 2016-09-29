package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class charMain {

    Texture imgRun[] = new Texture[5];
    Texture imgStand[] = new Texture[5];
    Texture imgJump[] = new Texture[5];
    TextureRegion imgOut;
    public int nX, nY, nHeight, nWidth, nSpeed, nJHeight, nCount, nCount2;
    boolean isJump, isFlip, isRun;
    TextureAtlas textRun = new TextureAtlas(Gdx.files.absolute("D:/Mogos/gdx/core/assets/standing/stand.pack"));
    Animation aniRun = new Animation(1 / 10f, textRun.getRegions());
    public void charMain() {
        
        nX = 0;
        nY = 0;
        nHeight = 70;
        nWidth = 35;
        nSpeed = 2;
        nJHeight = 35;
        nCount = 0;
        nCount2 = 0;
    }

    public void update() {
        float fTime = 0;
        fTime += Gdx.graphics.getDeltaTime();
        imgOut = aniRun.getKeyFrame(fTime, true);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            nX += nSpeed;
            isFlip = false;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            nX -= nSpeed;
            isFlip = true;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            methJump();
            isJump = true;
        }
        nCount++;
        if (nCount >= 10) {
            nCount = 0;
            nCount2++;
        }
        if (nCount2 == 5) {
            nCount2 = 0;
        }

        imgOut.flip(isFlip, false);
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
