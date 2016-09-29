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
    TextureRegion imgOut;
    int nX, nY, nHeight, nWidth, nSpeed, nJHeight, nCount, nCount2;
    boolean isJump, isFlip, isRun;
    public void charMain() {
        for(int i = 0; i < 5; i++){
            imgRun[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/run/" + i + ".png"));
            imgStand[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/standing/" + i + ".png"));
            imgJump[i] = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/jump/" + i + ".png"));
        }
        nX = 0;
        nY = 0;
        nHeight = 70;
        nWidth = 35;
        nSpeed = 2;
        nJHeight = 35;
        nCount = 0;
        nCount2 = 0;
    }
    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            nX += nSpeed;
            isFlip = false;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            nX -= nSpeed;
            isFlip = true;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            methJump();
        }
        nCount++;
        if(nCount == 10) {
            nCount = 0;
            nCount2 ++;
        }
        if(nCount2 == 5){
            nCount2 = 0;
        }
        imgOut = new TextureRegion(imgStand[nCount2]);
        imgOut.flip(isFlip, false);
    }
    private void methJump() {
        int nMax = nY + nJHeight;
        int nMin = nY;
        if(nY < nMax){
            nY += nSpeed;
        } else if (nY > nMin){
            nY -= nSpeed;
        } 
    } 
    
}
