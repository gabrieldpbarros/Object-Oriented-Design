package visitors;
import interfaces.IReportVisitor;
import reports.RaceResultsReport;
import reports.TrainingDeckReport;
import reports.UmaStatusReport;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class XlsVisitor implements IReportVisitor {
    public String extensionName = ".xls";

    @Override
    public void visit(RaceResultsReport r) {
        System.out.println("Convertendo Resultados de corrida para " + this.extensionName);
        System.out.println("TITULO PLANILHA: Resultados " + r.getRaceName() + " / " + r.getUmaPosition() + "º lugar");
        System.out.println("A1: Condição climática" + r.getClimaticCondition());
        System.out.println("A2: " + r.getClimaticCondition());
        System.out.println("B1: Condição da pista" + r.getTrackCondition());
        System.out.println("B2: " + r.getTrackCondition());
    }

    @Override
    public void visit(TrainingDeckReport r) {
        System.out.println("Convertendo deck do treinador para " + this.extensionName);
        System.out.println("TITULO PLANILHA: Dados treinador " + r.getTrainerName());

        System.out.println("A1: CARTAS");
        int i = 2;
        for (String card : r.getCardDeck())
            System.out.printf("A%d: %s%n", i++, card);

        System.out.println("B1: HABILIDADES NOVAS");
        i = 2;
        for (String skill : r.getSkillsObtained())
            System.out.printf("B%d: %s%n", i++, skill);
    }

    @Override
    public void visit(UmaStatusReport r) {
        System.out.println("Convertendo status da umamusume para " + this.extensionName);
        System.out.println("TITULO PLANILHA: Relatório " + r.getUmaName() + " / " + r.getFinalRank());

        System.out.println("AB1: STATS DA UMAMUSUME");
        var statsDict = r.getStats();
        AtomicInteger i = new AtomicInteger(2);
        statsDict.forEach( (stat, ranking) -> {
            System.out.printf("A%d: %s ", i.get(), stat);
            System.out.printf("B%d: %d%n", i.getAndIncrement(), ranking);
        });

        System.out.println("CDEFGH1: APTIDÕES DA UMAMUSUME");
        var aptitudesDict = r.getAptitudes();
        AtomicReference<Character> c = new AtomicReference<>('C');
        aptitudesDict.forEach( (racing, aptitudes)  -> {
            i.set(2);
            System.out.printf("%c%c%d: %s ", c.get(), c.get()+1, i.get(), racing);
            aptitudes.forEach( (aptitude, ranking) -> {
                System.out.printf("%c%d: %s ", c.get(), i.get(), aptitude);
                System.out.printf("%c%d: %c%n", c.get()+1, i.getAndIncrement(), ranking);
            });
            c.set((char) (c.get() + 2));
        });
    }
}
