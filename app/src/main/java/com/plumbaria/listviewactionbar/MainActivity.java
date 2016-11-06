package com.plumbaria.listviewactionbar;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

/*    private static final String[] items = {"En", "un", "lugar", "de",
            "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero",
            "acordarme", "no", "ha", "mucho", "tiempo", "que",
            "vivía", "un", "hidalgo", "de", "los", "de", "lanza",
            "en", "astillero", "adarga", "antigua", "rocín", "flaco",
            "y", "galgo", "corredor"};
*/
    private ArrayAdapter<String> adapter;
    private AdaptadorQuijote AdaptaQ = new AdaptadorQuijote();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializarAdaptador();
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Dependiendo del botón presionado, se realizarán una acción u otra
        if(item.getItemId() == findViewById(R.id.anyadir).getId()) {
            if(AdaptaQ.anyadir())
                return true;
            else
                Toast.makeText(this, "No existen mas palabras para añadir", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(item.getItemId() == findViewById(R.id.reset).getId()) {
            AdaptaQ.restablecer();
            return true;
        } else {
            Toast.makeText(this, "Ejercicio para ver las distintas formas en qué se muestra el menú, según el tipo de dispositivo en que se ejecute y según el API seleccionado " +
                    "utilizando un ListView junto con la ActionBar", Toast.LENGTH_LONG).show();
            return true;
        }
    }

    private void inicializarAdaptador() {
        AdaptaQ.restablecer();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, AdaptaQ.getLista());
        //Establecemos el adapter
        AdaptaQ.setAdapter(adapter);
    }

}
