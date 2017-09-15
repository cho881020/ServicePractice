package kr.co.tjeit.servicepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int currentNumber = 0;

    Thread mCountThread = null;

    private android.widget.Button startCountBtn;
    private android.widget.Button endCountBtn;
    private Button getCurrentNumberBtn;
    private Button serviceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.serviceBtn = (Button) findViewById(R.id.serviceBtn);
        this.getCurrentNumberBtn = (Button) findViewById(R.id.getCurrentNumberBtn);
        this.endCountBtn = (Button) findViewById(R.id.endCountBtn);
        this.startCountBtn = (Button) findViewById(R.id.startCountBtn);

        startCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (mCountThread == null) {
                    mCountThread = new Thread("Count Thread") {

                        @Override
                        public void run() {

                            while (currentNumber < 10000) {

                                Log.i("TJE_COUNT", currentNumber + "");

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    break;
                                }

                                currentNumber++;
                            }

                        }
                    };


                    mCountThread.start();
                }


            }
        });


        endCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCountThread != null) {
                    mCountThread.interrupt();
                    currentNumber = 0;

                    mCountThread = null;
                }
            }
        });


        getCurrentNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "현재 숫자 : " + currentNumber, Toast.LENGTH_SHORT).show();
            }
        });

        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ServiceTestActivity.class);
                startActivity(intent);
            }
        });

    }
}






