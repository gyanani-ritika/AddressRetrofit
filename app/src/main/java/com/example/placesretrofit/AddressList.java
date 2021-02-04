package com.example.placesretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressList {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("addressString")
        @Expose
        private String addressString;
        @SerializedName("latitude")
        @Expose
        private double latitude;
        @SerializedName("longitude")
        @Expose
        private double longitude;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("priority")
        @Expose
        private int priority;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddressString() {
            return addressString;
        }

        public void setAddressString(String addressString) {
            this.addressString = addressString;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

    }

