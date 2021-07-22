package com.koreait.boardapp.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.koreait.boardapp.MainActivity;
import com.koreait.boardapp.R;

public class ContentFragment extends Fragment {
    String TAG=this.getClass().getName();

    Button bt_list,bt_update,bt_delete;
    MainActivity mainActivity;

    @Override
    //반환되는 View는 현재의 프레그먼트에서 보여줄 뷰를 의미
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_content, container, false);//인플레이션
        mainActivity=(MainActivity)this.getActivity();


        bt_list=view.findViewById(R.id.bt_list);
        bt_update=view.findViewById(R.id.bt_update);
        bt_delete=view.findViewById(R.id.bt_delete);


        //java11 람다 - 이벤트, 내부 익명 클래스 대시 람다로 자주 사용된다.
        bt_list.setOnClickListener((View v)->{
            mainActivity.showPage(0);
        });
        bt_update.setOnClickListener((View v)->{
            mainActivity.showPage(0);
        });
        bt_delete.setOnClickListener((View v)->{
            mainActivity.showPage(0);
        });


        return view;
    }
}