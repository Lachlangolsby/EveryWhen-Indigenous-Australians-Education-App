package com.example.infs3605;

import java.util.ArrayList;

public class Event {
    public Event(String eventName, String eventDate, String eventLocation, String eventSuburb, String eventMonthDate, int eventImageId, String eventDescription, String googleMapUrl) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventSuburb = eventSuburb;
        this.eventMonthDate = eventMonthDate;
        this.eventImageId = eventImageId;
        this.eventDescription = eventDescription;
        this.googleMapUrl = googleMapUrl;
    }

    private String eventName;
    private String eventDate;
    private String eventLocation;
    private String eventSuburb;
    private String eventMonthDate;
    private String eventDescription;
    private int eventImageId;
    private String googleMapUrl;

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getEventImageId() {
        return eventImageId;
    }

    public void setEventImageId(int eventImageId) {
        this.eventImageId = eventImageId;
    }

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

    public String getGoogleMapUrl() {
        return googleMapUrl;
    }

    public void setGoogleMapUrl(String googleMapUrl) {
        this.googleMapUrl = googleMapUrl;
    }

    public static ArrayList<Event> getEvents() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("National Indigenous Music Awards 2021", "Sat, 6:30 – 10:00 pm ACST",
                "George Brown Darwin Botanic Gardens, Gilruth Ave & Gardens Rd", " The Gardens, NT", "7 AUG",
                R.drawable.nimas_baker_boy, "A celebration of First Nations music and musicians from across Australia. Recognising" +
                " achievement and excellence in the Indigenous music sector the awards will this year be broadcast through NITV", "https://goo.gl/maps/nAhx61NjtBgbc8pu5"));
        events.add(new Event("Piinpi: Contemporary Indigenous Fashion", "20 Feb 2021 to 8 Aug 2021",
                "National Museum of Australia, Lawson Cresent", "Acton, ACT", "AUG",
                R.drawable.piinpi_exhibit_event, "Featuring the work of around 60 Indigenous artists and designers from the inner city" +
                " to remote desert art centres, Piinpi: Contemporary Indigenous Fashion celebrates Australia’s leading First Nations creatives.", "https://g.page/nationalmuseumofaustralia?share"));
        events.add(new Event("Aboriginal Storytime at the Gallery", "Tue, 11:30 am – 12:30 pm",
                "Counihan Gallery, 233 Sydney Rd", "Brunswick, VIC", "10 AUG",
                R.drawable.storytime_gallery, "Join us for a special First Nations Storytime and explore Banj Banj/nawnta.", "https://goo.gl/maps/qsYzj8RnBokWE4Ek9"));
        events.add(new Event("Indigenous Food and Agriculture", "Fri, 6:30 – 7:45 pm",
                "The Royal Society of Victoria, 8 La Trobe St", "Melbourne, VIC", "13 AUG",
                R.drawable.indigenous_food_agriculture, "Come yarn about native foods, healthy eating and Australian Indigenous" +
                " farmers.", "https://g.page/royalsocietyvic?share"));
        events.add(new Event("Cairns Indigenous Art Fair", "17 Aug 2021 to 22 Aug 2021",
                "TBA", "Cairns City, QLD", "AUG",
                R.drawable.cairns_fair, "From the 17-22 August, delight in discovering the richness of Queensland’s Aboriginal and Torres" +
                " Strait Islander cultures in a series of art installations, performances and festivals across Cairns.", "https://www.google.com/search?q=cairns+indigenous+art+fair"));
        events.add(new Event("Winhangadurinya: Aboriginal Meditation", "Sat, 10:30 am – 1:00 pm",
                "Australian Museum, 1 William St", "Darlinghurst, NSW", "21 AUG",
                R.drawable.meditation_event, "This unique workshop offers both an authentic and heartfelt" +
                " introduction to First Nations culture and a chance to take time out in a hectic world.", "https://g.page/austmus?share"));
        events.add(new Event("Indigenous Science Experience at Redfern", "Sat, 10:00 am – 3:00 pm",
                "Redfern Community Centre, 29-53 Hugo St", "Redfern, NSW", "21 AUG",
                R.drawable.science_experience_event_redfern, "Indigenous Science Experience at Redfern at Redfern " +
                "Community Centre, 29-53 Hugo Street, Sydney, NSW, Australia on Sat Aug 21 2021 at 10:00 am to 03:00 pm", "https://g.page/redfern-community-centre?share"));
        events.add(new Event("Unsettled film series: High Ground", "Sat, 12:30 – 2:30 pm",
                "Australian Museum, 1 William St", "Darlinghurst, NSW", "28 AUG",
                R.drawable.hero_high_ground, "Set against the stunning landscapes of 1930s Arnhem Land, High Ground chronicles the quest" +
                " of a young Aboriginal man to save the last of his family.", "https://g.page/austmus?share"));

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
