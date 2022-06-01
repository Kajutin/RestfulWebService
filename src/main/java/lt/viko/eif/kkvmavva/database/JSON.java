package lt.viko.eif.kkvmavva.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

/**
 *
 */
public class JSON {

    FishInfo fish = new FishInfo();

    public void AddFishDetails(){
        fish.setName("abramas");
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
        fishList.add(fishObject);


        File f = new File("Fish.json");
        if (f.exists()){

        }
        //Write JSON file
        try (FileWriter file = new FileWriter("Fish.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(fishList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void ReadJSONFile(){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("fish.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray fishList = (JSONArray) obj;
            System.out.println(fishList);

            //Iterate over employee array
            fishList.forEach( fishl -> parseFish( (JSONObject) fishl ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Testing File Reading
    private  void parseFish(JSONObject employee)
    {
        JSONObject fishObject = (JSONObject) employee.get("fish");

        String name = (String) fishObject.get("name");
        System.out.println(name);

        String waterType = (String) fishObject.get("waterType");
        System.out.println(waterType);

        String location = (String) fishObject.get("location");
        System.out.println(location);

        String conservationStatus = (String) fishObject.get("conservationStatus");
        System.out.println(conservationStatus);

        String bestToCatchSeason = (String) fishObject.get("bestToCatchSeason");
        System.out.println(bestToCatchSeason);

        String fishBreedingSeason = (String) fishObject.get("fishBreedingSeason");
        System.out.println(fishBreedingSeason);

        String illegalToCatchSeason = (String) fishObject.get("illegalToCatchSeason");
        System.out.println(illegalToCatchSeason);

        Integer minimumLegalSizeToCatch = (Integer) Integer.parseInt(fishObject.get("minimumLegalSizeToCatch").toString());
        System.out.println(minimumLegalSizeToCatch);

        String description = (String) fishObject.get("description");
        System.out.println(description);

    }


    // Testing ground
    public static void main( String[] args ) {
        JSON j = new JSON();
        j.AddFishDetails();
        j.SaveToJson();
        j.ReadJSONFile();
    }

}
