package ayan.singletouch;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        text.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view,MotionEvent event){

        int action= MotionEventCompat.getActionMasked(event);
        float x=event.getX();
        float y=event.getY();
        if(view.getId()==R.id.text){
            switch(action){
                case MotionEvent.ACTION_DOWN:
                    text.setText("ACTION_DOWN ("+x+","+y+")");
                    break;
                case MotionEvent.ACTION_MOVE:
                    text.setText("ACTION_MOVE ("+x+","+y+")");
                    break;
                case MotionEvent.ACTION_UP:
                    text.setText("ACTION_UP ("+x+","+y+")");
                    break;
                //existen mucho mas acciones si se quiere ondear en el tema ver cada acion del MotionEvent
            }
        }
        return true;
    }
}
