package Devmar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Devmar extends ApplicationAdapter {
	SpriteBatch batch;
        Texture imgWalk[] = new Texture [7];
	TextureRegion img;
        int nCount = 0, nCount2 = 0;
	@Override
	public void create () {
		batch = new SpriteBatch();
                for(int i = 0; i < imgWalk.length; i++){
                    imgWalk[i] = new Texture(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/walk/" + i + ".png"));
                }
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                nCount++;
                if(nCount == 8){
                    nCount2++;
                    nCount = 0;
                }
                if(nCount2 == 6) {
                    nCount2 = 0;
                }
		batch.begin();
                img = new TextureRegion(imgWalk[nCount2]);
		batch.draw(img, 0, 0);
		batch.end();
	}
}
