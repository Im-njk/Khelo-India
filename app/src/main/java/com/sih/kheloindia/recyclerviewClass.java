package com.sih.kheloindia;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerviewClass extends RecyclerView.Adapter<recyclerviewClass.ViewHolder>{

    Context context;
    List<purposal_modal> list;
    int status ;

    public recyclerviewClass(Context context, List<purposal_modal> list, int status) {
        this.context = context;
        this.list = list;
        this.status = status;
    }

    public recyclerviewClass(Context context, List<purposal_modal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        purposal_modal obj = list.get(position);
        holder.name.setText(obj.getName_project());
        holder.applicant.setText(obj.getName_applicant());
        holder.cost.setText("Rs. " + obj.getCost());
        holder.status.setText(obj.getStatus());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,purposal_Details.class);
                i.putExtra("sampleObject", obj);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,applicant,cost,status;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recycer_pro_name);
            applicant = itemView.findViewById(R.id.recycer_applicant_name);
            cost = itemView.findViewById(R.id.recycer_cost);
            status = itemView.findViewById(R.id.recycer_status);
            card = itemView.findViewById(R.id.card);

        }
    }
}
