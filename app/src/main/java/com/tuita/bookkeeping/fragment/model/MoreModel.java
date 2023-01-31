package com.tuita.bookkeeping.fragment.model;

import com.tuita.bookkeeping.fragment.contract.MoreContract;

public class MoreModel implements MoreContract.IMoreModel {

    public static MoreModel getInstance() {
        return new MoreModel();
    }
}
