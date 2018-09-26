package edu.sjsu.izzymoriguchi.travelmap;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateTripDialogFragment extends DialogFragment {
    private static final String TAG = "CreateTripDialogFragmen";
    public CreateTripDialogFragment() {

    }

    public interface EditNameDialogListener {
        void onFinishEditDialog(String tripName);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_create_trip_dialog, null);
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setPositiveButton("OK",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditNameDialogListener listener = (EditNameDialogListener) getActivity();
                EditText tripNameInput = view.findViewById(R.id.trip_name_edittext);
                // Return the input to for trip name to activity through scanner
                listener.onFinishEditDialog(tripNameInput.getText().toString());

                // Open up TripDetailActivity
                Context context = getContext();
                Intent intent = new Intent(context, TripDetailActivity.class);
                context.startActivity(intent);
            }
        });

        return alertDialogBuilder.create();
    }
}
