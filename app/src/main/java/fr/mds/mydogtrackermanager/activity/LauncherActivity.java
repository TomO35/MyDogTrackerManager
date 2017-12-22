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
import java.io.IOException;

import fr.mds.mydogtrackermanager.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LauncherActivity extends AppCompatActivity {

    EditText et_email, et_password;
    Button btn_login, btn_register;
    TextView tv_forget_pass;
    boolean pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        et_email = findViewById(R.id.et_log_email);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        tv_forget_pass = findViewById(R.id.tv_forget_pass);

        setLogin();
        setRegister();
        setForgetPass();
    }

    public void setLogin(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_email.getText() != null && !et_email.getText().equals("")){
                    if (et_password.getText() != null && !et_password.getText().equals("")){
//                        RetrofitClient.getService().checkPassword(et_email.getText().toString(), et_password.getText().toString()).enqueue(new Callback<BasicAnswer>() {
//                            @Override
//                            public void onResponse(Call<BasicAnswer> call, Response<BasicAnswer> response) {
//                                Log.i("TEST-LOGS", "Success");
//                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                                startActivity(i);
//                            }
//
//                            @Override
//                            public void onFailure(Call<BasicAnswer> call, Throwable t) {
//                                Log.i("TEST-LOGS", "Fail");
//                                Toast.makeText(LauncherActivity.this, R.string.wronglogs, Toast.LENGTH_SHORT).show();
//                            }
//                        });
                        try {
                            run("http://dogtracker.epizy.com/ws.php?action=check_password&user_email="+et_email.getText().toString() +"&password="+et_password.getText().toString());
                        } catch (Exception e) {
                            e.printStackTrace();
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
                Toast.makeText(LauncherActivity.this, R.string.emailsent, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private final OkHttpClient client = new OkHttpClient();

    public void run(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    Log.e(responseHeaders.name(i) , responseHeaders.value(i));
                }

                Log.e("response",response.body().string());
            }
        });
    }


}
