import entities.Pessoa;
import models.ConsultaRetorno;
import models.PrimeiraConsulta;
import models.Triagem;
import models.CatalogoModelos;
import roles.Medico;
import roles.Paciente;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Medico 1
        Pessoa drClebinho = new Pessoa("Clebinho Jubirildo", "111.222.333-44", LocalDate.of(1995, 5, 20), 1);
        drClebinho.addPapel(new Medico("12345-SP", "Clínico Geral"));
        // Medico 2
        Pessoa draClaudineia = new Pessoa("Claudineia Santos", "111.222.333-44", LocalDate.of(1995, 5, 20), 1);
        draClaudineia.addPapel(new Medico("12345-SP", "Cardiologista"));
        // Paciente 1
        Pessoa pacientePedrinho = new Pessoa("Pedrinho Jogador", "999.888.777-66", LocalDate.of(1980, 10, 15), 2);
        pacientePedrinho.addPapel(new Paciente("O+", "CART-9876"));
        // Paciente 2
        Pessoa pacienteMaria = new Pessoa("Maria Joaquina", "555.444.333-22", LocalDate.of(1990, 2, 10), 3);
        pacienteMaria.addPapel(new Paciente("A-", "CART-1234"));
        // Paciente 3
        Pessoa pacienteAntonella = new Pessoa("Antonella Caterine", "222.777.111-67", LocalDate.of(2009, 5, 28), 4);
        pacienteAntonella.addPapel(new Paciente("AB+", "CART-3461"));

        // Registro de modelos existentes
        CatalogoModelos catalogo = CatalogoModelos.getInstance();
        PrimeiraConsulta modeloPrimeira = new PrimeiraConsulta();
        modeloPrimeira.setTipoFicha("MODELO - Primeira Consulta");
        modeloPrimeira.setStatus("Em branco");
        catalogo.registrarModelo("PRIMEIRA_CONSULTA", modeloPrimeira);
        ConsultaRetorno modeloRetorno = new ConsultaRetorno();
        modeloRetorno.setTipoFicha("MODELO - Retorno");
        catalogo.registrarModelo("RETORNO", modeloRetorno);
        Triagem modeloTriagem = new Triagem();
        modeloTriagem.setTipoFicha("MODELO - Triagem");
        catalogo.registrarModelo("TRIAGEM", modeloTriagem);

        // =====================================================================
        System.out.println("--- TESTE 1: Criar fichas a partir do mesmo modelo ---");
        PrimeiraConsulta fichaPedrinho = (PrimeiraConsulta) catalogo.criarFicha("PRIMEIRA_CONSULTA");
        PrimeiraConsulta fichaMaria = (PrimeiraConsulta) catalogo.criarFicha("PRIMEIRA_CONSULTA");
        Triagem fichaAntonella = (Triagem) catalogo.criarFicha("TRIAGEM");
        System.out.println("Fichas criadas com sucesso.\n");


        System.out.println("--- TESTE 2: Preencher e alterar dados diferentes em cada ficha ---");
        fichaPedrinho.setPaciente(pacientePedrinho);
        fichaPedrinho.setProfissionalResponsavel(drClebinho);
        fichaPedrinho.setStatus("Em Andamento");
        fichaPedrinho.setObservacoes("Paciente chegou ansioso.");
        fichaPedrinho.registraQueixa("Dor de cabeça forte há 3 dias.");
        fichaPedrinho.registraMedicamento("Paracetamol");

        fichaMaria.setPaciente(pacienteMaria);
        fichaMaria.setProfissionalResponsavel(draClaudineia);
        fichaMaria.setStatus("Finalizada");
        fichaMaria.setObservacoes("Paciente necessita de exames.");
        fichaMaria.registraQueixa("Dor no joelho após corrida.");
        fichaMaria.registraMedicamento("Ibuprofeno");

        fichaAntonella.setPaciente(pacienteAntonella);
        fichaAntonella.setProfissionalResponsavel(drClebinho);
        fichaAntonella.setStatus("Finalizada");
        fichaAntonella.setObservacoes("Paciente estava com febre alta.");
        fichaAntonella.setTemperaturaAferida(39.1);
        fichaAntonella.registraQueixa("Dores no corpo depois de ir ao show do Harry Styles.");
        fichaAntonella.registraMedicamento("Dipirona");
        System.out.println("Dados preenchidos nas respectivas fichas.\n");


        System.out.println("--- TESTE 3: Provar isolamento das estruturas internas ---");
        System.out.println("MODELO ORIGINAL (1):");
        System.out.println("Tipo: " + modeloPrimeira.getTipoFicha());
        System.out.println("Status: " + modeloPrimeira.getStatus());
        System.out.println("Paciente: " + modeloPrimeira.getPaciente());
        System.out.println("Medico responsavel: " + modeloPrimeira.getProfissionalResponsavel());
        System.out.println("Medicamentos no Modelo: " + modeloPrimeira.getCamposPreenchimento().getMedicamentosEmUso());
        System.out.println("Queixa: " + modeloPrimeira.getQueixa());
        System.out.println("Observacoes no Modelo: " + modeloPrimeira.getObservacoes());

        System.out.println("\nMODELO ORIGINAL (2):");
        System.out.println("Tipo: " + modeloTriagem.getTipoFicha());
        System.out.println("Status: " + modeloTriagem.getStatus());
        System.out.println("Paciente: " + modeloTriagem.getPaciente());
        System.out.println("Medico Rresponsavel: " + modeloTriagem.getProfissionalResponsavel());
        System.out.println("Medicamentos no Modelo: " + modeloTriagem.getCamposPreenchimento().getMedicamentosEmUso());
        System.out.println("Temperatura aferida: " + modeloTriagem.getTemperaturaAferida());
        System.out.println("Observacoes no Modelo: " + modeloTriagem.getObservacoes());

        System.out.println("\nFICHA DO JOÃO:");
        System.out.println("Status: " + fichaPedrinho.getStatus());
        System.out.println("Paciente: " + fichaPedrinho.getPaciente().getNome());
        System.out.println("Medico responsavel: " + fichaPedrinho.getProfissionalResponsavel().getNome());
        System.out.println("Medicamentos João: " + fichaPedrinho.getCamposPreenchimento().getMedicamentosEmUso());
        System.out.println("Observacoes João: " + fichaPedrinho.getObservacoes());

        System.out.println("\nFICHA DA MARIA:");
        System.out.println("Status: " + fichaMaria.getStatus());
        System.out.println("Paciente: " + fichaMaria.getPaciente().getNome());
        System.out.println("Medico responsavel: " + fichaMaria.getProfissionalResponsavel().getNome());
        System.out.println("Medicamentos Maria: " + fichaMaria.getCamposPreenchimento().getMedicamentosEmUso());
        System.out.println("Observacoes Maria: " + fichaMaria.getObservacoes());

        System.out.println("\nFICHA DA ANTONELLA:");
        System.out.println("Status: " + fichaAntonella.getStatus());
        System.out.println("Paciente: " + fichaAntonella.getPaciente().getNome());
        System.out.println("Medico responsavel: " + fichaAntonella.getProfissionalResponsavel().getNome());
        System.out.println("Temperatura Aferida: " + fichaAntonella.getTemperaturaAferida());
        System.out.println("Medicamentos Antonella: " + fichaAntonella.getCamposPreenchimento().getMedicamentosEmUso());
        System.out.println("Observacoes Antonella: " + fichaAntonella.getObservacoes());
    }
}
