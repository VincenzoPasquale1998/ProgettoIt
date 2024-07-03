package bean;

import java.sql.Date;

public class Partita {
    private int id;
    private Date data;
    private String luogo;

    public Partita() {}

    public Partita(Date data, String luogo) {
        this.data = data;
        this.luogo = luogo;
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }
}
