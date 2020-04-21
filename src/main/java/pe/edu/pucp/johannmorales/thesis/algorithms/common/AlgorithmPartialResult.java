package pe.edu.pucp.johannmorales.thesis.algorithms.common;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlgorithmPartialResult {

  private Individual individual;

  private Integer iteration;

  private Long executionTime;

  private BigDecimal fitness;

}
