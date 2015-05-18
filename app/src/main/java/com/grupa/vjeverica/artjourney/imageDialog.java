package com.grupa.vjeverica.artjourney;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class imageDialog {
    private Dialog dialog;
    private Button dialogButton;
    public imageDialog(Context context, String showText, int res){

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.img_dialog);
        dialog.setTitle("Congradulations!!!");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.dialog_text);
        text.setText(showText);

        ImageView image = (ImageView) dialog.findViewById(R.id.dialog_image);
        //image.setImageResource(res);


        dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
    }

    public void show(){
        dialog.show();
    }

    public void onDismissClose(final Activity a){
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                a.finish();
            }
        });
    }

}
