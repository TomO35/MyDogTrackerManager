package fr.mds.mydogtrackermanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.mds.mydogtrackermanager.R;

public class RegisterActivity extends AppCompatActivity {

    EditText et_name, et_firstname, et_email, et_password, et_passConf;
    Button btnOk;
    boolean pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = findViewById(R.id.etName);
        et_firstname = findViewById(R.id.etFirstname);
        et_email = findViewById(R.id.etEmail);
        et_password = findViewById(R.id.etPassword);
        et_passConf = findViewById(R.id.etPassConf);
        btnOk = findViewById(R.id.btnOk);

        setButton();
    }

    public void setButton(){
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = true; //TODO WebServ create user + send password
                if (pass == true) {
                    Toast.makeText(RegisterActivity.this, R.string.emailsent, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
