package com.example.sop.ui.catalogSop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sop.api.Const;
import com.example.sop.models.Factory;
import com.example.sop.R;

import java.util.ArrayList;
import java.util.List;

public class catalogSopFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        catalogSopViewModel model = new ViewModelProvider(this).get(catalogSopViewModel.class);

        View root = inflater.inflate(R.layout.fragment_catalog_sop, container, false);

        recyclerView = root.findViewById(R.id.factory_recycler);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        model.getFactories().observe(getViewLifecycleOwner(), factories -> {
            Log.i(Const.TAG, "ZAVOD: " + factories.size());
            adapter = new catalogSopAdapter(getActivity(), factories);
            recyclerView.setAdapter(adapter);
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}