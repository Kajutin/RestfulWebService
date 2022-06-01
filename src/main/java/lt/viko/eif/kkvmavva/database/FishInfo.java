package lt.viko.eif.kkvmavva.database;

/**
 *
 */
public class FishInfo {
    private String name;
    private String waterType;
    private String location;
    private String conservationStatus;
    private String bestToCatchSeason;
    private String fishBreedingSeason;
    private String illegalToCatchSeason;
    private Integer minimumLegalSizeToCatch;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public String getBestToCatchSeason() {
        return bestToCatchSeason;
    }

    public void setBestToCatchSeason(String bestToCatchSeason) {
        this.bestToCatchSeason = bestToCatchSeason;
    }

    public String getFishBreedingSeason() {
        return fishBreedingSeason;
    }

    public void setFishBreedingSeason(String fishBreedingSeason) {
        this.fishBreedingSeason = fishBreedingSeason;
    }

    public String getIllegalToCatchSeason() {
        return illegalToCatchSeason;
    }

    public void setIllegalToCatchSeason(String illegalToCatchSeason) {
        this.illegalToCatchSeason = illegalToCatchSeason;
    }

    public Integer getMinimumLegalSizeToCatch() {
        return minimumLegalSizeToCatch;
    }

    public void setMinimumLegalSizeToCatch(Integer minimumLegalSizeToCatch) {
        this.minimumLegalSizeToCatch = minimumLegalSizeToCatch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
