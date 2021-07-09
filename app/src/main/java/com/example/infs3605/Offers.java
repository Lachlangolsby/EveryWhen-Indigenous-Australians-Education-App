package com.example.infs3605;

import java.util.ArrayList;

public class Offers {


        // 1. Declaring variable for attraction class type
        private String Attraction;
        private String type;
        private String location;
        private String suburb;
        private double rating;
        private String AttractionCode;
        private String priceGuide;
        private String imageUrl;
        private String imageUrl2;
        private String imageUrl3;
        private String phoneNumber;
        private String email;
        private String description;

        // 2. Creating constructor for attractions class
        public Offers(String Attraction, String type, String location, String suburb, double rating, String AttractionCode, String priceGuide, String imageUrl,String imageUrl2, String imageUrl3, String phoneNumber, String email, String description) {
            this.Attraction = Attraction;
            this.type = type;
            this.location = location;
            this.suburb = suburb;
            this.rating = rating;
            this.AttractionCode = AttractionCode;
            this.priceGuide = priceGuide;
            this.imageUrl = imageUrl;
            this.imageUrl2 = imageUrl2;
            this.imageUrl3 = imageUrl3;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.description = description;

        }

        // 3.creating Array list to be used by adapter class to implement correctly into the recycler view. (Acts similar to a database for the workings of the app).
        public static ArrayList<Offers> getAttractions() {
            ArrayList<Offers> offersArrayList = new ArrayList<>();
            offersArrayList.add(new Offers("Bondi Beach", "Recreational", "Bondi Beach, Sydney NSW 2026", "Bondi 2026", 4.6, "BB", "$30 PP", "https://upload.wikimedia.org/wikipedia/commons/e/e5/Bondi_Beach_Sydney_Australia_7.jpg", "https://cdn.theculturetrip.com/wp-content/uploads/2019/11/khj7eh.jpg","https://www.sydney.com/sites/sydney/files/styles/landscape_992x558/public/2019-09/147392-56.jpg?itok=uFCTfJ0m","(02) 9083 8000 ", "info@waverley.nsw.gov.au", "Bondi Beach is Australia's most famous beach. The jewel of Sydney's laid-back beach lifestyle is home to one of the oldest surf lifesaving clubs in the world and one of Australia's oldest swimming clubs."));
            offersArrayList.add(new Offers("Sydney Opera House", "Arts", "Bennelong Point, Sydney NSW 2000", "Haymarket 2000", 4.3, "OH", "$40 PP  ", "https://media-cdn.tripadvisor.com/media/photo-m/1280/17/3b/95/61/photo2jpg.jpg","https://imgs.classicfm.com/images/112697?width=1000&crop=16_9&signature=XBbdgPuFObxMZ8mc5K5XIhWcJSw=" ,"https://i.pinimg.com/originals/79/10/c3/7910c32621f7579d05ae20728f1abf55.jpg","(02) 9250 7111", "bookings@sydneyoperahouse.com", "The Opera House is Sydney's best-known landmark. It is a multipurpose performing arts facility whose largest venue, the 2,679-seat Concert Hall, is host to symphony concerts, choir performances, and popular music shows."));
            offersArrayList.add(new Offers("Sydney Harbour Bridge", "Historical", "Sydney Harbour Bridge, Sydney NSW 2000", "Haymarket 2000", 4.3, "SB", "$100 PP", "https://images.arcadis.com/media/A/F/D/%7BAFDCAEB3-7314-48FC-B624-D209EC987F35%7DSydney-Harbour-Bridge-header.jpg?width=1920&height=0&mode=crop&anchor=top","https://www.sydney.com/sites/sydney/files/styles/landscape_992x558/public/2019-10/150417-Header.jpg?itok=9fxZoqXC","https://visitgayaustralia.com.au/wp-content/uploads/2019/04/Sydney%20Harbour%20Bridge%20Fireworks%20VGA.jpg", "(02) 8274 7777", "admin@bridgeclimb.com", "The Sydney Harbour Bridge is the world's widest and tallest (but not longest) steel arch bridge."));
            offersArrayList.add(new Offers("Royal Botanical Gardens", "Recreational", "Mrs Macquaries Rd, Sydney NSW 2000", "Haymarket 2000", 4.1, "BG", "$15 PP", "https://sydneylivingmuseums.com.au/sites/default/files/crop%20Spring%20Walk%202007%2026.jpg","https://assets.atdw-online.com.au/images/fdb160eeadc7d83ce96aa78c6c684b9d.jpeg?rect=178","https://pbs.twimg.com/media/ET1cmusWAAAVKJj.jpg", "(02) 9231 8111", "feedback@rbgsyd.nsw.gov.au", "The Royal Botanic Garden Sydney, an oasis of 30 hectares in the heart of the city. Wrapped around Sydney Harbour, the Gardens occupy one of Sydney's most spectacular positions. "));
            offersArrayList.add(new Offers("Taronga Zoo", "Recreational", "Bradleys Head Rd, Sydney NSW 2088", "Mosman 2088", 4.0, "TZ", "$75 PP", "https://www.ausleisure.com.au/images/ausleisure/files/_news-main/Taronga_Zoo_Sydney_1.jpg","https://www.savingdessert.com/wp-content/uploads/2018/06/Taronga-Zoo-Sydney-Australia-3.jpg","https://taronga.org.au/sites/default/files/styles/opengraph/public/content/header-images/header-tz-shows-keeper-talks-birdshow-2880.jpg?itok=Thl61-81", "(02) 9969 2777", "tz@zoo.nsw.gov.au", "the award-winning Taronga Zoo is home to over 4,000 animals, including Australian native wildlife, as well as rare and endangered exotic animals. Overlooking the magnificent Sydney Harbour."));
            return offersArrayList;
        }

        // 4. Creating getters and setters for the various attributes of attractions class type
        public String getAttraction() {
            return Attraction;
        }

        public void setAttraction(String attraction) {
            this.Attraction = attraction;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getSuburb() {
            return suburb;
        }

        public void setSuburb(String suburb) {
            this.suburb = suburb;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getAttractionCode() {
            return AttractionCode;
        }

        public void setAttractionCode(String AttractionCode) {
            this.AttractionCode = AttractionCode;
        }

        public String getPriceGuide() {
            return priceGuide;
        }

        public void setPriceGuide(String priceGuide) {
            this.priceGuide = priceGuide;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.imageUrl = ImageUrl;
        }

        public String getImageUrl2() {
            return imageUrl2;
        }

        public void setImageUrl2(String ImageUrl2) {
            this.imageUrl2 = ImageUrl2;
        }

        public String getImageUrl3() {
            return imageUrl3;
        }

        public void setImageUrl3(String ImageUrl3) {
            this.imageUrl3 = ImageUrl3;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.priceGuide = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

