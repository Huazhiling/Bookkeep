package com.tuita.bookkeeping.fragment.view;

import static com.tuita.bookkeeping.command.Constant.SystemConfig.MAX_PREVIEW_RECORD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.allen.library.SuperTextView;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.activity.view.MoreBookkeepingActivity;
import com.tuita.bookkeeping.adapter.rvadapter.BookkeepingRecordAdapter;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseMvpFragment;
import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.bean.BookkeepingItemBean;
import com.tuita.bookkeeping.event.BookkeepingRefreshEvent;
import com.tuita.bookkeeping.fragment.contract.BookkeepingContract;
import com.tuita.bookkeeping.fragment.presenter.BookkeepingPresenter;
import com.tuita.bookkeeping.ui.RuleRecyclerLines;
import com.tuita.bookkeeping.utils.RecordUtils;

import org.greenrobot.eventbus.Subscribe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlLayoutResId(portContentId = R.layout.fragment_bookkeeping)
public class BookkeepingFragment extends BaseMvpFragment<BookkeepingPresenter> implements BookkeepingContract.IBookkeepingView {
    private TextView bkTime;
    private TextView outAccount;
    private TextView inAccount;
    private SuperTextView bkMore;
    private RecyclerView bkRecord;
    private BookkeepingRecordAdapter bookkeepingRecordAdapter;
    private List<BookkeepingItemBean> bookkeepingItemBeans;
    private boolean moreClickFlag;

    @Override
    protected void initView() {
        bkTime = findViewById(R.id.bk_time);
        outAccount = findViewById(R.id.out_account);
        inAccount = findViewById(R.id.in_account);
        bkMore = findViewById(R.id.bk_more);
        bkRecord = findViewById(R.id.bk_record);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void initData() {
        super.initData();
        bookkeepingItemBeans = new ArrayList<>();
        bookkeepingItemBeans.addAll(RecordUtils.getInstance().getPreviewRecord());
        bookkeepingRecordAdapter = new BookkeepingRecordAdapter(R.layout.item_booppeening_record, bookkeepingItemBeans);
        bkRecord.setAdapter(bookkeepingRecordAdapter);
        bkTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        adapterInti();
        viewInit();
    }

    private void viewInit() {
        initAccountPrice();
    }

    private void initAccountPrice() {
        int inPrice = 0, outPrice = 0;
        for (BookkeepingItemBean bookkeepingItemBean : bookkeepingItemBeans) {
            if (bookkeepingItemBean.getRecordStatus() == 1) {
                inPrice += bookkeepingItemBean.getRecordPrice();
            } else {
                outPrice += bookkeepingItemBean.getRecordPrice();
            }
        }
        inAccount.setText(String.format("+%s", inPrice));
        outAccount.setText(String.format("-%s", outPrice));
        if(bookkeepingItemBeans.size() == MAX_PREVIEW_RECORD){
            bkMore.setRightString("查看更多");
            moreClickFlag = true;
        }else{
            bkMore.setRightString("");
        }
    }

    private void adapterInti() {
        bkRecord.addItemDecoration(new RuleRecyclerLines(mContext, RuleRecyclerLines.HORIZONTAL_LIST, 1));
        bookkeepingRecordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(bookkeepingItemBeans.get(position).getRecordName());
            }
        });
        bkMore.setOnClickListener(v -> {
            if (moreClickFlag) {
                startActivity(new Intent(mActivity, MoreBookkeepingActivity.class));
            }
        });
    }

    @Override
    public void startActivity() {

    }

    @Override
    public void failed(String msg) {

    }

    @Override
    public BasePresenter initPresenter() {
        return BookkeepingPresenter.newInstance();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Subscribe
    public void bookkeepingRefresh(BookkeepingRefreshEvent bookkeepingRefreshEvent){
        bookkeepingItemBeans.clear();
        bookkeepingItemBeans.addAll(RecordUtils.getInstance().getPreviewRecord());
        bookkeepingRecordAdapter.notifyDataSetChanged();
        initAccountPrice();
    }
}
