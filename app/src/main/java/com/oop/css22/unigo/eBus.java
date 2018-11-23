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
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class eBus extends Fragment implements droplist{


    private Spinner start,stop;
    private ImageView yellow,orange;
    private ImageButton search;
    private ArrayList startmenu = new ArrayList();
    private  ArrayList stopmenu = new ArrayList();

    public eBus() {
        // Required empty public constructor
    }

    public static eBus newInstrance(){
        return new eBus();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_e_bus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("เส้นทาง e-bus");

        start = (Spinner)view.findViewById(R.id.start_list);
        stop = (Spinner)view.findViewById(R.id.goal_list);
        yellow = (ImageView)view.findViewById(R.id.yellowroad);
        orange = (ImageView)view.findViewById(R.id.orangeroad);
        search = (ImageButton)view.findViewById(R.id.search);
        createList();
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,startmenu);
        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,stopmenu);
        start.setAdapter(adapter);
        stop.setAdapter(adapter1);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedText = stop.getSelectedItem().toString();
                setImg(selectedText);
            }
        });


    }

    private void setImg(String item){
        switch (item){
            case "1. สำนักงานอธิการบดี":
                yellow.setImageResource(R.drawable.b1default);
                orange.setImageResource(R.drawable.b2default);
                break;
            case "3. บ้านธรรมรักษา 1(หอหญิง)":
                yellow.setImageResource(R.drawable.b41);
                orange.setImageResource(R.drawable.b42);
                break;
            case "4. อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี(KFC)" :
                yellow.setImageResource(R.drawable.b11);
                orange.setImageResource(R.drawable.b12);
                break;
            case "6. สำนักหอสมุด" :
                yellow.setImageResource(R.drawable.b21);
                orange.setImageResource(R.drawable.b22);
                break;
            case "7. อาคารปฏิบัติการวิทยาศาสตร์(SCL)" :
                yellow.setImageResource(R.drawable.b31);
                orange.setImageResource(R.drawable.b32);
                break;
            default:
                yellow.setImageResource(R.drawable.b1default);
                orange.setImageResource(R.drawable.b2default);
                break;
        }
    }

    @Override
    public String selectedItem(String item) {
        switch (item){
            case "1. สำนักงานอธิการบดี": return "default";
            case "3. บ้านธรรมรักษา 1(หอหญิง)" : return  "b4";
            case "4. อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี(KFC)" : return  "b1";
            case "6. สำนักหอสมุด" : return "b2";
            case "7. อาคารปฏิบัติการวิทยาศาสตร์(SCL)" : return  "b3";
            default:return "default";
        }
    }

    @Override
    public String readFile(String path) {
        return null;
    }

    @Override
    public void createList() {
        startmenu.add("1. สำนักงานอธิการบดี");
        stopmenu.add("3. บ้านธรรมรักษา 1(หอหญิง)");
        stopmenu.add("4. อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี(KFC)");
        stopmenu.add("6. สำนักหอสมุด");
        stopmenu.add("7. อาคารปฏิบัติการวิทยาศาสตร์(SCL)");

    }
}
