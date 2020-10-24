package com.budimanlai.basictemplate;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.budimanlai.basictemplate.library.MyAppCompatActivity;

public class SplashActivity extends MyAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // display app version in splash screen
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            final TextView txtVersion = findViewById(R.id.txtVersion);
            txtVersion.setText(getString(R.string.app_ver, pInfo.versionName));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // show splash screen in 2 seconds before enter to main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }
}