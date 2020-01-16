package com.intentfuzzer;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.intentfuzzer", appContext.getPackageName());
        List<PackageInfo> packages = appContext.getPackageManager().getInstalledPackages(
                PackageManager.GET_DISABLED_COMPONENTS
                        | PackageManager.GET_ACTIVITIES
                        | PackageManager.GET_RECEIVERS
                        | PackageManager.GET_INSTRUMENTATION
                        | PackageManager.GET_SERVICES);
        for(int i=0;i< packages.size();i++){

            Log.i("packagestest", "useAppContext: " + packages.get(i).packageName);
            Log.i("packagestest", "useAppContext: " + packages.get(i).activities);
            Log.i("packagestest", "useAppContext: " + packages.get(i).receivers);
            Log.i("packagestest", "useAppContext: " + packages.get(i).services.toString());
        }

    }
}
