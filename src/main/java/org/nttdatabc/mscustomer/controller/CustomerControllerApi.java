package org.nttdatabc.mscustomer.controller;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;
import org.nttdatabc.mscustomer.api.ApiUtil;
import org.nttdatabc.mscustomer.model.AuthorizedSigner;
import org.nttdatabc.mscustomer.model.Customer;
import org.nttdatabc.mscustomer.utils.exceptions.errors.ErrorResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-26T16:52:24.401022700-05:00[America/Lima]")
@Validated
@Tag(name = "customers", description = "the customers API")
public interface CustomerControllerApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * POST /customer/authorized_signers/{customer_id} : Crea Signatarios autorizados por cliente.
   *
   * @param customerId       ID del cliente (required).
   * @param authorizedSigner (required).
   * @return Se creó el Signatario autorizado (status code 201).
   * or Error en request (status code 400).
   * or Recurso no encontrado (status code 404).
   */
  @Operation(
      operationId = "createAuthorizedSignersByCustomerId",
      summary = "Crea Signatarios autorizados por cliente",
      tags = {"customers"},
      responses = {
          @ApiResponse(responseCode = "201", description = "Se creó el Signatario autorizado"),
          @ApiResponse(responseCode = "400", description = "Error en request"),
          @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
      }
  )
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/customer/authorized_signers/{customer_id}",
      consumes = {"application/json"}
  )
  default Maybe<ResponseEntity<Object>> createAuthorizedSignersByCustomerId(
      @Parameter(name = "customer_id", description = "ID del cliente", required = true, in = ParameterIn.PATH) @PathVariable("customer_id") String customerId,
      @Parameter(name = "AuthorizedSigner", description = "", required = true) @Valid @RequestBody AuthorizedSigner authorizedSigner
  ) throws ErrorResponseException {
    return Maybe.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

  }


  /**
   * POST /customer : Crear un nuevo cliente.
   *
   * @param customer (required).
   * @return Cliente creado con éxito (status code 201).
   * or Error en Request (status code 400).
   */
  @Operation(
      operationId = "createCustomer",
      summary = "Crear un nuevo cliente",
      tags = {"customers"},
      responses = {
          @ApiResponse(responseCode = "201", description = "Cliente creado con éxito"),
          @ApiResponse(responseCode = "400", description = "Error en Request")
      }
  )
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/customer",
      consumes = {"application/json"}
  )
  default Maybe<ResponseEntity<Object>> createCustomer(
      @Parameter(name = "Customer", description = "", required = true) @Valid @RequestBody Customer customer
  ) throws ErrorResponseException {
    return Maybe.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

  }


  /**
   * DELETE /customer/{customer_id} : Eliminar un cliente.
   *
   * @param customerId ID del cliente (required).
   * @return Cliente actualizado con éxito (status code 200).
   * or Error Request (status code 400).
   * or Recurso no encontrado (status code 404).
   */
  @Operation(
      operationId = "deleteCustomerById",
      summary = "Eliminar un cliente",
      tags = {"customers"},
      responses = {
          @ApiResponse(responseCode = "200", description = "Cliente actualizado con éxito"),
          @ApiResponse(responseCode = "400", description = "Error Request"),
          @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
      }
  )
  @RequestMapping(
      method = RequestMethod.DELETE,
      value = "/customer/{customer_id}"
  )
  default Maybe<ResponseEntity<Object>> deleteCustomerById(
      @Parameter(name = "customer_id", description = "ID del cliente", required = true, in = ParameterIn.PATH) @PathVariable("customer_id") String customerId
  ) throws ErrorResponseException {
    return Maybe.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

  }


  /**
   * GET /customer : Obtener lista de todos los clientes.
   *
   * @return Lista de clientes obtenida con éxito (status code 200).
   */
  @Operation(
      operationId = "getAllCustomers",
      summary = "Obtener lista de todos los clientes",
      tags = {"customers"},
      responses = {
          @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida con éxito", content = {
              @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Customer.class)))
          })
      }
  )
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/customer",
      produces = {"application/json"}
  )
  default Observable<ResponseEntity<List<Customer>>> getAllCustomers(

  ) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "[ { \"birthday\" : \"birthday\", \"identifier\" : \"identifier\", \"authorizedSigners\" : [ { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" }, { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" } ], \"address\" : \"address\", \"phone\" : \"phone\", \"_id\" : \"_id\", \"fullname\" : \"fullname\", \"type\" : \"type\", \"email\" : \"email\" }, { \"birthday\" : \"birthday\", \"identifier\" : \"identifier\", \"authorizedSigners\" : [ { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" }, { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" } ], \"address\" : \"address\", \"phone\" : \"phone\", \"_id\" : \"_id\", \"fullname\" : \"fullname\", \"type\" : \"type\", \"email\" : \"email\" } ]";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return Observable.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

  }


  /**
   * GET /customer/authorized_signers/{customer_id} : Obtener los signatarios autorizados de un cliente.
   *
   * @param customerId ID del cliente (required).
   * @return Lista de signatarios autorizados obtenida con éxito (status code 200).
   * or Error en request (status code 400).
   * or Recurso no encontrado (status code 404).
   */
  @Operation(
      operationId = "getAuthorizedSignersByCustomerId",
      summary = "Obtener los signatarios autorizados de un cliente",
      tags = {"customers"},
      responses = {
          @ApiResponse(responseCode = "200", description = "Lista de signatarios autorizados obtenida con éxito", content = {
              @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AuthorizedSigner.class)))
          }),
          @ApiResponse(responseCode = "400", description = "Error en request"),
          @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
      }
  )
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/customer/authorized_signers/{customer_id}",
      produces = {"application/json"}
  )
  default Observable<ResponseEntity<List<AuthorizedSigner>>> getAuthorizedSignersByCustomerId(
      @Parameter(name = "customer_id", description = "ID del cliente", required = true, in = ParameterIn.PATH) @PathVariable("customer_id") String customerId
  ) throws ErrorResponseException {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "[ { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" }, { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" } ]";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return Observable.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

  }


  /**
   * GET /customer/{customer_id} : Obtener información de un cliente.
   *
   * @param customerId ID del cliente (required).
   * @return Información del cliente obtenida con éxito (status code 200).
   * or Error Request (status code 400).
   * or Recurso no encontrado (status code 404).
   */
  @Operation(
      operationId = "getCustomerById",
      summary = "Obtener información de un cliente",
      tags = {"customers"},
      responses = {
          @ApiResponse(responseCode = "200", description = "Información del cliente obtenida con éxito", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))
          }),
          @ApiResponse(responseCode = "400", description = "Error Request"),
          @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
      }
  )
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/customer/{customer_id}",
      produces = {"application/json"}
  )
  default Single<ResponseEntity<Customer>> getCustomerById(
      @Parameter(name = "customer_id", description = "ID del cliente", required = true, in = ParameterIn.PATH) @PathVariable("customer_id") String customerId
  ) throws ErrorResponseException {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"birthday\" : \"birthday\", \"identifier\" : \"identifier\", \"authorizedSigners\" : [ { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" }, { \"fullname\" : \"fullname\", \"cargo\" : \"cargo\", \"dni\" : \"dni\" } ], \"address\" : \"address\", \"phone\" : \"phone\", \"_id\" : \"_id\", \"fullname\" : \"fullname\", \"type\" : \"type\", \"email\" : \"email\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return Single.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

  }


  /**
   * PUT /customer : Actualizar un cliente.
   *
   * @param customer (required).
   * @return Cliente actualizado con éxito (status code 200).
   * or Error Request (status code 400).
   * or Recurso no encontrado (status code 404).
   */
  @Operation(
      operationId = "updateCustomer",
      summary = "Actualizar un cliente",
      tags = {"customers"},
      responses = {
          @ApiResponse(responseCode = "200", description = "Cliente actualizado con éxito"),
          @ApiResponse(responseCode = "400", description = "Error Request"),
          @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
      }
  )
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/customer",
      consumes = {"application/json"}
  )
  default Maybe<ResponseEntity<Object>> updateCustomer(
      @Parameter(name = "Customer", description = "", required = true) @Valid @RequestBody Customer customer
  ) throws ErrorResponseException {
    return Maybe.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

  }

}