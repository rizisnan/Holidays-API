package com.example.projectakhir.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectakhir.AppDatabase;
import com.example.projectakhir.LoginDAO;
import com.example.projectakhir.R;

public class SignUpActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
private Button btnRegister,btnBack;
private EditText etNamaLengkap, etUsername, etPassword, etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        appDatabase = AppDatabase.iniDb(getApplicationContext());
        etNamaLengkap=findViewById(R.id.etNamaLengkap);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        etEmail=findViewById(R.id.etEmail);
        btnBack=findViewById(R.id.btnBack);
        btnRegister =findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insertData();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent moveIntent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(moveIntent);
            }
        });
    }
    private void insertData()
    {
        String Nama = etNamaLengkap.getText().toString();
        String Username = etUsername.getText().toString();
        String Email = etEmail.getText().toString();
        String Password = etPassword.getText().toString();

        LoginDAO item = new LoginDAO();
        item.setUsername(Username);
        item.setNama(Nama);
        item.setEmail(Email);
        item.setPassword(Password);

        appDatabase.dao().insertData(item);
        etNamaLengkap.setText("");
        etUsername.setText("");
        etEmail.setText("");
        etPassword.setText("");


    }
}
