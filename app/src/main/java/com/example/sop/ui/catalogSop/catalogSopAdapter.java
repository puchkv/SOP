package com.example.sop.ui.catalogSop;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sop.R;
import com.example.sop.api.Const;
import com.example.sop.models.Factory;

import java.util.List;

public class catalogSopAdapter extends RecyclerView.Adapter<catalogSopAdapter.ViewHolder> {

    private List<Factory> factories;
    private Context context;

    public catalogSopAdapter(Context context, List<Factory> factories) {
        this.context = context;
        this.factories = factories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Factory factory = factories.get(position);
        holder.tvFactoryName.setText(factory.getName());
        Glide.with(context)
                .load(Const.apiURL + Const.factory_storage_path + factory.getPicture())
                .into(holder.factoryImageView);
    }

    @Override
    public int getItemCount() {
        return factories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView factoryImageView;
        private final TextView tvFactoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            factoryImageView = (ImageView) itemView.findViewById(R.id.list_view_image);
            tvFactoryName = (TextView) itemView.findViewById(R.id.list_view_tv);
        }
    }

}
