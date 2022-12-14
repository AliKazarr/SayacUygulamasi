package com.example.counter;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsClass {
    int upperLimit;
    int lowerLimit;
    int currentValue;
    boolean upperVib;
    boolean upperSound;
    boolean lowerVib;
    boolean lowerSound;;

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    static SettingsClass settingsClass=null;

    private SettingsClass(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("settings", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public static SettingsClass  getInstance(Context context) {
        if (settingsClass == null) {
            settingsClass=new SettingsClass(context);
        }
            return settingsClass;
    }
       public void setValues(int upperLimit ,int lowerLimit, int currentValue,boolean upperSound,boolean lowerSound,boolean lowerVib,boolean upperVib )
       {
           this.upperLimit=upperLimit;
           this.lowerLimit=lowerLimit;
           this.currentValue=currentValue;
           this.upperVib=upperVib;
           this.lowerVib=lowerVib;
           this.upperSound=upperSound;
           this.lowerSound=lowerSound;
       }
       public void saveValues()
       {
           editor.putInt("upperLimit",upperLimit);
           editor.putInt("lowerLimit",lowerLimit);
           editor.putInt("currentValue",currentValue);
           editor.putBoolean("upperVib",upperVib);
           editor.putBoolean("lowerVib",lowerVib);
           editor.putBoolean("upperSound",upperSound);
           editor.putBoolean("lowerSound",lowerSound);
           editor.commit();
       }
 public void loadValues()
 {
          upperLimit=sharedPreferences.getInt("upperLimit",20);
          lowerLimit=sharedPreferences.getInt("lowerLimit",0);
          currentValue=sharedPreferences.getInt("currentValue",0);
          upperVib=sharedPreferences.getBoolean("upperVib",true);
          lowerVib=sharedPreferences    .getBoolean("lowerVib",true);
          upperSound=sharedPreferences.getBoolean("upperSound",true);
          lowerSound=sharedPreferences.getBoolean("lowerSound",true);

 }
}
