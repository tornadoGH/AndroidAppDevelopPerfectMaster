package com.example.android9_1_3_535;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                final CharSequence[] items = {"RED", "GREEN", "BLUE"};
                AlertDialog.Builder dialog = new AlertDialog.Builder( MainActivity.this );
                dialog.setTitle("カラー選択");
                dialog.setSingleChoiceItems( items, -1, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick( DialogInterface dialog, int which )
                    {
                        TextView textView = ( TextView )findViewById( R.id.textView );
                        textView.setText( String.format("%sを選択", items[which]));
                    }
                });
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick( DialogInterface dialog, int which )
                    {

                    }
                });
                dialog.show();
            }
        });

    }
}
