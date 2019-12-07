package com.grabathon.booster.controller;

import com.grabathon.booster.model.Merchant;
import com.grabathon.booster.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MerchantController {

    @Autowired
    private MerchantRepository merchantRepository;

    @RequestMapping(value = "/merchants", method = RequestMethod.GET)
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Merchant> getMerchants() {
        return merchantRepository.findAll();
    }
}
