package bean;

public class Risultato {
    private int id;
    private int golSegnati;
    private int squadraId;
    private int partitaId;

    public Risultato() {}

    public Risultato(int golSegnati, int squadraId, int partitaId) {
        this.golSegnati = golSegnati;
        this.squadraId = squadraId;
        this.partitaId = partitaId;
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGolSegnati() {
        return golSegnati;
    }

    public void setGolSegnati(int golSegnati) {
        this.golSegnati = golSegnati;
    }

    public int getSquadraId() {
        return squadraId;
    }

    public void setSquadraId(int squadraId) {
        this.squadraId = squadraId;
    }

    public int getPartitaId() {
        return partitaId;
    }

    public void setPartitaId(int partitaId) {
        this.partitaId = partitaId;
    }
}
