package com.tuita.bookkeeping.fragment.model;

import com.tuita.bookkeeping.fragment.contract.BookkeepingContract;

public class BookkeepingModel implements BookkeepingContract.IBookkeepingModel {

    public static BookkeepingModel getInstance() {
        return new BookkeepingModel();
    }
}
