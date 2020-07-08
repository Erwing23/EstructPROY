/*
 * REPRESENTA EL PROCESO DEL JUEGO EN SI , EL NUMERO DE SILLAS , PARTICIPANTES ETC.
 */
package entities;

/**
 *
 * @author PITA ESTRELLA JORGE
 */
public class Game {

    private int numCompetitor;
    private int numChairs;

    public Game(int numCompetitor) {
        this.numCompetitor = numCompetitor;
        this.numChairs = numCompetitor - 1;
    }

    /**
     * @return the numCompetitor
     */
    public int getNumCompetitor() {
        return numCompetitor;
    }

    /**
     * @param numCompetitor the numCompetitor to set
     */
    public void setNumCompetitor(int numCompetitor) {
        this.numCompetitor = numCompetitor;
    }

    /**
     * @return the numChairs
     */
    public int getNumChairs() {
        return numChairs;
    }

    /**
     * @param numChairs the numChairs to set
     */
    public void setNumChairs(int numChairs) {
        this.numChairs = numChairs;
    }

}
