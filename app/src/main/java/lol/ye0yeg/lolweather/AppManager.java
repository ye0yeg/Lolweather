package lol.ye0yeg.lolweather;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by Administrator on 6/22/2017.
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private volatile static AppManager instance;

    private AppManager() {
    }

    public static AppManager newInstance() {
        if (instance == null) {
            synchronized (AppManager.class) {
                instance = new AppManager();
                activityStack = new Stack<>();
            }
        }
        return instance;
    }

    public void addActivity(Activity activity){
        if(activityStack == null){
            activityStack=  new Stack<>();
        }
        activityStack.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity = null;
        }
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity = null;
        }
    }

    public void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    public boolean isOpenActivity(Class<?> clazz) {
        if (activityStack != null) {
            if (clazz == activityStack.peek().getClass()) {
                return true;
            }
        }
        return false;
    }

}
