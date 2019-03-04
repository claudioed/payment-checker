package tech.claudioed.paymentchecker.domain.exception;

/**
 * @author claudioed on 2019-03-04.
 * Project payment-checker
 */
public class RequesterNotFound extends RuntimeException {

  public RequesterNotFound(String message) {
    super(message);
  }

}
