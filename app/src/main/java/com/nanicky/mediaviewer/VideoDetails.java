package com.nanicky.mediaviewer;

import android.graphics.Bitmap;

import java.util.Date;

public class VideoDetails {

    public Bitmap videoThumbNail;
    public String name;
    public String videoPath;
    public Date dateTaken;
    public Date dateModified;
    public Date dateAdded;
    public String resolution;
    public String mimeType;

    public VideoDetails(Bitmap videoThumbNail, String name, String videoPath, Date dateTaken, Date dateModified, Date dateAdded, String resolution, String mimeType) {
        this.videoThumbNail = videoThumbNail;
        this.name = name;
        this.videoPath = videoPath;
        this.dateTaken = dateTaken;
        this.dateModified = dateModified;
        this.dateAdded = dateAdded;
        this.resolution = resolution;
        this.mimeType = mimeType;
    }

    public VideoDetails(String name, String videoPath, Date dateTaken, Date dateModified, Date dateAdded, String resolution, String mimeType) {
        this.name = name;
        this.videoPath = videoPath;
        this.dateTaken = dateTaken;
        this.dateModified = dateModified;
        this.dateAdded = dateAdded;
        this.resolution = resolution;
        this.mimeType = mimeType;
    }
}
