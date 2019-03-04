package tech.claudioed.paymentchecker.domain.repository;

import org.springframework.data.repository.CrudRepository;
import tech.claudioed.paymentchecker.domain.Requester;

/** @author claudioed on 2019-03-02. Project payment-checker */
public interface RequesterRepository extends CrudRepository<Requester, String> {}
