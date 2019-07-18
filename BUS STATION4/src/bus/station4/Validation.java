/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station4;

import java.util.HashMap;

public class Validation {

    HashMap userDictionary;

    public Validation() {
        userDictionary = new HashMap();
        userDictionary.put("Ahmed", "1");
        userDictionary.put("Yasswe", "2");
        userDictionary.put("Ali", "3");
        userDictionary.put("Hagar", "4");
        userDictionary.put("Monier", "5");
    }

    public boolean validate(String username, String password) {

        boolean validationResult = false;
        String fetchedPassword = (String) userDictionary.get(username); // we took the object username because . why did wwe cast ?
        if ((fetchedPassword != null)) {
            validationResult = fetchedPassword.equals(password);
        }
        return validationResult;
    }

}
