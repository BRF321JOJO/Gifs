package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

class MusicMono {

    //In here, we needed to split the audio into two files.
    private boolean playonce = true;
    private static Sound Spamerinoleft;
    private static Sound Spamerinoright;

    MusicMono() {
        Spamerinoleft = Gdx.audio.newSound(Gdx.files.internal("leftrealmono.mp3"));
        Spamerinoright = Gdx.audio.newSound(Gdx.files.internal("rightrealmono.mp3"));
    }

    void Loopmonosong() {
        if (playonce) {
            Spamerinoleft.loop(1, 1, -1);
            Spamerinoright.loop(1, 1, 1);
            playonce = false;
        }
    }

    void update () {
        Loopmonosong();
    }
}
