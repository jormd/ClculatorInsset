package org.insset.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

    /**
     * Verifies that the specified name is valid for our service.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty())) {
            return false;
        }
        return true;
    }

    /**
     * Verifies that the specified value is valide.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidDecimal(Integer nbr) {
        return true;
    }

    public static boolean isValidRoman(String nbr) {
        
        if(nbr.isEmpty() || (nbr == null)){
            return false;
        }
        
        nbr = nbr.toUpperCase();
        Map<String, Integer> arab = new HashMap<>();
        
        //insertion des différent cas possible avec leur valeur
       arab.put("M", 0);
       arab.put("D", 0);
       arab.put("C", 0);
       arab.put("L", 0);
       arab.put("X", 0);
       arab.put("V", 0);
       arab.put("I", 0);
       arab.put("CM", 0);
       arab.put("CD", 0);
       arab.put("XC", 0);
       arab.put("XL", 0);
       arab.put("IX", 0);
       arab.put("IV", 0);
        //Implement your code
         
                 
        int sizeNbr = nbr.length();      
        boolean stop = false;
        int i = 0;
        
        

        //boucle sur le nombre de caractère
        while(i<sizeNbr && !stop){
            
            if(i+1<sizeNbr){
                if(arab.containsKey(nbr.substring(i, i+2))){
                    arab.put(nbr.substring(i, i+2), arab.get(nbr.substring(i, i+2)).intValue() + 1);
                    i +=2;
                }
                else if(!arab.containsKey(nbr.substring(i, i+1))){
                    stop = true;
                    break;
                }
                else{
                    arab.put(nbr.substring(i, i+1), arab.get(nbr.substring(i, i+1)).intValue() + 1);
                    i++;
                } 
            }
            else{
                if(!arab.containsKey(nbr.substring(i, i+1))){
                    stop = true;
                    break;
                }
                else{
                    arab.put(nbr.substring(i, i+1), arab.get(nbr.substring(i, i+1)).intValue() + 1);
                    i++;
                }
            }
            
           

            
        }

        if(stop || arab.get("M")>1 || arab.get("D")>1 || arab.get("C")>3 || arab.get("L")>1 || arab.get("X")>3 || arab.get("V")>1 || arab.get("I")>3){
            return false;
        }
       
        return true;
    }

    public static boolean isValidDate(String date) {
        //Implement your code
        return true;
    }
}
