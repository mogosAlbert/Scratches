package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class charEnemy {

    Vector2 vLoc;
    Texture imgWalk[] = new Texture[7];
    Texture imgAttack[] = new Texture[3];
    Texture imgDie[] = new Texture[3];
    int nFrames[] = new int[3], nCurTex = 0, nHealth, nCount = 0, nCount2 = 0, nWidth, nHeight;
    TextureRegion imgOut;
    boolean isFlip;

    public charEnemy(int nX, int nY) {
        vLoc = new Vector2(nX, nY);
        for (int i = 0; i < imgWalk.length; i++) {
            imgWalk[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Enemy/Walk/" + i + ".png"));
        }
        for (int i = 0; i < imgAttack.length; i++) {
            imgAttack[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Enemy/attack/" + i + ".png"));
            imgDie[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Enemy/die/" + i + ".png"));
        }
        nFrames[0] = imgWalk.length;
        nFrames[1] = imgAttack.length;
        nFrames[2] = imgDie.length;
    }

    public void update(int nSpeedx, Vector2 vMainLoc) {
        vLoc.x += nSpeedx;
        nCount++;
        nCurTex = 0;
        if (nCount == 5) {
            nCount = 0;
            nCount2++;
        }
        if (isAttack(vMainLoc)) {
            nCurTex = 1;
        }
        if (nCount2 >= nFrames[nCurTex]) {
            nCount2 = 0;
        }
        if (nSpeedx < 0) {
            isFlip = true;
        } else if (nSpeedx > 0) {
            isFlip = false;
        }
        if(nCurTex == 1) {
            imgOut = new TextureRegion(imgAttack[nCount2]);
        } else {
            imgOut = new TextureRegion(imgWalk[nCount2]);
        }
        imgOut.flip(isFlip, false);
    }

    public int nDirSpeed(Vector2 vCLoc) {
        int nSpeed;
        if (vLoc.x < vCLoc.x + 60 && vLoc.x + 40 > vCLoc.x) {
            nSpeed = 0;
        } else {
            if (vCLoc.x > vLoc.x) {
                nSpeed = 1;
            } else if (vCLoc.x < vLoc.x) {
                nSpeed = -1;
            } else {
                nSpeed = 0;
            }
        }
        return nSpeed;
    }

    public boolean isAttack(Vector2 vEnemLoc) {
        if (vLoc.x < vEnemLoc.x + 60 && vLoc.x + 40 > vEnemLoc.x) {
            return true;
        }
        return false;
    }
}
