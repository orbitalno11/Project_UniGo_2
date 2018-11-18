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
public class Dept2_group extends Fragment implements droplist{

    private TextView textView;
    private Spinner droplist;
    private ImageButton search;
    private ArrayList menu = new ArrayList();

    public Dept2_group() {
        // Required empty public constructor
    }

    public static Dept2_group newInstrance(){
        return new Dept2_group();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dept2_group, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("หน่วยงานในกำกับของ มจธ.");

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
        switch (item){
            case "ศูนย์หนังสือพระจอมเกล้าธนบุรี (KMUTT Book Store)": return readFile("book");
            case "หอพักนักศึกษา": return readFile("dorrm");
            default: return "กรุณาเลือกอีกครั้ง";
        }
    }

    @Override
    public String readFile(String path) {
        String txt="";
        try {
            InputStream inputStream = getActivity().getAssets().open("dep2_"+path+".txt");
            byte[] buf = new byte[inputStream.available()];
            inputStream.read(buf);
            inputStream.close();
            txt = new String(buf);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return txt;
    }

    @Override
    public void createList() {
        menu.add("กรุณาเลือกส่วนงานที่สนใจ");
        menu.add("ศูนย์หนังสือพระจอมเกล้าธนบุรี (KMUTT Book Store)");
        menu.add("หอพักนักศึกษา");
    }
}
