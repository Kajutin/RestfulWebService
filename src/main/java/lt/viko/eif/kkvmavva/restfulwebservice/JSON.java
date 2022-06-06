package lt.viko.eif.kkvmavva.restfulwebservice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import static java.lang.System.out;

/**
 * Reads, saves, updates, deletes JSON file database
 */
public class JSON {

    public JSONArray fishList = new JSONArray();
    private Integer index = 1;
    public List<Integer> fishID = new ArrayList<Integer>();

    /**
     * Saves new fish to JSON database
     *
     * @param fish
     */
    public void SaveToJson(FishInfo fish) {
        fishID.add(index++);
        JSONObject fishDetails = new JSONObject();
        ReadJSONFile();

        fishDetails.put("name", fish.getName());
        fishDetails.put("waterType", fish.getWaterType());
        fishDetails.put("location", fish.getLocation());
        fishDetails.put("conservationStatus", fish.getConservationStatus());
        fishDetails.put("bestToCatchSeason", fish.getBestToCatchSeason());
        fishDetails.put("fishBreedingSeason", fish.getFishBreedingSeason());
        fishDetails.put("illegalToCatchSeason", fish.getIllegalToCatchSeason());
        fishDetails.put("minimumLegalSizeToCatchInCentimeters", fish.getMinimumLegalSizeToCatchInCentimeters());
        fishDetails.put("description", fish.getDescription());
        JSONObject fishObject = new JSONObject();
        fishObject.put("fish", fishDetails);


        fishList.add(fishObject);

        //Write JSON file
        try (FileWriter file = new FileWriter("FishCollection.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(fishList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates JSON information about fish
     */
    public void UpdateFish(FishInfo fishInfo, long id) {
        int i=0;
        JSONArray temp = new JSONArray();
        for (Integer o : fishID){
            if(id!=Long.valueOf(o)) temp.add(fishList.get(i));
            else {
                JSONObject fishDetails = new JSONObject();
                fishDetails.put("name", fishInfo.getName());
                fishDetails.put("waterType", fishInfo.getWaterType());
                fishDetails.put("location", fishInfo.getLocation());
                fishDetails.put("conservationStatus", fishInfo.getConservationStatus());
                fishDetails.put("bestToCatchSeason", fishInfo.getBestToCatchSeason());
                fishDetails.put("fishBreedingSeason", fishInfo.getFishBreedingSeason());
                fishDetails.put("illegalToCatchSeason", fishInfo.getIllegalToCatchSeason());
                fishDetails.put("minimumLegalSizeToCatchInCentimeters", fishInfo.getMinimumLegalSizeToCatchInCentimeters());
                fishDetails.put("description", fishInfo.getDescription());
                JSONObject fishObject = new JSONObject();
                fishObject.put("fish", fishDetails);
                temp.add(fishObject);
            }
            i++;
        }
        fishList=temp;


        // Overwrites JSON with new values
        //Write JSON file
        try (FileWriter file = new FileWriter("FishCollection.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(fishList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ReadsJSONFile and puts it in List
     */
    @SuppressWarnings("unchecked")
    public void ReadJSONFile() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("FishCollection.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            fishList = (JSONArray) obj;
            fishList.forEach(fishList -> parseFish((JSONObject) fishList));
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
     *
     * @param fish
     * @return
     */
    public FishInfo parseFish(JSONObject fish) {
        fishID.add(index++);
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

        return new FishInfo(name, waterType, location, conservationStatus, bestToCatchSeason, fishBreedingSeason,
                illegalToCatchSeason, minimumLegalSizeToCatch, description);
    }

    /**
     * Deletes Fish
     * @param id
     */
    public void DeleteFish(long id) {
        int i = 0;
        int deleteID=0;
        JSONArray temp = new JSONArray();
        for (Integer o : fishID){
            if(id!=Long.valueOf(o)) {
                temp.add(fishList.get(i));

            }else deleteID=i;
            i++;
        }
        fishID.remove(deleteID);
        fishList=temp;
        // Overwrites JSON with new values
        //Write JSON file
        try (FileWriter file = new FileWriter("FishCollection.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(fishList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
