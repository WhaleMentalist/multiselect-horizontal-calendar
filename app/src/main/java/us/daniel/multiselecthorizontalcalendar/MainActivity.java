package us.daniel.multiselecthorizontalcalendar;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Date> dateList;

    private RecyclerView recyclerView;

    private MultiSelectHorizontalCalendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new MultiSelectHorizontalCalendarAdapter(dateList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        recyclerView.setAdapter(adapter);

        prepareDates();
        adapter.notifyDataSetChanged();
    }

    private void prepareDates() {
        Calendar c = GregorianCalendar.getInstance();

        for(int i = 0; i < 10; i++) {
            dateList.add(c.getTime());
            c.add(Calendar.DATE, 1);
        }
    }
}
