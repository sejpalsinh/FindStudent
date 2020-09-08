package com.i2i.findstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Login extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    EditText e_uname,e_pass;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e_uname = findViewById(R.id.et_email);
        e_pass =   findViewById(R.id.et_pass);
        preferences = getSharedPreferences("findstident", MODE_PRIVATE);
        editor = preferences.edit();
        requestQueue = Volley.newRequestQueue(this);
    }

    public void makeLogin(View view) {
        String uname,pass;
        uname = e_uname.getText().toString();
        pass = e_pass.getText().toString();
        isUser(uname, pass);
    }
    void isUser(String uname,String pass)
    {
        String url = "http://18soeit11033.dx.am/findstudent/checkuser.php?uname="+uname+"&pass="+pass;
        System.out.println("url url : "+url);
        final boolean[] isUser = {false};
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        if(response.toString().charAt(0)=='1')
                        {
                            editor.putString("islogin","1");
                            editor.commit();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Please Check Username and password",Toast.LENGTH_LONG).show();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(),"Please try Again Letter",Toast.LENGTH_LONG).show();
                    }

                });

        requestQueue.add(stringRequest);
    }
}
