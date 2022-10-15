package com.example.sigma;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    Context context;
    public RecyclerViewAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View layout=inflater.inflate(R.layout.recycleritem,parent,false);
        return new ItemViewHolder(layout);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.textView.setText("hello guys");
        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(context,MainActivity2.class);
            intent.putExtra("Username","hello guy "+holder.getAdapterPosition());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.recyclertext1);
        }
    }

}
