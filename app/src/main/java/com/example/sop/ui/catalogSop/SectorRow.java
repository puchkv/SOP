package com.example.sop.ui.catalogSop;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.sop.R;
import com.example.sop.adapters.RecyclerAdapter;
import com.example.sop.api.Const;
import com.example.sop.models.Factory;
import com.example.sop.models.Sector;

public class SectorRow extends LinearLayout implements RecyclerAdapter.RecyclerViewRow<Sector> {

    private ImageView imageView;
    private TextView tvTitle;

    public SectorRow(Context context) {
        super(context);
    }

    public SectorRow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SectorRow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SectorRow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvTitle = (TextView) findViewById(R.id.list_view_title_tv);
        imageView = (ImageView) findViewById(R.id.list_view_image);

    }


    @Override
    public void showData(Sector data) {
        tvTitle.setText(data.getName());
        Glide.with(getContext())
                .load(Const.apiURL + Const.sector_storage_path + data.getPicture())
                .into(imageView);
    }
}
