package fr.mds.mydogtrackermanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.mds.mydogtrackermanager.R;
import fr.mds.mydogtrackermanager.retrofit.BasicAnswer;
import fr.mds.mydogtrackermanager.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    String name, firstname, password, email;
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
                name = et_name.getText().toString();
                firstname = et_firstname.getText().toString();
                password = et_password.getText().toString();
                email = et_email.getText().toString();

                if(password.equals(et_passConf.getText().toString())){
                    RetrofitClient.getService().add_user(name, firstname, password, email).enqueue(new Callback<BasicAnswer>() {
                        @Override
                        public void onResponse(Call<BasicAnswer> call, Response<BasicAnswer> response) {
                            Log.i("TEST-LOGS", "Success");
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(Call<BasicAnswer> call, Throwable t) {
                            Log.i("TEST-LOGS", "Fail");
                            Toast.makeText(RegisterActivity.this, R.string.errorbdd, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
}
