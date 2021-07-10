package com.example.infs3605;

public class ArtDetails {

    private String id;
    private String type;
    private String additionalType;
    private String title;
    private String region;
    private String creator;
    private String identifier;
    private String physicalDescription;


    public ArtDetails(String id, String type, String additionalType, String title, String region, String creator, String identifier, String physicalDescription) {
        this.id = id;
        this.type = type;
        this.additionalType = additionalType;
        this.title = title;
        this.region = region;
        this.creator = creator;
        this.identifier = identifier;
        this.physicalDescription = physicalDescription;
    }

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

    public String getAdditionalType() {
        return additionalType;
    }

    public void setAdditionalType(String additionalType) {
        this.additionalType = additionalType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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