package com.tuita.bookkeeping.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class HomePageAdapter extends FragmentStateAdapter {
    private List<Fragment> fragmentsMg;

    public HomePageAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentsMg) {
        super(fragmentActivity);
        this.fragmentsMg = fragmentsMg;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentsMg.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentsMg.size();
    }
}
