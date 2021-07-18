package com.koreait.study10_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_dialog;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        tv_result = (TextView)findViewById(R.id.tv_result);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("Title");
                ad.setMessage("Test Dialog");


                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result=et.getText().toString();
                        tv_result.setText(result);
                        dialog.dismiss();//닫기
                    }
                });


                ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                ad.show()
            }
        });

    }
}