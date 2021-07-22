package com.koreait.fragmentapp.pager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.koreait.fragmentapp.R;

public class HostActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    MyAdapter myAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        viewPager=findViewById(R.id.viewPager);
        myAdapter = new MyAdapter(this);
        viewPager.setAdapter(myAdapter);
        toolbar=findViewById(R.id.toolbar);

/*
        ActionBar bar = this.getSupportActionBar();
        bar.setTitle("나의액션바");

 */
    this.setSupportActionBar(toolbar);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=this.getMenuInflater();
        menuInflater.inflate(R.menu.menu_navi,menu);
        return true;
    }

    public void showPage(int index){
        viewPager.setCurrentItem(index);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_red:showPage(1);
            case R.id.item_yellow:showPage(2);
            case R.id.item_blue:showPage(3);
        }
        return super.onOptionsItemSelected(item);
    }
}