package com.sma_rasanehsoft.afghanistanema_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by alavi on 4/20/2017.
 */
public class recyclenewsAdaptor extends RecyclerView.Adapter<viewholder>{

    ArrayList<recycleinfo> recycleinfos = new ArrayList<>();
    public recyclenewsAdaptor(ArrayList<recycleinfo> recycleinfos){
        this.recycleinfos=recycleinfos;

    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclernews, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
        recycleinfo recycleinfo = recycleinfos.get(position);
        holder.title.setText(recycleinfo.title);



        Picasso.with(G.context).load("http://192.168.1.201/afgApp/"+recycleinfo.img).into(holder.img);
        Picasso.with(G.context).load("http://afghanistanema.com/"+recycleinfo.img).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return recycleinfos.size();
    }
}
class viewholder extends RecyclerView.ViewHolder{

    public ImageView img;
    public TextView title;
    public viewholder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img);
        title = (TextView) itemView.findViewById(R.id.title);
    }
}