package com.alejandro.seccion_05_sharedpreferences_lab.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.alejandro.seccion_05_sharedpreferences_lab.Activities.LoginActivity;
import com.alejandro.seccion_05_sharedpreferences_lab.Activities.MainActivity;
import com.alejandro.seccion_05_sharedpreferences_lab.Utils.Util;

public class SplashScreenActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);

        if (!TextUtils.isEmpty(Util.getUserMailPrefs(prefs)) &&
                !TextUtils.isEmpty(Util.getUserPassPrefs(prefs))) {
            startActivity(intentMain);
        } else {
            startActivity(intentLogin);
        }
        finish();
    }

}
