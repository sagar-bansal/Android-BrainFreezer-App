package com.digipodium.brainfreezer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.holder>
{


    private final Context context;
    ArrayList<category> arr;
    LayoutInflater inflater;

    public adapter(Context context,ArrayList<category> arr) {
        this.arr = arr;
       // this.context=context;
        this.context = context;
        inflater=LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_card,parent,false);
        holder hold=new holder(v);
        return hold;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        category cat=arr.get(position);
        holder.txt.setText(String.valueOf(cat.text));

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }


    public class holder extends RecyclerView.ViewHolder

    {
        TextView txt;
        public holder(View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.item);

            txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String name=((TextView)v).getText().toString();
                    if(name=="Physics")
                    {
                        Intent intent=new Intent(v.getContext(),physics.class);
                        v.getContext().startActivity(intent);

                    }
                    if(name=="Chemistry")
                    {
                        Intent intent=new Intent(v.getContext(),chemistry.class);
                        v.getContext().startActivity(intent);

                    }
                    if(name=="History")
                    {
                        Intent intent=new Intent(v.getContext(),history.class);
                        v.getContext().startActivity(intent);

                    }if(name=="Biology")
                    {
                        Intent intent=new Intent(v.getContext(),biology.class);
                        v.getContext().startActivity(intent);

                    }if(name=="Computers")
                    {
                        Intent intent=new Intent(v.getContext(),computer.class);
                        v.getContext().startActivity(intent);

                    }

                }
            });
        }


    }
}
