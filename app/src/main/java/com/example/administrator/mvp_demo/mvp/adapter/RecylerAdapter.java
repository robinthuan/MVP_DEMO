package com.example.administrator.mvp_demo.mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mvp_demo.R;

import butterknife.BindView;

/**
 * Created by administrator on 12/8/17.
 */

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.Viewholder> {

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.fullName)
        TextView name;
        @BindView(R.id.gender)
        TextView gender;
        @BindView(R.id.phone)
        TextView phone;
        public Viewholder(View itemView) {
            super(itemView);
        }
    }
}
