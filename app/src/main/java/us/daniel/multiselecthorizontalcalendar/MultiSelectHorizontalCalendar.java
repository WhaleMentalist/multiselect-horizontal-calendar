package us.daniel.multiselecthorizontalcalendar;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MultiSelectHorizontalCalendar {

    /** The parent view the calendar will reside in */
    private View parentView;

    /** The start point of the calendar */
    private Date startDate;

    /** The end point of the calendar */
    private Date endDate;

    /** The view that holds date items */
    private RecyclerView mRecyclerView;

    /** Translates date for view to display*/
    private MultiSelectHorizontalCalendarAdapter mAdapter;

    /** The list of dates that are displayed in horizontal fashion */
    private List<Date> mDateList;

    /** Check if the thread has loaded all the dates into the list */
    private boolean isLoading;

    /**
     * Specifiy the activity that utilizes the calendar and the date boundaries
     *
     * @param activity  the activity that spawned calendar
     * @param start the starting point of calendar
     * @param end   the ending point of calendar
     */
    public MultiSelectHorizontalCalendar(Activity activity, Date start, Date end) {
        parentView = activity.getWindow().getDecorView();
        startDate = start;
        endDate = end;
        new PrepareDates().execute(); /* Generate dates on other thread */
    }

    public void load() {
        mDateList = new ArrayList<>();
        mRecyclerView = parentView.findViewById(R.id.recycler_view);
        mAdapter = new MultiSelectHorizontalCalendarAdapter(mDateList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(parentView.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private class PrepareDates extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            isLoading = true;
        }

        @Override
        protected Void doInBackground(Void ...params) {
            Calendar c = GregorianCalendar.getInstance();
            c.setTime(startDate);

            while(c.getTime().before(endDate)) {
                mDateList.add(c.getTime());
                c.add(Calendar.DATE, 1); /* Increment by one day */
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            isLoading = false;
        }

    }
}
