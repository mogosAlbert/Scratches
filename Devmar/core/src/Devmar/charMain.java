package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class charMain {
    Texture imgWalk[] = new Texture[6];
    Texture imgStand[] = new Texture[3];
    Texture imgJump[] = new Texture[4];
    Texture imgAttack[] = new Texture[4];
    Texture imgHeavy[] = new Texture[9];
    TextureRegion imgOut;
    int nCount, nCount2, nFrames[] = new int [5], nCurTex = 0, nJumpH;
    float nX, nY, fShotX, fShotY;
    Vector2 vLoc;
    boolean isAttack, isJumpU, isJumpD, isHeavy;
    Sound sJump, sAttack;
    public charMain() {
        for (int i = 0; i < imgWalk.length; i++) {
            imgWalk[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Wolverine/walk2/" + i + ".png"));
        }
        for (int i = 0; i < imgStand.length; i++) {
            imgStand[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Wolverine/Stand/" + i + ".png"));
        }
        for (int i = 0; i < imgJump.length; i++) {
            imgJump[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Wolverine/Jump/" + i + ".png"));
        }
        for(int i = 0; i < imgAttack.length; i++) {
            imgAttack[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Wolverine/Attack/" + i + ".png"));
        }
        for (int i = 0; i < imgHeavy.length; i++) {
            imgHeavy[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Wolverine/Heavy/" + i + ".png"));
        }
        vLoc = new Vector2(70, 120);
        nFrames[0] = imgStand.length;
        nFrames[1] = imgWalk.length;
        nFrames[2] = imgJump.length;
        nFrames[3] = imgAttack.length;
        nFrames[4] = imgHeavy.length;
        sJump = Gdx.audio.newSound(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Music/Jump.wav"));
        sAttack = Gdx.audio.newSound(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Music/attack.mp3"));
    }
    
    public void update(int nSpeedX, boolean isFlip) {
        if (isFlip) {
            fShotX = vLoc.x;
            fShotY = vLoc.y + 20;   
        } else {
            fShotX = vLoc.x + 30;
            fShotY = vLoc.y + 20;
        }
        
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
                sAttack.play(1.0f);
            } else if(Gdx.input.isKeyJustPressed(Input.Keys.H)) {
                isHeavy = true;
                nCount2 = 0;
   
            }
        }
        if(isAttack){
            nCurTex = 3;
            nSpeedX = 0;
        } else if(isJumpU){
            nCurTex = 2;
        } else if(isHeavy) {
            nCurTex = 4;
            nSpeedX = 0;
        }
        if(nCount2 >= nFrames[nCurTex]) {
            nCount2 = 0;
            if(nCurTex == 3 || nCurTex == 4) {
                isAttack = false;
                isHeavy = false;
            }
        }
        if(nCurTex == 0) {
            imgOut = new TextureRegion(imgStand[nCount2]);
        } else if (nCurTex == 1) {
            imgOut = new TextureRegion(imgWalk[nCount2]);
        } else if (nCurTex == 2) {
            imgOut = new TextureRegion(imgJump[nCount2]);
        } else if (nCurTex == 3) {
            imgOut = new TextureRegion(imgAttack[nCount2]);
        } else if (nCurTex == 4) {
            imgOut = new TextureRegion(imgHeavy[nCount2]);
        }
        vLoc.x += nSpeedX;
        if (!isJumpU && !isJumpD) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                isJumpU = true;
                nCount2 = 0;
                sJump.play(1.0f);
            }
        }
        if (isJumpU) {
            if (vLoc.y <= nJumpH) {
                vLoc.y += 2;
            } else {
                isJumpD = true;
                isJumpU = false;
            }
        } else {
            nJumpH = (int) vLoc.y + 55;
        }
        if (isJumpD) {
            if (vLoc.y >= 47) {
                vLoc.y--;
                imgOut = new TextureRegion(imgJump[3]);
            } else {
                isJumpD = false;
            }
        }
        imgOut.flip(isFlip, false);
    }
}
