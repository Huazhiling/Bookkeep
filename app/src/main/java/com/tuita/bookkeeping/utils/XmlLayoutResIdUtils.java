package com.tuita.bookkeeping.utils;


import android.app.Activity;
import android.util.DisplayMetrics;

import com.tuita.bookkeeping.annoation.XmlLayoutResId;

/**
 * 解析注解布局的文件
 *
 * @author Administrator
 */
public class XmlLayoutResIdUtils {
    public static int checkRes(Object clazz) {
        boolean annotationPresent = clazz.getClass().isAnnotationPresent(XmlLayoutResId.class);
        if (!annotationPresent) {
            throw new IllegalStateException("Activity或Fragment必须有注解布局文件");
        }
        XmlLayoutResId annotation = clazz.getClass().getAnnotation(XmlLayoutResId.class);
        if (clazz instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) clazz).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels > displayMetrics.heightPixels ?
                    (annotation.landContentId() == 0 ? annotation.portContentId() : annotation.landContentId())
                    : annotation.portContentId();
        } else {
            //默认竖屏
            return annotation.portContentId();
        }
    }
}
