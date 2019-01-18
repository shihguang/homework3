package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText ed_ntd;
    private String title;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    public void findviews(){
        ed_ntd = findViewById(R.id.ed_ntd);
    }

    public void go(View view){
        String ntd = ed_ntd.getText().toString();
        if (ntd.equals("")){
            title = getString(R.string.problem);
            message=getString(R.string.please);
        }
        else{
            title = getString(R.string.result);
            message = getString(R.string.usd_is)+String.valueOf(Float.parseFloat(ntd)/30.9f);
        }
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ed_ntd.setText("");
                    }
                })
                .show();
    }
}
