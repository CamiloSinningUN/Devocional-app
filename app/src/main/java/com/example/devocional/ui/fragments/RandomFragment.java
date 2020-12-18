package com.example.devocional.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devocional.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RandomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomFragment extends Fragment implements View.OnClickListener {
    //Mis variables
    String Coordinador;
    TextView CoordinadorText;

    String Adoraciones;
    TextView AdoracionesText;

    String Alabanzas;
    TextView AlabanzasText;

    String Oraciones;
    TextView OracionesText;

    String Suplente;
    TextView SuplenteText;

    FloatingActionButton randomizer;






    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RandomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RandomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RandomFragment newInstance(String param1, String param2) {
        RandomFragment fragment = new RandomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        randomizer = (FloatingActionButton) getView().findViewById(R.id.floatingActionButton3);
        randomizer.setOnClickListener(this);

        SuplenteText = (TextView) getView().findViewById(R.id.SuplidorPerson);
        AdoracionesText = (TextView) getView().findViewById(R.id.AdoradorPerson);
        AlabanzasText = (TextView) getView().findViewById(R.id.AlabadorPerson);
        OracionesText = (TextView) getView().findViewById(R.id.OradorPerson);
        CoordinadorText = (TextView) getView().findViewById(R.id.CoordinadorPerson);

    }

    @Override
    public void onClick(View view) {
        if(AddFragment.people.size()!=0){
            boolean[] YaPuesto = new boolean[AddFragment.people.size()];
            for(Boolean b: YaPuesto){
                b = false;
            }
            Random rand = new Random();

            //Suplente
            int index = rand.nextInt(AddFragment.people.size());
            Suplente = AddFragment.people.get(index);
            SuplenteText.setText(Suplente);
            YaPuesto[index] = true;


            //Adoraciones
            do {
                index = rand.nextInt(AddFragment.people.size());
            }while((YaPuesto[index]==true) && (!TodosAsigandos(YaPuesto)));
            if(!TodosAsigandos(YaPuesto)){
                Adoraciones = AddFragment.people.get(index);
                AdoracionesText.setText(Adoraciones);
                YaPuesto[index] = true;
            }else{
                AdoracionesText.setText(Suplente);
            }

            //Alabanzas
            do {
                index = rand.nextInt(AddFragment.people.size());
            }while((YaPuesto[index]==true) && (!TodosAsigandos(YaPuesto)));
            if(!TodosAsigandos(YaPuesto)){
                Alabanzas = AddFragment.people.get(index);
                AlabanzasText.setText(Alabanzas);
                YaPuesto[index] = true;
            }else{
                AlabanzasText.setText(Suplente);
            }

            //Oraciones
            do {
                index = rand.nextInt(AddFragment.people.size());
            }while((YaPuesto[index]==true) && (!TodosAsigandos(YaPuesto)));
            if(!TodosAsigandos(YaPuesto)){
                Oraciones = AddFragment.people.get(index);
                OracionesText.setText(Oraciones);
                YaPuesto[index] = true;
            }else{
                OracionesText.setText(Suplente);
            }

            //Coordinador
            do {
                index = rand.nextInt(AddFragment.people.size());
            }while((YaPuesto[index]==true) && (!TodosAsigandos(YaPuesto)));
            if(!TodosAsigandos(YaPuesto)){
                Coordinador = AddFragment.people.get(index);
                CoordinadorText.setText(Coordinador);
                YaPuesto[index] = true;
            }else{
                CoordinadorText.setText(Suplente);
            }
        }else{
            Toast.makeText(getActivity(),"No tiene personas para sortear",Toast.LENGTH_SHORT).show();
        }

    }

    public Boolean TodosAsigandos(boolean[] YaPuesto){
        for(boolean b : YaPuesto){
            if(!b){
                return false;
            }
        }
        return true;
    }
}