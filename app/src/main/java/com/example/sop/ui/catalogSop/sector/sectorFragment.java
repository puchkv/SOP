package com.example.sop.ui.catalogSop.sector;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sop.R;
import com.example.sop.adapters.RecyclerAdapter;
import com.example.sop.models.Department;
import com.example.sop.models.Sector;
import com.example.sop.ui.catalogSop.department.departmentViewModel;

public class sectorFragment extends Fragment implements RecyclerAdapter.OnRecyclerViewItemClickListener<Sector>  {

    private RecyclerView recyclerView;
    private RecyclerAdapter<Sector> adapter;

    private static final String PARAM_ID = "department_id";
    private static final String PARAM_NAME = "department_name";
    private static final String PARAM_FACTORY_NAME = "factory_name";

    private int department_id;
    private String department_name;
    private String factory_name;

    public sectorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            department_id = getArguments().getInt(PARAM_ID);
            department_name = getArguments().getString(PARAM_NAME);
            factory_name = getArguments().getString(PARAM_FACTORY_NAME);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        sectorViewModel model = new ViewModelProvider(this).get(sectorViewModel.class);

        View root = inflater.inflate(R.layout.fragment_catalog_sop_sector, container, false);

        root.getParent();

        recyclerView = root.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        model.getFactoryDepartments(department_id).observe(getViewLifecycleOwner(), sectors -> {
            adapter = new RecyclerAdapter<>(sectors, this, R.layout.row_sector);
            recyclerView.setAdapter(adapter);
        });

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvDepartmentName = (TextView) view.findViewById(R.id.department_name_tv);
        TextView tvFactoryName = (TextView) view.findViewById(R.id.factory_name_tv);
        tvDepartmentName.setText(department_name);
        tvFactoryName.setText(factory_name);
    }

    @Override
    public void onItemClick(Sector data) {

        Bundle bundle = new Bundle();
        bundle.putInt("sector_id", data.getId());
        bundle.putString("sector_name", data.getName());
        bundle.putString("department_name", department_name);

        Navigation.findNavController(requireView()).navigate(R.id.action_sectorFragment_to_categoryFragment, bundle);
    }
}