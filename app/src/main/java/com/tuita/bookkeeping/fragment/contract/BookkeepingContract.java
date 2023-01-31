package com.tuita.bookkeeping.fragment.contract;

import com.tuita.bookkeeping.base.BasePresenter;
import com.tuita.bookkeeping.base.IBaseActivity;
import com.tuita.bookkeeping.base.IBaseModel;
import com.tuita.bookkeeping.base.IBaseView;

public interface BookkeepingContract {
    abstract class BookkeepingPresenter extends BasePresenter<IBookkeepingModel,IBookkeepingView>{

    }

    interface IBookkeepingModel extends IBaseModel {

    }

    interface IBookkeepingView extends IBaseActivity {

    }
}
