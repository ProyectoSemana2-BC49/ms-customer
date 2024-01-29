package org.nttdatabc.mscustomer.controller;

import static org.nttdatabc.mscustomer.utils.Constantes.PREFIX_PATH;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.nttdatabc.mscustomer.model.AuthorizedSigner;
import org.nttdatabc.mscustomer.model.Customer;
import org.nttdatabc.mscustomer.service.CustomerServiceImpl;
import org.nttdatabc.mscustomer.utils.exceptions.errors.ErrorResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller del Customer.
 */
@RestController
@Slf4j
@RequestMapping(PREFIX_PATH)
public class CustomerController implements CustomerControllerApi {

  @Autowired
  private CustomerServiceImpl customerServiceImpl;

  @Override
  public Maybe<ResponseEntity<Object>> createCustomer(Customer customer) throws ErrorResponseException {
    return customerServiceImpl.createCustomerService(customer)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(disposable -> log.debug("createCustomer:: init"))
        .andThen(Maybe.just(ResponseEntity.status(HttpStatus.CREATED).build()))
        .doOnSuccess(response -> log.info("createCustomer:: completed"));
  }

  @Override
  public Observable<ResponseEntity<List<Customer>>> getAllCustomers() {
    return customerServiceImpl.getAllCustomersService()
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(disposable -> log.debug("getAllCustomers:: init"))
        .doOnComplete(() -> log.info("getAllCustomers: completed"))
        .map(ResponseEntity::ok);
  }

  //
  @Override
  public Single<ResponseEntity<Customer>> getCustomerById(String customerId) throws ErrorResponseException {
    return customerServiceImpl.getCustomerByIdService(customerId)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(disposable -> log.debug("getCustomerById:: init"))
        .map(ResponseEntity::ok)
        .doOnSuccess(cus -> log.debug("getCustomerById:: completed"));
  }


  @Override
  public Maybe<ResponseEntity<Object>> updateCustomer(Customer customer) throws ErrorResponseException {
    return customerServiceImpl.updateCustomerService(customer)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(disposable -> log.debug("updateCustomer:: init"))
        .andThen(Maybe.just(ResponseEntity.status(HttpStatus.OK).build()))
        .doOnSuccess(response -> log.info("updateCustomer:: completed"));
  }

  @Override
  public Maybe<ResponseEntity<Object>> deleteCustomerById(String customerId) throws ErrorResponseException {
    return customerServiceImpl.deleteCustomerByIdService(customerId)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(disposable -> log.info("deleteCustomerById:: init"))
        .andThen(Maybe.just(ResponseEntity.status(HttpStatus.OK).build()))
        .doOnSuccess(objectResponseEntity -> log.info("deleteCustomerById:: completed"));
  }

  @Override
  public Observable<ResponseEntity<List<AuthorizedSigner>>> getAuthorizedSignersByCustomerId(String customerId) throws ErrorResponseException {
    return customerServiceImpl.getAuthorizedSignersByCustomerIdService(customerId)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(disposable -> log.info("getAuthorizedSignersByCustomerId:: init"))
        .doOnComplete(() -> log.info("getAuthorizedSignersByCustomerId:: completed"))
        .map(authorizedSigners -> ResponseEntity.ok().body(authorizedSigners));
  }

  @Override
  public Maybe<ResponseEntity<Object>> createAuthorizedSignersByCustomerId(String customerId, AuthorizedSigner auth) throws ErrorResponseException {
    return customerServiceImpl.createAuthorizedSignersByCustomerId(customerId, auth)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(disposable -> log.info("createAuthorizedSignersByCustomerId:: init"))
        .andThen(Maybe.just(ResponseEntity.status(HttpStatus.CREATED).build()))
        .doOnSuccess(objectResponseEntity -> log.info("createAuthorizedSignersByCustomerId:: completed"));
  }
}
