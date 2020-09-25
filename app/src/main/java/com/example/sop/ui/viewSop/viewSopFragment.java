package com.example.sop.ui.viewSop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sop.R;
import com.example.sop.adapters.RecyclerAdapter;
import com.example.sop.api.Const;
import com.example.sop.models.Sop;
import com.example.sop.ui.catalogSop.category.categoryViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class viewSopFragment extends Fragment {

    private static Boolean isOpen = false;
    private LinearLayout sopDetails;
    private ImageView sopDetailsButton;

    private static final String PARAM_ID = "sop_id";

    private int sop_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sop_id = getArguments().getInt(PARAM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_view_sop, container, false);

        sopDetails = root.findViewById(R.id.sop_details_layout);
        sopDetails.setVisibility(View.INVISIBLE);

        viewSopViewModel model = new ViewModelProvider(this).get(viewSopViewModel.class);

        final TextView tvSopName = root.findViewById(R.id.sop_name_tv);
        final TextView tvSopDescripton = root.findViewById(R.id.sop_description_tv);
        final TextView tvSopStatus = root.findViewById(R.id.sop_status_tv);
        final TextView tvSopCategory = root.findViewById(R.id.sop_category_tv);
        final TextView tvSopCreatedAt = root.findViewById(R.id.sop_created_at);
        final TextView tvSopApprovedAt = root.findViewById(R.id.sop_approved_at);
        final TextView tvSopOwner = root.findViewById(R.id.sop_owner_name);
        final TextView tvSopOwnerPosition = root.findViewById(R.id.sop_owner_position);
        final TextView tvSopApprover = root.findViewById(R.id.sop_approver_name);
        final TextView tvSopApproverPosition = root.findViewById(R.id.sop_approver_position);

        final ImageView sopImage = root.findViewById(R.id.sop_image_view);

        model.getSop(sop_id).observe(getViewLifecycleOwner(), sop -> {

            tvSopName.setText(sop.getName());
            tvSopDescripton.setText(sop.getDescription());
            tvSopStatus.setText(sop.getStatus());
            tvSopCategory.setText(sop.getCategory().getName());
            tvSopCreatedAt.setText(sop.getCreatedAt());
            tvSopApprovedAt.setText("");

            String ownerName = sop.getOwner().getName() + " " + sop.getOwner().getSurname();
            tvSopOwner.setText(ownerName);
            tvSopOwnerPosition.setText(sop.getOwner().getPosition().getName());

            String approverName = sop.getApprover().getName() + " " + sop.getApprover().getSurname();
            tvSopApprover.setText(approverName);
            tvSopApproverPosition.setText(sop.getApprover().getPosition().getName());

            Glide.with(root.getContext())
                    .load(Const.apiURL + Const.sop_storage_path + sop.getPicture())
                    .into(sopImage);

        });

        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("");
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sopDetailsButton = view.findViewById(R.id.sop_details_btn);
        sopDetailsButton.setOnClickListener(view1 -> {
            if(isOpen) {
                sopDetails.setVisibility(View.INVISIBLE);
                sopDetailsButton.animate().rotation(0).setDuration(300);
                isOpen = false;
            } else {
                sopDetails.setVisibility(View.VISIBLE);
                sopDetailsButton.animate().rotation(180).setDuration(300);
                isOpen = true;
            }
        });
    }
}