/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.SoldeConverterService;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author talend
 */
@SuppressWarnings("serial")
public class SoldeConverterServiceImpl extends RemoteServiceServlet implements
        SoldeConverterService {

    /**
     * Calcul le montant final à partir du montant de départ et du pourcentage
     * @param montantDepart
     * @param pourcentage
     * @return montant final (float)
     * @throws IllegalArgumentException 
     */
    @Override
    public float CalculMontantFinal(float montantDepart, float pourcentage) throws IllegalArgumentException {
        if(FieldVerifier.isNombreDecimalCorrect(montantDepart))
            return montantDepart * (1 - (pourcentage / 100));
        return -1;
    }

    /**
     * Calcul le montant de départ à partir du montant final et du pourcentage
     * @param montantFinal
     * @param pourcentage
     * @return montant de départ (flaot)
     * @throws IllegalArgumentException 
     */
    @Override
    public float CalculMontantDepart(float montantFinal, float pourcentage) throws IllegalArgumentException {
        if(FieldVerifier.isNombreDecimalCorrect(montantFinal))
            return montantFinal / (1 - (pourcentage / 100));
        return -1;
    }

    /**
     * Calcul la différence entre le prix final et de départ pour connaitre la remise
     * @param montantDepart
     * @param montantFinal
     * @return remise (flaot)
     * @throws IllegalArgumentException 
     */
    @Override
    public float CalculRemise(float montantDepart, float montantFinal) throws IllegalArgumentException {
        return montantFinal - montantDepart;
    }

}
