package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class charMain {
    Texture imgWalk[] = new Texture[6];
    TextureRegion imgOut;
    int nCount, nCount2, nFrames[] = new int [3];
    float nX, nY;
    
    public charMain() {
        for (int i = 0; i < imgWalk.length; i++){
            imgWalk[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/walk2/" + i + ".png"));
        }
        nX = 50;
        nY = 0;
    }
    
    public void update(int nSpeedX) {
        nX += nSpeedX;
        nCount++;
        if(nCount == 7){
            nCount = 0;
            nCount2++;
        }
        if(nCount2 == imgWalk.length) {
            nCount2 = 0;
        }
        imgOut = new TextureRegion(imgWalk[nCount2]);
    }
}
