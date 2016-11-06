package com.plumbaria.listviewactionbar;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quico on 6/11/16.
 */

public class AdaptadorQuijote {

    private ArrayAdapter<String> adapter;
    private static final String[] items = {"En", "un", "lugar", "de",
            "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero",
            "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía",
            "un", "hidalgo", "de", "los", "de", "lanza", "en", "astillero",
            "adarga", "antigua", "rocín", "flaco", "y", "galgo", "corredor"};
    private int posicion;
    private List<String> lista = new ArrayList<String>();

    public List<String> getLista() {
        return lista;
    }

    public void setAdapter(ArrayAdapter<String> adapter) {
        this.adapter = adapter;
    }

    //Método para reiniciar el ArrayAdapter a los 6 primeros elementos de la lista
    public void restablecer()
    {
        //Si adapter no es null, se borrarán todos los elementos que existían y se almacenarán los 6 primeros del array items
        if(adapter != null)
            adapter.clear();
        for (int i = 0; i < 6; i++) {
            lista.add(items[i]);
        }
        //Posición del siguiente elemento a introducir
        posicion = 6;
    }

    //Método que añade al ArrayAdapter el siguiente elemento del array 'items'
    public boolean anyadir()
    {
        if(posicion < items.length)
        {
            adapter.add(items[posicion]);
            posicion++;
            return true;
        }
        return false;
    }
}