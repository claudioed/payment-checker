package tech.claudioed.paymentchecker.domain.resource;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import tech.claudioed.paymentchecker.domain.Requester;
import tech.claudioed.paymentchecker.domain.resource.data.NewRequester;
import tech.claudioed.paymentchecker.domain.service.RequesterService;

/**
 * @author claudioed on 2019-03-02.
 * Project payment-checker
 */
@RestController
@RequestMapping("/api/requesters")
public class RequesterResource {

  private final RequesterService requesterService;

  public RequesterResource(RequesterService requesterService) {
    this.requesterService = requesterService;
  }

  @PostMapping
  @Timed(value = "payment.checker.new.requester.seconds")
  public ResponseEntity<Requester> newRequester(@RequestBody NewRequester request,
      UriComponentsBuilder uriBuilder){
    final Requester requester = this.requesterService.newRequester(request);
    final UriComponents uriComponents = uriBuilder.path("api/requesters/{id}").buildAndExpand(requester.getId());
    return ResponseEntity.created(uriComponents.toUri()).build();
  }

  @GetMapping("/{id}")
  @Timed(value = "payment.checker.find.requester.seconds")
  public ResponseEntity<Requester> find(@PathVariable("id") String id){
    try{
      final Requester requester = this.requesterService.find(id);
      return ResponseEntity.ok(requester);
    }catch (Exception ex){
      return ResponseEntity.notFound().build();
    }
  }

}
