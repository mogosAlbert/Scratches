
package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.MathUtils;

public class Bullet {
    Vector2 nLoc;
    float fX, fY, fRot, fSpeed;
    Texture imgBul = new Texture(Gdx.files.internal("bullet.png"));
    public Bullet(float nX, float nY) {
        nLoc = new Vector2(nX, nY);
        fX = Gdx.input.getX();
        fY = Gdx.input.getY();
        fRot = MathUtils.atan2(fY - nLoc.y, fX - nLoc.x) / MathUtils.PI * 180;
        fSpeed = 10;
    }
    public void update(){
        nLoc.x += MathUtils.cos(fRot/180*MathUtils.PI)*fSpeed;
        nLoc.y += MathUtils.sin(fRot/180*MathUtils.PI)*fSpeed;
    }
           
}
