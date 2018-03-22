package co.siempo.phone.utils;

import android.content.Context;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import co.siempo.phone.app.CoreApplication;
import co.siempo.phone.models.AppListInfo;
import co.siempo.phone.models.MainListItem;

import static java.util.Collections.sort;

/**
 * Created by rajeshjadi on 9/2/18.
 */

public class Sorting {
    /**
     * Sort the application alphabetically.
     *
     * @param context
     * @param list
     * @return
     */
    public static ArrayList<ResolveInfo> sortAppAssignment(final Context context, ArrayList<ResolveInfo> list) {
        sort(list, new Comparator<ResolveInfo>() {
            @Override
            public int compare(final ResolveInfo object1, final ResolveInfo object2) {
                if (object1 != null && object2 != null) {
                    int sortValue = object1.loadLabel(context
                            .getPackageManager()).toString().toLowerCase().compareTo
                            (object2.loadLabel(context.getPackageManager())
                                    .toString().toLowerCase());
                    return sortValue;
                } else {
                    return 1;
                }
            }
        });
        return list;
    }

    /**
     * Sort the application alphabetically.
     *
     * @param list
     * @return
     */
    public static ArrayList<String> sortJunkAppAssignment(ArrayList<String> list) {
        sort(list, new Comparator<String>() {
            @Override
            public int compare(final String object1, final String object2) {
                return CoreApplication.getInstance().getApplicationNameFromPackageName(object1).compareTo(CoreApplication.getInstance().getApplicationNameFromPackageName(object2));
            }
        });
        return list;
    }


    public static ArrayList<MainListItem> SortApplications(final ArrayList<MainListItem> appList) {
        sort(appList, new Comparator<MainListItem>() {
            @Override
            public int compare(final MainListItem object1, final MainListItem object2) {
                return object1.getTitle().toLowerCase().compareTo(object2.getTitle().toLowerCase());
            }
        });
        return appList;
    }


    public static ArrayList<MainListItem> sortToolAppAssignment(final Context context, ArrayList<MainListItem> list) {
        Collections.sort(list, new Comparator<MainListItem>() {
            @Override
            public int compare(final MainListItem object1, final MainListItem object2) {
                return object1.getTitle().toLowerCase().compareTo(object2.getTitle().toLowerCase());
            }
        });
        return list;
    }

    public static List<AppListInfo> sortApplication(List<AppListInfo> list) {
        Collections.sort(list, new Comparator<AppListInfo>() {
            @Override
            public int compare(final AppListInfo object1, final AppListInfo object2) {
                String strObj1;
                String strObj2;

                if (CoreApplication.getInstance().getListApplicationName().get(object1.packageName) != null) {
                    strObj1 = CoreApplication.getInstance().getListApplicationName().get(object1.packageName);
                } else {
                    strObj1 = CoreApplication.getInstance().getApplicationNameFromPackageName(object1.packageName);
                }

                if (CoreApplication.getInstance().getListApplicationName().get(object2.packageName) != null) {
                    strObj2 = CoreApplication.getInstance().getListApplicationName().get(object2.packageName);
                } else {
                    strObj2 = CoreApplication.getInstance().getApplicationNameFromPackageName(object2.packageName);
                }

                return (strObj1 != null ? strObj1.toLowerCase() : "").compareTo((strObj2 != null ? strObj2.toLowerCase() : ""));
            }
        });
        return list;
    }

}