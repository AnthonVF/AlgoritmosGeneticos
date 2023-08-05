package algoritmosgeneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author ZAMBOY
 */
public class FuncionAptitud extends FitnessFunction {

    @Override
    protected double evaluate(IChromosome ic) {
        double score = 0;
        // Función X^2 + y^2
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
        // 1111 = 15
        // 15^2 = 225 Con X y con Y
        // Score = 450 - (x^2+y^2)
        score = 450 - (X * X + Y * Y);
        return score;
    }

}
