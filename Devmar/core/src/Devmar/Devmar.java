package Devmar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

public class Devmar extends ApplicationAdapter {
	SpriteBatch batch;
        Texture imgWalk[] = new Texture [7];
	TextureRegion img;
        ArrayList <Bullet> ArrBul;
        int nCount = 0, nCount2 = 0, nSpeed;
        float fRot;
        charMain Char1;
        Bullet bul;
        boolean isBul = false, isFlip = false;
	@Override
	public void create () {
		batch = new SpriteBatch();
                Char1 = new charMain();
                ArrBul = new ArrayList<Bullet>();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                nSpeed = 0;
                nCount++;
                if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                    nSpeed = -2;
                    isFlip = true;
                } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    nSpeed = 2;
                    isFlip = false;
                }
                if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
                    ArrBul.add(new Bullet(Char1.fShotX, Char1.fShotY));
                    System.out.println("add");
                }
		batch.begin();
                Char1.update(nSpeed, isFlip);
                for(int i = 0; i < ArrBul.size(); i++) {
                    Bullet bulTemp = ArrBul.get(i);
                    bulTemp.update();
                    if (bulTemp.isOffScreen()) {
                        ArrBul.remove(i);
                    }
                    batch.draw(bulTemp.imgOut, bulTemp.nLoc.x, bulTemp.nLoc.y, (float) 25/2, (float) 25/2, (float) 25.0, (float)25.0, (float)1, (float)1, bulTemp.fRot);
                }
		batch.draw(Char1.imgOut, Char1.nX, Char1.nY);
                System.out.println(ArrBul.size());
		batch.end();
	}
}
