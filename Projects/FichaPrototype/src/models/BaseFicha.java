package models;
import entities.InformacoesPaciente;
import entities.Pessoa;
import interfaces.IFicha;
import java.time.LocalDate;

public abstract class BaseFicha implements IFicha {
    private String tipoFicha;
    private Pessoa paciente;
    private Pessoa profissionalResponsavel;
    private String status;
    private InformacoesPaciente camposPreenchimento = new InformacoesPaciente();
    private String observacoes;
    private LocalDate dataAtendimento;

    public BaseFicha() {}
    public BaseFicha(BaseFicha ficha) {
        this.tipoFicha = ficha.tipoFicha;
        this.status = ficha.status;
        this.observacoes = ficha.observacoes;
        this.dataAtendimento = ficha.dataAtendimento;

        if (ficha.getPaciente() != null) this.paciente = new Pessoa(ficha.getPaciente());
        else this.paciente = null;
        if (ficha.getProfissionalResponsavel() != null) this.profissionalResponsavel = new Pessoa(ficha.getProfissionalResponsavel());
        else this.profissionalResponsavel = null;
        if (ficha.camposPreenchimento != null)
            this.camposPreenchimento = new InformacoesPaciente(ficha.camposPreenchimento);
    }

    public String getTipoFicha() { return this.tipoFicha; }
    public void setTipoFicha(String tipoFicha) { this.tipoFicha = tipoFicha; }
    public Pessoa getPaciente() { return this.paciente; }
    public void setPaciente(Pessoa paciente) { this.paciente = paciente; }
    public Pessoa getProfissionalResponsavel() { return this.profissionalResponsavel; }
    public void setProfissionalResponsavel(Pessoa responsavel) { this.profissionalResponsavel = responsavel; }
    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }
    public String getObservacoes() { return this.observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public LocalDate getDataAtendimento() { return this.dataAtendimento; }
    public void setDataAtendimento(LocalDate dataAtendimento) { this.dataAtendimento = dataAtendimento; }

    /*
    * Relativos ao campo de preenchimento
    * */
    public InformacoesPaciente getCamposPreenchimento() { return this.camposPreenchimento; }
    public void registraNome(String nome) { this.camposPreenchimento.setNomePaciente(nome); }
    public void registraIdade(int idade) { this.camposPreenchimento.setIdade(idade); }
    public void registraQueixa(String queixa) { this.camposPreenchimento.setQueixaPrincipal(queixa); }
    public void registraHistorico(LocalDate data, String historico) { this.camposPreenchimento.addHistorico(data, historico); }
    public void registraMedicamento(String medicamento) { this.camposPreenchimento.setMedicamentosEmUso(medicamento); }
    public void registraEvolucao(String evolucao) { this.camposPreenchimento.setEvolucao(evolucao); }
    public void registraPrioridade(int prioridade) { this.camposPreenchimento.setPrioridade(prioridade); }
    public void registraEncaminhamento(String encaminhamento) { this.camposPreenchimento.setEncaminhamento(encaminhamento); }

    @Override
    public abstract IFicha clone();
}
