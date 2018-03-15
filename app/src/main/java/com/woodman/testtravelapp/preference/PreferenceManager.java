package com.woodman.testtravelapp.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Zver on 14.03.2018.
 */

public class PreferenceManager {
    private SharedPreferences preferences;
    private  SharedPreferences.Editor editor;
    private static PreferenceManager preferenceManager=new PreferenceManager();

    private PreferenceManager() {
    }

    public static PreferenceManager getInstance(){
        return preferenceManager;
    }
     public void setSoundNotification(Context context,boolean sound){
        preferences=context.getSharedPreferences("SoundNotification",Context.MODE_PRIVATE);
        editor=preferences.edit();
        editor.putBoolean("Sound",sound);
        editor.apply();
     }
     public void setVibrationNotification(Context context,boolean vibration){
         preferences=context.getSharedPreferences("VibrationNotification",Context.MODE_PRIVATE);
         editor=preferences.edit();
         editor.putBoolean("Vibration",vibration);
         editor.apply();
     }
     public boolean getSoundNotification(Context context){
         preferences=context.getSharedPreferences("SoundNotification",Context.MODE_PRIVATE);
         return preferences.getBoolean("Sound",true);
     }
     public boolean getVibrationNotification(Context context){
         preferences=context.getSharedPreferences("VibrationNotification",Context.MODE_PRIVATE);
         return preferences.getBoolean("Vibration",true);
     }
}
