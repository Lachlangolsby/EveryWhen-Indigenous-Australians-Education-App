package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EventsDetailActivity extends AppCompatActivity {

    public static final String EVENT_MESSAGE = "EventMessage";

    private TextView eventDateByMonth;
    private TextView eventTitle;
    private ImageView eventImage;
    private TextView detailsText;
    private TextView eventFullDate;
    private TextView eventPhysicalLocation;
    private TextView eventDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_detail);

        eventDateByMonth = findViewById(R.id.monthDateTv);
        eventTitle = findViewById(R.id.eventTitleTv);
        eventImage = findViewById(R.id.eventImageIv);
        detailsText = findViewById(R.id.detailsTextTv);
        eventFullDate = findViewById(R.id.actualDateTv);
        eventPhysicalLocation = findViewById(R.id.eventLocationTv);
        eventDetails = findViewById(R.id.eventDescriptionTv);

        Intent intent = getIntent();
        String eventName = intent.getStringExtra(EVENT_MESSAGE);

        Event event = Event.getEvent(eventName);
        if(event !=null) {
            eventDateByMonth.setText(event.getEventMonthDate());
            eventTitle.setText(event.getEventName());
            detailsText.setText("Details");
            eventImage.setImageResource(event.getEventImageId());
            eventFullDate.setText(event.getEventDate());
            eventPhysicalLocation.setText(event.getEventLocation());
            eventDetails.setText(event.getEventDescription());
        }

    }
}