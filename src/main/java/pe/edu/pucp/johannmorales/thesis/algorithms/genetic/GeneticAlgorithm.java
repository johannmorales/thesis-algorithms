package pe.edu.pucp.johannmorales.thesis.algorithms.genetic;

import pe.edu.pucp.johannmorales.thesis.algorithms.common.Algorithm;
import pe.edu.pucp.johannmorales.thesis.algorithms.genetic.model.Chromosome;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GeneticAlgorithm implements Algorithm<GeneticAlgorithmParameters, Chromosome> {

    List<Chromosome> population;

    public Chromosome run(GeneticAlgorithmParameters parameters) {
        Long amountSurvivors = Math.round(parameters.getPopulationSize() * parameters.getRatioSurvive());
        Long amountCrossover = Math.round(parameters.getPopulationSize() * parameters.getRatioRecombination());
        Long amountMutations = Math.round(parameters.getPopulationSize() * parameters.getRatioMutation());

        population = initializePopulation(parameters.getPopulationSize());
        population.sort(Comparator.comparing(Chromosome::getFitness));

        for (int i = 0; i < parameters.getGenerations(); i++) {
            population = population.subList(0, amountSurvivors.intValue());
            population.addAll(crossover(population, amountCrossover));
            population.addAll(mutation(population, amountMutations));
            population.sort(Comparator.comparing(Chromosome::getFitness));
            population = population.subList(0, parameters.getPopulationSize().intValue());
        }

        return population.get(0);
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
