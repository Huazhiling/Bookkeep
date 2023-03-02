package com.tuita.bookkeeping.activity;

import static com.tuita.bookkeeping.command.Constant.contents;
import static com.tuita.bookkeeping.command.Constant.resIds;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.tuita.bookkeeping.R;
import com.tuita.bookkeeping.adapter.rvadapter.BookkeepingTypeAdapter;
import com.tuita.bookkeeping.adapter.rvadapter.InsertItemAdapter;
import com.tuita.bookkeeping.annoation.XmlLayoutResId;
import com.tuita.bookkeeping.base.BaseActivity;
import com.tuita.bookkeeping.bean.BookkeepingTypeBean;
import com.tuita.bookkeeping.bean.InsertItemBean;
import com.tuita.bookkeeping.event.BookkeepingRefreshEvent;
import com.tuita.bookkeeping.listener.ICountDownCallBack;
import com.tuita.bookkeeping.room.database.BookkeepingDatabase;
import com.tuita.bookkeeping.room.entity.Bookkeeping;
import com.tuita.bookkeeping.utils.RecordUtils;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlLayoutResId(portContentId = R.layout.activity_insert_bookkeeping)
public class InsertBookkeepingActivity extends BaseActivity {
    private RecyclerView typeRv;
    private BookkeepingTypeAdapter bookkeepingTypeAdapter;
    private InsertItemAdapter insertItemAdapter;
    private List<BookkeepingTypeBean> bookkeepingTypeBeans;
    private List<InsertItemBean> insertItemBeans;
    private ImageView insertTypeIcon;
    private TextView insertTypeName;
    private EditText insertPerson;
    private TextView insertTypeTime;
    private RadioButton insertStatusSl;
    private RadioButton insertStatusHl;
    private RecyclerView insertItem;
    private EditText insertRemark;
    private TextView insertRemarkAudio;
    private TextView insertAddItem;
    private TextView insertAllPrice;
    private TextView insertSubmit;
    private int selectPosition;

    @Override
    protected void adapterInit() {
        typeRv.setAdapter(bookkeepingTypeAdapter);
        insertItem.setAdapter(insertItemAdapter);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void viewInit() {
        bookkeepingTypeAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            selectPosition = position;
            insertTypeIcon.setImageResource(resIds[position]);
            insertTypeName.setText(contents[position]);
        });
        insertItemAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.item_reduce) {
                insertItemBeans.remove(position);
                insertItemAdapter.notifyItemRemoved(position);
            }
        });
        insertItemAdapter.setInsertCallBack((content, position) -> {
            insertItemBeans.get(position).setName(content);
//            insertItemAdapter.notifyItemChanged(position);
        });
        insertTypeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("不可编辑，请从上方选择一项或添加新的人情帐类型");
            }
        });
        insertStatusSl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    insertAllPrice.setTextColor(getColor(R.color.app_in_color));
                }
            }
        });
        insertStatusHl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                insertAllPrice.setTextColor(getColor(R.color.app_out_color));
            }
        });
        insertTypeTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        addBookkeepingItem(true);
        insertAddItem.setOnClickListener(v -> {
            if (insertItemBeans.size() >= 5) {
                ToastUtils.showShort("最多添加五项");
                return;
            }
            addBookkeepingItem(false);
        });
        insertSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkInfo()) {
                    return;
                }
                Bookkeeping bean = new Bookkeeping();
                bean.setRecordBookkeepingType(resIds[selectPosition]);
                bean.setRecordName(contents[selectPosition]);
                bean.setRecordDescription(insertRemark.getText().toString().trim());
                int recordPrice = 0;
                for (InsertItemBean insertItemBean : insertItemBeans) {
                    int convertNumber = insertItemBean.getName().isEmpty() ? 0 : Integer.parseInt(insertItemBean.getName());
                    recordPrice += convertNumber;
                }
                bean.setRecordPrice(recordPrice);
                bean.setRecordStatus(insertStatusSl.isChecked() ? 0 : 1);
                bean.setRecordTime(insertTypeTime.getText().toString().trim());
                bean.setRecordPerson(insertPerson.getText().toString().trim());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        BookkeepingDatabase.getInstance(getApplicationContext())
                                .bookkeepingDao()
                                .insertRecord(bean);
                    }
                }).start();
//                boolean isAdd = RecordUtils.getInstance().insertBookkeepingRecord(bean);
//                if (count > 0) {
                showSuccessDialog(() -> {
                    EventBus.getDefault().post(new BookkeepingRefreshEvent());
                    finish();
                }, new ICountDownCallBack() {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        dialog.dismiss();
                    }
                });
            }
//            }
        });
    }

    private boolean checkInfo() {
        if (insertTypeName.getText().toString().trim().isEmpty()) {
            ToastUtils.showShort("请选择一项人情帐");
            return false;
        }
        if (insertPerson.getText().toString().trim().isEmpty()) {
            ToastUtils.showShort("请输入来往人员姓名");
            return false;
        }
        return true;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void addBookkeepingItem(boolean isDefault) {
        InsertItemBean insertItemBean = new InsertItemBean();
        insertItemBean.setDefault(isDefault);
        insertItemBean.setInsertType(1);
        insertItemBean.setInsertTypeName("现金");
        insertItemBeans.add(insertItemBean);
        insertItemAdapter.notifyItemInserted(insertItemBeans.size());
    }

    @Override
    protected void findView() {
        typeRv = findViewById(R.id.type_rv);
        insertTypeIcon = findViewById(R.id.insert_type_icon);
        insertTypeName = findViewById(R.id.insert_type_name);
        insertPerson = findViewById(R.id.insert_person);
        insertTypeTime = findViewById(R.id.insert_type_time);
        insertStatusSl = findViewById(R.id.insert_status_sl);
        insertStatusHl = findViewById(R.id.insert_status_hl);
        insertItem = findViewById(R.id.insert_item);
        insertRemark = findViewById(R.id.insert_remark);
        insertRemarkAudio = findViewById(R.id.insert_remark_audio);
        insertAddItem = findViewById(R.id.insert_add_item);
        insertAllPrice = findViewById(R.id.insert_all_price);
        insertSubmit = findViewById(R.id.insert_submit);
    }

    @Override
    protected void initView() {
        bookkeepingTypeBeans = new ArrayList<>();
        insertItemBeans = new ArrayList<>();
        int forCount = resIds.length;
        for (int i = 0; i < forCount; i++) {
            BookkeepingTypeBean bookkeepingTypeBean = new BookkeepingTypeBean();
            bookkeepingTypeBean.setTypeId(i);
            bookkeepingTypeBean.setResId(resIds[i]);
            bookkeepingTypeBean.setTypeName(contents[i]);
            bookkeepingTypeBeans.add(bookkeepingTypeBean);
        }
        bookkeepingTypeAdapter = new BookkeepingTypeAdapter(R.layout.item_insert_bookkeeping_icon, bookkeepingTypeBeans);
        insertItemAdapter = new InsertItemAdapter(R.layout.item_insert_default, insertItemBeans);
    }
}
