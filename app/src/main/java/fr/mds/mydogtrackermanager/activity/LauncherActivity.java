package fr.mds.mydogtrackermanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.mds.mydogtrackermanager.R;
import fr.mds.mydogtrackermanager.retrofit.BasicAnswer;
import fr.mds.mydogtrackermanager.retrofit.DogTrackerService;
import fr.mds.mydogtrackermanager.retrofit.Positions;
import fr.mds.mydogtrackermanager.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LauncherActivity extends AppCompatActivity implements Callback<BasicAnswer> {

    EditText et_email, et_password;
    Button btn_login, btn_register;
    TextView tv_forget_pass;
    boolean pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        getSupportActionBar().hide();

        et_email = findViewById(R.id.et_log_email);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        tv_forget_pass = findViewById(R.id.tv_forget_pass);

        setLogin();
        setRegister();
        setForgetPass();

        RetrofitClient.getService().add_spy("test").enqueue(new Callback<BasicAnswer>() {
            @Override
            public void onResponse(Call<BasicAnswer> call, Response<BasicAnswer> response) {
                Log.i("TEST", "Success");
            }

            @Override
            public void onFailure(Call<BasicAnswer> call, Throwable t) {
                Log.i("TEST", "Fail");
            }
        });
    }

    @Override
    public void onResponse(Call<BasicAnswer> call, Response<BasicAnswer> response) {

    }

    @Override
    public void onFailure(Call<BasicAnswer> call, Throwable t) {

    }

    public void setLogin(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_email.getText() != null && !et_email.getText().equals("")){
                    if (et_password.getText() != null && !et_password.getText().equals("")){
                        pass = true;//TODO Webserv check password
                        if (pass == true) {
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(LauncherActivity.this, R.string.wronglogs, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LauncherActivity.this, R.string.nopass, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LauncherActivity.this, R.string.noemail, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setRegister(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    public void setForgetPass(){
        tv_forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO send password to e-mail (Material Dialog)
                Toast.makeText(LauncherActivity.this, R.string.emailsent, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
