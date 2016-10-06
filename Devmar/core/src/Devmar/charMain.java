package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class charMain {
    Texture imgWalk[] = new Texture[7];
    TextureRegion imgOut;
    int nX, nY, nCount, nCount2;
    
    public charMain() {
        for (int i = 0; i < imgWalk.length; i++){
            imgWalk[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/walk/" + i + ".png"));
        }
        nX = 50;
        nY = 0;
    }
    
    public void update(int nSpeedX, int nSpeedY) {
        nX += nSpeedX;
        nY += nSpeedY;
        
    }
}
