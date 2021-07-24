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
        private String QR;


        // 2. Creating constructor for attractions class
        public Offers(String Offer, String type, String location, String suburb, String OfferCode, String imageUrl, String phoneNumber, String email, String description, String QR) {
            this.Offer = Offer;
            this.type = type;
            this.location = location;
            this.suburb = suburb;
            this.OfferCode = OfferCode;
            this.imageUrl = imageUrl;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.description = description;
            this.QR = QR;

        }

        // 3.creating Array list to be used by adapter class to implement correctly into the recycler view. (Acts similar to a database for the workings of the app).
        public static ArrayList<Offers> getOffers() {
            ArrayList<Offers> offersArrayList = new ArrayList<>();
            offersArrayList.add(new Offers("National Museum Of Australia", "Discount", "ACT", "Lawson Cres, Acton ACT 2601", "MD", "https://wilsonanastasios.files.wordpress.com/2010/10/hero.jpg", "(02) 6208 5000", "friends@nma.gov.au", "Present to staff at the National Museum of Australia to receive a 15% discount on admission.", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1200px-QR_code_for_mobile_English_Wikipedia.svg.png"));
            offersArrayList.add(new Offers("Art Gallery of NSW", "Discount", "NSW", "Art Gallery Rd, Sydney NSW 2000", "ND", "https://www.datocms-assets.com/42890/1619662450-20210423150years002.jpg?fit=crop&h=419&w=579", "(02) 9225 1700", "GalleryShop@ag.nsw.gov.au", "Present your to staff at the Art Gallery of NSW to receive a 15% discount on admission.", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1200px-QR_code_for_mobile_English_Wikipedia.svg.png"));
            offersArrayList.add(new Offers("The Red Cross", "Donation", "Australia Wide", "Online", "RP", "https://clubs.uow.edu.au/wp-content/uploads/2020/07/red-cross.png", "1800 733 276", "support@redcrosstraining.org", "Post a picture of yourself and your favourite piece of indigenous art work with the #RedCrossReconcile, as well as tag the Red Cross and $20 will be donated to ANTaR.", "https://clubs.uow.edu.au/wp-content/uploads/2020/07/red-cross.png"));
            offersArrayList.add(new Offers("Spirit Gallery", "Discount", "Sydney, NSW", " Shop 8 Cnr of Argyle and, Playfair St, The Rocks NSW 2000", "SG", "https://www.therocks.com/getmedia/67457174-f3b6-4e11-a102-0696a7c4881f/spirit-gallery-logo.png?width=300", "(02) 9247 5961", "info@spiritgallery.com.au", "Spend over $100 at the Spirit Gallery and receive a 10% discount.", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1200px-QR_code_for_mobile_English_Wikipedia.svg.png"));
            offersArrayList.add(new Offers("Karlangu Aboriginal Art Centre", "Donation", "NSW", "QVB, Shop 47-51 Level 2, 455 George St, Sydney NSW 2000", "KA", "https://media-cdn.tripadvisor.com/media/photo-s/08/d2/64/1d/karlangu-aboriginal-art.jpg", "(02) 9279 2700", "info@karlangu.com", "Present to staff at the Karlangu Aboriginal Art Centre and a $10 donation will be made to The Indigenous Literacy Foundation.", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1200px-QR_code_for_mobile_English_Wikipedia.svg.png"));
            offersArrayList.add(new Offers("Red Sand Art Gallery", "Donation", "QLD", "27 Campbell St, Paddington QLD 4064", "RD", "https://static.wixstatic.com/media/08cdf3_b033b4529bc7473ab43908d5456e19d2~mv2.jpg/v1/fit/w_2500,h_1330,al_c/08cdf3_b033b4529bc7473ab43908d5456e19d2~mv2.jpg", "0418 805 633", "peter@redsandart.com.au", "Purchase a piece of art from The Red Sand Art gallery and 20% of the purchase price will be donated to NAAJA.", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1200px-QR_code_for_mobile_English_Wikipedia.svg.png"));
            offersArrayList.add(new Offers("Birrunga Art Gallery", "Discount", "QLD", "300 Adelaide St, Brisbane City QLD 4000", "BD", "https://birrunga.com.au/wp-content/uploads/2020/08/Birrunga-Logo_Horizontal-2.png", "(07) 3705 5742", "info@birrunga.com.au", "Present to staff at Birrunga art gallery to receive a 10% discount on food purchased.", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1200px-QR_code_for_mobile_English_Wikipedia.svg.png"));
            offersArrayList.add(new Offers("Finchley Lookout", "Donation", "NSW", "Finchley Trig Lookout Walking Track, Paynes Crossing NSW 2325", "FV", "http://cdn.exploroz.com/images/Places/77669_0__TN1200.jpg", "1300 072 757", "parks.info@environment.nsw.gov.au", "Post an Instagram photo at Finchley lookout tagging National parks and wildlife services NSW and $2 will be donated to the KARI Foundation.", "http://cdn.exploroz.com/images/Places/77669_0__TN1200.jpg"));
            offersArrayList.add(new Offers("Aboriginal Heritage Walk", "Donation", "NSW", "Bobbin Head Rd, New South Wales", "AH", "https://blog.nationalparks.nsw.gov.au/uploads/2018/07/West-Head-Lookout-127-RETOUCHED-1.jpg", "(02) 9451 3479 ", "npws.sydneynorth@environment.nsw.gov.au", "Post an Instagram photo along the Aboriginal Heritage Walk tagging NSW National Parks and $2 will be donated to the KARI Foundation.", "https://blog.nationalparks.nsw.gov.au/uploads/2018/07/West-Head-Lookout-127-RETOUCHED-1.jpg"));
            offersArrayList.add(new Offers("Aboriginal Dreaming's Gallery", "Discount", "ACT", "19 O'Hanlon Place Gold Creek Village, Nicholls ACT 2913", "LG", "https://swassets.visitcanberra.com.au/atdw/0003/19/thumb_218602_atdw_gallery.jpeg", "+61 2 6230 2922", "dream@aboriginaldream.com", "Present to staff at the Aboriginal Dreaming's Gallery to receive a 10% discount on admission.", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/1200px-QR_code_for_mobile_English_Wikipedia.svg.png"));
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

        public String getQR() {
        return QR;
    }

        public void setQR(String QR) {
        this.QR = QR;
    }
    }

