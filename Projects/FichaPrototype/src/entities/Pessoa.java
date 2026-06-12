package entities;
import interfaces.IPapelClinico;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Integer id;
    private List<IPapelClinico> papeis;

    public Pessoa() {}

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.id = id;
        this.papeis = new ArrayList<>();
    }

    public Pessoa(Pessoa p) {
        this.nome = p.getNome();
        this.cpf = p.getCpf();
        this.dataNascimento = p.getDataNascimento();
        this.id = p.getId();
        if (p.getPapeis() != null) this.papeis = new ArrayList<>(p.getPapeis());
        else this.papeis = new ArrayList<>();
    }

    public void addPapel(IPapelClinico papel) { this.papeis.add(papel); }
    public boolean possuiPapel(IPapelClinico papel) {
        for (IPapelClinico p : this.papeis)
            if (papel.equals(p)) return true;
        return false;
    }

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return this.cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return this.dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public List<IPapelClinico> getPapeis() { return this.papeis; }
    public Integer getId() { return this.id; }
    public void setId(int id) { this.id = id; }
}
