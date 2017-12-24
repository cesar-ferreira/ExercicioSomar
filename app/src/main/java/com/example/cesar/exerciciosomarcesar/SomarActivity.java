package com.example.cesar.exerciciosomarcesar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SomarActivity extends AppCompatActivity {

    //protected static final int RESULT_OK = 20001;

    @BindView(R.id.edit_value1)
    EditText value1;

    @BindView(R.id.edit_value2)
    EditText value2;

    @BindView(R.id.button_ok)
    Button btnOk;

    @BindView(R.id.button_cancel)
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_ok)
    public void submit(View view) {

        Double n1 = Double.valueOf(value1.getText().toString());
        Double n2 = Double.valueOf(value2.getText().toString());

        Double result = n1 + n2;

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getString(R.string.key), result.toString());
        setResult(RESULT_OK, intent);
        finish();
        //startActivityForResult(intent, RESULT_OK);

    }

    @OnClick(R.id.button_cancel)
    public void cancel(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
