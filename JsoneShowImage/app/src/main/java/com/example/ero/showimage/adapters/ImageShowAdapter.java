package com.example.ero.showimage.adapters;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ero.showimage.R;
import com.example.ero.showimage.activitys.MainActivity;
import com.example.ero.showimage.fragments.ImageDialogFragment;
import com.example.ero.showimage.models.Model;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class ImageShowAdapter extends RecyclerView.Adapter<ImageShowAdapter.ViewHolder> {

    public static final String KEY = "kay";
    private static final String FR_KEY = "kay_fr";
    private List<Model> list = Collections.emptyList();
    private Context context;

    public ImageShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ImageShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageShowAdapter.ViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getThumbnailUrl()).into(holder.smollImage);

    }

    public void setData(List<Model> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView smollImage;
        private final FragmentManager fragment;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            smollImage = itemView.findViewById(R.id.image_id);
            fragment = ((MainActivity) context).getFragmentManager();
            showImage();
        }

        private void showImage() {
            smollImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(KEY, getAdapterPosition());
                    ImageDialogFragment dialogFragment = new ImageDialogFragment();
                    dialogFragment.setArguments(bundle);
                    dialogFragment.show(fragment, FR_KEY);
                    dialogFragment.getList(list);
                }
            });
        }
    }
}
