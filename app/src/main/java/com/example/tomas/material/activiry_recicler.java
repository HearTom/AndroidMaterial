package com.example.tomas.material;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class activiry_recicler extends AppCompatActivity {

    JsonObjectRequest array;
    RequestQueue mRequestQueue;
    private final String url = "http://192.168.1.22:8000/Sicom/public/jugador";
    private final String TAG = "PRUEBITA";
    private List<Jugador> lista_jugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_recicler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mitoolbar);
        setSupportActionBar(toolbar);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.lista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        FloatingActionButton botonflotante = (FloatingActionButton) findViewById(R.id.botonflotante);
        botonflotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "BOTON FLOTANTE", Toast.LENGTH_LONG).show();
            }
        });

        rv.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                 Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
                 Jugador jugador = lista_jugador.get(position);
            }
        }));

        mRequestQueue = VolleySingleton.getInstance().getmRequestQueue();
        array = new JsonObjectRequest(Request.Method.GET, url, "", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                lista_jugador = getJugadores(response);
                Adaptador adapter = new Adaptador(lista_jugador);
                rv.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.toString());
            }
        });
        mRequestQueue.add(array);
    }

    private List<Jugador> getJugadores(JSONObject jsonObject)
    {
        List<Jugador> lista = new ArrayList<>();
        try {
            JSONArray array = jsonObject.getJSONArray("jugador");
            for(int i = 0 ;i<array.length();i++)
            {
                JSONObject objeto = array.getJSONObject(i);
                Jugador jugador = new Jugador();
                jugador.setNombre(objeto.getString("nombre_jugador"));
                jugador.setEquipo(objeto.getString("equipo"));
                jugador.setIdjugador(objeto.getInt("id"));
                jugador.setFoto(objeto.getString("foto"));
                lista.add(jugador);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activiry_recicler, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
