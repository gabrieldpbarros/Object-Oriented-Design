package models;
import interfaces.IFicha;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PrimeiraConsulta extends BaseFicha {
    private String nome;
    private int id;
    private String queixa;
    private Map<LocalDate, String> historico;
    private Map<LocalDate, String> antecedentes;
    private String planoConduta;

    public PrimeiraConsulta() {}
    public PrimeiraConsulta(PrimeiraConsulta ficha) {
        super(ficha);
        this.nome = ficha.getNome();
        this.id = ficha.getId();
        this.queixa = ficha.getQueixa();
        this.planoConduta = ficha.getPlanoConduta();

        if (ficha.getHistorico() != null) this.historico = new HashMap<>(ficha.getHistorico());
        else this.historico = new HashMap<>();
        if (ficha.getAntecedentes() != null) this.antecedentes = new HashMap<>(ficha.getAntecedentes());
        else this.antecedentes = new HashMap<>();
    }

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getQueixa() { return this.queixa; }
    public void setQueixa(String queixa) { this.queixa = queixa; }
    public Map<LocalDate, String> getHistorico() { return this.historico; }
    public void setHistorico(Map<LocalDate, String> historico) { this.historico = historico; }
    public Map<LocalDate, String> getAntecedentes() { return this.antecedentes; }
    public void setAntecedentes(Map<LocalDate, String> antecedentes) { this.antecedentes = antecedentes; }
    public String getPlanoConduta() { return this.planoConduta; }
    public void setPlanoConduta(String planoConduta) { this.planoConduta = planoConduta; }

    @Override
    public IFicha clone() { return new PrimeiraConsulta(this); }
}
