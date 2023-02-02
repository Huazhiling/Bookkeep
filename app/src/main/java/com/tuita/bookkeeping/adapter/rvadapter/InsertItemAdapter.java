package com.tuita.bookkeeping.adapter.rvadapter;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.bean.InsertItemBean;

import java.util.List;

public class InsertItemAdapter extends BaseQuickAdapter<InsertItemBean, BaseViewHolder> {
    private InsertCallBack insertCallBack;

    public InsertItemAdapter(int layoutResId, @Nullable List<InsertItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InsertItemBean item) {
        helper.setText(R.id.item_type, item.getInsertTypeName());
        EditText valueView = helper.getView(R.id.item_desc);
        valueView.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
//                insertCallBack.editFocusChange(valueView.getText().toString().trim(),helper.getLayoutPosition());
                item.setName(valueView.getText().toString().trim());
            }
        });
        ImageView reduceView = helper.getView(R.id.item_reduce);
        if (!item.isDefault()) {
            reduceView.setVisibility(View.VISIBLE);
            helper.addOnClickListener(R.id.item_reduce);
        } else {
            reduceView.setVisibility(View.INVISIBLE);
        }
        helper.setText(R.id.item_desc, item.getName());
    }

    public void setInsertCallBack(InsertCallBack insertCallBack) {
        this.insertCallBack = insertCallBack;
    }

    public interface InsertCallBack {
        /**
         * 焦点改变的时候
         */
        void editFocusChange(String content,int position);
    }
}
