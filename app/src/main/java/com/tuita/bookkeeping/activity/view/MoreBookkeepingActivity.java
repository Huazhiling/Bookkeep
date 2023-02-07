package com.tuita.bookkeeping.activity.view;

import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.activity.contract.MoreBookkeepingContract;
import com.tuita.bookkeeping.activity.presenter.MoreBookkeepingPresenter;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseActivity;
import com.tuita.bookkeeping.base.BaseMvpActivity;
import com.tuita.bookkeeping.base.BasePresenter;

@XmlLayoutResId(portContentId = R.layout.activity_more_bookkeeping)
public class MoreBookkeepingActivity extends BaseMvpActivity<MoreBookkeepingPresenter> implements MoreBookkeepingContract.MoreBookkeepingView {
    @Override
    protected void adapterInit() {

    }

    @Override
    protected void viewInit() {

    }

    @Override
    protected void findView() {

    }

    @Override
    protected void initMVPData() {

    }

    @Override
    protected void initMVPView() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public BasePresenter initPresenter() {
        return MoreBookkeepingPresenter.newInstance();
    }
}
