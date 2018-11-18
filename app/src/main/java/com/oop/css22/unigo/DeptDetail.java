package com.oop.css22.unigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeptDetail extends Fragment {

    private ImageButton presi,fac,dept1,dept2;

    public DeptDetail() {
        // Required empty public constructor
    }

    public static DeptDetail newInstranc(){
        return new DeptDetail();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dept_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("หน่วยงานใน มจธ.");

        presi = (ImageButton) view.findViewById(R.id.president);
        presi.setOnClickListener(president);

        fac = (ImageButton) view.findViewById(R.id.faculty);
        fac.setOnClickListener(faculty);
    }

    private View.OnClickListener president = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,President_group.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };

    private View.OnClickListener faculty = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,Faculty_group.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };
}
