package com.koreait.boardapp.pages;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.koreait.boardapp.BoardDAO;
import com.koreait.boardapp.MainActivity;
import com.koreait.boardapp.R;
import com.koreait.boardapp.domain.Board;
import com.koreait.boardapp.list.BoardListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//게시물 목록을 보여줄 리스트 페이지
public class ListFragment extends Fragment {
    String TAG=this.getClass().getName();
    ListView listView;

    public BoardListAdapter boardListAdapter;

    String ip="220.72.128.42";
    int port=8888;

    Handler handler;

    @Override
    //반환되는 View는 현재의 프레그먼트에서 보여줄 뷰를 의미
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list, container, false);//인플레이션

        listView=view.findViewById(R.id.listView);

        //리스트 뷰와 어댑터 연결
        boardListAdapter=new BoardListAdapter((MainActivity) getActivity());
        listView.setAdapter(boardListAdapter);



        handler = new Handler(){
            public void handleMessage(@NonNull Message msg) {
                boardListAdapter.notifyDataSetChanged();//새로고침
                listView.invalidate();
            }
        };


        Thread thread = new Thread(){
            public void run() {
               getList();
            }
        };
        thread.start();

        //리스트 뷰와 이벤트 리스너 연결
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"아이템 선택");
                MainActivity mainActivity=(MainActivity) ListFragment.this.getActivity();
                mainActivity.showPage(2);
            }
        });


        return view;
    }
    public void getList(){
        //게시물 목록 가져오기
        //웹 서버로부터 데이터 가져오기
        URL url=null;
        HttpURLConnection con=null;
        BufferedReader buffr=null;
        StringBuilder sb=new StringBuilder();



        //220.72.128.42
        try {
            url=new URL("http://"+ip+":"+port+"/rest/board");
            con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            buffr=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));

            String data=null;
            while (true){
                data= buffr.readLine();
                if(data==null)break;
                sb.append(data);//한줄씩 모으기
            }
            int code=con.getResponseCode();

            Log.d(TAG,"code="+code);
            Log.d(TAG,"sb="+sb.toString());

            //여기서부터 서버로부터 전송된, json을 ListView 에 반영하기기(실제적으로는 BaseAdapter를 제어해야한다)
            //서버로부터 가져온 데이터를 ListView가 의존하고 있는 어댑터의 ArrayList에 대입

            //sb를 java의 util의 List로 변환해야한다
            JSONArray jsonArray = new JSONArray(sb.toString());
            Log.d(TAG,"json배열의 길이는 "+jsonArray.length());
            List<Board> boardList = new ArrayList<Board>();
            for(int i=0;i<jsonArray.length();i++){
                JSONObject json=(JSONObject)jsonArray.get(i);
                Board board = new Board();
                board.setBoard_id(json.getInt("board_id"));
                board.setTitle(json.getString("title"));
                board.setWriter(json.getString("writer"));
                board.setContent(json.getString("content"));
                board.setRegdate(json.getString("regdate"));
                board.setHit(json.getInt("hit"));

                boardList.add(board);
            }

            boardListAdapter.boardList =boardList;


            //핸들러에게 부탁하자UI를
            handler.sendEmptyMessage(0);



        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if(buffr!=null){
                try {
                    buffr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }




}
