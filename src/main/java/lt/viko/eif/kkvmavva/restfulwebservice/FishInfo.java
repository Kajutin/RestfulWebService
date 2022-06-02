package lt.viko.eif.kkvmavva.restfulwebservice;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
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
    private Integer minimumLegalSizeToCatch;
    private String description;
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
}