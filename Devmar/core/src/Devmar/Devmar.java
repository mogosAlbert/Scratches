package Devmar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Devmar extends ApplicationAdapter {
	SpriteBatch batch;
        Texture imgWalk[] = new Texture [7];
	TextureRegion img;
        int nCount = 0, nCount2 = 0, nSpeed;
        float fRot;
        charMain Char1;
        Bullet bul;
        boolean isBul = false;
	@Override
	public void create () {
		batch = new SpriteBatch();
                Char1 = new charMain();
                
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                nSpeed = 0;
                nCount++;
                if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                    nSpeed = -2;
                } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    nSpeed = 2;
                }
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                    bul = new Bullet(Char1.nX, Char1.nY);
                    isBul = true;
                }
		batch.begin();
                Char1.update(nSpeed);
                if(isBul){
                bul.update();
                batch.draw(bul.imgBul, bul.nLoc.x, bul.nLoc.y);
                }
		batch.draw(Char1.imgOut, Char1.nX, Char1.nY);
                
		batch.end();
	}
}
