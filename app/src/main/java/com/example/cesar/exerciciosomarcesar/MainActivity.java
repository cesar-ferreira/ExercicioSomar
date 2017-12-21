package com.example.cesar.exerciciosomarcesar;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cesar.exerciciosomarcesar.fragment.ResultadoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_calculate)
    Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ResultadoFragment fragment = new ResultadoFragment();
        fragmentTransaction.add(R.id.frame_soma, fragment);
        fragmentTransaction.commit();

        loadDataFromActivity();
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123456) {
            if (resultCode == MainActivity.RESULT_OK) {
                // usuário tirou foto.
            } else {
                // usuário não tirou foto.
            }
        }
    }
    private void loadDataFromActivity(){

        Bundle extras = getIntent().getExtras();

        if (extras != null){

            Double result = extras.getDouble("key");



        }
    }

    @OnClick(R.id.button_calculate)
    public void calculate(View view) {

        Intent intent = new Intent(this, SomaActivity.class);
        startActivity(intent);

    }
}
