package com.example.android9_1_1_529;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = ( Button )findViewById( R.id.button );
        button.setOnClickListener( new SampleClickListener() );
    }

    /*
     *   クリックリスナー用のクラスを生成
     */
    class SampleClickListener implements View.OnClickListener
    {
        @Override
        public void onClick( View view )
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder( MainActivity.this );
            dialog.setTitle("AlertDialog");
            dialog.setMessage("ボタンクリック");
            dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    AlertDialog.Builder dialog2 = new AlertDialog.Builder( MainActivity.this );
                    dialog2.setTitle("確認");
                    dialog2.setMessage("YESが押されました");
                    dialog2.setPositiveButton("OK", null );
                    dialog2.show();
                }
            });
            dialog.setNegativeButton("NO", null );
            dialog.show();
        }
    }
}
