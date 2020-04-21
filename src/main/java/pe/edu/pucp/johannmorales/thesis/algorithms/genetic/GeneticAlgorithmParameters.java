package pe.edu.pucp.johannmorales.thesis.algorithms.genetic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneticAlgorithmParameters {

    private Long generations;

    private Long populationSize;

    private Double ratioSurvive;

    private Double ratioRecombination;

    private Double ratioMutation;

}
