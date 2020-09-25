package com.example.sop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerAdapter<T>.ViewHolder> {

    private List<T> data;
    private OnRecyclerViewItemClickListener<T> onRecyclerViewItemClickListener;
    private int layoutId;

    public RecyclerAdapter(List<T> data,
                           OnRecyclerViewItemClickListener<T> onRecyclerViewItemClickListener,
                           int layoutId) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
        this.data = data;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public RecyclerAdapter<T>.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerViewRow<T> row = (RecyclerViewRow<T>) LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

        ViewHolder viewHolder = new ViewHolder(row);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.row.showData(data.get(position));
        ((View) holder.row).setOnClickListener(view -> {
            if(onRecyclerViewItemClickListener != null) {
                onRecyclerViewItemClickListener.onItemClick(data.get(position));
            }
        });

    }

    @Override
    public int getItemCount() { return data.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewRow<T> row;

        public ViewHolder(@NonNull RecyclerViewRow<T> itemView) {
            super((View) itemView);
            row = itemView;
        }
    }

    public interface RecyclerViewRow<T> {
        void showData(T data);
    }

    public interface OnRecyclerViewItemClickListener<T> {
        void onItemClick(T data);
    }

}

/*public class catalogSopAdapter extends RecyclerView.Adapter<catalogSopAdapter.ViewHolder> {

    private List<Factory> factories;
    private Context context;

    public catalogSopAdapter(Context context, List<Factory> factories) {
        this.context = context;
        this.factories = factories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_factory, parent, false);
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
            tvFactoryName = (TextView) itemView.findViewById(R.id.list_view_title_tv);

        }
    }

}*/
