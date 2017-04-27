package co.minium.launcher3.mm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.sharedpreferences.Pref;

import co.minium.launcher3.app.Launcher3Prefs_;

/**
 * Created by tkb on 2017-03-21.
 */

@EReceiver
public class AlarmReciever extends BroadcastReceiver
{
    @Pref
    Launcher3Prefs_ launcherPrefs;
    @Override
    public void onReceive(Context context, Intent intent)
    {

        Log.e("TKB",launcherPrefs.isAwayChecked().get()+"");
        if (launcherPrefs.isAwayChecked().get()) {

            MindfulMorningActivity_.intent(context).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
        }
    }

}