package com.triard.asus.openproject2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.triard.asus.openproject2019.CustomFilter;
import com.triard.asus.openproject2019.R;
import com.triard.asus.openproject2019.model.Model;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {

    Context mContext;
    public ArrayList<Model> models;
    ArrayList<Model> filterList;
    private Onclick listener;
    CustomFilter filter;

    public MyAdapter(Context mContext, ArrayList<Model> models, Onclick onclick) {
        this.mContext = mContext;
        this.models = models;
        this.listener = onclick;
        this.filterList = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.list_item, null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder myHolder, int position) {
        Model model = models.get(position);

        myHolder.mNama.setText(model.getNama());
        myHolder.mAsal.setText(model.getAsal());
        myHolder.mCoach.setText(model.getCoach());
        myHolder.mDesc.setText(model.getDesc());

        Picasso.get().load(model.getImg()).into(myHolder.mImageIv);
        myHolder.bind(model, listener);

        Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
        myHolder.itemView.startAnimation(animation);
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter = new CustomFilter(filterList, this);
        }
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView mImageIv;
        TextView mNama, mAsal,mCoach,mDesc,mstadiom;

        public ViewHolder(@NonNull View itemview) {
            super(itemview);
            this.mImageIv = itemview.findViewById(R.id.ImageView);
            this.mNama = itemview.findViewById(R.id.TextViewNama);
            this.mAsal = itemview.findViewById(R.id.TextViewAsal);
            this.mCoach = itemview.findViewById(R.id.TextViewCoach);
            this.mstadiom = itemview.findViewById(R.id.TextViewStadion);
            this.mDesc = itemview.findViewById(R.id.TextViewdesc);
        }

        public void bind(final Model model, final Onclick onModelClick){


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onModelClick.clickItem(model);
                }
            });
        }
    }

    public interface Onclick{
        void clickItem(Model model);
    }
}
