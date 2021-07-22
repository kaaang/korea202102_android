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

public class WriteFragment extends Fragment implements View.OnClickListener {
    String TAG=this.getClass().getName();

    Button bt_list,bt_write;
    MainActivity mainActivity;

    @Override
    //반환되는 View는 현재의 프레그먼트에서 보여줄 뷰를 의미
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_write, container, false);//인플레이션

        bt_list=view.findViewById(R.id.bt_list);
        bt_write=view.findViewById(R.id.bt_write);
        bt_list.setOnClickListener(this);
        bt_write.setOnClickListener(this);
        mainActivity=(MainActivity) this.getActivity();//호스트 액티비티 얻어두기
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_list) {
            Log.d(TAG, "목록으로 갈까요?");
            mainActivity.showPage(0);
        }else if(v.getId()==R.id.bt_write){
            Log.d(TAG, "등록 할까요?");
        }
    }


}