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
public class Shop extends Fragment implements droplist{
    private Spinner droplist;
    private ImageButton search;
    private ArrayList menu = new ArrayList();
    private TextView textView;


    public Shop() {
        // Required empty public constructor
    }
    public static Shop newInstrance(){
        return new Shop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("ร้านค้า");

        createList();
        textView =(TextView) view.findViewById(R.id.shop_shows);
        droplist =(Spinner) view.findViewById(R.id.shoplist);
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
            case "ตึกจอดรถ 14 ชั้น":
                return readFile("s (1).txt");
            case "พระจอมเกล้าราชานุสรณ์ 190 ปี":
                return readFile("s (2).txt");
            case "อาคารเรียนรวม 4":
                return readFile("s (3).txt");
            case "วิศวกรรมเคมี":
                return readFile("s (4).txt");
            case "บ้านธรรมรักษา 1":
                return readFile("s (5).txt");
            case "อาคารเรียนรวม 1":
                return readFile("s (6).txt");
            case "ตึกศิลปศาสตร์":
                return readFile("s (7).txt");
            case "ตึกฟิสิกส์ - คณิตศาสตร์":
                return readFile("s (8).txt");
            case "อาคารปฎิบัติงานทางวิทยาศาสตร์":
                return readFile("s (9).txt");
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
            menu.add("ตึกจอดรถ 14 ชั้น");
            menu.add("พระจอมเกล้าราชานุสรณ์ 190 ปี");
            menu.add("อาคารเรียนรวม 4");
            menu.add("วิศวกรรมเคมี");
            menu.add("บ้านธรรมรักษา 1");
            menu.add("อาคารเรียนรวม 1");
            menu.add("ตึกศิลปศาสตร์");
            menu.add("ตึกฟิสิกส์ - คณิตศาสตร์");
            menu.add("อาคารปฎิบัติงานทางวิทยาศาสตร์");

        }

}

