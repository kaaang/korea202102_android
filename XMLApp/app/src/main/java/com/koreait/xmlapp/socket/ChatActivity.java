package com.koreait.xmlapp.socket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.koreait.xmlapp.R;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.Socket;

public class ChatActivity extends AppCompatActivity {

    Socket socket;
    EditText t_ip,t_port;
    TextView area;
    EditText t_input;
    Thread connectThread;//네트워크 작업에 메인 쓰레드를 사용하면 안되기 때문에
    Handler handler;
    MessageThread messageThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        t_ip=findViewById(R.id.t_ip);
        t_port=findViewById(R.id.t_port);
        area=findViewById(R.id.area);
        t_input=findViewById(R.id.t_input);


        handler = new Handler(){
            public void handleMessage(@NonNull Message message) {
                Bundle bundle = message.getData();
                String msg=(String)bundle.get("msg");
                area.append(msg+"\n");
            }
        };
    }

    public void connect(View view){
        //서버에 접속하기
        String ip=t_ip.getText().toString();
        int port=Integer.parseInt(t_port.getText().toString());

        connectThread = new Thread(){
            public void run() {
                try {
                    socket=new Socket(ip,port);//접속

                    //메시지 전용 쓰레드 생성
                    messageThread = new MessageThread(ChatActivity.this);
                    messageThread.start();


                    //area.append("접속 완료\n");
                    //view제어는 메인 쓰레드만이 할 수 있다.
                    // 개발자가 정의한 쓰레드가 UI를 제어하고 싶다면 핸들러를 이용하여서 부탁해야 한다.
                    // 즉 간접적으로 메인쓰레드를 동작시켜야 한다.

                    Message message = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("msg","접속 완료");
                    message.setData(bundle);
                    handler.sendMessage(message);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        connectThread.start();
    }

    public void sendMsg(View view){
        String msg=t_input.getText().toString();
        Thread thread = new Thread(){
            public void run() {
                messageThread.send(msg);
            }
        };
        thread.start();

        t_input.setText("");
    }
}