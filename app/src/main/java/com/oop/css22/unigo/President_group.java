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
public class President_group extends Fragment implements droplist{

    private TextView textView;
    private Spinner droplist;
    private ImageButton search;
    private ArrayList menu = new ArrayList();

    public President_group() {
        // Required empty public constructor
    }

    public static President_group newInstrance(){
        return new President_group();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_president_group, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("สำนักงานอธิการบดี");

        this.createList();
        search = (ImageButton) view.findViewById(R.id.search);
        droplist = (Spinner) view.findViewById(R.id.droplist);
        textView = (TextView) view.findViewById(R.id.detail);
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
        switch(item){
            case "1: งานทะเบียนนักศึกษา" : return readFile("President1.txt");
            case "2: สำนักงานกิจการนักศึกษา" : return readFile("President2.txt");
            case "3: สำนักงานคัดเลือกและสรรหานักศึกษา" : return readFile("President3.txt");
            case "4: กลุ่มงาน่วยเหลือทางการเงินนักศึกษา" : return readFile("President4.txt");
            case "5: กลุ่มงานบริการสุขภาพและอนามัย" : return readFile("President5.txt");
            default: return "กรุณาเลือกใหม่อีกครั้ง";
        }
    }

    @Override
    public String readFile(String path) {
        String txt="";
        try {
            InputStream inputStream = getActivity().getAssets().open(path);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            txt = new String(buffer);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return txt;
    }

    @Override
    public void createList() {
        menu.add("กรุณาเลือกจุดที่ต้องการ");
        menu.add("1: งานทะเบียนนักศึกษา");
        menu.add("2: สำนักงานกิจการนักศึกษา");
        menu.add("3: สำนักงานคัดเลือกและสรรหานักศึกษา");
        menu.add("4: กลุ่มงาน่วยเหลือทางการเงินนักศึกษา");
        menu.add("5: กลุ่มงานบริการสุขภาพและอนามัย");
    }
}
