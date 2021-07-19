package com.koreait.xmlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
    SAXParserFactory factory;
    SAXParser saxParser;
    MemberHandler memberHandler;
    ListView listView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=findViewById(R.id.listView);
        myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
    }


    public void loadData(View view){
        factory = SAXParserFactory.newInstance();
        InputStream is=null;
        try {
            saxParser = factory.newSAXParser();
            AssetManager assetManager =this.getResources().getAssets();
            is=assetManager.open("members.xml");
            saxParser.parse(is,memberHandler = new MemberHandler());


            //파싱이 완료되면, list가 채워져있을것이고, 이 list를 MyAdapter가 보유한 list대신에 대입하자
            myAdapter.list=memberHandler.list;

            myAdapter.notifyDataSetChanged();//어댑터에게 데이터가 변경되었음을 알리는 메서드
            //리스트뷰 refresh
            listView.invalidate();





//            saxParser.parse(null,null);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }







        //파서 수행

    }
}