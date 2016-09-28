package ayan.sinacec;

import android.Manifest;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.indooratlas.android.sdk.IALocationManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Navegacion.OnFragmentInteractionListener,Busqueda.OnFragmentInteractionListener,Locales.OnFragmentInteractionListener,
        Servicios.OnFragmentInteractionListener,InformacionGeneral.OnFragmentInteractionListener,InicioSesion.OnFragmentInteractionListener, ActivityCompat.OnRequestPermissionsResultCallback{
    private final int CODE_PERMISSIONS=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] neededPermissions = new String[]{
            Manifest.permission.CHANGE_WIFI_STATE,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.ACCESS_COARSE_LOCATION
        };

        ActivityCompat.requestPermissions( this, neededPermissions, CODE_PERMISSIONS );





        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragmentSeleccionado=null;
        boolean fragmentTransaction=false;
        int id = item.getItemId();

        if (id == R.id.nav_navegacion) {
            fragmentSeleccionado=new Navegacion();

            IALocationManager miLocalizacion=IALocationManager.create(this);


        } else if (id == R.id.nav_busqueda) {
            fragmentSeleccionado=new Busqueda();
        } else if (id == R.id.nav_locales) {
            fragmentSeleccionado=new Locales();
        } else if (id == R.id.nav_servicios) {
            fragmentSeleccionado=new Servicios();
        } else if (id == R.id.nav_informacionGeneral) {
            fragmentSeleccionado=new InformacionGeneral();
        } else if (id == R.id.nav_inicioSesion) {
            fragmentSeleccionado=new InicioSesion();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragmentSeleccionado).commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //((TextView)findViewById(R.id.latitudLabel)).setText("requestCode:"+requestCode);
    }

}
