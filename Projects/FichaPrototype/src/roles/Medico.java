package roles;
import interfaces.IPapelClinico;

public class Medico implements IPapelClinico {
    private String crm;
    private String especialidade;

    public Medico(String crm, String especialidade) {
        this.crm = crm;
        this.especialidade = especialidade;
    }

    @Override
    public String getIdentificadorPapel() {
        return "CRM: " + this.getCrm();
    }

    public String getCrm() { return this.crm; }
    public void setCrm(String crm) { this.crm = crm; }
    public String getEspecialidade() { return this.especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}
