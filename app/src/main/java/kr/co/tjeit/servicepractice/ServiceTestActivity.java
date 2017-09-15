package kr.co.tjeit.servicepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ServiceTestActivity extends AppCompatActivity {

//    카운팅은, CountService 이용해서 진행한다.

    private android.widget.Button startCountBtn;
    private android.widget.Button endCountBtn;
    private android.widget.Button getCurrentNumberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        this.getCurrentNumberBtn = (Button) findViewById(R.id.getCurrentNumberBtn);
        this.endCountBtn = (Button) findViewById(R.id.endCountBtn);
        this.startCountBtn = (Button) findViewById(R.id.startCountBtn);

        startCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                서비스를 실행하는법.

//                동적 방송 수신을 등록하는법과 유사함.

//                인텐트를 만듦. 내용물을 서비스의 액션명으로 지정.
//                Intent serviceIntent = new Intent("kr.co.tjeit.servicepractice.CountService");
//                startService(serviceIntent);

//                Intent intent = new Intent("kr.co.tjeit.servicepractice.CountService2");
//                startService(intent);

                Intent intent = new Intent("kr.co.tjeit.servicepractice.MusicService");
                intent.setPackage("kr.co.tjeit.servicepractice");
                startService(intent);

            }
        });


        endCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                카운팅이종료. => 돌아가고 있던 서비스를 종료.

//                Intent intent = new Intent("kr.co.tjeit.servicepractice.CountService");
//                stopService(intent);


//                Intent intent = new Intent("kr.co.tjeit.servicepractice.CountService2");
//                stopService(intent);


                Intent intent = new Intent("kr.co.tjeit.servicepractice.MusicService");
                intent.setPackage("kr.co.tjeit.servicepractice");
                stopService(intent);

            }
        });

        getCurrentNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
