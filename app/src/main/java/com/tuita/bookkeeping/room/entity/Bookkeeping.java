package com.tuita.bookkeeping.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bookkeeping {
    @PrimaryKey(autoGenerate = true)
    private int recordId;
    /**
     * 记录时间
     */
    private String recordTime;
    /**
     * 名称
     */
    private String recordName;
    /**
     * 描述，备注
     */
    private String recordDescription;
    /**
     * 语音描述
     */
    private String recordAudioDesc;
    /**
     * 人情金额
     */
    private int recordPrice;
    /**
     * 人情类型
     */
    private int recordBookkeepingType;
    /**
     * 人情状态，是支出，还是收入
     */
    private int recordStatus;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }

    public String getRecordAudioDesc() {
        return recordAudioDesc;
    }

    public void setRecordAudioDesc(String recordAudioDesc) {
        this.recordAudioDesc = recordAudioDesc;
    }

    public int getRecordPrice() {
        return recordPrice;
    }

    public void setRecordPrice(int recordPrice) {
        this.recordPrice = recordPrice;
    }

    public int getRecordBookkeepingType() {
        return recordBookkeepingType;
    }

    public void setRecordBookkeepingType(int recordBookkeepingType) {
        this.recordBookkeepingType = recordBookkeepingType;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

}
