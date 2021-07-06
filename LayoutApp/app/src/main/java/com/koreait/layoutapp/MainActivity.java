package com.koreait.layoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q7); //화면에 보여질 뷰를 XML을 이용하는 방법

/*
        //xml이 아닌 순수 자바 코드로 디자인을 구현해보자
        Button bt = new Button(this);
        bt.setText("button");

        //버튼의 width, height 지정
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        bt.setLayoutParams(layoutParams);
        setContentView(bt);//버튼은 view를 상속받으니까

 */
    }
}