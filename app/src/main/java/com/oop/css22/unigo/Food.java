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
public class Food extends Fragment implements droplist {

    private Spinner droplist;
    private ImageButton search;
    private ArrayList menu = new ArrayList();
    private TextView textView;


    public Food() {
        // Required empty public constructor
    }
    public static Food newInstrance(){
        return new Food();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("ร้านอาหารและเครื่องดืม");

        createList();
        textView = (TextView) view.findViewById(R.id.food_shows);

        droplist = (Spinner) view.findViewById(R.id.foodlist);
        search = (ImageButton) view.findViewById(R.id.search);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line, menu);
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
        switch (item) {
            case "อาตารเรียนรวม 4":
                return readFile("f (1).txt");
            case "ตึกจอดรถ 14 ชั้น":
                return readFile("f (2).txt");
            case "ตึกศิลปศาสตร์":
                return readFile("f (3).txt");
            case "หอสมุด":
                return readFile("f (4).txt");
            case "อาคารปฎิบัติการทางวิทยาศาสตร์ ":
                return readFile("f (5).txt");
            case "อาคารเรียนรวม 1":
                return readFile("f (6).txt");
            case "บ้านธรรมษา 1":
                return readFile("f (7).txt");
            case "บ้านธรรมรักษา 2":
                return readFile("f (8).txt");
            default:
                return "กรรุณาเลือกใหม่";
        }
    }

    @Override
    public String readFile(String path) {
        String txt ="";

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
        menu.add("กรุณาเลือกรายการ");
        menu.add("อาคารเรียนรวม 4");
        menu.add("ตึกจอดรถ 14 ชั้น");
        menu.add("ตึกศิลปศาสตร์");
        menu.add("หอสมุด");
        menu.add("อาคารปฎิบัติการทางวิทยาศาสตร์ ");
        menu.add("อาคารเรียนรวม 1");
        menu.add("บ้านธรรมษา 1");
        menu.add("บ้านธรรมรักษา 2");
    }
}
