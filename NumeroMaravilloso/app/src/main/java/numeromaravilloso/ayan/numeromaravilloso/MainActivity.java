package numeromaravilloso.ayan.numeromaravilloso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //https://www.youtube.com/watch?v=dmCDDw-9suo
    //https://www.youtube.com/watch?v=DXhMcrA45q8&feature=iv&src_vid=tpdVqhAV0UU&annotation_id=annotation_2786765269#t=16s
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,secondActivity.class);
                startActivity(i);
            }
        });
    }
}
