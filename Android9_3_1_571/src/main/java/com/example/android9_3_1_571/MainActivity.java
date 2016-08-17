package com.example.android9_3_1_571;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //  日付設定ダイアログ
    private DatePickerDialog.OnDateSetListener varDateSetListener;
    //  時刻設定ダイアログ
    private TimePickerDialog.OnTimeSetListener varTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  設定された日時を表示する為のEditText
        final EditText editText = ( EditText )findViewById( R.id.editText01 );

        //  日付設定ダイアログのリスナー
        varDateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            //  日付設定ダイアログのOKが押された時の処理
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth )
            {
                editText.setText( String.format("%d/%d/%d", year, monthOfYear+1, dayOfMonth ));
            }
        };

        //  時間設定ダイアログのリスナー
        varTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            //  時刻設定ダイアログのOKが押された時の処理
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute )
            {
                editText.setText( String.format("%d:%d", hourOfDay, minute ));
            }
        };

        //  日付ダイアログ起動ボタン
        Button button1 = ( Button )findViewById( R.id.button1 );
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //  現在日時を取得
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog dateDialog = new DatePickerDialog(
                        MainActivity.this,
                        varDateSetListener,
                        calendar.get( Calendar.YEAR ),
                        calendar.get( Calendar.MONTH ),
                        calendar.get( Calendar.DAY_OF_MONTH )
                );
                dateDialog.show();
            }
        });

        //  時刻選択ダイアログ起動ボタン
        Button button2 = ( Button )findViewById( R.id.button2 );
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                //  現在時刻を取得
                Calendar calendar = Calendar.getInstance();

                TimePickerDialog timeDialog = new TimePickerDialog(
                        MainActivity.this,
                        varTimeSetListener,
                        calendar.get( Calendar.HOUR_OF_DAY ),
                        calendar.get( Calendar.MINUTE ),
                        false
                );
                timeDialog.show();
            }
        });

    }
}
