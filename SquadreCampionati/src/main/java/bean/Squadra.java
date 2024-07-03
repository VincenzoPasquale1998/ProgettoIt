package bean;

public class Squadra {
    private int id;
    private String nome;
    private String citta;

    public Squadra() {}

    public Squadra(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
