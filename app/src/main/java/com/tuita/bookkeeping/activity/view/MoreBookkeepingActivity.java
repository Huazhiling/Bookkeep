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
import com.tuita.bookkeeping.room.entity.Bookkeeping;
import com.tuita.bookkeeping.utils.RecordUtils;

import java.util.ArrayList;
import java.util.List;

@XmlLayoutResId(portContentId = R.layout.activity_more_bookkeeping)
public class MoreBookkeepingActivity extends BaseMvpActivity<MoreBookkeepingPresenter> implements MoreBookkeepingContract.MoreBookkeepingView {
    private List<Bookkeeping> bookkeepings;
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
        bookkeepings = new ArrayList<>();
        bookkeepings.addAll(RecordUtils.getInstance().getMoreRecord());
        BookkeepingRecordAdapter bookkeepingRecordAdapter = new BookkeepingRecordAdapter(R.layout.item_booppeening_record, bookkeepings);
        moreRv.setAdapter(bookkeepingRecordAdapter);
        bookkeepingRecordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(bookkeepings.get(position).getRecordName());
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
