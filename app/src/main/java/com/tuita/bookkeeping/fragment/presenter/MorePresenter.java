package com.tuita.bookkeeping.fragment.presenter;


import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.fragment.contract.MoreContract;
import com.tuita.bookkeeping.fragment.model.MoreModel;

public class MorePresenter extends MoreContract.MorePresenter {

    public static BasePresenter newInstance() {
        return new MorePresenter();
    }

    @Override
    protected MoreContract.IMoreModel getModel() {
        return MoreModel.getInstance();
    }

    @Override
    public void onStart() {

    }
}
