package com.example.sop.ui.catalogSop.category;

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
import com.example.sop.models.Category;
import com.example.sop.models.Sector;
import com.example.sop.ui.catalogSop.sector.sectorViewModel;

import java.util.Objects;


public class categoryFragment extends Fragment
        implements RecyclerAdapter.OnRecyclerViewItemClickListener<Category> {

    private RecyclerView recyclerView;
    private RecyclerAdapter<Category> adapter;
    private LinearLayoutManager layoutManager;

    private static final String PARAM_ID = "sector_id";
    private static final String PARAM_NAME = "sector_name";
    private static final String PARAM_DEPARTMENT_NAME = "department_name";

    private int sector_id;
    private String sector_name;
    private String department_name;

    public categoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sector_id = getArguments().getInt(PARAM_ID);
            sector_name = getArguments().getString(PARAM_NAME);
            department_name = getArguments().getString(PARAM_DEPARTMENT_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        categoryViewModel model = new ViewModelProvider(this).get(categoryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_catalog_sop_category, container, false);

        root.getParent();

        recyclerView = root.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        model.getSectorCategories(sector_id).observe(getViewLifecycleOwner(), categories -> {
            adapter = new RecyclerAdapter<>(categories, this, R.layout.row_category);
            recyclerView.setAdapter(adapter);
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvSectorName = (TextView) view.findViewById(R.id.sector_name_tv);
        TextView tvDepartmentName = (TextView) view.findViewById(R.id.department_name_tv);
        tvSectorName.setText(sector_name);
        tvDepartmentName.setText(department_name);
    }

    @Override
    public void onItemClick(Category data) {

        Bundle bundle = new Bundle();
        bundle.putInt("category_id", data.getId());
        bundle.putString("category_name", data.getName());
        bundle.putString("sector_name", sector_name);

        Navigation.findNavController(requireView()).navigate(R.id.action_categoryFragment_to_sopFragment, bundle);

    }
}