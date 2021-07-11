package com.example.infs3605;

import java.util.ArrayList;

public class Offers {


        // 1. Declaring variable for attraction class type
        private String Offer;
        private String type;
        private String location;
        private String suburb;
        private String OfferCode;
        private String imageUrl;
        private String phoneNumber;
        private String email;
        private String description;

        // 2. Creating constructor for attractions class
        public Offers(String Offer, String type, String location, String suburb, String OfferCode, String imageUrl, String phoneNumber, String email, String description) {
            this.Offer = Offer;
            this.type = type;
            this.location = location;
            this.suburb = suburb;
            this.OfferCode = OfferCode;
            this.imageUrl = imageUrl;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.description = description;

        }

        // 3.creating Array list to be used by adapter class to implement correctly into the recycler view. (Acts similar to a database for the workings of the app).
        public static ArrayList<Offers> getOffers() {
            ArrayList<Offers> offersArrayList = new ArrayList<>();
            offersArrayList.add(new Offers("National Museum Of Australia", "Discount", "ACT", "Acton, 2601", "MD", "https://wilsonanastasios.files.wordpress.com/2010/10/hero.jpg", "96693391", "friends@nma.gov.au", "Present your account profile at the National Museum of Australia to receive a 15% discount on admission"));
            offersArrayList.add(new Offers("Art Gallery of NSW", "Discount", "NSW", "Sydney NSW 2000", "ND", "https://www.datocms-assets.com/42890/1619662450-20210423150years002.jpg?fit=crop&h=419&w=579", "9225 1700", "GalleryShop@ag.nsw.gov.au", "Present your account profile at the Art Gallery of NSW to receive a 15% discount on admission"));
            offersArrayList.add(new Offers("The Red Cross", "Donation", "Australia Wide", "Online", "RP", "https://clubs.uow.edu.au/wp-content/uploads/2020/07/red-cross.png", "1800 733 276", "support@redcrosstraining.org", "Post a picture of yourself and your favourite piece of indigenous art work with the #SOMETHING, as well as tag the Red Cross and $20 will be donated to ANTaR"));
            return offersArrayList;
        }

        // 4. Creating getters and setters for the various attributes of attractions class type
        public String getOffer() {
            return Offer;
        }

        public void setOffer(String Offer) {
            this.Offer = Offer;
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

        public String getAttractionCode() {
            return OfferCode;
        }

        public void setAttractionCode(String AttractionCode) {
            this.OfferCode = AttractionCode;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.imageUrl = ImageUrl;
        }


        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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

