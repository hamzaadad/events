package m.hamza.studios.ui.events;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import m.hamza.studios.R;
import m.hamza.studios.data.model.Event;
import m.hamza.studios.ui.main.PokemonAdapter;

/**
 * Created by DevBlaan on 15/12/2016.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.eventViewHolder> {

    List<Event> mEvent;
    private ClickListener mClickListener;

    @Inject
    public EventAdapter() {
        mEvent = Collections.emptyList();
    }


    public void setEvents(List<Event> events){
        mEvent = events;
    }
    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }


    @Override
    public EventAdapter.eventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(EventAdapter.eventViewHolder holder, int position) {
        Event event = mEvent.get(position);

        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return mEvent.size();
    }



    public interface ClickListener {
        void onEventClick(Event event);
    }

    class eventViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.text_name)
        TextView nameText;

        public eventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(Event event){
            //nameText.setText(event.getName);
            itemView.setOnClickListener(v -> {
                if (mClickListener != null) {
                    mClickListener.onEventClick(event);
                }
            });
        }
    }

}
