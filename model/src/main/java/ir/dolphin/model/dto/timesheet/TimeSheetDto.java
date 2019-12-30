package ir.dolphin.model.dto.timesheet;


/**
 * @author amin.rafiee
 */


import ir.dolphin.model.BaseStaticEntity;

import java.sql.Timestamp;

/**
 *
 * @EntityName پروفایل فروشنده
 */

public class TimeSheetDto implements BaseStaticEntity {

    private Timestamp currentTime;
    private int registerType;


    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public int getRegisterType() {
        return registerType;
    }

    public void setRegisterType(int registerType) {
        this.registerType = registerType;
    }
}
