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
import com.example.sop.models.Category;
import com.example.sop.models.Sector;

public class CategoryRow extends LinearLayout implements RecyclerAdapter.RecyclerViewRow<Category> {

    private ImageView imageView;
    private TextView tvTitle;

    public CategoryRow(Context context) {
        super(context);
    }

    public CategoryRow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoryRow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CategoryRow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvTitle = (TextView) findViewById(R.id.list_view_title_tv);
        imageView = (ImageView) findViewById(R.id.list_view_image);

    }


    @Override
    public void showData(Category data) {
        tvTitle.setText(data.getName());
        Glide.with(getContext())
                .load(Const.apiURL + Const.category_storage_path + data.getPicture())
                .into(imageView);
    }
}
