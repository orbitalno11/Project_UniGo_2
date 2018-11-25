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
public class Facili extends Fragment {


    private ImageButton atm, food, shop, post;

    public Facili() {
        // Required empty public constructor
    }

    public static Facili newInstrance() {
        return new Facili();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_facili, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("จุดบริการ");

        atm = (ImageButton) view.findViewById(R.id.atm);
        atm.setOnClickListener(atmpush);
        food = (ImageButton) view.findViewById(R.id.food);
        food.setOnClickListener(foodpush);
        shop = (ImageButton) view.findViewById(R.id.shop);
        shop.setOnClickListener(shoppush);
        post = (ImageButton) view.findViewById(R.id.post);
        post.setOnClickListener(postpush);
    }

    private View.OnClickListener atmpush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer, Atm.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };
    private View.OnClickListener foodpush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer, Food.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };
    private  View.OnClickListener shoppush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,Shop.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };
    private  View.OnClickListener postpush = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragcontainer,Post.newInstrance())
                    .addToBackStack(null)
                    .commit();
        }
    };

}
