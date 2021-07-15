package com.koreait.dataviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    LayoutInflater layoutInflater;

    String[] writerArray={"히어로1","히어로2","히어로3","히어로4","히어로5","히어로6","히어로7","히어로8","히어로9","히어로10"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//인플레이션 + 뷰로 사용

        //스크롤 뷰 안쪽의 리니어 레리아웃 가져오기
        container = (LinearLayout) findViewById(R.id.container);
        layoutInflater = this.getLayoutInflater();


        getList();
    }

    public void getList(){
        //item_board.xml을 인플레이션 시켜 반복문으로 채워넣자
        for(int i=0;i<10;i++) {
            View view = layoutInflater.inflate(R.layout.item_board, null, false);
            TextView t_title = (TextView)view.findViewById(R.id.t_title);
            TextView t_writer = (TextView)view.findViewById(R.id.t_writer);

            t_writer.setText(writerArray[i]);

            container.addView(view);
        }
    }



}