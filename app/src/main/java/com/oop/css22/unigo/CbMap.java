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
public class CbMap extends Fragment implements droplist{

    private TextView textView;
    private Spinner droplist;
    private ImageButton search;
    private ArrayList menu = new ArrayList();

    public static CbMap newInstrance() {
        return new CbMap();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cb_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("อาคารเรียนรวมและพื้นที่ส่วนกลาง");

        textView = (TextView) view.findViewById(R.id.detail);
        droplist = (Spinner) view.findViewById(R.id.droplist);
        search = (ImageButton) view.findViewById(R.id.search);
        this.createList();
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
            case "14: ศูนย์การจัดการด้านพลังงานสิ่งแวดล้อมความปลอดภัยและอาชีวอนามัย (EESH)":
                return readFile("14");
            case "15: อาคารสำนักงานอธิการบดี (Office of The President)":
                return readFile("15");
            case "16: อาคาร Green Society":
                return readFile("16");
            case "19: อาคารปฏิบัติการทางวิศวะกรรมอุตสาหการ 5 (Production ENG, Building 5)":
                return readFile("19");
            case "20: อาคารเรียนรวม 1":
                return readFile("20");
            case "21: อาคารเรียนรวม 2":
                return readFile("21");
            case "22: อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี":
                return readFile("22");
            case "23: อาคารไฟฟ้าแรงสูง (Hi-Voltage Building)":
                return readFile("23");
            case "24: อาคารโรงแยกขยะ (Recycle Building)":
                return readFile("24");
            case "25: ศูนย์ซ่อมบำรุง (Maintenance and Services Center)":
                return readFile("25");
            case "26: อาคารเรือนอนุบาลต้นไม้ (Nursery Plant)":
                return readFile("26");
            case "27: อาคารเรียนและปฏิบัติการทางศิลปะศาสตร์":
                return readFile("27");
            default:
                return "กรุณาเลือกใหม่";
        }
    }

    @Override
    public String readFile(String path) {
        String txt = "";
        try{
            InputStream input = getActivity().getAssets().open(path+".txt");
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();
            txt = new String(buffer);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return txt;
    }

    @Override
    public void createList() {
        menu.add("เลือกจุดที่สนใจ");
        menu.add("14: ศูนย์การจัดการด้านพลังงานสิ่งแวดล้อมความปลอดภัยและอาชีวอนามัย (EESH)");
        menu.add("15: อาคารสำนักงานอธิการบดี (Office of The President)");
        menu.add("16: อาคาร Green Society");
        menu.add("19: อาคารปฏิบัติการทางวิศวะกรรมอุตสาหการ 5 (Production ENG, Building 5)");
        menu.add("20: อาคารเรียนรวม 1");
        menu.add("21: อาคารเรียนรวม 2");
        menu.add("22: อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี");
        menu.add("23: อาคารไฟฟ้าแรงสูง (Hi-Voltage Building)");
        menu.add("24: อาคารโรงแยกขยะ (Recycle Building)");
        menu.add("25: ศูนย์ซ่อมบำรุง (Maintenance and Services Center)");
        menu.add("26: อาคารเรือนอนุบาลต้นไม้ (Nursery Plant)");
        menu.add("27: อาคารเรียนและปฏิบัติการทางศิลปะศาสตร์");
    }
}
