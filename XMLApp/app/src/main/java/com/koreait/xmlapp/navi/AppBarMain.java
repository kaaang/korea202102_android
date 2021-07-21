package com.koreait.xmlapp.navi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.koreait.xmlapp.R;
import com.koreait.xmlapp.RemoteActivity;
import com.koreait.xmlapp.socket.ChatActivity;

public class AppBarMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
    }

    //메뉴 초기화 메서드
    //개발자가 정의한 menu xml파일 등을 여기서 활용
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=this.getMenuInflater(); //menu xml을 인플레이션 시켜주는 객체
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


        public void openWeb(){
            Intent intent = new Intent(this, RemoteActivity.class);
            startActivity(intent);
        }
        public void openChat(){
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        }



    //액션 아이템들에게 이벤트 추기
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //4가지 아이템을 구분
        switch (item.getItemId()){
            case R.id.item_web: openWeb();break;
            case R.id.item_chat: openChat();break;

        }

        return super.onOptionsItemSelected(item);
    }
}