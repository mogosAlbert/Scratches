package GamDev.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import GamDev.Sprites.SprMain;

public class ScrGame implements Screen {

    private TiledMap Map1;
    private OrthogonalTiledMapRenderer MapRender;
    private OrthographicCamera MapCam;
    private int nChangeX;
    private SprMain Spr1;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        MapRender.setView(MapCam);
        MapCam.position.set(Spr1.getX() + Spr1.getWidth() / 2, Spr1.getY() + Spr1.getHeight() / 2 + 250 - 50, 0);
        MapCam.update();
        MapRender.render();
        MapRender.getBatch().begin();
        Spr1.draw(MapRender.getBatch());
        MapRender.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        MapCam.viewportHeight = height;
        MapCam.viewportWidth = width;
        MapCam.translate(0.25f * width, 0.2f * height);
        MapCam.update();
    }

    @Override
    public void show() {
        Map1 = new TmxMapLoader().load("Maps/level1.tmx");
        MapRender = new OrthogonalTiledMapRenderer(Map1, 2.5f);
        MapCam = new OrthographicCamera();
        Spr1 = new SprMain((TiledMapTileLayer) Map1.getLayers().get(0));
        Spr1.setPosition(11 * Spr1.getCollisionLayer().getTileWidth(), (Spr1.getCollisionLayer().getHeight() - 14) * Spr1.getCollisionLayer().getTileHeight() + 60);
        Gdx.input.setInputProcessor(Spr1);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        Map1.dispose();
        MapRender.dispose();
    }
}