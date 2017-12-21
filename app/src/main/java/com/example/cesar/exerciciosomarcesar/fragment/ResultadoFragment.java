
package com.example.cesar.exerciciosomarcesar.fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cesar.exerciciosomarcesar.R;


/**
 * Created by cesar on 21/12/17.
 */

public class ResultadoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado, container, false);
    }

}
