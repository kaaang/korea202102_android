package com.koreait.boardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.koreait.boardapp.R;
import com.koreait.boardapp.domain.Board;
import com.koreait.boardapp.pages.ContentFragment;
import com.koreait.boardapp.pages.ListFragment;
import com.koreait.boardapp.pages.WriteFragment;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager2 viewPager;
    PageAdapter pageAdapter;
    public Fragment[] pages=new Fragment[3];
    public Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        //메인 액티비티가 거느힐 하위 프레그먼트 정보를 알면 좋다
        pages[0]=new ListFragment();
        pages[1]=new WriteFragment();
        pages[2]=new ContentFragment();
        viewPager=findViewById(R.id.viewPager);
        pageAdapter=new PageAdapter(this);
        viewPager.setAdapter(pageAdapter);


        //viewPager2의 경우 메서드 호출로 스와이핑을 scroll을 비활성화 시킬 수 있을듯
        viewPager.setUserInputEnabled(false);
        this.setSupportActionBar(toolbar);



        showPage(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=this.getMenuInflater();
        menuInflater.inflate(R.menu.main_navi,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void getBoardList(){
        //ListGragment의 getList()호출
        ListFragment listFragment=(ListFragment)pages[0];

        Thread thread = new Thread(){
            @Override
            public void run() {
                listFragment.getList();
            }
        };
        thread.start();


        showPage(0);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_list:
                getBoardList();
                break;
            case R.id.item_write:showPage(1);break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPage(int index) {
        viewPager.setCurrentItem(index);
    }
}