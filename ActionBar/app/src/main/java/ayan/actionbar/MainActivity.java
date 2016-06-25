package ayan.actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    public void muestraMensajeToast(String mensaje,int duracion){
        Toast toast=Toast.makeText(getApplicationContext(),mensaje,duracion);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idItem=item.getItemId();
        switch(idItem){
            case R.id.action_settings:
                muestraMensajeToast("Settings 1",Toast.LENGTH_SHORT);
                break;
            case R.id.action_settings2:
                muestraMensajeToast("Settings 2",Toast.LENGTH_SHORT);
                break;
            case R.id.action_settings3:
                muestraMensajeToast("Settings 3",Toast.LENGTH_SHORT);
                break;
            case R.id.action_settings4:
                muestraMensajeToast("Settings 4",Toast.LENGTH_SHORT);
                break;
            case R.id.action_settings5:
                muestraMensajeToast("Settings 5",Toast.LENGTH_SHORT);
                break;
        }
        return false;
    }
}
