package com.example.administrator.mvp_demo.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mvp_demo.R;
import com.example.administrator.mvp_demo.mvp.model.People;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by administrator on 12/8/17.
 */

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.Viewholder> {
    ArrayList<People> list;
    Context context;
    OnResultClickListener onResultClickListener;
    public RecylerAdapter(ArrayList<People> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public void attach(OnResultClickListener onResultClickListener){
        this.onResultClickListener=onResultClickListener;
    }
    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        Picasso.with(context).load(list.get(position).getPicture().getMedium()).into(holder.icon);
        holder.gender.setText(list.get(position).getGender().toString());
        holder.name.setText(list.get(position).getName().getTitle() +" "+ list.get(position).getName().getFirst().toString());
        holder.phone.setText(list.get(position).getPhone().toString());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResultClickListener.clickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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
        View view;
        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            view=itemView;
        }
    }
     public interface  OnResultClickListener{
        void clickListener(int positon);
    }
}
