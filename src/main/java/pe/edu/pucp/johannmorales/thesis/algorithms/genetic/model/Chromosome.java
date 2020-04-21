package pe.edu.pucp.johannmorales.thesis.algorithms.genetic.model;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.johannmorales.thesis.algorithms.common.Individual;
import pe.edu.pucp.johannmorales.thesis.algorithms.genetic.structures.BitArray;

@Getter
@Setter
public class Chromosome extends Individual {

  private BitArray bitArray;

}
