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
public class EngineerMap extends Fragment implements droplist {


    private ImageButton search;
    private TextView textView;
    private Spinner droplist;
    private ArrayList menu = new ArrayList();

    public static EngineerMap newInstrance() {
        return new EngineerMap();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_engineer_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("คณะวิศวกรรมศาสตร์ และครุศาสตร์อุตสาหกรรม");

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
            case "1: อาคารสัมมนา":
                return readFile("1");
            case "2: รร.ดรุณสิกขาลัย":
                return readFile("2");
            case "3: อาคารวิศววัฒนะ":
                return readFile("3");
            case "4: บ้านธรรมรักษา2":
                return readFile("4");
            case "5: บ้านธรรมรักษา1":
                return readFile("5");
            case "6: อาคารโรงประลองเทคโนโลยีและวัสดุ":
                return readFile("6");
            case "7: อาคารเรียนและปฏิบัติการคณะพลังงานสิ่งแวดล้อมและวัสดุ":
                return readFile("7");
            case "8: อาคารเรียนรวม 3 (CB3) ":
                return readFile("8");
            case "9: อาคารเรียนรวม 4 (CB4) ":
                return readFile("9");
            case "10: อาคารเรียนรวม 5 (CB5) ":
                return readFile("10");
            case "11: อาคารวิศวกรรมเคมี":
                return readFile("11");
            case "12: อาคารวิศวกรรมเครื่องกล 4":
                return readFile("12");
            case "13: อาคารจอดรถ อาคารสูง 14 ชั้น":
                return readFile("13");
            default:
                return "กรุณาเลือกใหม่";
        }
    }

    @Override
    public String readFile(String path) {
        String txt="";
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
    public void createList(){
        menu.add("เลือกจุดที่สนใจ");
        menu.add("1: อาคารสัมมนา");
        menu.add("2: รร.ดรุณสิกขาลัย");
        menu.add("3: อาคารวิศววัฒนะ");
        menu.add("4: บ้านธรรมรักษา2");
        menu.add("5: บ้านธรรมรักษา1");
        menu.add("6: อาคารโรงประลองเทคโนโลยีและวัสดุ");
        menu.add("7: อาคารเรียนและปฏิบัติการคณะพลังงานสิ่งแวดล้อมและวัสดุ");
        menu.add("8: อาคารเรียนรวม 3 (CB3) ");
        menu.add("9: อาคารเรียนรวม 4 (CB4) ");
        menu.add("10: อาคารเรียนรวม 5 (CB5) ");
        menu.add("11: อาคารวิศวกรรมเคมี");
        menu.add("12: อาคารวิศวกรรมเครื่องกล 4");
        menu.add("13: อาคารจอดรถ อาคารสูง 14 ชั้น");
    }
}
