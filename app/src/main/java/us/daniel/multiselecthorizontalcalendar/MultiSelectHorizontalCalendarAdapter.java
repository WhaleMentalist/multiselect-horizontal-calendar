package us.daniel.multiselecthorizontalcalendar;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MultiSelectHorizontalCalendarAdapter extends RecyclerView.Adapter<MultiSelectHorizontalCalendarAdapter.DateHolder> {

    /** Store the date objects the view displays*/
    private List<Date> dateList;

    @Override
    public DateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.date_item, parent, false);

        return new DateHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(DateHolder holder, int position) {
        Date date = dateList.get(position);
        
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /** Hold the view that displays a <code>Date</code> */
    private class DateHolder extends RecyclerView.ViewHolder {

        public TextView dayOfWeek;

        public TextView dayOfMonth;

        public TextView month;

        public DateHolder(View view) {
            super(view);
            dayOfWeek = view.findViewById(R.id.day_of_week);
            dayOfMonth = view.findViewById(R.id.day_of_month);
            month = view.findViewById(R.id.month);
        }
    }
}
