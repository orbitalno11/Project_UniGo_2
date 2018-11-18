package com.oop.css22.unigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapDetail extends Fragment{

    private ImageButton eng,cb,sci;

    public static MapDetail newIntrance() {
        return new MapDetail();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("KMUTT's Map");

        eng = (ImageButton) view.findViewById(R.id.eng_btn);
        eng.setOnClickListener(engpush);

//        cb = (ImageButton) view.findViewById(R.id.cb_btn);
//        cb.setOnClickListener(cbpush);
//
//        sci = (ImageButton) view.findViewById(R.id.sci_btn);
//        sci.setOnClickListener(scipush);
    }

    private View.OnClickListener engpush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,EngineerMap.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };

//    private View.OnClickListener cbpush = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragcontainer,)
//                    .addToBackStack(null)
//                    .commit();
//        }
//    };
//
//    private View.OnClickListener scipush = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragcontainer,)
//                    .addToBackStack(null)
//                    .commit();
//        }
//    };
}
