package com.tuita.bookkeeping.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.adapter.HomePageAdapter;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseActivity;
import com.tuita.bookkeeping.fragment.view.BookkeepingFragment;
import com.tuita.bookkeeping.fragment.view.MoreFragment;

import java.util.ArrayList;
import java.util.List;

@XmlLayoutResId(portContentId = R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private ViewPager2 mainVp;
    private RadioGroup mainBtn;
    private ImageView mainAdd;
    private HomePageAdapter homePageAdapter;
    private List<RadioButton> clickList;

    @Override
    protected void adapterInit() {

    }

    @Override
    protected void viewInit() {
        mainVp.setAdapter(homePageAdapter);
        mainAdd.setOnClickListener(v ->
                startActivity(new Intent(getBaseContext(), InsertBookkeepingActivity.class)));
        mainVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                clickList.get(position).setChecked(true);
            }
        });
        mainVp.setUserInputEnabled(false);
    }

    @Override
    protected void findView() {
        mainVp = findViewById(R.id.main_vp);
        mainBtn = findViewById(R.id.main_btn);
        mainAdd = findViewById(R.id.main_add);
    }

    @Override
    protected void initView() {
        clickList = new ArrayList<>();
        List<Fragment> fragmentMg = new ArrayList<>();
        BookkeepingFragment bookkeepingFragment = new BookkeepingFragment();
        MoreFragment moreFragment = new MoreFragment();
        fragmentMg.add(bookkeepingFragment);
        fragmentMg.add(moreFragment);
        homePageAdapter = new HomePageAdapter(this, fragmentMg);
        clickList.clear();
        int allRadioCount = mainBtn.getChildCount();
        for (int i = 0; i < allRadioCount; i++) {
            if (mainBtn.getChildAt(i) instanceof RadioButton) {
                clickList.add((RadioButton) mainBtn.getChildAt(i));
            }
        }
        for (int i = 0; i < clickList.size(); i++) {
            int position = i;
            clickList.get(position).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainVp.setCurrentItem(position);
                }
            });
        }
    }
}
