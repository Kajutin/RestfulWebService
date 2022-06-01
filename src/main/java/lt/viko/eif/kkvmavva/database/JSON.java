package lt.viko.eif.kkvmavva.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 */
public class JSON {

    FishInfo fish = new FishInfo();

    public void AddFishDetails(){
        fish.setName("a");
        fish.setWaterType("b");
        fish.setLocation("c");
        fish.setConservationStatus("d");
        fish.setBestToCatchSeason("e");
        fish.setFishBreedingSeason("f");
        fish.setIllegalToCatchSeason("g");
        fish.setMinimumLegalSizeToCatch(0);
        fish.setDescription("h");
    }

    public void SaveToJson(){
        JSONObject fishDetails = new JSONObject();

        fishDetails.put("name",fish.getName());
        fishDetails.put("waterType",fish.getWaterType());
        fishDetails.put("location",fish.getLocation());
        fishDetails.put("securityStatus",fish.getConservationStatus());
        fishDetails.put("bestToCatchSeason",fish.getBestToCatchSeason());
        fishDetails.put("fishBreedingSeason",fish.getFishBreedingSeason());
        fishDetails.put("illegalToCatchSeason",fish.getIllegalToCatchSeason());
        fishDetails.put("minimumLegalSizeToCatch",fish.getMinimumLegalSizeToCatch());
        fishDetails.put("description",fish.getDescription());

        JSONObject fishObject = new JSONObject();
        fishObject.put("fish",fishDetails);

        JSONArray fishList = new JSONArray();
        fishList.add(fishDetails);


        //Write JSON file
        try (FileWriter file = new FileWriter("Fish.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(fishList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Testing ground
    public static void main( String[] args ) {
        JSON j = new JSON();
        j.AddFishDetails();
        j.SaveToJson();
    }

}
