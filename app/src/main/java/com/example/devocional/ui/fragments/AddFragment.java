package com.example.devocional.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.devocional.R;
import com.example.devocional.ui.Archive;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    //Mis variables
    ListView list;
    FloatingActionButton add;
    public static ArrayList<String> people  = new ArrayList<String>();
    String name = "";

    public AddFragment() {
        // Required empty public constructor
    }


    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Button
        add = (FloatingActionButton) getView().findViewById(R.id.floatingActionButton2);
        add.setOnClickListener(this);
        //List
        list = (ListView) getView().findViewById(R.id.list);
        ArrayList<String> temp = Archive.deArchivo_Array(getActivity());
        if(temp!=null) {
            people = temp;
            ArrayAdapter<String> peopleAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, people);
            list.setAdapter(peopleAdapter);
            list.setOnItemClickListener(this);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final String person = adapterView.getItemAtPosition(i).toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete");

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                people.remove(person);
                ArrayAdapter<String> peopleAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, people);
                list.setAdapter(peopleAdapter);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Name");

        // Set up the input
        final EditText input = new EditText(getActivity());
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name = input.getText().toString();
                people.add(name);
                ArrayAdapter<String> peopleAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, people);
                list.setAdapter(peopleAdapter);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

}