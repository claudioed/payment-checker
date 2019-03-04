package tech.claudioed.paymentchecker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author claudioed on 2019-03-02.
 * Project payment-checker
 */
@Data
@Document(collection = "requester")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Requester {

  @Id
  private String id;

  private String name;

}
