package lt.viko.eif.kkvmavva.restfulwebservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 *
 */
@Data
@Entity
@AllArgsConstructor
@Getter
public class FishInfo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String waterType;
    private String location;
    private String conservationStatus;
    private String bestToCatchSeason;
    private String fishBreedingSeason;
    private String illegalToCatchSeason;
    private Integer minimumLegalSizeToCatchInCentimeters;
    private String description;


    public FishInfo(){

    }

    public FishInfo(String name, String waterType, String location, String conservationStatus, String bestToCatchSeason,
                    String fishBreedingSeason, String illegalToCatchSeason, Integer minimumLegalSizeToCatchInCentimeters,
                    String description) {
        this.name = name;
        this.waterType = waterType;
        this.location = location;
        this.conservationStatus = conservationStatus;
        this.bestToCatchSeason = bestToCatchSeason;
        this.fishBreedingSeason = fishBreedingSeason;
        this.illegalToCatchSeason = illegalToCatchSeason;
        this.minimumLegalSizeToCatchInCentimeters = minimumLegalSizeToCatchInCentimeters;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public void setBestToCatchSeason(String bestToCatchSeason) {
        this.bestToCatchSeason = bestToCatchSeason;
    }

    public void setFishBreedingSeason(String fishBreedingSeason) {
        this.fishBreedingSeason = fishBreedingSeason;
    }

    public void setIllegalToCatchSeason(String illegalToCatchSeason) {
        this.illegalToCatchSeason = illegalToCatchSeason;
    }

    public void setMinimumLegalSizeToCatchInCentimeters(Integer minimumLegalSizeToCatchInCentimeters) {
        this.minimumLegalSizeToCatchInCentimeters = minimumLegalSizeToCatchInCentimeters;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWaterType() {
        return waterType;
    }

    public String getLocation() {
        return location;
    }

    public String getConservationStatus() {
        return conservationStatus;
    }

    public String getBestToCatchSeason() {
        return bestToCatchSeason;
    }

    public String getFishBreedingSeason() {
        return fishBreedingSeason;
    }

    public String getIllegalToCatchSeason() {
        return illegalToCatchSeason;
    }

    public Integer getMinimumLegalSizeToCatchInCentimeters() {
        return minimumLegalSizeToCatchInCentimeters;
    }

    public String getDescription() {
        return description;
    }
}