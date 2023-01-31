package com.tuita.bookkeeping.fragment.presenter;

import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.fragment.contract.BookkeepingContract;
import com.tuita.bookkeeping.fragment.model.BookkeepingModel;

public class BookkeepingPresenter extends BookkeepingContract.BookkeepingPresenter {

    public static BasePresenter newInstance() {
        return new BookkeepingPresenter();
    }

    @Override
    protected BookkeepingContract.IBookkeepingModel getModel() {
        return BookkeepingModel.getInstance();
    }

    @Override
    public void onStart() {

    }
}
