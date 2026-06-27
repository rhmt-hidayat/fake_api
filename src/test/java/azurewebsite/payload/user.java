package azurewebsite.payload;
import java.util.Random;
import org.json.simple.JSONObject;

public class user {
    Random ran = new Random();

    public JSONObject createUsers() {
        JSONObject data = new JSONObject();
        data.put("id", 55);
        data.put("userName", "User" + ran.nextInt((100)));
        data.put("password", "12345");
        return data;
    }

    public JSONObject updateUsers() {
        JSONObject data = new JSONObject();
        data.put("id", 54);
        data.put("userName", "User" + ran.nextInt((100)));
        data.put("password", "56789");
        return data;
    }
}
