package com.tuita.bookkeeping.utils;

import static com.tuita.bookkeeping.command.Constant.SystemConfig.DEFAULT_PREVIEW_RECORD;
import static com.tuita.bookkeeping.command.Constant.SystemConfig.MAX_PREVIEW_RECORD;
import static com.tuita.bookkeeping.command.Constant.contents;
import static com.tuita.bookkeeping.command.Constant.resIds;

import android.annotation.SuppressLint;

import com.tuita.bookkeeping.room.entity.Bookkeeping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordUtils {
    private final List<Bookkeeping> bookkeepingItemBeans;

    private static final class RecordUtilsHolder {
        static final RecordUtils recordUtils = new RecordUtils();
    }

    public static RecordUtils getInstance() {
        return RecordUtilsHolder.recordUtils;
    }

    public RecordUtils() {
        bookkeepingItemBeans = new ArrayList<>();
    }

    public void initSimulationData() {
        for (int i = 0; i < DEFAULT_PREVIEW_RECORD; i++) {
            Bookkeeping bean = new Bookkeeping();
            int typePotion = (int) (Math.random() * 7);
            bean.setRecordBookkeepingType(resIds[typePotion]);
            bean.setRecordName(contents[typePotion]);
            bean.setRecordDescription("记一下，怕忘了");
            bean.setRecordPrice((int) (Math.random() * 5000));
            bean.setRecordStatus((int) (Math.random() * 2));
            bean.setRecordTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            bookkeepingItemBeans.add(bean);
        }
    }

    @SuppressLint("SimpleDateFormat")
    public boolean insertBookkeepingRecord(Bookkeeping bean) {
        return bookkeepingItemBeans.add(bean);
    }

    public List<Bookkeeping> getMoreRecord() {
        return bookkeepingItemBeans;
    }

    public List<Bookkeeping> getPreviewRecord() {
        return bookkeepingItemBeans.subList(0, Math.min(bookkeepingItemBeans.size(), MAX_PREVIEW_RECORD));
    }
}
