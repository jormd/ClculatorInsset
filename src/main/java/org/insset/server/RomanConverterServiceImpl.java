/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import org.insset.client.service.RomanConverterService;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    /**
     * Méthode permettant de passer de roman en Arabe 
     *
     * @param nbr chaine de caractère en chiffre romain
     * @return integer Valeur en arabe du param passer
     * @throws IllegalArgumentException 
     */
    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        
        if(FieldVerifier.isValidRoman(nbr)){
            
        
            nbr = nbr.toUpperCase();
            Map<String, Integer> arab = new HashMap<>();

            //insertion des différent cas possible avec leur valeur
           arab.put("M", 1000);
           arab.put("CM", 900);
           arab.put("D", 500);
           arab.put("CD", 400);
           arab.put("C", 100);
           arab.put("XC", 90);
           arab.put("L", 50);
           arab.put("XL", 40);
           arab.put("X", 10);
           arab.put("IX", 9);
           arab.put("V", 5);
           arab.put("IV", 4);
           arab.put("I", 1);

           int sizeNbr = nbr.length();
           

           int res = 0;

           //boucle sur le nombre de caractère
           for(int i = 0; i < sizeNbr; i++){ 
               int val = 0;

               if(i+1<sizeNbr){

                   //regarde si il existe bien un couple de valeur, si oui on l'ajout
                   if(arab.get(nbr.substring(i, i+2)) != null){
                      val = arab.get(nbr.substring(i, i+2));
                      i++;
                   }
               }

               if(val == 0){
                   if(arab.get(nbr.substring(i, i+1)) != null){
                       res += arab.get(nbr.substring(i, i+1));
                   }

               }
               else{
                   res += val;
               }
           }


            return res;
        }
        else{
            throw new IllegalArgumentException("Veuillez rentrer une valeur valide");
        }
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        
        if(nbr != (int)nbr) {
            throw new IllegalArgumentException("Veuillez entrer un nombre entier");
        }
        if(nbr<=0 || nbr>=2000){
            throw new IllegalArgumentException("Veuillez entrer un nombre valide: entre [1-2000] et positif");
        }
        
        TreeMap<Integer, String> roman = new TreeMap<>();

        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        String res = "";
        for (int i = nbr; i > 0; i=i) {
            int l =  roman.floorKey(i);
            res += roman.get(l);
            i = i - l;
        }
        return res;
            
    }
}
    
    
    
