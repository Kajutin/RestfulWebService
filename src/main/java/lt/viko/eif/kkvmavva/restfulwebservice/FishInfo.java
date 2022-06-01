package lt.viko.eif.kkvmavva.restfulwebservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 */
@Entity
public class FishInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String name;
    private String waterType;
    private String location;
    private String conservationStatus;
    private String bestToCatchSeason;
    private String fishBreedingSeason;
    private String illegalToCatchSeason;
    private Integer minimumLegalSizeToCatch;
    private String description;

    public FishInfo() {
    }

    public FishInfo(String name, String waterType, String location, String conservationStatus, String bestToCatchSeason,
                    String fishBreedingSeason, String illegalToCatchSeason, Integer minimumLegalSizeToCatch,
                    String description) {
        this.name = name;
        this.waterType = waterType;
        this.location = location;
        this.conservationStatus = conservationStatus;
        this.bestToCatchSeason = bestToCatchSeason;
        this.fishBreedingSeason = fishBreedingSeason;
        this.illegalToCatchSeason = illegalToCatchSeason;
        this.minimumLegalSizeToCatch = minimumLegalSizeToCatch;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishInfo))
            return false;
        FishInfo fishInfo = (FishInfo) o;
        return Objects.equals(id, fishInfo.id) && Objects.equals(name, fishInfo.name) && Objects.equals(waterType,
                fishInfo.waterType) && Objects.equals(location, fishInfo.location) && Objects.equals(conservationStatus,
                fishInfo.conservationStatus) && Objects.equals(bestToCatchSeason, fishInfo.bestToCatchSeason)
                && Objects.equals(fishBreedingSeason, fishInfo.fishBreedingSeason) && Objects.equals(illegalToCatchSeason,
                fishInfo.illegalToCatchSeason) && Objects.equals(minimumLegalSizeToCatch, fishInfo.minimumLegalSizeToCatch)
                && Objects.equals(description, fishInfo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, waterType, location, conservationStatus, bestToCatchSeason, fishBreedingSeason,
                illegalToCatchSeason, minimumLegalSizeToCatch, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "FishInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", waterType='" + waterType + '\'' +
                ", location='" + location + '\'' +
                ", conservationStatus='" + conservationStatus + '\'' +
                ", bestToCatchSeason='" + bestToCatchSeason + '\'' +
                ", fishBreedingSeason='" + fishBreedingSeason + '\'' +
                ", illegalToCatchSeason='" + illegalToCatchSeason + '\'' +
                ", minimumLegalSizeToCatch=" + minimumLegalSizeToCatch +
                ", description='" + description + '\'' +
                '}';
    }
}
