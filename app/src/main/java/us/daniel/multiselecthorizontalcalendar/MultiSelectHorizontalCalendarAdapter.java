package us.daniel.multiselecthorizontalcalendar;

import android.support.v7.widget.RecyclerView;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MultiSelectHorizontalCalendarAdapter
        extends RecyclerView.Adapter<MultiSelectHorizontalCalendarAdapter.DateHolder> {

    /** Store the date objects the view displays*/
    private List<Date> dateList;

    /** Will track what items in the view are selected */
    private SparseBooleanArray selected;

    /**
     * Assigns the dates the view will display and hold
     *
     * @param dates the specified range of dates to show
     */
    public MultiSelectHorizontalCalendarAdapter(List<Date> dates) {
        dateList = dates;
        selected = new SparseBooleanArray();
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

        /* This will prevent multiple elements from being tagged as selected */
        if(selected.get(position, false)) {
            holder.itemView.setSelected(true);
        }
        else {
            holder.itemView.setSelected(false);
        }

        holder.dayOfWeek.setText(CalendarUtil.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
        holder.dayOfMonth.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
        holder.month.setText(CalendarUtil.getMonth(c.get(Calendar.MONTH)));
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    /** Hold the view that displays a <code>Date</code> */
    protected class DateHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            selected.put(position, !selected.get(position)); /* Toggle mechanism*/
            Toast.makeText(view.getContext(), "Position: " + position, Toast.LENGTH_LONG).show();
            notifyItemChanged(position); /* Efficient to update at specified location */
        }
    }
}
