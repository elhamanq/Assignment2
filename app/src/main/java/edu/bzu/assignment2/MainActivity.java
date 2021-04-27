package edu.bzu.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;

import edu.bzu.assignment2.pojo.Car;

public class MainActivity extends AppCompatActivity {
    public static final String UName="NAME";
    public static final String EMAIL="EMAIL";
    public static final String hobbies="HOBBIES";
    public static final String gender="GENDER";
    public static final String FLAG="FLAG";
   public static  String carsString="";
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtHobbies;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private boolean flag=false;
    private CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupviews();
        setupsharedprefs();
        setupcheckprefs();
        
    }

    private void setupcheckprefs() {
       Car[] cars = new Car[2];
        cars[0] = new Car("marcedses", "red");
        cars[1] = new Car("BMW", "black");
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        flag=prefs.getBoolean(FLAG,false);
        if(flag){
            String name=prefs.getString(UName, "");
            String email=prefs.getString(EMAIL,"");
            String hobby=prefs.getString(hobbies,"");
            String Gen=prefs.getString(gender,"");
            edtName.setText(name);
            edtEmail.setText(email);
            edtHobbies.setText(hobby);


            Gson gson = new Gson();
           carsString = gson.toJson(cars);
            editor.putString("2358", carsString);
          editor.commit();

          //  check.setChecked(true);

        }



    }

    private void setupsharedprefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();
    }

    private void setupviews() {
        edtName=findViewById(R.id.name);
        edtEmail=findViewById(R.id.email);
        edtHobbies=findViewById(R.id.hobbies);
        radioGroup =findViewById(R.id.radioG);
    }


    public void saveData(View view) {
        String name =edtName.getText().toString();
        String email =edtEmail.getText().toString();
        String hobby = edtHobbies.getText().toString();
      //  String gender =spinner.getSelectedItem().toString();
        editor.putString(UName,name);
        editor.putString(EMAIL,email);
        editor.putString(hobbies,hobby);

        editor.putBoolean(FLAG,true);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + carsString,
                Toast.LENGTH_SHORT).show();
    }
    public void btnonclick(View view) {
        Intent intent = new Intent( this,MainActivity2.class);
        startActivity(intent);
    }
}