package com.example.nirvan.assignment1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NIRVAN on 14-03-2017.
 */
public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>
{
    List<String> items;

    myAdapter()
    {;};

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView2 = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_xml,
                        parent,
                        false);
        return new myViewHolder(itemView2);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position)
    {
     holder.text.setText(items.get(position));
    }

    myAdapter(List<String> a)
    {
        this.items=a;
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
     TextView text;

        public myViewHolder(View itemView)
        {
            super(itemView);
            text=(TextView) itemView.findViewById(R.id.text);
        }
    }


}
