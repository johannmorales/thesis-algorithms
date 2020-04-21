package pe.edu.pucp.johannmorales.thesis.algorithms.genetic;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import pe.edu.pucp.johannmorales.thesis.algorithms.common.AlgorithmPartialResult;
import pe.edu.pucp.johannmorales.thesis.algorithms.genetic.model.Chromosome;

public class GeneticAlgorithm {

  List<Chromosome> population;

  public List<AlgorithmPartialResult> run(GeneticAlgorithmParameters parameters) {
    LinkedList<AlgorithmPartialResult> results = new LinkedList<>();
    Long amountSurvivors = Math
        .round(parameters.getPopulationSize() * parameters.getRatioSurvive());
    Long amountCrossover = Math
        .round(parameters.getPopulationSize() * parameters.getRatioRecombination());
    Long amountMutations = Math
        .round(parameters.getPopulationSize() * parameters.getRatioMutation());

    Long initialTime = System.currentTimeMillis();
    population = initializePopulation(parameters.getPopulationSize());
    population.sort(Comparator.comparing(Chromosome::getFitness));

    for (int i = 0; i < parameters.getGenerations(); i++) {
      population = population.subList(0, amountSurvivors.intValue());
      population.addAll(crossover(population, amountCrossover));
      population.addAll(mutation(population, amountMutations));
      population.sort(Comparator.comparing(Chromosome::getFitness));
      population = population.subList(0, parameters.getPopulationSize().intValue());

      AlgorithmPartialResult partialResult = AlgorithmPartialResult.builder()
          .executionTime(System.currentTimeMillis() - initialTime)
          .fitness(population.get(0).getFitness())
          .individual(population.get(0))
          .iteration(i)
          .build();

      results.add(partialResult);
    }

    return results;
  }

  private Collection<? extends Chromosome> mutation(List<Chromosome> population, Long amount) {
    throw new UnsupportedOperationException();
  }

  private Collection<? extends Chromosome> crossover(List<Chromosome> population, Long amount) {
    throw new UnsupportedOperationException();
  }

  private List<Chromosome> initializePopulation(Long populationSize) {
    throw new UnsupportedOperationException();
  }


}
