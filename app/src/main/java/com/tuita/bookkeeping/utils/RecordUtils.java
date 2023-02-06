package com.tuita.bookkeeping.utils;

import static com.tuita.bookkeeping.command.Constant.contents;
import static com.tuita.bookkeeping.command.Constant.resIds;

import android.annotation.SuppressLint;

import com.tuita.bookkeeping.bean.BookkeepingItemBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordUtils {
    private final List<BookkeepingItemBean> bookkeepingItemBeans;
    private static RecordUtils recordUtils;
    private static final Object object = new Object();

    public static RecordUtils getInstance() {
        if (recordUtils == null) {
            synchronized (object) {
                if (recordUtils == null) {
                    recordUtils = new RecordUtils();
                }
            }
        }
        return recordUtils;
    }

    public RecordUtils() {
        bookkeepingItemBeans = new ArrayList<>();
    }

    public List<BookkeepingItemBean> initSimulationData() {
        return initSimulationData(5);
    }

    @SuppressLint("SimpleDateFormat")
    public List<BookkeepingItemBean> initSimulationData(int number) {
        for (int i = 0; i < number; i++) {
            BookkeepingItemBean bean = new BookkeepingItemBean();
            int typePotion = (int) (Math.random() * 7);
            bean.setRecordBookkeepingType(resIds[typePotion]);
            bean.setRecordName(contents[typePotion]);
            bean.setRecordDescription("记一下，怕忘了");
            bean.setRecordPrice((int) (Math.random() * 5000));
            bean.setRecordStatus((int) (Math.random() * 2));
            bean.setRecordTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            bookkeepingItemBeans.add(bean);
        }
        return bookkeepingItemBeans;
    }

    @SuppressLint("SimpleDateFormat")
    public boolean insertBookkeepingRecord(BookkeepingItemBean bean) {
        return bookkeepingItemBeans.add(bean);
    }

    public List<BookkeepingItemBean> getMoreRecord(){
        return bookkeepingItemBeans;
    }

    public List<BookkeepingItemBean> getPreviewRecord(){
        return bookkeepingItemBeans.subList(0,10);
    }
}
