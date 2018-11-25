package com.oop.css22.unigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    private ImageButton map;
    private ImageButton dept;
    private ImageButton ebus;
    private ImageButton service;

    public static Home newInstrance() {
        return new Home();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("หน้าแรก");


        map = (ImageButton) view.findViewById(R.id.map_btn);
        map.setOnClickListener(mappush);

        dept = (ImageButton) view.findViewById(R.id.dept_btn);
        dept.setOnClickListener(deptpush);

        ebus = (ImageButton) view.findViewById(R.id.ebus);
        ebus.setOnClickListener(ebuspush);

        service = (ImageButton) view.findViewById(R.id.sevice);
        service.setOnClickListener(servicepush);


    }

    private  View.OnClickListener ebuspush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,eBus.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };

    private View.OnClickListener mappush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,MapDetail.newIntrance())
                    .addToBackStack(null)
                    .commit();
        }
    };

    private View.OnClickListener deptpush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,DeptDetail.newInstranc())
                    .addToBackStack(null)
                    .commit();
        }
    };

    private View.OnClickListener servicepush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,Facili.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };

//    private String ranKnow(){
//        String txt="";
//        int ran = (int) (Math.random()*5)+1;
//        String num = String.valueOf(ran);
//        num = "qa"+num+".txt";
//
//        try {
//            InputStream inputStream = getActivity().getAssets().open(num);
//            byte[] buf = new byte[inputStream.available()];
//            inputStream.read(buf);
//            inputStream.close();
//            txt = new String(buf);
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }
//        return txt;
//    }

}
