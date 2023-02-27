package com.tuita.bookkeeping.adapter.rvadapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.room.entity.Bookkeeping;

import java.util.List;

public class BookkeepingRecordAdapter extends BaseQuickAdapter<Bookkeeping, BaseViewHolder> {
    public BookkeepingRecordAdapter(int layoutResId, @Nullable List<Bookkeeping> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bookkeeping item) {
        helper.setImageResource(R.id.item_bk_icon, item.getRecordBookkeepingType());
        helper.setText(R.id.item_bk_name, item.getRecordName());
        helper.setText(R.id.item_bk_desc, item.getRecordDescription());
        helper.setText(R.id.item_bk_time, item.getRecordTime());
        String price = String.valueOf(item.getRecordPrice());
        if (item.getRecordStatus() == 1) {
            helper.setText(R.id.item_bk_price, "+" + price).setTextColor(R.id.item_bk_price, mContext.getColor(R.color.app_in_color));
        } else {
            helper.setText(R.id.item_bk_price, "-" + price).setTextColor(R.id.item_bk_price, mContext.getColor(R.color.app_out_color));
        }
        helper.addOnClickListener(R.id.record_parent);
    }
}
