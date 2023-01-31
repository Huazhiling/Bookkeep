package com.tuita.bookkeeping.activity;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.adapter.rvadapter.BookkeepingTypeAdapter;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseActivity;
import com.tuita.bookkeeping.bean.BookkeepingTypeBean;

import java.util.ArrayList;
import java.util.List;

@XmlLayoutResId(portContentId = R.layout.activity_insert_bookkeeping)
public class InsertBookkeepingActivity extends BaseActivity {
    private RecyclerView typeRv;
    private BookkeepingTypeAdapter bookkeepingTypeAdapter;
    private List<BookkeepingTypeBean> bookkeepingTypeBeans;
    private final int[] resIds = {R.drawable.jiehun, R.drawable.give_birth
            , R.drawable.zhousui, R.drawable.manyue
            , R.drawable.birthday, R.drawable.qiaoqian
            , R.drawable.yasuiqian, R.drawable.shengxue
            , R.drawable.dashou, R.drawable.sangshi};
    private final String[] contents = {"结婚", "生子", "周岁", "满月", "生日"
            , "乔迁", "压岁", "升学", "大寿", "丧事"};

    @Override
    protected void adapterInit() {
        typeRv.setAdapter(bookkeepingTypeAdapter);
    }

    @Override
    protected void viewInit() {
        bookkeepingTypeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(bookkeepingTypeBeans.get(position).getTypeName());
            }
        });
    }

    @Override
    protected void findView() {
        typeRv = findViewById(R.id.type_rv);
    }

    @Override
    protected void initView() {
        bookkeepingTypeBeans = new ArrayList<>();
        int forCount = resIds.length;
        for (int i = 0; i < forCount; i++) {
            BookkeepingTypeBean bookkeepingTypeBean = new BookkeepingTypeBean();
            bookkeepingTypeBean.setTypeId(i);
            bookkeepingTypeBean.setResId(resIds[i]);
            bookkeepingTypeBean.setTypeName(contents[i]);
            bookkeepingTypeBeans.add(bookkeepingTypeBean);
        }
        bookkeepingTypeAdapter = new BookkeepingTypeAdapter(R.layout.item_insert_bookkeeping_icon, bookkeepingTypeBeans);
    }
}
