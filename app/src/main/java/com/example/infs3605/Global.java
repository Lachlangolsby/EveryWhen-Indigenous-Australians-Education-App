package com.example.infs3605;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Global {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("additionalType")
    @Expose
    private List<String> additionalType = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("physicalDescription")
    @Expose
    private String physicalDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAdditionalType() {
        return additionalType;
    }

    public void setAdditionalType(List<String> additionalType) {
        this.additionalType = additionalType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPhysicalDescription() {
        return physicalDescription;
    }

    public void setPhysicalDescription(String physicalDescription) {
        this.physicalDescription = physicalDescription;
    }
}
