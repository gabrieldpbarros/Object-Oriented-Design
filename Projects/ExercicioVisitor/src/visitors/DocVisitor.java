package visitors;
import interfaces.IReportVisitor;
import reports.RaceResultsReport;
import reports.TrainingDeckReport;
import reports.UmaStatusReport;

public class DocVisitor implements IReportVisitor {
    public String extensionName = ".doc";

    @Override
    public void visit(RaceResultsReport r) {
        System.out.println("Convertendo resultados de corrida para " + this.extensionName);
        System.out.println("TITULO DOC: Resultados " + r.getRaceName() + " / " + r.getUmaPosition() + "º lugar");
        System.out.println("Condição climática - " + r.getClimaticCondition());
        System.out.println("Condição da pista - " + r.getTrackCondition());
    }

    @Override
    public void visit(TrainingDeckReport r) {
        System.out.println("Convertendo deck do treinador para " + this.extensionName);
        System.out.println("TITULO DOC: Dados treinador " + r.getTrainerName());

        System.out.println("---- CARTAS ----");
        for (String card : r.getCardDeck())
            System.out.println(" - " + card);

        System.out.println("---- HABILIDADES NOVAS ----");
        for (String skill : r.getSkillsObtained())
            System.out.println(" - " + skill);
    }

    @Override
    public void visit(UmaStatusReport r) {
        System.out.println("Convertendo status da umamusume para " + this.extensionName);
        System.out.println("TITULO DOC: Relatório " + r.getUmaName() + " / " + r.getFinalRank());

        System.out.println("---- STATS DA UMAMUSUME ----");
        var statsDict = r.getStats();
        statsDict.forEach( (stat, ranking) -> {
            System.out.println(stat + ": " + ranking);
        });

        System.out.println("---- APTIDÕES DA UMAMUSUME ----");
        var aptitudesDict = r.getAptitudes();
        aptitudesDict.forEach( (racing, aptitudes)  -> {
            System.out.println(racing + " aptitude:");
            aptitudes.forEach( (aptitude, ranking) -> {
                System.out.println(" - " + aptitude + ": " + ranking);
            });
        });
    }
}
