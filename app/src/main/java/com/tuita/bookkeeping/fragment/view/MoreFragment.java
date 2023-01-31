package com.tuita.bookkeeping.fragment.view;

import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseMvpFragment;
import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.fragment.contract.BookkeepingContract;
import com.tuita.bookkeeping.fragment.contract.MoreContract;
import com.tuita.bookkeeping.fragment.presenter.BookkeepingPresenter;
import com.tuita.bookkeeping.fragment.presenter.MorePresenter;

@XmlLayoutResId(portContentId = R.layout.fragment_more)
public class MoreFragment extends BaseMvpFragment<MorePresenter> implements MoreContract.IMoreView {
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
        return MorePresenter.newInstance();
    }
}
