package models;
import interfaces.IFicha;

public class ConsultaRetorno extends BaseFicha {
    private String evolucaoUltimaConsulta;
    private int taxaAdesaoTratamento;
    private String ajusteConduta;

    public ConsultaRetorno() {}
    public ConsultaRetorno(ConsultaRetorno ficha) {
        super(ficha);
        this.setEvolucaoUltimaConsulta(ficha.getEvolucaoUltimaConsulta());
        this.setTaxaAdesaoTratamento(ficha.getTaxaAdesaoTratamento());
        this.setAjusteConduta(ficha.getAjusteConduta());
    }

    public String getEvolucaoUltimaConsulta() { return this.evolucaoUltimaConsulta; }
    public void setEvolucaoUltimaConsulta(String evolucaoUltimaConsulta) { this.evolucaoUltimaConsulta = evolucaoUltimaConsulta; }
    public int getTaxaAdesaoTratamento() { return this.taxaAdesaoTratamento; }
    public void setTaxaAdesaoTratamento(int taxaAdesaoTratamento) { this.taxaAdesaoTratamento = taxaAdesaoTratamento; }
    public String getAjusteConduta() { return this.ajusteConduta; }
    public void setAjusteConduta(String ajusteConduta)  { this.ajusteConduta = ajusteConduta; }

    @Override
    public IFicha clone() {
        return new ConsultaRetorno(this);
    }
}
