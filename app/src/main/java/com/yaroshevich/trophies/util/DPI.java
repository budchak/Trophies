package com.yaroshevich.trophies.util;

public enum DPI {
    LDPI("ldpi"),
    MDPI("mdpi"),
    HDPI("hdpi"),
    XHDPI("xhdpi"),
    XXHDPI("xxhdpi"),
    XXXHDPI("xxxhdpi");

    private String name;

    private DPI(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
