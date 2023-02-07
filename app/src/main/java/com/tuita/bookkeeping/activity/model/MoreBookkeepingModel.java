package com.tuita.bookkeeping.activity.model;

import com.tuita.bookkeeping.activity.contract.MoreBookkeepingContract;

public class MoreBookkeepingModel implements MoreBookkeepingContract.MoreBookkeepingModel {
    public static MoreBookkeepingModel getInstance() {
        return new MoreBookkeepingModel();
    }

}
