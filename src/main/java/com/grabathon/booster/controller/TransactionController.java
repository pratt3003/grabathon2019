package com.grabathon.booster.controller;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grabathon.booster.dto.TransactionRequestDTO;
import com.grabathon.booster.model.Merchant;
import com.grabathon.booster.model.Transaction;
import com.grabathon.booster.model.User;
import com.grabathon.booster.repository.MerchantRepository;
import com.grabathon.booster.repository.TransactionRepository;
import com.grabathon.booster.repository.UserRepository;
import com.grabathon.booster.service.UserBadgeService;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

  private static int id = 0;

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private TransactionRepository transactionRepository;

  @Autowired
  private UserBadgeService userBadgeService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MerchantRepository merchantRepository;

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  private Transaction convertToEntity(TransactionRequestDTO transactionRequestDTO)
      throws ParseException {
    Transaction post = modelMapper().map(transactionRequestDTO, Transaction.class);

    return post;
  }

  @RequestMapping(method = RequestMethod.POST)
  @Transactional
  public Boolean postTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO)
      throws ParseException {

    //Transaction transaction = new Transaction();
    //id++;
    User user = userRepository.findOne(transactionRequestDTO.getUser_id());
    Merchant merchant = merchantRepository.findOne(transactionRequestDTO.getMerchant_id());
    //transactionRequestDTO.setId(id);
    // transactionRequestDTO.setCreated_at(new Date());
    //transactionRequestDTO.setModified_at(new Date());

    entityManager.createNativeQuery(
        "INSERT INTO transaction (id, merchant_id, user_id, amount, created_at) VALUES (?, ?, ?, " +
            "?, now())").setParameter(1, id).setParameter(2, transactionRequestDTO.getMerchant_id())
        .setParameter(3, transactionRequestDTO.getUser_id())
        .setParameter(4, transactionRequestDTO.getAmount()).executeUpdate();
    //transaction.setUser(user);
    //transaction.setMerchant(merchant);
    //entityManager.getTransaction().begin();
    //entityManager.persist(transaction);
    //entityManager.flush();
    //entityManager.getTransaction().commit();
    //transactionRepository.saveAndFlush(convertToEntity(transactionRequestDTO));
    //transactionRepository.save(convertToEntity(transactionRequestDTO));
    userBadgeService.evaluateUserBadges(user);

    return true;
  }
}
