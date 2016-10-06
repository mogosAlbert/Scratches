package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame3;

public class DesktopLauncher {

    public static void main(String[] arg) {
        int nHeight = MyGdxGame3.nHeight;
        int nWidth = MyGdxGame3.nWidth;
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = nHeight;
        config.width = nWidth;
        new LwjglApplication(new MyGdxGame3(), config);
    }
}
