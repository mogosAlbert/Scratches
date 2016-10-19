package Devmar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.*;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Devmar extends ApplicationAdapter {

    SpriteBatch batch;
    Sprite Enemy;
    TextureRegion img;
    ArrayList<Bullet> ArrBul;
    int nCount = 0, nCount2 = 0, nSpeed;
    float fRot;
    charMain Char1;
    ArrayList<charEnemy> ArrEnemies;
    Bullet bul;
    boolean isBul = false, isFlip = false, isPlay = false;
    Music music;
    TiledMap map;
    TiledMapRenderer Render;
    MapProperties Prop;
    OrthographicCamera Cam;
    MapObjects MapObj;
    TiledMapTileLayer Layer;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Char1 = new charMain();
        ArrEnemies = new ArrayList<charEnemy>();
        ArrBul = new ArrayList<Bullet>();
        music = Gdx.audio.newMusic(Gdx.files.absolute("D:/Mogos/Devmar/core/assets/Music/music1.mp3"));
        map = new TmxMapLoader().load("level1.tmx");
        Render = new OrthogonalTiledMapRenderer(map);
        Cam = new OrthographicCamera();
        Layer = (TiledMapTileLayer) map.getLayers().get(1);
        MapObj = Layer.getObjects();
        Cam.setToOrtho(false, 1000, 500);
        Cam.update();
    }

    @Override
    public void render() {
        Cam.update();
        Render.setView(Cam);
        Render.render();
        map.getLayers().get(1).setVisible(!map.getLayers().get(1).isVisible());
        Prop = map.getProperties();
        nSpeed = 0;
        nCount++;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            nSpeed = -2;
            isFlip = true;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            nSpeed = 2;
            isFlip = false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            ArrBul.add(new Bullet(Char1.fShotX, Char1.fShotY));
            System.out.println("add");
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            isPlay = !isPlay;
            ArrEnemies.add(new charEnemy(700, 120));
        }
        if (isPlay) {
            music.play();
        } else if (!isPlay) {
            music.pause();
        }
        batch.begin();
        Char1.update(nSpeed, isFlip);
        for (int i = 0; i < ArrBul.size(); i++) {
            Bullet bulTemp = ArrBul.get(i);
            bulTemp.update();
            if (bulTemp.isOffScreen()) {
                ArrBul.remove(i);
            }
            batch.draw(bulTemp.imgOut, bulTemp.nLoc.x, bulTemp.nLoc.y, (float) 25 / 2, (float) 25 / 2, (float) 25.0, (float) 25.0, (float) 1, (float) 1, bulTemp.fRot);
        }
        for (int i = 0; i < ArrEnemies.size(); i++) {
            charEnemy enemTemp = ArrEnemies.get(i);
            enemTemp.update(enemTemp.nDirSpeed(Char1.vLoc), Char1.vLoc);
            batch.draw(enemTemp.imgOut, enemTemp.vLoc.x, enemTemp.vLoc.y, 40, 60);
        }
        for (RectangleMapObject RectangleObject: MapObj.getByType(RectangleMapObject.class)) {
            Rectangle Rect = RectangleObject.getRectangle();
            System.out.println("check");
            if(Intersector.overlaps(Rect, Char1.RectDet)) {
                System.out.println("hit");
            }
        }
        batch.draw(Char1.imgOut, Char1.vLoc.x, Char1.vLoc.y);
        batch.end();
    }
}