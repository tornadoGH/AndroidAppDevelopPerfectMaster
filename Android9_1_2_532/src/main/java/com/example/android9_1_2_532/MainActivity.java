package com.example.android9_1_2_532;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = ( Button )findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View view )
            {
                final CharSequence[] colors = {"RED", "BLUE", "GREEN"};
                AlertDialog.Builder dialog = new AlertDialog.Builder( MainActivity.this );
                dialog.setTitle("カラーを選択");
                dialog.setItems( colors, new DialogInterface.OnClickListener()
                {
                    public void onClick( DialogInterface dialog, int which )
                    {
                        TextView textView = ( TextView )findViewById( R.id.textView );
                        textView.setText( String.format("%sが選択", colors[which]));
                    }
                });
                dialog.show();
            }
        });
    }
}
