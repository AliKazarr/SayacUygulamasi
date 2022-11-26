package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
    int uplimit=20 ;
    Button lowerLimit,upperLimit,lowerplus,lowerminus;
    EditText upvalue,lowvalue;
    CheckBox upVib,upSound,lowVib,lowSound;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
         upperLimit=(Button) findViewById(R.id.up_plus);
         lowerLimit=(Button) findViewById(R.id.up_minus);
         upvalue=(EditText) findViewById(R.id.upper);

        lowerplus=(Button) findViewById(R.id.low_plus);
        lowerminus=(Button) findViewById(R.id.low_minus);
        lowvalue=(EditText) findViewById(R.id.lower);

         upVib=(CheckBox) findViewById(R.id.up_vib);
         upSound=(CheckBox) findViewById(R.id.up_sound);
         lowVib=(CheckBox) findViewById(R.id.low_vib);

         Context context=getApplicationContext();
         prefs=context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
         editor=prefs.edit();
        upvalue.setText(String.valueOf(uplimit));
         upperLimit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                uplimit++;
                upvalue.setText(String.valueOf(uplimit));
             }
         });
        lowerLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uplimit--;
                upvalue.setText(String.valueOf(uplimit));
            }
        });
upvalue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View view, boolean b) {
        uplimit=Integer.valueOf(upvalue.getText().toString());
    }
});
    }

    @Override
    protected void onPause() {
        super.onPause();
        uplimit=Integer.valueOf(upvalue.getText().toString());
        editor.putInt("UpperLimit",uplimit);
        editor.commit();
    }
}