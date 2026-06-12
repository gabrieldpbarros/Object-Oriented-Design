package entities;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class InformacoesPaciente {
    private String nomePaciente;
    private int idade;
    private String queixaPrincipal;
    private Map<LocalDate, String> historico;
    private String medicamentosEmUso;
    private String evolucao;
    private int prioridade;
    private String encaminhamento;

    public InformacoesPaciente() { this.historico = new HashMap<>(); }
    public InformacoesPaciente(InformacoesPaciente informacoesPaciente) {
        this.nomePaciente = informacoesPaciente.nomePaciente;
        this.idade = informacoesPaciente.idade;
        this.queixaPrincipal = informacoesPaciente.queixaPrincipal;
        this.medicamentosEmUso = informacoesPaciente.medicamentosEmUso;
        this.evolucao = informacoesPaciente.evolucao;
        this.prioridade = informacoesPaciente.prioridade;
        this.encaminhamento = informacoesPaciente.encaminhamento;

        if (informacoesPaciente.historico != null) this.historico = new HashMap<>(informacoesPaciente.historico);
        else this.historico = new HashMap<>();
    }

    public String getNomePaciente() { return this.nomePaciente; }
    public void setNomePaciente(String nomePaciente) { this.nomePaciente = nomePaciente; }
    public int getIdade() { return this.idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getQueixaPrincipal() { return this.queixaPrincipal; }
    public void setQueixaPrincipal(String queixaPrincipal) { this.queixaPrincipal = queixaPrincipal; }
    public Map<LocalDate, String> getHistorico() { return this.historico; }
    public void addHistorico(LocalDate data, String historico) { this.historico.put(data, historico); }
    public String getMedicamentosEmUso() { return this.medicamentosEmUso; }
    public void setMedicamentosEmUso(String medicamentosEmUso) { this.medicamentosEmUso = medicamentosEmUso; }
    public String getEvolucao() { return this.evolucao; }
    public void setEvolucao(String evolucao) { this.evolucao = evolucao; }
    public int getPrioridade() { return this.prioridade; }
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }
    public String getEncaminhamento() { return this.encaminhamento; }
    public void setEncaminhamento(String encaminhamento) { this.encaminhamento = encaminhamento; }
}
