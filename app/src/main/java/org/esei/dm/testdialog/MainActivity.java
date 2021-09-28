package org.esei.dm.testdialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button  = findViewById(R.id.buttonDatePickerDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this);
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText( MainActivity.this,
                                "Valores seleccionados " + i + " " + i1 + " " + i2,
                                Toast.LENGTH_LONG).show();

                    }
                });
                datePickerDialog.show();

            }
        });

        button =  findViewById(R.id.buttonTimePickerDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText( MainActivity.this,
                                "Valores seleccionados " + i + " " + i1 ,
                                Toast.LENGTH_LONG).show();
                    }
                };
                TimePickerDialog timePickerDialog =
                        new TimePickerDialog(MainActivity.this, listener, 0, 0, true);
                timePickerDialog.show();
            }
        });

        button = findViewById(R.id.buttonEditTextDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Introduce un texto");
                EditText editText = new EditText(MainActivity.this);
                builder.setView(editText);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText( MainActivity.this,
                                "Valor introducido " + editText.getText().toString(),
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();
            }
        });

        button = findViewById(R.id.buttonCustomDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                View layoutInflated = layoutInflater.inflate(R.layout.custom_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Diálogo personalizado");
                builder.setView(layoutInflated);
                EditText editTextValue = layoutInflated.findViewById(R.id.editTextValue);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText( MainActivity.this,
                                "Valor introducido " + editTextValue.getText().toString(),
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();

            }
        });


    }
}