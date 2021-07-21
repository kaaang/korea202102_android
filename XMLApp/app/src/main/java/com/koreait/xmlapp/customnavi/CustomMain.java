package com.koreait.xmlapp.customnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.koreait.xmlapp.R;
import com.koreait.xmlapp.RemoteActivity;

public class CustomMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_main);
    }

    //웹 요청 액티비티 띄우기기
    public void openWeb(){
        //의도를 명시할 수 있는 객체, 주로 의도 및 액티비티간 데이터 전달등에 사용
        Intent intent=new Intent(this, RemoteActivity.class);
        this.startActivity(intent);

    }
    //소캣채팅 액티비티 띄우기
    public void openChat(){

    }

   public void showPage(View view){
        switch (view.getId()){
            case R.id.img1:
                openWeb();
                break;
            case R.id.img2:
                openChat();
                break;
            case R.id.img3: ;break;
            case R.id.img4: ;break;
        }
    }
}