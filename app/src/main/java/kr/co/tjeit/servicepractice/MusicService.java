package kr.co.tjeit.servicepractice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by user on 2017-09-15.
 */


//    실제로, 음악을 재생하는 서비스로 변경.

public class MusicService extends Service {

    MediaPlayer player;

    @Override
    public void onCreate() {
        super.onCreate();

//        음악 재생 도구를 생성. sample.mp3를 불러달라.
        player = MediaPlayer.create(this, R.raw.sample);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
