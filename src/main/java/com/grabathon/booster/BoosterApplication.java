package com.grabathon.booster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class BoosterApplication {

  public static void main(String[] args) {
    SpringApplication.run(BoosterApplication.class, args);
  }

  /**
   * Validation Message Source Bean.
   *
   * @return
   */
  @Bean
  public MessageSource validationMessageSource() {
    ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
    bean.setAlwaysUseMessageFormat(true);
    bean.setBasename("classpath:validation-messages");
    bean.setDefaultEncoding("UTF-8");
    return bean;
  }

  /**
   * Validator Factory Bean.
   *
   * @return
   */
  @Bean
  public LocalValidatorFactoryBean validator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(validationMessageSource());
    return bean;
  }
}
