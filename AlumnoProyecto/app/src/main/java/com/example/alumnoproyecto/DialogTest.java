package com.example.alumnoproyecto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogTest extends DialogFragment {

    public Dialog onCreateDialog (Bundle save){
        View myview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_dialog,null);

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.tittle)
                .setMessage(R.string.message)
                .setPositiveButton(R.string.btnPositive, (dialogInterface, i) -> {
                    Toast.makeText(getContext(), R.string.mensagePositive, Toast.LENGTH_SHORT);
                })
                .setNegativeButton(R.string.btnNegative,(dialogInterface, i) -> {
                    Toast.makeText(getContext(), R.string.mensageNegative, Toast.LENGTH_SHORT);
                })
                .setView(myview)
                .create();
    }
}
