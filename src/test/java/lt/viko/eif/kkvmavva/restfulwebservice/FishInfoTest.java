package lt.viko.eif.kkvmavva.restfulwebservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing fish info class
 */
class FishInfoTest {

    /**
     * Test setting id
     */
    @Test
    void setId() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setId(12L);
        assertEquals(12L, fishInfo.getId());
    }

    /**
     * Test setting name
     */
    @Test
    void setName() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setName("Salmon");
        assertEquals("Salmon", fishInfo.getName());
    }
    /**
     * Test setting water type
     */
    @Test
    void setWaterType() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setWaterType("Clean river");
        assertEquals("Clean river", fishInfo.getWaterType());
    }
    /**
     * Test setting location
     */
    @Test
    void setLocation() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setLocation("Atlantic");
        assertEquals("Atlantic", fishInfo.getLocation());
    }
    /**
     * Test setting conservation status
     */
    @Test
    void setConservationStatus() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setConservationStatus("Least Concern - Endangered in Lithuania");
        assertEquals("Least Concern - Endangered in Lithuania", fishInfo.getConservationStatus());

    }
    /**
     * Test setting best to catch season
     */
    @Test
    void setBestToCatchSeason() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setBestToCatchSeason("Summer");
        assertEquals("Summer", fishInfo.getBestToCatchSeason());
    }
    /**
     * Test setting fish breeding season
     */
    @Test
    void setFishBreedingSeason() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setFishBreedingSeason("Spring");
        assertEquals("Spring", fishInfo.getFishBreedingSeason());
    }
    /**
     * Test setting illegal to catch season
     */
    @Test
    void setIllegalToCatchSeason() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setIllegalToCatchSeason("Winter");
        assertEquals("Winter", fishInfo.getIllegalToCatchSeason());
    }
    /**
     * Test setting minimum legal size to catch in centimeters
     */
    @Test
    void setMinimumLegalSizeToCatchInCentimeters() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setMinimumLegalSizeToCatchInCentimeters(65);
        assertEquals(65, fishInfo.getMinimumLegalSizeToCatchInCentimeters());
    }
    /**
     * Test setting description
     */
    @Test
    void setDescription() {
        FishInfo fishInfo = new FishInfo();
        fishInfo.setDescription("Nice fish");
        assertEquals("Nice fish", fishInfo.getDescription());
    }
}