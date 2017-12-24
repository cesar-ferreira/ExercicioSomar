package com.example.cesar.exerciciosomarcesar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesar.exerciciosomarcesar.fragment.ResultadoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_calculate)
    Button calculate;

    TextView textFragment;

    ResultadoFragment fragment = new ResultadoFragment();

    protected static final int SOMAR_ACTIVITY_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //loadDataFromActivity();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SOMAR_ACTIVITY_REQUEST_CODE){

            if (resultCode == RESULT_OK) {

                String result = data.getStringExtra(getString(R.string.key));
                setFragment(fragment);

                //fragment.setTextViewText(result);

                Toast.makeText(this, result, Toast.LENGTH_LONG).show();

                //textFragment.setText("TESTE");
                Log.i("****************", result);



                //loadDataFromActivity();

            }

            //Lógica
            //TextView tv = (TextView) findViewById(R.id.textView1);
            //tv.setText(R.string.hello_activity_sub);
        }
    }

    private void loadDataFromActivity(){

        Bundle extras = getIntent().getExtras();

        if (extras != null){

            Double result = extras.getDouble("key");

            //textFragment.setText(result.toString());

        }
    }

    @OnClick(R.id.button_calculate)
    public void calculate(View view) {

        Intent intent = new Intent(MainActivity.this, SomarActivity.class);
        startActivityForResult(intent, SOMAR_ACTIVITY_REQUEST_CODE);

    }

    private void setFragment(Fragment newFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_soma, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onFragmentViewCreated(View view) {
        // Iniciar os campos buscando no layout do Fragment
        textFragment = view.findViewById(R.id.text_fragment);
    }
}
