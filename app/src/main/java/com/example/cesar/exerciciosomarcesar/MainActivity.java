package com.example.cesar.exerciciosomarcesar;

import android.app.Fragment;
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

    protected static final int SOMAR_ACTIVITY_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SOMAR_ACTIVITY_REQUEST_CODE){

            if (resultCode == RESULT_OK) {

                String result = data.getStringExtra(getString(R.string.key));

                ResultadoFragment fragment = new ResultadoFragment();

                Bundle b = new Bundle();
                b.putString(getString(R.string.key), result);
                fragment.setArguments(b);

                setFragment(fragment);
            }
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
}
