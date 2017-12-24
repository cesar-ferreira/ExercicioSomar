
package com.example.cesar.exerciciosomarcesar.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.cesar.exerciciosomarcesar.R;


/**
 * Created by cesar on 21/12/17.
 */

public class ResultadoFragment extends Fragment {

    TextView textFragment;
    String mResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        mResultado = getArguments().getString(getString(R.string.key));
        textFragment = view.findViewById(R.id.text_fragment);
        textFragment.setText(mResultado);

        return view;
    }

}
