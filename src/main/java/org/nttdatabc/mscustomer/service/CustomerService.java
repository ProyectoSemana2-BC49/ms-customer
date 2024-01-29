package org.nttdatabc.mscustomer.service;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import org.nttdatabc.mscustomer.model.AuthorizedSigner;
import org.nttdatabc.mscustomer.model.Customer;
import org.nttdatabc.mscustomer.utils.exceptions.errors.ErrorResponseException;


/**
 * Interface de CustomerService.
 */
public interface CustomerService {
  Observable<List<Customer>> getAllCustomersService();

  Completable createCustomerService(Customer customer) throws ErrorResponseException;

  Single<Customer> getCustomerByIdService(String customerId) throws ErrorResponseException;

  Completable updateCustomerService(Customer customer) throws ErrorResponseException;

  Completable deleteCustomerByIdService(String customerId) throws ErrorResponseException;

  Observable<List<AuthorizedSigner>> getAuthorizedSignersByCustomerIdService(String customerId) throws ErrorResponseException;

  Completable createAuthorizedSignersByCustomerId(String customerId, AuthorizedSigner authorizedSigner) throws ErrorResponseException;
}
