package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class ScrGame extends InputAdapter implements Screen  {

    private TiledMap Map1;
    private OrthogonalTiledMapRenderer MapRender;
    private OrthographicCamera MapCam;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        MapRender.setView(MapCam);
        MapRender.render();
    }

    @Override
    public void resize(int width, int height) {
        MapCam.viewportHeight = height;
        MapCam.viewportWidth = width;
        MapCam.translate(300, 0);
        MapCam.update();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Map1 = new TmxMapLoader().load("Maps/level1.tmx");
        MapRender = new OrthogonalTiledMapRenderer(Map1);
        MapCam = new OrthographicCamera();
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

    @Override
    public boolean keyDown(int i) {
        System.out.println("down");
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        System.out.println("up");
        return true;
    }
}
