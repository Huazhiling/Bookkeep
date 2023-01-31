package com.tuita.bookkeeping.fragment.view;

import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseMvpFragment;
import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.fragment.contract.BookkeepingContract;
import com.tuita.bookkeeping.fragment.presenter.BookkeepingPresenter;

@XmlLayoutResId(portContentId = R.layout.fragment_bookkeeping)
public class BookkeepingFragment extends BaseMvpFragment<BookkeepingPresenter> implements BookkeepingContract.IBookkeepingView {
    @Override
    protected void initView() {

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
}
