package com.i2i.findstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    Spinner s_school,s_bramch,s_sem;
    ArrayAdapter<CharSequence> adapter;
    EditText e_fname,e_mname,e_lname,e_enroll,e_mobile,e_email,e_dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s_school = findViewById(R.id.sp_school);
        s_bramch = findViewById(R.id.sp_branch);
        s_sem = findViewById(R.id.sp_sem);
        e_fname = findViewById(R.id.et_fname);
        e_mname = findViewById(R.id.et_mname);
        e_lname = findViewById(R.id.et_lname);
        e_enroll = findViewById(R.id.et_en_num);
        e_mobile = findViewById(R.id.et_mo_num);
        e_email = findViewById(R.id.et_email);
        e_dob = findViewById(R.id.et_dob);
        adapter = ArrayAdapter.createFromResource(this, R.array.school_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_school.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this, R.array.sem_number, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_sem.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this, R.array.allbranch, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_bramch.setAdapter(adapter);
        s_school.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name = s_school.getSelectedItem().toString();
                switch (name)
                {
                    case "SOE":
                        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.SOE, android.R.layout.simple_spinner_item);
                        break;
                    case "SOPT":
                        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.SOPT, android.R.layout.simple_spinner_item);
                        break;
                    case "SOS":
                        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.SOS, android.R.layout.simple_spinner_item);
                        break;
                    case "SODS":
                        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.SODS, android.R.layout.simple_spinner_item);
                        break;
                    case "SOP":
                        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.SOP, android.R.layout.simple_spinner_item);
                        break;
                    default:
                        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.allbranch, android.R.layout.simple_spinner_item);
                        break;
                }
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s_bramch.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void searchStudent(View view) {
        
    }
}
