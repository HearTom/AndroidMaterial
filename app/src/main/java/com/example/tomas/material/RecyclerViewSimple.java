package com.example.tomas.material;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class RecyclerViewSimple extends AppCompatActivity {

    RecyclerView rv_jugador;
    List<Jugador> jugadorList = Arrays.asList(new Jugador("http://www.infodeportes.com/fotos/2009/11/43.3758.9.987.250.jpg","Leonel Messi","Barcelona"),
            new Jugador("http://biografias.wiki/wp-content/uploads/2015/10/Neymar-Jr-150x150-150x150.jpg","Neymar","Barcelona"),
            new Jugador("http://goladicto.com/wp-content/uploads/2016/06/cristiano-ronaldo-on-football-lionel-messi-and-leaving-real-madrid-001-150x150.jpg","Cristiano Ronaldo","Real Madrid"),
            new Jugador("http://www.cronicaviva.com.pe/wp-content/uploads/2016/09/apaolo-150x150.jpg","Paolo Guerrero","Flamengo"),
            new Jugador("http://scontent.cdninstagram.com/t51.2885-19/s150x150/16908585_1901722790062756_5211128268853346304_a.jpg","Manuel Neuer","Bayern Munich"),
            new Jugador("https://scontent.cdninstagram.com/t51.2885-19/10540317_1511122629121399_1825392912_a.jpg","Marco Reus","Borussia Dortmund"),
            new Jugador("http://www.madridismosubversivo.es/wp-content/uploads/2014/08/Buffon-150x150.png","Gianluigi Buffon","Juventus"),
            new Jugador("http://e0.365dm.com/17/02/150x150/skysports-wayne-rooney-manchester-united-football-premier-league_3896116.jpg","Wayne Rooney","Manchester United")
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_simple);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mitoolbar);
        setSupportActionBar(toolbar);

        rv_jugador= (RecyclerView) findViewById(R.id.rv_jugador);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_jugador.setLayoutManager(llm);

        Adaptador adaptador = new Adaptador(jugadorList);
        rv_jugador.setAdapter(adaptador);

        rv_jugador.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        }));
    }
}
