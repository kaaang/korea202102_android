package com.koreait.fragmentapp.pager;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.koreait.fragmentapp.fragments.BlueFragment;
import com.koreait.fragmentapp.fragments.RedFragment;
import com.koreait.fragmentapp.fragments.YellowFragment;

//viewPager는 뷰에 불과하므로 실제적으로 몇페이지, 어떤 페이지 등을 보여줄지를 결정짓는 어탭터를 정의해본다.
public class MyAdapter extends FragmentStateAdapter {
    Fragment[] page = new Fragment[3];


    //생성자 호출시, 액티비티 넘기면 된다.
    public MyAdapter(HostActivity fragment) {
        super(fragment);
        page[0] = new RedFragment();
        page[1] = new YellowFragment();
        page[2] = new BlueFragment();
    }

    //총 몇페이지 인지 반호나하여 viewPager가 페이지 수를 구성할 수 있도록
    public int getItemCount() {
        return page.length;
    }

    @Override
    public Fragment createFragment(int position) {
        return page[position];
    }
}
