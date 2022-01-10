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

    public RandomFragment() {
        // Required empty public constructor
    }
    
    public static RandomFragment newInstance() {
        RandomFragment fragment = new RandomFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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