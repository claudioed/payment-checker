package tech.claudioed.paymentchecker.domain.service;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.claudioed.paymentchecker.domain.Requester;
import tech.claudioed.paymentchecker.domain.exception.RequesterNotFound;
import tech.claudioed.paymentchecker.domain.repository.RequesterRepository;
import tech.claudioed.paymentchecker.domain.resource.data.NewRequester;

/** @author claudioed on 2019-03-02. Project payment-checker */
@Slf4j
@Service
public class RequesterService {

  private final RequesterRepository requesterRepository;

  public RequesterService(RequesterRepository requesterRepository) {
    this.requesterRepository = requesterRepository;
  }

  public Requester newRequester(@NonNull NewRequester newRequester) {
    log.info("Creating new requester...");
    final Requester requester =
        this.requesterRepository.save(
            Requester.builder()
                .id(UUID.randomUUID().toString())
                .name(newRequester.getName())
                .build());
    log.info("Requester created {}", requester.getId());
    return requester;
  }

  public Requester find(@NonNull String requesterId) {
    log.info("Creating new requester...");
    final Optional<Requester> requesterOptional = this.requesterRepository.findById(requesterId);
    if (requesterOptional.isPresent()) {
      log.info("Requester {} is able to process transactions", requesterOptional.get().getId());
      return requesterOptional.get();
    }
    log.error("Requester with id {} not found", requesterId);
    throw new RequesterNotFound("Requester not found");
  }

}
