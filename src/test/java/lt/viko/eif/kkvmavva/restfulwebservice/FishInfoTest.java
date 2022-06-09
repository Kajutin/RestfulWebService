package lt.viko.eif.kkvmavva.restfulwebservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FishInfoTest {

    @Test
    void setId() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setId(12L);
        assertEquals(12L, fishInfo.getId());
    }

    @Test
    void setName() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setName("Salmon");
        assertEquals("Salmon", fishInfo.getName());
    }

    @Test
    void setWaterType() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setWaterType("Clean river");
        assertEquals("Clean river", fishInfo.getWaterType());
    }

    @Test
    void setLocation() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setLocation("Atlantic");
        assertEquals("Atlantic", fishInfo.getLocation());
    }

    @Test
    void setConservationStatus() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setConservationStatus("Least Concern - Endangered in Lithuania");
        assertEquals("Least Concern - Endangered in Lithuania", fishInfo.getConservationStatus());

    }

    @Test
    void setBestToCatchSeason() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setBestToCatchSeason("Summer");
        assertEquals("Summer", fishInfo.getBestToCatchSeason());
    }

    @Test
    void setFishBreedingSeason() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setFishBreedingSeason("Spring");
        assertEquals("Spring", fishInfo.getFishBreedingSeason());
    }

    @Test
    void setIllegalToCatchSeason() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setIllegalToCatchSeason("Winter");
        assertEquals("Winter", fishInfo.getIllegalToCatchSeason());
    }

    @Test
    void setMinimumLegalSizeToCatchInCentimeters() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setMinimumLegalSizeToCatchInCentimeters(65);
        assertEquals(65, fishInfo.getMinimumLegalSizeToCatchInCentimeters());
    }

    @Test
    void setDescription() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setDescription("Nice fish");
        assertEquals("Nice fish", fishInfo.getDescription());
    }
}