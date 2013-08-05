package com.thoughtworks.trakemoi.models;

public class Zone {

    private Long id;
    private String name;
    private String desc;
    private int radius;
    private double latitude;
    private double longitude;

    private Zone(Builder builder) {
        this.name = builder.name;
        this.desc = builder.desc;
        this.radius = builder.radius;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getRadius() {
        return radius;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static class Builder {
        private String name;
        private String desc;
        private int radius;
        private double latitude;
        private double longitude;

        public Builder withName(String name) {
            this.name = setBlankIfNull(name);
            return this;
        }

        public Builder withDesc(String desc) {
            this.desc = setBlankIfNull(desc);
            return this;
        }

        public Builder withRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public Builder withLatitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder withLongitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Zone build() {
            return new Zone(this);
        }

        private String setBlankIfNull(String name) {
            return (name == null) ? "" : name;
        }
    }

}
