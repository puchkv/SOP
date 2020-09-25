package com.example.sop.ui.catalogSop.factory;

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
import android.widget.Toast;

import com.example.sop.adapters.RecyclerAdapter;
import com.example.sop.api.Const;
import com.example.sop.models.Factory;
import com.example.sop.R;

import java.util.Objects;

public class factoryFragment extends Fragment implements RecyclerAdapter.OnRecyclerViewItemClickListener<Factory> {

    private RecyclerView recyclerView;
    private RecyclerAdapter<Factory> adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        factoryViewModel model = new ViewModelProvider(this).get(factoryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_catalog_sop_factory, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        model.getFactories().observe(getViewLifecycleOwner(), factories -> {
            Log.i(Const.TAG, "ZAVOD: " + factories.size());
            adapter = new RecyclerAdapter<>(factories, this, R.layout.row_factory);
            recyclerView.setAdapter(adapter);
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(Factory data) {

        Bundle bundle = new Bundle();
        bundle.putInt("factory_id", data.getId());
        bundle.putString("factory_name", data.getName());

        Navigation.findNavController(requireView()).navigate(R.id.action_nav_catalog_sop_to_departmentFragment, bundle);
    }
}