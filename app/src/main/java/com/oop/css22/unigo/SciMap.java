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
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SciMap extends Fragment implements droplist{

    private TextView textView;
    private Spinner droplist;
    private ImageButton search;
    private ArrayList menu = new ArrayList();

    public SciMap() {
        // Required empty public constructor
    }

    public static SciMap newInstrance(){
        return new SciMap();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sci_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("คณะวิทยาศาสตร์และ FIBO");

        createList();
        textView = (TextView) view.findViewById(R.id.detail);
        search = (ImageButton) view.findViewById(R.id.search);
        droplist = (Spinner) view.findViewById(R.id.droplist);
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
        switch (item) {
            case "28: อาคารภาควิชาเคมี ":
                return readFile("28");
            case "29: อาคารภาควิชาฟิสิกส์":
                return readFile("29");
            case "30: อาคารภาควิชาคณิตศาสตร์":
                return readFile("30");
            case "31: อาคารศูนย์เครื่องมือวิทยาศาสตร์":
                return readFile("31");
            case "32: อาคารจุลชีววิทยา":
                return readFile("32");
            case "33: อาคารปฏิบัติการพื้นฐานทางวิทยาศาสตร์ (Fundamental Science Laboratory Building)":
                return readFile("33");
            case "34: สำนักงานหอสมุด (Library Building)":
                return readFile("34");
            case "35: อาคารคณะเทคโนโลยีสารสนเทศ":
                return readFile("35");
            case "36: สถาบันวิทยาการหุ่นยนต์ภาคสนาม (Institute of Field Robotics)":
                return readFile("36");
            default:
                return "กรุณาเลือกใหม่";
        }
    }

    @Override
    public String readFile(String path) {
        String txt = "";
        try{
            InputStream inputStream = getActivity().getAssets().open(path+".txt");
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
        menu.add("เลือกจุดที่สนใจ");
        menu.add("28: อาคารภาควิชาเคมี ");
        menu.add("29: อาคารภาควิชาฟิสิกส์");
        menu.add("30: อาคารภาควิชาคณิตศาสตร์");
        menu.add("31: อาคารศูนย์เครื่องมือวิทยาศาสตร์");
        menu.add("32: อาคารจุลชีววิทยา");
        menu.add("33: อาคารปฏิบัติการพื้นฐานทางวิทยาศาสตร์ (Fundamental Science Laboratory Building)");
        menu.add("34: สำนักงานหอสมุด (Library Building)");
        menu.add("35: อาคารคณะเทคโนโลยีสารสนเทศ");
        menu.add("36: สถาบันวิทยาการหุ่นยนต์ภาคสนาม (Institute of Field Robotics)");
    }
}
