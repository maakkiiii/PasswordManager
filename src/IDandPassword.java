import java.util.HashMap;

public class IDandPassword {
    HashMap<String, String> loginInfo = new HashMap<>();

    IDandPassword(){
        loginInfo.put("Mateja", "noiceness");
        loginInfo.put("Mark", "njeri");
        loginInfo.put("Poseidon", "fisch");
    }

    protected HashMap<String, String> getLoginInfo(){
        return loginInfo;
    }
}
