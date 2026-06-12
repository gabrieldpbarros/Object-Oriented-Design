package models;
import interfaces.IFicha;

public class Triagem extends BaseFicha {
    private String nomePaciente;
    private int id;
    private int idade;
    private double temperaturaAferida;
    private double pressaoAferida;

    public Triagem() {}
    public Triagem(Triagem ficha) {
        super(ficha);
        this.setNomePaciente(ficha.getNomePaciente());
        this.setId(ficha.getId());
        this.setIdade(ficha.getIdade());
        this.setTemperaturaAferida(ficha.getTemperaturaAferida());
        this.setPressaoAferida(ficha.getPressaoAferida());
    }

    public String getNomePaciente() { return this.nomePaciente; }
    public void setNomePaciente(String nomePaciente) { this.nomePaciente = nomePaciente; }
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public int getIdade() { return this.idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public double getTemperaturaAferida() { return this.temperaturaAferida; }
    public void setTemperaturaAferida(double temperaturaAferida) {  this.temperaturaAferida = temperaturaAferida; }
    public double getPressaoAferida() { return this.pressaoAferida; }
    public void setPressaoAferida(double pressaoAferida)  {  this.pressaoAferida = pressaoAferida; }

    @Override
    public IFicha clone() { return new Triagem(this); }
}
