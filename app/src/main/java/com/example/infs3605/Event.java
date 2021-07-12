package com.example.infs3605;

import java.util.ArrayList;

public class Event {
    public Event(String eventName, String eventDate, String eventLocation, String eventSuburb, String eventMonthDate, int eventImageId) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventSuburb = eventSuburb;
        this.eventMonthDate = eventMonthDate;
        this.eventImageId = eventImageId;
    }

    private String eventName;
    private String eventDate;
    private String eventLocation;
    private String eventSuburb;
    private String eventMonthDate;

    public int getEventImageId() {
        return eventImageId;
    }

    public void setEventImageId(int eventImageId) {
        this.eventImageId = eventImageId;
    }

    private int eventImageId;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventSuburb() {
        return eventSuburb;
    }

    public void setEventSuburb(String eventSuburb) {
        this.eventSuburb = eventSuburb;
    }

    public String getEventMonthDate() {
        return eventMonthDate;
    }

    public void setEventMonthDate(String eventMonthDate) {
        this.eventMonthDate = eventMonthDate;
    }

    public static ArrayList<Event> getEvents() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("Aboriginal Cultural Heritage Walk", "Sun, 8:00am - 2:00pm",
                "North Sydney Council, 200 Miller St", "North Sydney, NSW", "27 JUN",
                R.drawable.aboriginal_heritage_walk));
        events.add(new Event("National Indigenous ArtDetails Fair", "Sat, 9:00am - 10:00pm",
                "Sydney Cove Terminal, 130 Argyle St", "The Rocks, NSW", "03 JUL",
                R.drawable.indigenous_art_fair));
        return events;
    }

    public static Event getEvent(String eventName) {
        ArrayList<Event> events = Event.getEvents();
        for(final Event event : events) {
            if(event.getEventName().equals(eventName)) {
                return event;
            }
        }
        return null;
    }
}
