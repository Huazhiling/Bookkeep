package com.tuita.bookkeeping.activity.presenter;

import com.tuita.bookkeeping.activity.contract.MoreBookkeepingContract;
import com.tuita.bookkeeping.activity.model.MoreBookkeepingModel;
import com.tuita.bookkeeping.base.BasePresenter;

public class MoreBookkeepingPresenter extends MoreBookkeepingContract.MoreBookkeepingPresenter {

    public static BasePresenter newInstance() {
        return new MoreBookkeepingPresenter();
    }

    @Override
    protected MoreBookkeepingContract.MoreBookkeepingModel getModel() {
        return MoreBookkeepingModel.getInstance();
    }

    @Override
    public void onStart() {

    }
}
