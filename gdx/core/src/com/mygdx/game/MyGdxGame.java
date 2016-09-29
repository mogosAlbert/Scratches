package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame extends ApplicationAdapter {

    public static int nHeight = 300;
    public static int nWidth = 1000;
    public static int nTempJ, nTempF = 0;
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
            isFlip = true;
            isRun = true;
            nTempX = nX;
            nX -= nSpeed;
            if (isOffScreen(nX, nY, nEWidth, nEHeight)) {
                nX = nTempX;
            }
            if (isHit(nX, nY, 70, 40, 200, 0, 30, 30)) {
                nX = nTempX;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            nTempX = nX;
            nX += nSpeed;
            isFlip = false;
            isRun = true;
            if (isOffScreen(nX, nY, nEWidth, nEHeight)) {
                nX = nTempX;
            }
            if (isHit(nX, nY, 70, 40, 200, 0, 30, 30)) {
                nX = nTempX;
            }
        }
        if (!isJump && !isJumpD) {
            
            
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                nTempJ = nTempF + 40;
                isJump = true;
                nTempF = nY;
                System.out.println("Check");
            } 
            
        }
        batch.begin();
        if(isHit(nX, nY, 70, 40, 200, 0, 30, 30)){
            nY+= 3;
            nTempF = nY + 3;
            System.out.println("true");
        } else {
            nTempF = 0;
        }
        if (isJump) {
            if (nY <= nTempJ) {
                nY += 2;
            } else {
                isJump = false;          
                isJumpD = true;                
            }
            imgFlip = new TextureRegion(imgJump[nCount2]);
        } else {
            if (nY > nTempF && isJumpD) {
                nY -= 2;
                imgFlip = new TextureRegion(imgJump[nCount2]);
            } else {
                isJumpD = false;
                if (isRun) {
                    imgFlip = new TextureRegion(imgRun[nCount2]);
                    isRun = false;
                } else {
                    imgFlip = new TextureRegion(imgStand[nCount2]);
                }
            }
        }
        imgFlip.flip(isFlip, false);
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

    public boolean isHit(int nX, int nY, int nHeight, int nWidth, int nOx, int nOy, int nOw, int nOh) {
        if (nX + nWidth <= nOx || nX >= nOx + nOw || nY >= nOy + nOh) {
            return false;
        }
        return true;
    }
}