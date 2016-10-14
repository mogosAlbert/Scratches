package Devmar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class SoundTest {

    Music music;

    public SoundTest() {
        music = Gdx.audio.newMusic(Gdx.files.internal("music/music.mp3"));
    }

    public void Play() {
        music.setVolume(0.5f);                 // sets the volume to half the maximum volume
        music.setLooping(true);                // will repeat playback until music.stop() is called
        music.stop();                          // stops the playback
        music.pause();                         // pauses the playback
        music.play();
    }
}
