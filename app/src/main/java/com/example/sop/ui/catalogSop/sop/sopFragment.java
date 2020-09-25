package com.example.sop.ui.catalogSop.sop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sop.R;
import com.example.sop.adapters.RecyclerAdapter;
import com.example.sop.models.Sop;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sopFragment extends Fragment
        implements RecyclerAdapter.OnRecyclerViewItemClickListener<Sop> {

    private RecyclerView recyclerView;
    private RecyclerAdapter<Sop> adapter;
    private LinearLayoutManager layoutManager;

    private static final String PARAM_ID = "category_id";
    private static final String PARAM_NAME = "category_name";
    private static final String PARAM_SECTOR_NAME = "sector_name";

    private int category_id;
    private String category_name;
    private String sector_name;

    public sopFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category_id = getArguments().getInt(PARAM_ID);
            category_name = getArguments().getString(PARAM_NAME);
            sector_name = getArguments().getString(PARAM_SECTOR_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sopViewModel model = new ViewModelProvider(this).get(sopViewModel.class);

        View root = inflater.inflate(R.layout.fragment_catalog_sop_sop, container, false);

        root.getParent();

        recyclerView = root.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        model.getCategorySops(category_id).observe(getViewLifecycleOwner(), sops -> {
            adapter = new RecyclerAdapter<>(sops, this, R.layout.row_sop);
            recyclerView.setAdapter(adapter);
        });

        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvCategoryName = (TextView) view.findViewById(R.id.category_name_tv);
        TextView tvSectorName = (TextView) view.findViewById(R.id.sector_name_tv);
        tvCategoryName.setText(category_name);
        tvSectorName.setText(sector_name);
    }

    @Override
    public void onItemClick(Sop data) {

        Bundle bundle = new Bundle();
        bundle.putInt("sop_id", data.getId());

        Navigation.findNavController(requireView()).navigate(R.id.action_sopFragment_to_viewSopFragment, bundle);

    }
}