package com.koreait.activityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//자바와 Inflation 시키는 과정이 포함
        //따라서 이 시점 이후 부터는 실제 객체가 존재하는 시점
        //그래서 이때 버튼과 리스너를 연결해야한다.
        Button bt=(Button) this.findViewById(R.id.bt); //레퍼런스 얻기
        bt.setOnClickListener(this);//버튼과 리스너와의 연결
    }


    @Override
    public void onClick(View v) {
        System.out.println("click");
        //파란 화면이 나오도록 파란화면을 담당하는 BlueActivity 클래스를 활성화 시켜야한다.

        Intent intent=new Intent(this, BlueActivity.class);//개발자가 new 해서는 안되기 때문에
        //시스템에게 클래스 바이트명을 넘기자

        this.startActivity(intent);//지정한 내용으로 또다른 액티비티를 호출
    }
}