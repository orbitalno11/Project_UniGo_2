package com.oop.css22.unigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Atm extends Fragment implements droplist{


    private Spinner droplist;
    private ImageButton search;
    private ArrayList menu = new ArrayList();
    private TextView textView;

    public Atm() {
        // Required empty public constructor
    }

    public static Atm newInstrance(){
        return new Atm();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("ATM");

        createList();
        textView =(TextView) view.findViewById(R.id.atm_shows);

        droplist = (Spinner) view.findViewById(R.id.atmlist);
        search = (ImageButton) view.findViewById(R.id.search);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,menu);
        droplist.setAdapter(adapter);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectText = droplist.getSelectedItem().toString();
                textView.setText(selectedItem(selectText));
            }
        });

    }

    @Override
    public String selectedItem(String item) {
        switch (item){
            case "ธนาคารไทยพาณิชย์" : return readFile("a(1).txt");
            case "ธนาคารกรุงไทย" : return  readFile("a(2).txt");
            case "ธนาคารกรุงศรีอยุธยา": return readFile("a(3).txt");
            default:
                return "กรรุณาเลือกใหม่";
        }
    }

    @Override
    public String readFile(String path) {
        String txt = "";
        try{
            InputStream inputStream = getActivity().getAssets().open(path);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            txt = new String(buffer);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return txt;
    }

    @Override
    public void createList() {
        menu.add("กรุณาเลือกรายการ");
        menu.add("ธนาคารไทยพาณิชย์");
        menu.add("ธนาคารกรุงไทย");
        menu.add("ธนาคารกรุงศรีอยุธยา");
    }
}
