package com.tuita.bookkeeping.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @author Administrator
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
            mPresenter.attachMVP(this);
        }
        initMVPView();
        initMVPData();
    }

    protected abstract void initMVPData();

    protected abstract void initMVPView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMVP();
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
    }
}
