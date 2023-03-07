package com.tuita.bookkeeping.utils;

import static com.tuita.bookkeeping.command.Constant.SystemConfig.MAX_PREVIEW_RECORD;

import com.tuita.bookkeeping.room.entity.Bookkeeping;

import java.util.ArrayList;
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
