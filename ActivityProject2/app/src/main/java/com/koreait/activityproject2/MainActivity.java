package com.koreait.activityproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트 뷰가 사용할 데이터를 준비한 후, 이 데이터와 리스트뷰를 연결해줄 어댑터를 사용해보자
        //setContentView 메서드가 호출되면, 이미 자바 객체들이 존재하는 상태이므로, 아이디로 래퍼런스를 얻어오자


        //지정된 어댑터를 넣어주자    어댑터란 뷰가 직접적으로 데이터를 제어하지 않도록, 즉 뷰와 모델을 분리시키기 위한 객체를 의미
        //어댑터를 사용하는 방법은 2가지가 있다.
        //1.아주 간단한 데이터의 경우 즉, 스트링만 출력할 경우엔 이미 안드로이드 api에서 지원하는 내장 어댑터를 사용하면 된다.
        //2.구조가 복잡한 경우엔 개발자가 커스텀해서 사용해야 한다.


        //Model 구성하기
        ArrayList<String> data = new ArrayList<String>();
        data.add("사과");
        data.add("딸기");
        data.add("바나나");
        data.add("포도");
        data.add("오렌지");
        data.add("망고");



        ListView listView=(ListView)this.findViewById(R.id.listView);//인플레이션된 뷰 얻기
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,data);
        listView.setAdapter(adapter);

        /*
        GridView gridView = (GridView) this.findViewById(R.id.gridView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,data);
        gridView.setAdapter(adapter);

         */

//        Spinner spinner = (Spinner)this.findViewById(R.id.spinner);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,data);
//        spinner.setAdapter(adapter);

    }
}