package com.tuita.bookkeeping.activity.view;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.activity.contract.MoreBookkeepingContract;
import com.tuita.bookkeeping.activity.presenter.MoreBookkeepingPresenter;
import com.tuita.bookkeeping.adapter.rvadapter.BookkeepingRecordAdapter;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseMvpActivity;
import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.bean.BookkeepingItemBean;
import com.tuita.bookkeeping.utils.RecordUtils;

import java.util.ArrayList;
import java.util.List;

@XmlLayoutResId(portContentId = R.layout.activity_more_bookkeeping)
public class MoreBookkeepingActivity extends BaseMvpActivity<MoreBookkeepingPresenter> implements MoreBookkeepingContract.MoreBookkeepingView {
    private BookkeepingRecordAdapter bookkeepingRecordAdapter;
    private List<BookkeepingItemBean> bookkeepingItemBeans;
    private RecyclerView moreRv;

    @Override
    protected void findView() {
        moreRv = findViewById(R.id.more_rv);

    }

    @Override
    protected void initMVPData() {

    }

    @Override
    protected void initMVPView() {
        bookkeepingItemBeans = new ArrayList<>();
        bookkeepingItemBeans.addAll(RecordUtils.getInstance().getMoreRecord());
        bookkeepingRecordAdapter = new BookkeepingRecordAdapter(R.layout.item_booppeening_record, bookkeepingItemBeans);
        moreRv.setAdapter(bookkeepingRecordAdapter);
        bookkeepingRecordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(bookkeepingItemBeans.get(position).getRecordName());
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    public BasePresenter initPresenter() {
        return MoreBookkeepingPresenter.newInstance();
    }
}
