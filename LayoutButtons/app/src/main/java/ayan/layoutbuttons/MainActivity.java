package ayan.layoutbuttons;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button entrar;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrar=(Button)findViewById(R.id.entrarButton);
        boton2=(Button)findViewById(R.id.boton2);
        boton3=(Button)findViewById(R.id.boton3);
        boton4=(Button)findViewById(R.id.boton4);
        boton5=(Button)findViewById(R.id.boton5);

        //metodo in line para controlar el evento del boton
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muestraMensajeToast("Presiono el boton Entrar",Toast.LENGTH_SHORT);
            }
        });

        //metodo de delegacion a otra clase
        boton2.setOnClickListener(this);

        //metodo 3 agregar el listener desde el archivo xml (CHECAR activity_main.xml)

        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
    }
    public void muestraMensajeToast(String mensaje,int duracion){
        Context context=getApplicationContext();
        Toast toast=Toast.makeText(context,mensaje,duracion);
        toast.show();
    }
    public void acionBoton4(){
        TextView inicioSesionTextView=(TextView)findViewById(R.id.inicioSesion);
        String texto=inicioSesionTextView.getText().toString();
        muestraMensajeToast("Texto antiguo: "+texto,Toast.LENGTH_SHORT);
        inicioSesionTextView.setText("SINACEC");
        muestraMensajeToast("Texto nuevo: SINACE",Toast.LENGTH_SHORT);
    }
    public void acionBoton5(){
        EditText cuentaEditText=(EditText)findViewById(R.id.cuentaEditText);
        String texto=cuentaEditText.getText().toString();
        if(!texto.contains("@gmail.com")){
            cuentaEditText.setText(texto+"@gmail.com");
        }
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.boton2:
                muestraMensajeToast("Presiono el boton2",Toast.LENGTH_LONG);
            break;
            case R.id.boton3:
                muestraMensajeToast("Presiono el boton3",Toast.LENGTH_SHORT);
            break;
            case R.id.boton4:
                acionBoton4();
            break;
            case R.id.boton5:
                acionBoton5();
                break;
            default:
                muestraMensajeToast("El boton precionado no tiene codigo preparado :(",Toast.LENGTH_LONG);
        }
    }
}
