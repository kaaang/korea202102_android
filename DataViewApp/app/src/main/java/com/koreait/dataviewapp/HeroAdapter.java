package com.koreait.dataviewapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//View인 ListView에게 데이터에 대한 정보를 제공해주는 어댑터
//swing에서의 TableModel과 그 역할이 같다.
public class HeroAdapter extends BaseAdapter {
    LayoutInflater layoutInflater=null; //activity를 통해 얻어야 한다
    Context context;
    String[] writerArray={"HERO1","HERO2","HERO3","HERO4","HERO5","HERO6","HERO7","HERO8","HERO9","HERO10"};
    int[] drawables={
            R.drawable.h1,
            R.drawable.h2,
            R.drawable.h3,
            R.drawable.h4,
            R.drawable.h5,
            R.drawable.h6,
            R.drawable.h7,
            R.drawable.h8,
            R.drawable.h9,
            R.drawable.h10
    };
    Resources res;
    
    //생성자에서 Activity를 이용하자
    public HeroAdapter(Context context) {
        this.context=context;
        Activity ac = (Activity)context;
        layoutInflater=ac.getLayoutInflater();
        res=context.getResources();//res를 뜻한다.
    }
    

    //총 아이템 갯수
    public int getCount() {
        Log.d("HeroAdapter", "총 데이터 갯수는"+writerArray.length);
        return writerArray.length;
    }

    //지정한 위치의 아이템 반환
    public Object getItem(int position) {
        return null;
    }

    //각 아이템에 부여된 아이디 반환
    public long getItemId(int position) {
        return 0;
    }

    //스윙의 TableModel에서의 getValueAt()과 같다
    public View getView(int position, View convertView, ViewGroup parent) {
        //아이템으로 사용할 뷰를 반환하자(우리의 경우  item_board의 인플레이션 결과물
        View view=layoutInflater.inflate(R.layout.item_board,null,false);
        ImageView img=(ImageView)view.findViewById(R.id.img);
        TextView t_writer=(TextView)view.findViewById(R.id.t_writer);

        //이미지는 drawable에 있으므로, drawable안의 리소스를 접근할 수 있어야 한다.

        Drawable d = res.getDrawable(drawables[position]);
        img.setImageDrawable(d);


        t_writer.setText(writerArray[position]);
        
        
        return view;
    }
}
