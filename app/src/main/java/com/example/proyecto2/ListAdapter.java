package com.example.proyecto2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mdata;
    private LayoutInflater mInflater;
    private Context context;


    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater= LayoutInflater.from(context);
        this.context= context;
        this.mdata= itemList;

    }
    @Override
    public int getItemCount(){ return mdata.size();}

    @Override

    public ListAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.binData(mdata.get(position));
    }

    public void setItems(List<ListElement> items){ mdata= items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, city, status;

        ViewHolder (View itemView){

            super(itemView);
            iconImage= itemView.findViewById(R.id.iconImageView);
            name= itemView.findViewById(R.id.nameTextView);
            city= itemView.findViewById(R.id.cityTextView);
            status=itemView.findViewById(R.id.statusTextView);

        }

        void binData(final ListElement item){
            iconImage.setColorFilter(Color.parseColor (item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            city.setText(item.getCity());
            status.setText(item.getStatus());

        }

    }

}
