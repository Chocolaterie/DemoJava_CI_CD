package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BankService {

    /**
     * RG-11515
     * @param amount Le montant à prélever
     * @return
     */
    public ServiceResponseDTO<Float> debit(float amount){
        // 2300 €
        // CAS : Erreur 789
        if (amount > 2300){
            return ServiceResponseDTO.buildResponse("789", "Solde insuffisant");
        }

        // CAS : Succès 207
        return ServiceResponseDTO.buildResponseWithData("207", "Prélèvement effectué avec succès", 2300-amount);
    }


    public ServiceResponseDTO<Float> credit(float amount){
        // 2300 €
        // CAS : Erreur 709
        if (amount < 1){
            return ServiceResponseDTO.buildResponse("709", "Le montant doit être positive");
        }

        // CAS : Succès 201
        return ServiceResponseDTO.buildResponseWithData("201", "Solde approvisionné", amount);
    }
}
