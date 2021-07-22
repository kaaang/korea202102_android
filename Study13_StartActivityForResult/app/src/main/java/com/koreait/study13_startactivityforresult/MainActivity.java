package com.koreait.study13_startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_comeback;
    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_comeback=findViewById(R.id.tv_comeback);
        btn_go=findViewById(R.id.btn_go);

        btn_go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SubActivity.class);
                startActivityForResult(intent,);
            }
        });
    }
}