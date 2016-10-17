package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class charEnemy {
    Vector2 vLoc;
    Texture imgWalk[] = new Texture[7];
    Texture imgAttack[] = new Texture[3];
    Texture imgDie [] = new Texture[3];
    int nFrames[] = new int[3], nCurTex = 0, nHealth, nCount = 0, nCount2 = 0;
    TextureRegion imgOut;
    boolean isFlip;
    public charEnemy(int nX, int nY) {
        vLoc = new Vector2(nX, nY);
        for(int i = 0; i < imgWalk.length; i++) {
            imgWalk[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Enemy/Walk/" + i + ".png"));
        }
        for(int i = 0; i < imgAttack.length; i++) {
            imgAttack[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Enemy/attack/" + i + ".png"));
            imgDie[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Enemy/die/" + i + ".png"));
        }
        nFrames[0] = imgWalk.length;
        nFrames[1] = imgAttack.length;
        nFrames[2] = imgDie.length;
    }
    public void update(int nSpeedx) {
        vLoc.x += nSpeedx;
        nCount++;
        if(nCount == 3) {
            nCount = 0;
            nCount2++;
        }
        if (nCount2 == imgWalk.length) {
            nCount2 = 0;
        }
        if(nSpeedx < 0) {
            isFlip = true;
        } else {
            isFlip = false;
        }
        imgOut = new TextureRegion(imgWalk[nCount2]);
        imgOut.flip(isFlip, false);
    }
    public int nDirSpeed(Vector2 vCLoc) {
        int nSpeed;
        if(vCLoc.x > vLoc.x) {
            nSpeed = 1;
        } else if (vCLoc.x < vLoc.x) {
            nSpeed = -1;
        } else {
            nSpeed = 0;
        }
        return nSpeed;
    }
}
