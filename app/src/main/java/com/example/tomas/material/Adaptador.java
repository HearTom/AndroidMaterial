package com.example.tomas.material;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Jugador> listajugador;
    private static final int VISTA1 = 1;
    private static final int VISTA2 = 2;


    public Adaptador(List<Jugador> listajugador) {
        this.listajugador = listajugador;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VISTA1 :
                default:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
                return new JugadorViewHolder(v);
            case VISTA2:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_template, parent, false);
                return new Vista2ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewtype = getItemViewType(position);
        switch (viewtype){
            case VISTA1:
                JugadorViewHolder jugadorViewHolder = (JugadorViewHolder) holder;
                jugadorViewHolder.imgjugador.setImageUrl(listajugador.get(position).getFoto(), VolleySingleton.getInstance().getImageLoader());
                jugadorViewHolder.txtjugador.setText(listajugador.get(position).getNombre());
                jugadorViewHolder.txtequipo.setText(listajugador.get(position).getEquipo());
                break;
            case VISTA2:
                Vista2ViewHolder vista2ViewHolder = (Vista2ViewHolder) holder;
                vista2ViewHolder.imgjugador2.setImageUrl(listajugador.get(position).getFoto(), VolleySingleton.getInstance().getImageLoader());
                vista2ViewHolder.txtjugador2.setText(listajugador.get(position).getNombre());
                vista2ViewHolder.txtequipo2.setText(listajugador.get(position).getEquipo());
                break;

        }

    }

    @Override
    public int getItemCount() {
        return listajugador.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? VISTA1 : VISTA2 ;
    }

    public static class JugadorViewHolder extends RecyclerView.ViewHolder {
        NetworkImageView imgjugador;
        TextView txtjugador;
        TextView txtequipo;

        public JugadorViewHolder(View itemView) {
            super(itemView);
            Typeface font = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/Roboto-Regular.ttf");
            imgjugador = (NetworkImageView) itemView.findViewById(R.id.imgjugador);
            txtjugador = (TextView) itemView.findViewById(R.id.txtjugador);
            txtequipo = (TextView) itemView.findViewById(R.id.txtequipo);
            txtjugador.setTypeface(font);
            txtequipo.setTypeface(font);
        }

    }

    public static class Vista2ViewHolder extends RecyclerView.ViewHolder {
        NetworkImageView imgjugador2;
        TextView txtjugador2;
        TextView txtequipo2;

        public Vista2ViewHolder(View itemView) {
            super(itemView);
            Typeface font = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/Roboto-Regular.ttf");
            imgjugador2 = (NetworkImageView) itemView.findViewById(R.id.imgjugador2);
            txtjugador2 = (TextView) itemView.findViewById(R.id.txtjugador2);
            txtequipo2 = (TextView) itemView.findViewById(R.id.txtequipo2);
            txtjugador2.setTypeface(font);
            txtequipo2.setTypeface(font);
        }

    }
}
