package us.daniel.multiselecthorizontalcalendar;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = GregorianCalendar.getInstance();

        Date start = c.getTime();
        c.add(Calendar.MONTH, 5);
        Date end = c.getTime();

        MultiSelectHorizontalCalendar calendar = new
                MultiSelectHorizontalCalendar(this, start, end);
        calendar.load();
    }
}
