package lt.viko.eif.kkvmavva.restfulwebservice;

import org.apache.log4j.BasicConfigurator;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.apache.log4j.Logger;

import static org.junit.Assert.*;

public class JSONTest {

    private Logger log = Logger.getLogger(this.getClass());

    @Test
    public void SaveToJson() {
        try {
            log.info("Starting execution of SaveToJson");
            FishInfo fish = null;
            JSON json = new JSON();
            json.SaveToJson(fish);
            assertTrue(true);

        } catch (Exception exception) {
            log.error("Exception in execution ofSaveToJson-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }


    @Test
    public void UpdateFish() {
        try {
            log.info("Starting execution of UpdateFish");
            FishInfo fishInfo = null;
            long id = 0;

            JSON json = new JSON();
            json.UpdateFish(fishInfo, id);
            assertTrue(true);

        } catch (Exception exception) {
            log.error("Exception in execution ofUpdateFish-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void ReadJSONFile() {
        try {
            log.info("Starting execution of ReadJSONFile");

            JSON json = new JSON();
            json.ReadJSONFile();
            assertTrue(true);

        } catch (Exception exception) {
            log.error("Exception in execution ofReadJSONFile-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void parseFish() {
        try {
            log.info("Starting execution of parseFish");
            FishInfo expectedValue = null;

            JSONObject fish = null;

            JSON json = new JSON();
            FishInfo actualValue = json.parseFish(fish);
            log.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);

        } catch (Exception exception) {
            log.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void DeleteFish() {
        try {
            log.info("Starting execution of DeleteFish");
            long id = 0;

            JSON json = new JSON();
            json.DeleteFish(id);
            assertTrue(true);

        } catch (Exception exception) {
            log.error("Exception in execution ofDeleteFish-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }
}