package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class charMain {
    Texture imgWalk[] = new Texture[6];
    Texture imgStand[] = new Texture[3];
    Texture imgJump[] = new Texture[4];
    Texture imgAttack[] = new Texture[4];
    TextureRegion imgOut;
    int nCount, nCount2, nFrames[] = new int [4], nCurTex = 0;
    float nX, nY;
    boolean isAttack;
    public charMain() {
        for (int i = 0; i < imgWalk.length; i++) {
            imgWalk[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/walk2/" + i + ".png"));
        }
        for (int i = 0; i < imgStand.length; i++) {
            imgStand[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Stand/" + i + ".png"));
        }
        for (int i = 0; i < imgJump.length; i++) {
            imgJump[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Jump/" + i + ".png"));
        }
        for(int i = 0; i < imgAttack.length; i++){
            imgAttack[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Attack/" + i + ".png"));
        }
        nX = 70;
        nY = 120;
        nFrames[0] = imgStand.length;
        nFrames[1] = imgWalk.length;
        nFrames[2] = imgJump.length;
        nFrames[3] = imgAttack.length;
    }
    
    public void update(int nSpeedX, boolean isFlip) {
        nX += nSpeedX;
        nCount++;
        if(nSpeedX != 0) {
            nCurTex = 1;
        } else {
            nCurTex = 0;
        }
        if(nCount == 8){
            nCount = 0;
            nCount2++;
        }      
        if (!isAttack) {
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                isAttack = true;
                nCount2 = 0;
            }
        }
        if(isAttack){
            nCurTex = 3;
            
        }
        if(nCount2 >= nFrames[nCurTex]) {
            nCount2 = 0;
            if(nCurTex == 3) {
                isAttack = false;
            }
        }
        if(nCurTex == 0) {
            imgOut = new TextureRegion(imgStand[nCount2]);
        } else if (nCurTex == 1) {
            imgOut = new TextureRegion(imgWalk[nCount2]);
        } else if (nCurTex == 2) {
            imgOut = new TextureRegion(imgJump[nCount2]);
        } else if (nCurTex == 3) {
            imgOut = new TextureRegion(imgAttack[2]);
        }
        imgOut.flip(isFlip, false);
    }
}
