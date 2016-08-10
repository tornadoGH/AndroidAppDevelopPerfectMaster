package com.example.android11_6_3_714;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by kooka on 2016/07/22
 */
public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );
        builder.setTitle("DialogFragment");
        builder.setMessage("フラグメントダイアログ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){

            @Override
            public void onClick( DialogInterface dialog, int which )
            {
                dismiss();
            }
        });

        return builder.create();
    }
}
