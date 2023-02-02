package com.tuita.bookkeeping.base;


import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.listener.ICountDownCallBack;
import com.tuita.bookkeeping.listener.IDialogDismissCallBack;
import com.tuita.bookkeeping.utils.XmlLayoutResIdUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Administrator
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = getClass().getSimpleName();
    protected Dialog dialog;
    protected CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(XmlLayoutResIdUtils.checkRes(this));
        TAG = this.getClass().getSimpleName();
        findView();
        ImmersionBar.with(this).statusBarView(R.id.status_bar).statusBarDarkFont(true).init();
        initView();
        viewInit();
        adapterInit();
        EventBus.getDefault().register(this);
        initDialog();
    }

    private void initDialog() {
        dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
    }

    /**
     * adapter 初始化
     */
    protected abstract void adapterInit();

    /**
     * 对View设置一些点击事件等初始化
     */
    protected abstract void viewInit();

    /**
     * findViewById
     */
    protected abstract void findView();

    @Subscribe
    public void objEvent(Object obj) {

    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    /**
     * 该方法初始化一些基础库或基础属性
     */
    protected void initData() {

    }

    protected abstract void initView();

    public void onBackFinish(View view) {
        finish();
    }

    /**
     * 检查手机上是否安装了指定的软件
     *
     * @param context
     * @param packageName：应用包名
     * @return
     */
    protected boolean isAvailable(Context context, String packageName) {
        //获取packageManager
        final PackageManager packageManager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> packageInfo = packageManager.getInstalledPackages(0);
        //用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<>();
        //packageInfo，压入pName list中
        if (packageInfo != null) {
            for (int i = 0; i < packageInfo.size(); i++) {
                String packName = packageInfo.get(i).packageName;
                packageNames.add(packName);
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName);
    }

    /**
     * 判断某个activity是否在activity栈顶
     *
     * @param cls
     * @param context
     * @return
     */
    private boolean isActivityTop(Class cls, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String name = manager.getRunningTasks(1).get(0).topActivity.getClassName();
        return name.equals(cls.getName());
    }

    protected void showSuccessDialog(IDialogDismissCallBack iDialogDismissCallBack,ICountDownCallBack iCountDownCallBack) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog.setContentView(R.layout.dialog_system_notify);
        dialog.setOnDismissListener(dialog -> {
            iDialogDismissCallBack.dismiss();
        });
        dialog.show();
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(layoutParams);
        startCountDownTimer(1500,1500,iCountDownCallBack);
    }

    protected void startCountDownTimer(int millisInFuture, int countDownInterval, ICountDownCallBack iCountDownCallBack) {
        countDownTimer = new CountDownTimer(1500, 1500) {

            @Override
            public void onTick(long millisUntilFinished) {
                iCountDownCallBack.onTick(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                countDownTimer.cancel();
                iCountDownCallBack.onFinish();
            }
        }.start();
    }
}
