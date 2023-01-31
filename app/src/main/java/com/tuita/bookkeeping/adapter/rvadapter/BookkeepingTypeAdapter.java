package com.tuita.bookkeeping.adapter.rvadapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.bean.BookkeepingTypeBean;

import java.util.List;

public class BookkeepingTypeAdapter extends BaseQuickAdapter<BookkeepingTypeBean, BaseViewHolder> {
    public BookkeepingTypeAdapter(int layoutResId, @Nullable List<BookkeepingTypeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookkeepingTypeBean item) {
        helper.setImageResource(R.id.insert_icon, item.getResId());
        helper.addOnClickListener(R.id.icon_parent);
    }
}
