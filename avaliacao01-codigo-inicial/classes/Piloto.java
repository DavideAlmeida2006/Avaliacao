package classes;

public class Piloto extends Pessoa {
    private String breve;
    public Aeronave aeronave;

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    @Override
    public String toString() {
        String texto = " ";
        texto += "Nome: " + getNome();
        texto += " - CPF: " + getCpf();
        texto += " - Brevê: " + getBreve();
        if (aeronave != null){
            texto += getAeronave();
        }
        return texto;
    }
    
}
