package com.tuita.bookkeeping.fragment.contract;


import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.base.IBaseActivity;
import com.tuita.bookkeeping.base.IBaseModel;

public interface MoreContract {
    abstract class MorePresenter extends BasePresenter<IMoreModel,IMoreView> {

    }

    interface IMoreModel extends IBaseModel {

    }

    interface IMoreView extends IBaseActivity {

    }
}
