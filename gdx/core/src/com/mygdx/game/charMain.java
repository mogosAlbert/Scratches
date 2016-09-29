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
    int nX, nY, nHeight, nWidth, nSpeed, nJHeight;
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
    }
    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            nX += nSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            nX -= nSpeed;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            methJump();
        }
    }
    private void methJump() {
        int nMax = nY + nJHeight;
        int nMin = nY;
        if(nY < nMax){
            nY += nSpeed;
        } else if (nY > nMin){
            nY -= nSpeed;
        } else {
            
        }
    } 
    
}
