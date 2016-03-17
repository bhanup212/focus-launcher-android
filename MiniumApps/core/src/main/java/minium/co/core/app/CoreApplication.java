package minium.co.core.app;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import org.androidannotations.annotations.EApplication;

import io.fabric.sdk.android.Fabric;
import minium.co.core.BuildConfig;
import minium.co.core.R;
import minium.co.core.config.Config;
import minium.co.core.log.Tracer;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Each application should contain an {@link Application} class instance
 * All applications of this project should extend their own application from this class
 * This will be first class where we can initialize all necessary first time configurations
 *
 * Created by shahab on 3/17/16.
 */
@EApplication
public abstract class CoreApplication extends Application {

    private static CoreApplication sInstance;

    public static synchronized CoreApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        Tracer.i("Version code: " + BuildConfig.VERSION_CODE);
        Tracer.i("Version name: " + BuildConfig.VERSION_NAME);
        Tracer.i("Build time: " + BuildConfig.BUILD_TIME);
        Tracer.i("Application Id: " + BuildConfig.APPLICATION_ID);
        Tracer.i("Build type: " + BuildConfig.BUILD_TYPE);
        Tracer.i("Git SHA: " + BuildConfig.GIT_SHA);
        Tracer.i("Debug? : " + BuildConfig.DEBUG);

        init();
    }

    protected void init() {
        // set initial configurations here
        configCalligraphy();
        configFabric();
    }

    private void configCalligraphy() {
        CalligraphyConfig
                .initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath(getString(Config.DEFAULT_FONT_PATH_RES))
                        .setFontAttrId(R.attr.fontPath)
                        .build());
    }

    private void configFabric() {
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(Config.DEBUG)
                .build();
        Fabric.with(fabric);
    }
}