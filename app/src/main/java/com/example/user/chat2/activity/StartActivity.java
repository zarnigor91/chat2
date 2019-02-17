package com.example.user.chat2.activity;

import android.arch.lifecycle.LiveData;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.user.chat2.MyViewModel;
import com.example.user.chat2.R;


public class StartActivity extends AppCompatActivity {
    private TextView tv;
    Button button, btPage;
    private ProgressBar progressBar;
    private Handler handler;
    private  int progresStatus=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_layout);
        tv = findViewById(R.id.timer1);
        button=findViewById(R.id.btBack);
        btPage=findViewById(R.id.btPage);
        Intent intent=new Intent(StartActivity.this, MainActivity.class);
        Intent intent1= new Intent(StartActivity.this, NavigationActivity.class);
        btPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        CountDownTimer countDownTimer = new CountDownTimer(62000, 1000) {
            int i = 0;
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText(getTime(i));
                i = i + 1;

            }
            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
        progressBar=findViewById(R.id.prBar);
       progressBar.setMax(60);
       btPage.setEnabled(false);
     /*   MyViewModel viewModel =  ViewModelProvider.of(this).get(MyViewModel.class);
        LiveData<Integer> liveData = viewModel.onStartTask();
        liveData.observe(this, integer -> {
            progressBar.setProgress(integer);
            if (integer == 19) btPage.setEnabled(true);
        });*/

//        handler=new Handler();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//               while(progresStatus<60){
//                   progresStatus+=1;
//                   try{
//                       Thread.sleep(20);
//                   }catch(InterruptedException e){
//                       e.printStackTrace();
//                   }
//                   handler.post(new Runnable() {
//                       @Override
//                       public void run() {
//                           progressBar.setProgress(progresStatus);
//                       }
//                   });
//               }
//            }
//        }).start();
    }

     private String  getTime(int time){
        if (time<10){
            return "00:0"+time;
        }
        else {
            if (time>60) {
                if (time % 60 > 10)
                    return "01:" + time;
                if (time % 60 < 10)
                    return "01:0" + time;
            }else {
                return "00:"+time;
                }

        }
        return time+"";
     }
}
