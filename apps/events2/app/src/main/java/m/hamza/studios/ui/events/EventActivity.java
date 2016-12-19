package m.hamza.studios.ui.events;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import m.hamza.studios.R;
import m.hamza.studios.data.model.Event;
import m.hamza.studios.ui.base.BaseActivity;
import m.hamza.studios.ui.common.ErrorView;

/**
 * Created by DevBlaan on 15/12/2016.
 */

public class EventActivity  extends BaseActivity implements EventMvpView, EventAdapter.ClickListener, ErrorView.ErrorListener {

    @Inject
    EventAdapter mEventAdapter;
    @Inject
    EventPresenter mEventPresenter;

    @BindView(R.id.view_error)
    ErrorView mErrorView;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.recycler_events)
    RecyclerView mEventRecycler;
    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
        //mEventPresenter = new EventPresenter();
        mEventPresenter.attachView(this);

        setSupportActionBar(mToolbar);

        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.primary);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.white);
        mSwipeRefreshLayout.setOnRefreshListener(() -> mEventPresenter.getEvent(10));

        mEventAdapter.setClickListener(this);
        mEventRecycler.setLayoutManager(new LinearLayoutManager(this));
        mEventRecycler.setAdapter(mEventAdapter);

        mErrorView.setErrorListener(this);

        mEventPresenter.getEvent(10);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEventPresenter.detachView();
    }

    @Override
    public void showEvents(List<Event> events) {
        mEventAdapter.setEvents(events);
        mEventAdapter.notifyDataSetChanged();
        mEventRecycler.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            if (mEventRecycler.getVisibility() == View.VISIBLE
                    && mEventAdapter.getItemCount() > 0) {
                mSwipeRefreshLayout.setRefreshing(true);
            } else {
                mProgress.setVisibility(View.VISIBLE);

                mEventRecycler.setVisibility(View.GONE);
                mSwipeRefreshLayout.setVisibility(View.GONE);
            }

            mErrorView.setVisibility(View.GONE);
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
            mProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {
        mEventRecycler.setVisibility(View.GONE);
        mSwipeRefreshLayout.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onReloadData() {
        mEventPresenter.getEvent(10);
    }

    @Override
    public void onEventClick(Event event) {
        Toast.makeText(getApplicationContext(), "ok clicked", Toast.LENGTH_LONG).show();
    }
}
