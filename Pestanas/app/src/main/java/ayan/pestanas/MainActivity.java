package ayan.pestanas;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarPestanas();
    }
    public void agregarPestana(Resources resources,TabHost contenedorPestanas,String tituloPestana,int id){
        TabHost.TabSpec pestana=contenedorPestanas.newTabSpec(tituloPestana);
        pestana.setContent(id);
        pestana.setIndicator(tituloPestana,resources.getDrawable(android.R.drawable.ic_dialog_map));
        contenedorPestanas.addTab(pestana);
    }
    public void agregarPestanas(){
        Resources resources=getResources();
        TabHost contenedorPestanas=(TabHost)findViewById(android.R.id.tabhost);
        contenedorPestanas.setup();
        agregarPestana(resources,contenedorPestanas,"Contactos",R.id.contactos);
        agregarPestana(resources,contenedorPestanas,"Llamadas",R.id.llamadas);
        contenedorPestanas.setCurrentTab(0);
        contenedorPestanas.setOnTabChangedListener(this);
    }
    public void muestraMensajeToast(String mensaje,int duracion){
        Context context=getApplicationContext();
        Toast toast=Toast.makeText(context,mensaje,duracion);
        toast.show();
    }
    @Override
    public void onTabChanged(String s) {//s contiene el nombre de la pestana puesta con el codigo contenedorPestanas.newTabSpec(tituloPestana); donde contenedorPestanas es de tipo TabHost
        muestraMensajeToast("Se cambio la pestana: "+s,Toast.LENGTH_SHORT);
    }
}
