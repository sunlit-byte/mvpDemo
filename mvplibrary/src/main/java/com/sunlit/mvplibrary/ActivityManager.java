package com.sunlit.mvplibrary;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动管理类
 */
public class ActivityManager {

    /**
     * 保存所有的活动页
     */
    private List<Activity> activityList = new ArrayList<>();

    //添加活动页

    public void addActivity(Activity activity){
        if(activity != null){
            activityList.add(activity);
        }
    }

    //删除活动页
    public  void removeActivity(Activity activity){
        if(activity != null){
            activityList.remove(activity);
        }
    }

    //关闭活动页
    public void finishActivity(){
        for(Activity activity : activityList){
            activity.finish();
        }
    }

}
