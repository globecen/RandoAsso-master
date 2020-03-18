package com.example.test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.models.RandonneeeModel;

import java.util.ArrayList;

public class RandonneeAdapter extends RecyclerView.Adapter<RandonneeAdapter.ViewHolder> {

    private ArrayList<RandonneeeModel> randonneeModels=new ArrayList<>();
    private Context context;


    public RandonneeAdapter(Context context, ArrayList<RandonneeeModel> randonneeModels) {
        this.randonneeModels=randonneeModels;
        this.context=context;
    }

    @NonNull
    @Override
    public RandonneeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.randonnee_list_item,viewGroup,false);
        return new RandonneeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandonneeAdapter.ViewHolder viewHolder, int i) {
        viewHolder.raondonnee_no.setText(randonneeModels.get(i).getLieu());
        viewHolder.raondonnee_lieu.setText(randonneeModels.get(i).getDate());

    }

    @Override
    public int getItemCount() {
        return randonneeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView raondonnee_no,raondonnee_lieu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            raondonnee_no=(TextView) itemView.findViewById(R.id.randonneeno);
            raondonnee_lieu=(TextView)itemView.findViewById(R.id.randonneelieu);
        }
    }
    public RandonneeeModel getRando(int position){
        return this.randonneeModels.get(position);
    }
}
