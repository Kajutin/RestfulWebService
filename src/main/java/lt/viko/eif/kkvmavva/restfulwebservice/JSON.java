package lt.viko.eif.kkvmavva.restfulwebservice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

/**
 * Reads, saves, updates, deletes JSON file database
 */
public class JSON {

    JSONArray fishList = new JSONArray();

    /**
     * Saves new fish to JSON database
     * @param fish
     */
    public void SaveToJson(FishInfo fish){

        JSONObject fishDetails = new JSONObject();
        ReadJSONFile();

        fishDetails.put("name",fish.getName());
        fishDetails.put("waterType",fish.getWaterType());
        fishDetails.put("location",fish.getLocation());
        fishDetails.put("conservationStatus",fish.getConservationStatus());
        fishDetails.put("bestToCatchSeason",fish.getBestToCatchSeason());
        fishDetails.put("fishBreedingSeason",fish.getFishBreedingSeason());
        fishDetails.put("illegalToCatchSeason",fish.getIllegalToCatchSeason());
        fishDetails.put("minimumLegalSizeToCatchInCentimeters",fish.getMinimumLegalSizeToCatchInCentimeters());
        fishDetails.put("description",fish.getDescription());
        JSONObject fishObject = new JSONObject();
        fishObject.put("fish",fishDetails);


        fishList.add(fishObject);


        File f = new File("FishCollection.json");
        if (f.exists()){

        }
        //Write JSON file
        try (FileWriter file = new FileWriter("FishCollection.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(fishList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UpdateFish(){

    }

    /**
     * ReadsJSONFile and puts it in List
     */
    @SuppressWarnings("unchecked")
    public void ReadJSONFile(){

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("FishCollection.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            fishList = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * Parse fishList
     * @param fish
     * @return
     */
    public  FishInfo parseFish(JSONObject fish)
    {
        JSONObject fishObject = (JSONObject) fish.get("fish");

        String name = (String) fishObject.get("name");

        String waterType = (String) fishObject.get("waterType");

        String location = (String) fishObject.get("location");

        String conservationStatus = (String) fishObject.get("conservationStatus");

        String bestToCatchSeason = (String) fishObject.get("bestToCatchSeason");

        String fishBreedingSeason = (String) fishObject.get("fishBreedingSeason");

        String illegalToCatchSeason = (String) fishObject.get("illegalToCatchSeason");

        Integer minimumLegalSizeToCatch = (Integer) Integer.parseInt(fishObject.get("minimumLegalSizeToCatchInCentimeters").toString());

        String description = (String) fishObject.get("description");

        return new FishInfo(name,waterType,location,conservationStatus,bestToCatchSeason,fishBreedingSeason,
                illegalToCatchSeason,minimumLegalSizeToCatch,description);
    }

}
