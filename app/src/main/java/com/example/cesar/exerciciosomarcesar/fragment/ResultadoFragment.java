
package com.example.cesar.exerciciosomarcesar.fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cesar.exerciciosomarcesar.MainActivity;
import com.example.cesar.exerciciosomarcesar.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by cesar on 21/12/17.
 */

public class ResultadoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        ((MainActivity) getActivity()).onFragmentViewCreated(view);
        return view;
    }

}
