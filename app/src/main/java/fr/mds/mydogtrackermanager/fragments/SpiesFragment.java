package fr.mds.mydogtrackermanager.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import fr.mds.mydogtrackermanager.R;
import fr.mds.mydogtrackermanager.activity.MainActivity;
import fr.mds.mydogtrackermanager.activity.RegisterActivity;
import fr.mds.mydogtrackermanager.retrofit.BasicAnswer;
import fr.mds.mydogtrackermanager.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpiesFragment extends MyFragment {
    String spy_id, user_id;
    Button btn_addSpy;
    EditText et_textIdSpy;
    ListView lv_spies;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spies, container, false);

        et_textIdSpy = view.findViewById(R.id.et_textIdSpy);
        btn_addSpy = view.findViewById(R.id.btn_addSpy);
        lv_spies = view.findViewById(R.id.lv_spies);

        setButton();

        return view;
    }

    public void setButton(){
        btn_addSpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                spy_id = et_textIdSpy.getText().toString();
//
//                RetrofitClient.getService().link_spy(spy_id,user_id).enqueue(new Callback<BasicAnswer>() {
//                    @Override
//                    public void onResponse(Call<BasicAnswer> call, Response<BasicAnswer> response) {
//                        Log.i("TEST-LOGS", "Success");
//                        lv_spies.addView(response.toString());
//                        lv_spies.notifyAll();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<BasicAnswer> call, Throwable t) {
//                        Log.i("TEST-LOGS", "Fail");
//
//                    }
//                });

            }
        });
    }
}
