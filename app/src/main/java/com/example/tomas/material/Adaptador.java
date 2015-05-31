package com.example.tomas.material;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Tomas on 19/05/2015.
 */
public class Adaptador extends RecyclerView.Adapter<Adaptador.JugadorViewHolder> {

    List<Jugador> listajugador;

    public Adaptador(List<Jugador> listajugador) {
        this.listajugador = listajugador;
    }

    @Override
    public JugadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        JugadorViewHolder holder = new JugadorViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(JugadorViewHolder holder, int position) {
       holder.imgjugador.setImageResource(listajugador.get(position).getFoto());
       holder.txtjugador.setText(listajugador.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listajugador.size();
    }

    public static class JugadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imgjugador;
        TextView txtjugador;

        public JugadorViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgjugador = (ImageView) itemView.findViewById(R.id.imgjugador);
            txtjugador = (TextView) itemView.findViewById(R.id.txtjugador);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"CLICK",Toast.LENGTH_SHORT).show();
        }
    }
}
