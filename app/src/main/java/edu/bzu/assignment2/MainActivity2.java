package edu.bzu.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import edu.bzu.assignment2.pojo.Car;

public class MainActivity2 extends AppCompatActivity {
    public static final String university = "UNI";
    public static final String certificate = "CER";
    public static final String major = "MAJ";
    public static final String language = "LAN";
    public static final String FLAG = "FLAG";

    private EditText edtuniversity;
    private EditText edtcirtficate;
    private EditText edtmajor;
    private EditText lan;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupviews();
        setupsharedprefs();
        setupcheckprefs();

    }

    private void setupcheckprefs() {
        Car[] cars = new Car[2];
        cars[0] = new Car("marcedses", "red");
        cars[1] = new Car("BMW", "black");

        flag = prefs.getBoolean(FLAG, false);
        if (flag) {
            String uni = prefs.getString(university, "");
            String cir = prefs.getString(certificate, "");
            String maj = prefs.getString(major, "");
            String lang = prefs.getString(language, "");
            edtuniversity.setText(uni);
            edtcirtficate.setText(cir);
            edtmajor.setText(maj);
            lan.setText(lang);


//            Gson gson = new Gson();
//            carsString = gson.toJson(cars);
//            editor.putString("2358", carsString);
//            editor.commit();

            //  check.setChecked(true);

        }


    }

    private void setupsharedprefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void setupviews() {
        edtuniversity = findViewById(R.id.edtuniversity);
        edtcirtficate = findViewById(R.id.edtcirtficate);
        edtmajor = findViewById(R.id.edtmajor);
        lan = findViewById(R.id.lan);
    }


    public void save(View view) {
        String universityy = edtuniversity.getText().toString();
        String cir = edtcirtficate.getText().toString();
        String majo = edtmajor.getText().toString();
        String lang = lan.getText().toString();
        //  String gender =spinner.getSelectedItem().toString();
        editor.putString(university, universityy);
        editor.putString(certificate, cir);
        editor.putString(major, majo);
        editor.putString(language, lang);

        editor.putBoolean(FLAG, true);
        editor.commit();
//        Toast.makeText(this, "Data Saved:\n" + carsString,
//                Toast.LENGTH_SHORT).show();
    }
}