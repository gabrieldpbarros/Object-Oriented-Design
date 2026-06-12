package roles;
import interfaces.IPapelClinico;

public class Paciente implements IPapelClinico {
    private String tipoSanguineo;
    private String numeroCarteirinha;

    public Paciente(String tipoSanguineo, String numeroCarteirinha) {
        this.tipoSanguineo = tipoSanguineo;
        this.numeroCarteirinha = numeroCarteirinha;
    }

    @Override
    public String getIdentificadorPapel() {
        return "Carteirinha: " + this.getNumeroCarteirinha();
    }

    public String getTipoSanguineo() { return this.tipoSanguineo; }
    public void setTipoSanguineo(String tipoSanguineo) { this.tipoSanguineo = tipoSanguineo; }
    public String getNumeroCarteirinha() { return this.numeroCarteirinha; }
    public void setNumeroCarteirinha(String carteirinha) { this.numeroCarteirinha = carteirinha; }
}
