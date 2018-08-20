package com.hshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hshop.R;
import com.hshop.models.SubCategoryDetails;
import com.hshop.shopping.Product;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Admin on 09-06-2018.
 */

public class SubCategoryAdapterList extends RecyclerView.Adapter<SubCategoryAdapterList.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<SubCategoryDetails> event;


    public SubCategoryAdapterList(Context context,ArrayList<SubCategoryDetails> event)
    {
        this.context=context;
        this.event=event;
        inflater=(LayoutInflater) context.getSystemService (context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public SubCategoryAdapterList.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate( R.layout.sub_cat_row,parent,false );
        RecyclerViewHolder holder=new RecyclerViewHolder( view ) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(SubCategoryAdapterList.RecyclerViewHolder holder, int position) {

        final String name=event.get( position ).getSubCategoryName();
        final String id=event.get( position ).getSubCategoryId();
        final String id1=event.get(position).getFilterid();
        holder.name.setText( name );
        holder.r1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(context,Product.class);
                i1.putExtra("sub_cat_id",id);
                i1.putExtra("sub_cat_name",name);
                i1.putExtra("filter",id1);
                i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(i1);
            }
        } );
    }

    @Override
    public int getItemCount() {
       return event.size();

    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RelativeLayout r1;
        public RecyclerViewHolder(View itemView) {
            super( itemView );
            name=(TextView)itemView.findViewById( R.id.txt_subcat );
            r1=(RelativeLayout)itemView.findViewById(R.id.r1);
        }
    }
}
