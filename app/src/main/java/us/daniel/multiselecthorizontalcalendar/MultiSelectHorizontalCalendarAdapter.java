package us.daniel.multiselecthorizontalcalendar;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MultiSelectHorizontalCalendarAdapter extends RecyclerView.Adapter<MultiSelectHorizontalCalendarAdapter.DateHolder> {

    /** Store the date objects the view displays*/
    private List<Date> dateList;

    /**
     * Assigns the dates the view will display and hold
     *
     * @param dates the specified range of dates to show
     */
    public MultiSelectHorizontalCalendarAdapter(List<Date> dates) {
        dateList = dates;
    }

    @Override
    public DateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.date_item, parent, false);

        return new DateHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(DateHolder holder, int position) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(dateList.get(position));

        holder.dayOfWeek.setText(CalendarUtil.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
        holder.dayOfMonth.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
        holder.month.setText(CalendarUtil.getMonth(c.get(Calendar.MONTH)));
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    /** Hold the view that displays a <code>Date</code> */
    protected class DateHolder extends RecyclerView.ViewHolder {

        /** Displays the day of the week (i.e MON, TUE, ..., SUN) */
        public TextView dayOfWeek;

        /** Displays the day of the month */
        public TextView dayOfMonth;

        /** Displays the month (i.e JAN, FEB, ..., DEC) */
        public TextView month;

        public DateHolder(View view) {
            super(view);
            dayOfWeek = view.findViewById(R.id.day_of_week);
            dayOfMonth = view.findViewById(R.id.day_of_month);
            month = view.findViewById(R.id.month);
        }
    }
}
