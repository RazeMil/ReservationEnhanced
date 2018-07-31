package sg.edu.rp.c346.reservationenhanced;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText reserver;
    EditText num;
    EditText grp;
    EditText etDay;
    EditText etTime;
    CheckBox area;
    Button cfm;
    Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reserver = findViewById(R.id.enterName);
        num = findViewById(R.id.enterMobile);
        grp = findViewById(R.id.enterSize);
        etDay = findViewById(R.id.editTextDay);
        etTime = findViewById(R.id.editTextTime);
        area = findViewById(R.id.smokeBox);
        cfm = findViewById(R.id.confirmButton);
        reset = findViewById(R.id.resetButton);

        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etDay.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                };
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);


                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hour, minute, true);
                myTimeDialog.show();
            }
        });
        cfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strName = reserver.getText().toString();
                String strMobile = num.getText().toString();
                String strSize = grp.getText().toString();
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                if (strName.trim().length()!=0 && strMobile.trim().length()!=0 && strSize.trim().length()!=0) {
                    if (area.isChecked()) {

                        Toast.makeText(MainActivity.this, String.format("Name: %s\n Mobile: %s\n Size: %s\n Table Area: %s\n Time: %s\n Date: %s", strName,
                                strMobile, strSize, "Table is in smoking area", hour + ":" + minute, day + "/" + month + "/" + year), Toast.LENGTH_LONG).show();


                    } else {


                        Toast.makeText(MainActivity.this, String.format("Name: %s\n Mobile: %s\n Size: %s\n Table Area: %s\n Time: %s\n Date: %s", strName,
                                strMobile, strSize, "Table is in non-smoking area", hour + ":" + minute, day + "/" + month + "/" + year), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error! Empty inputs detected!", Toast.LENGTH_LONG).show();
                }
            }
        });




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reserver.setText("");
                num.setText("");
                grp.setText("");
                area.setChecked(false);
                etTime.setText("");
                etDay.setText("");
            }
        });
    }
}