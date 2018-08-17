package com.example.ero.showimage.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ero.showimage.R;
import com.example.ero.showimage.adapters.ImageShowAdapter;
import com.example.ero.showimage.models.Model;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class ImageDialogFragment extends DialogFragment {
    private List<Model> modelList = Collections.emptyList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        final ImageView image = view.findViewById(R.id.fr_image);
        if (getArguments() != null) {
            int position = getArguments().getInt(ImageShowAdapter.KEY);
            Picasso.get().load(modelList.get(position).getUrl()).into(image);
        }
        return view;
    }

    public void getList(List<Model> list) {
        this.modelList = list;
    }
}
