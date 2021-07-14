package com.koreait.activityproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        
        
        //부착하기 위한 아이디 얻기
        LinearLayout container=(LinearLayout)this.findViewById(R.id.container);

        //복잡한 구조의 아이템뷰를 여러개 동적으로 화면에 보여주기 위해서는 반복문을 이용해야 하고,
        //반복문을 이용할려면 자바 코드를 이용하여 디자인을 수행해야함


        //지금부터는 디자인을 xml로 했기 때문에 해당 xml에 명시한 뷰들을 실제 자바의 인스턴스화 시켜야 한다
        LayoutInflater layoutInflater=this.getLayoutInflater();

        String[] title={"히어로1","히어로2","히어로3","히어로4","히어로5","히어로6","히어로7","히어로8","히어로9","히어로10"};

        for(int i=0;i<10;i++) {
            LinearLayout view = (LinearLayout) layoutInflater.inflate(R.layout.board_item, null, false);

            //뷰 그룹도 findviewById가 지원된다.
            TextView t_title=(TextView)view.findViewById(R.id.t_title);
            TextView t_writer=(TextView)view.findViewById(R.id.t_writer);

            t_title.setText(title[i]);


            //부착하기
            container.addView(view);
        }


    }
}