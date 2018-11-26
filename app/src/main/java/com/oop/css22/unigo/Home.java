package com.oop.css22.unigo;


import android.content.Intent;
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
    private ImageButton newacis;
    private ImageButton leb2;

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

        newacis = (ImageButton) view.findViewById(R.id.newacis);
        newacis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(),NewACIS.class);
                startActivityForResult(myIntent,0);
            }
        });

        leb2 = (ImageButton) view.findViewById(R.id.leb2);
        leb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(),LEB2.class);
                startActivityForResult(myIntent,0);
            }
        });


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


}
