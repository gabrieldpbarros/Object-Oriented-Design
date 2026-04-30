package visitors;
import interfaces.IReportVisitor;
import reports.RaceResultsReport;
import reports.TrainingDeckReport;
import reports.UmaStatusReport;

public class JsonVisitor implements IReportVisitor {
    public String extensionName = ".json";

    @Override
    public void visit(RaceResultsReport r) {
        System.out.println("Convertendo Resultados de corrida para " + this.extensionName);
        System.out.println("[");
        System.out.println("{");
        System.out.println("'resultados': '" + r.getRaceName() + "',");
        System.out.println("'posicao': " + r.getUmaPosition() + ",");
        System.out.println("'condicao_climatica': '" + r.getClimaticCondition() + "',");
        System.out.println("'condicao_pista': '" +  r.getTrackCondition() + "'");
        System.out.println("}");
        System.out.println("]");
    }

    @Override
    public void visit(TrainingDeckReport r) {
        System.out.println("Convertendo deck do treinador para " + this.extensionName);
        System.out.println("[");
        System.out.println("{");
        System.out.println("'treinador': '" + r.getTrainerName() + "',");

        System.out.println("'cartas': [");
        for (String card : r.getCardDeck())
            System.out.println("'" + card + "',");
        System.out.println("],");

        System.out.println("'habilidades_novas': [");
        for (String skill : r.getSkillsObtained())
            System.out.println("'" + skill + "',");
        System.out.println("]");

        System.out.println("}");
        System.out.println("]");
    }

    @Override
    public void visit(UmaStatusReport r) {
        System.out.println("Convertendo status da umamusume para " + this.extensionName);
        System.out.println("[");
        System.out.println("{");
        System.out.println("'nome_uma': '" + r.getUmaName() + "',");
        System.out.println("'rank': '" + r.getFinalRank() + "'," );

        System.out.println("stats: {");
        var statsDict = r.getStats();
        statsDict.forEach( (stat, ranking) -> {
            System.out.println("'" + stat + "': '" + ranking + "',");
        });
        System.out.println("},");

        System.out.println("'aptidoes': {");
        var aptitudesDict = r.getAptitudes();
        aptitudesDict.forEach( (racing, aptitudes)  -> {
            System.out.println("'" + racing + "': {");
            aptitudes.forEach( (aptitude, ranking) -> {
                System.out.println("'" + aptitude + "': '" + ranking + "',");
            });
            System.out.println("},");
        });
        System.out.println("}");

        System.out.println("}");
        System.out.println("]");
    }
}
