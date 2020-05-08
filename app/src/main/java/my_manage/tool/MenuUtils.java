package my_manage.tool;

import android.view.Menu;
import android.view.Window;

import java.lang.reflect.Method;

public final class MenuUtils {
    public static void setIconVisibe(int featureId, Menu menu) {
        //ActionBar的featureId=8,Toolbar 的featureId=108
        if (featureId % 100 == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try{
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
