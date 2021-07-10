package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity
public class Art {
    @PrimaryKey
    @NonNull
    @SerializedName("Id")
    @Expose
    public String id;
    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("AdditionalType")
    @Expose
    public String additionalType;
    @SerializedName("Region")
    @Expose
    public String region;
    @SerializedName("Creator")
    @Expose
    public String creator;
    @SerializedName("PhysicalDescription")
    @Expose
    public String physicalDescription;

    public String getArtId() {
        return id;
    }

    public void setArtId(String id) {
        this.id = id;
    }

    public String getArtTitle() {
        return title;
    }

    public void setArtTitle(String title) {
        this.title = title;
    }

    public String getArtAdditionalType() {
        return additionalType;
    }

    public void setArtAdditionalType(String additionalType) { this.additionalType = additionalType; }

    public String getArtRegion() {
        return region;
    }

    public void setArtRegion(String region) { this.region = region; }

    public String getArtCreator() {
        return creator;
    }

    public void setArtCreator(String creator) { this.creator = creator; }

    public String getArtPhysicalDescription() {
        return physicalDescription;
    }

    public void setArtPhysicalDescription(String physicalDescription) { this.physicalDescription = physicalDescription; }
}
