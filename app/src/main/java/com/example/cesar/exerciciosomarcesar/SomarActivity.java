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

        Double result = 0.0;
        Double n1 = Double.valueOf(value1.getText().toString());
        Double n2 = Double.valueOf(value2.getText().toString());

        if(!verifica(n1)){
            n1 = 0.0;
        }

        if(!verifica(n2)){
            n2 = 0.0;
        }

        result = n1 + n2;

        if(verifica(result)){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(getString(R.string.key), result.toString());
            setResult(RESULT_OK, intent);
            finish();
        }


    }

    @OnClick(R.id.button_cancel)
    public void cancel(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public boolean verifica(Double number){
        if (number.equals(0.0) || number.toString().equals("") || number.equals(null)){
            return false;
        }
        return true;
    }
}
