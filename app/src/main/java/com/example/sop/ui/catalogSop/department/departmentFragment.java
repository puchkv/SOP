package com.example.sop.ui.catalogSop.department;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.sop.R;
import com.example.sop.adapters.RecyclerAdapter;
import com.example.sop.api.Const;
import com.example.sop.models.Department;
import com.example.sop.models.Factory;
import com.example.sop.ui.catalogSop.factory.factoryViewModel;

import org.w3c.dom.Text;

import java.util.Objects;

public class departmentFragment extends Fragment implements RecyclerAdapter.OnRecyclerViewItemClickListener<Department> {

    private RecyclerView recyclerView;
    private RecyclerAdapter<Department> adapter;

    private static final String PARAM_ID = "factory_id";
    private static final String PARAM_NAME = "factory_name";

    private int factory_id;
    private String factory_name;

    public departmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            factory_id = getArguments().getInt(PARAM_ID);
            factory_name = getArguments().getString(PARAM_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        departmentViewModel model = new ViewModelProvider(this).get(departmentViewModel.class);

        View root = inflater.inflate(R.layout.fragment_catalog_sop_department, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        model.getFactoryDepartments(factory_id).observe(getViewLifecycleOwner(), departments -> {
            adapter = new RecyclerAdapter<>(departments, this, R.layout.row_department);
            recyclerView.setAdapter(adapter);
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvFactoryName = (TextView) view.findViewById(R.id.factory_name_tv);
        tvFactoryName.setText(factory_name);

    }

    @Override
    public void onItemClick(Department data) {

        Bundle bundle = new Bundle();
        bundle.putInt("department_id", data.getId());
        bundle.putString("department_name", data.getName());
        bundle.putString("factory_name", factory_name);

        Navigation.findNavController(requireView()).navigate(R.id.action_departmentFragment_to_sectorFragment, bundle);

    }
}