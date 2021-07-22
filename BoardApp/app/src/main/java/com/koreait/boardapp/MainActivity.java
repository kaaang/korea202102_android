package com.koreait.boardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.koreait.boardapp.R;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager2 viewPager;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.viewPager);
        pageAdapter=new PageAdapter(this);
        viewPager.setAdapter(pageAdapter);

        setSupportActionBar(toolbar);
        showPage(2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=this.getMenuInflater();
        menuInflater.inflate(R.menu.main_navi,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_list:showPage(0);break;
            case R.id.item_write:showPage(1);break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPage(int index) {
        viewPager.setCurrentItem(index);
    }
}