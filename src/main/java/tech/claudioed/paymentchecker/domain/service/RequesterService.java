package tech.claudioed.paymentchecker.domain.service;

import java.util.UUID;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import tech.claudioed.paymentchecker.Requester;
import tech.claudioed.paymentchecker.domain.repository.RequesterRepository;
import tech.claudioed.paymentchecker.domain.resource.data.NewRequester;

/**
 * @author claudioed on 2019-03-02.
 * Project payment-checker
 */
@Service
public class RequesterService {

  private final RequesterRepository requesterRepository;

  public RequesterService(RequesterRepository requesterRepository) {
    this.requesterRepository = requesterRepository;
  }

  public Requester newRequester(@NonNull NewRequester newRequester){
    return this.requesterRepository.save(Requester.builder().id(UUID.randomUUID().toString()).name(newRequester.getName()).build());
  }

  public Requester find(@NonNull String requesterId){
    return this.requesterRepository.findById(requesterId).get();
  }

}
