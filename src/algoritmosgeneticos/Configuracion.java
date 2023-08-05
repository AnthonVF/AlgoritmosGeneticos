package algoritmosgeneticos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author ZAMBOY
 */
public class Configuracion {

    private int cromosomaLong = 10; //Depende de la presición que se desee
    private int poblacionTamanio = 5;

    private Genotype configuracionAG() {
        Configuration configuration = new DefaultConfiguration();
        Genotype poblacion = null;
        try {
            configuration.setFitnessFunction(new FuncionAptitud());
            Gene[] ejemploGenes = new Gene[cromosomaLong];
            for (int i = 0; i < cromosomaLong; i++) {
                ejemploGenes[i] = new IntegerGene(configuration, 0, 1);
            }
            Chromosome ch = new Chromosome(configuration, ejemploGenes);
            configuration.setSampleChromosome(ch);
            configuration.setPopulationSize(poblacionTamanio);
            poblacion = Genotype.randomInitialGenotype(configuration);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return poblacion;
    }

    public void iniciarAG(int generaciones, int evoluciones) {
        Genotype poblacion = configuracionAG(); //Necesario para inicializar el algoritmo genético
        for (int i = 0; i < generaciones; i++) {
            mostrarTodos(poblacion.getChromosomes()); //Todos los individuos de la generación antes de evolucionarlos
            poblacion.evolve(evoluciones);
            IChromosome mejorIndividuoGeneracion = poblacion.getFittestChromosome();
            System.out.println("***** Mejor Individuo de la Generacion G: "+i+"*****");
            verCromosomas(mejorIndividuoGeneracion);
            System.out.println("********************************************");
        }
        IChromosome mejorIndividuoPoblacion = poblacion.getFittestChromosome();
        System.out.println("***** Mejor Individuo de la Poblacion *****");
        verCromosomas(mejorIndividuoPoblacion);
    }
    
    private void verCromosomas(IChromosome ic){
        // Ya con los cromosomas evolucionados 
        int signoX = (Integer) ic.getGene(0).getAllele(); //getAllele obtiene el objeto del gen.
        int x0 = (Integer) ic.getGene(1).getAllele();
        int x1 = (Integer) ic.getGene(2).getAllele();
        int x2 = (Integer) ic.getGene(3).getAllele();
        int x3 = (Integer) ic.getGene(4).getAllele();
        int signoY = (Integer) ic.getGene(5).getAllele();
        int y0 = (Integer) ic.getGene(6).getAllele();
        int y1 = (Integer) ic.getGene(7).getAllele();
        int y2 = (Integer) ic.getGene(8).getAllele();
        int y3 = (Integer) ic.getGene(9).getAllele();

        int X = Integer.parseInt((x0 + "" + x1 + "" + x2 + "" + x3), 2); // ¿2? Porque se trata de binarios (0,1)
        int Y = Integer.parseInt((y0 + "" + y1 + "" + y2 + "" + y3), 2);

        if (signoX == 0) {
            X = -X;
        }
        if (signoY == 0) {
            Y = -Y;
        }
        System.out.println(X+" , "+Y);
    }
    
    private void mostrarTodos(IChromosome[] ic){
        for (IChromosome iChromosome : ic) {
            verCromosomas(iChromosome);
        }
    }
}
