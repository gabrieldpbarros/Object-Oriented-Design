import interfaces.IReportVisitor;
import reports.BaseReport;
import reports.RaceResultsReport;
import reports.TrainingDeckReport;
import reports.UmaStatusReport;
import visitors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Populando os dados do UmaStatusReport
        Map<String, Integer> stats = Map.of(
                "Speed", 1200,
                "Stamina", 1050,
                "Power", 1100,
                "Guts", 800,
                "Intelligence", 900
        );

        Map<String, Character> surfaceApt = Map.of("Turf", 'A', "Dirt", 'G');
        Map<String, Character> distApt = Map.of("Sprint", 'G', "Mile", 'C', "Medium", 'A', "Long", 'A');
        Map<String, Character> styleApt = Map.of("Front", 'G', "Pace", 'B', "Late", 'B', "End", 'A');
        Map<String, Map<String, Character>> aptitudes = Map.of(
                "Surface", surfaceApt,
                "Distance", distApt,
                "Style", styleApt
        );

        UmaStatusReport statusReport = new UmaStatusReport("Gold Ship", "UG", stats, aptitudes);

        // 2. Populando os dados do TrainingDeckReport
        List<String> deck = List.of("Kitasan Black [Speed]", "Super Creek [Stamina]", "Tazuna [Friend]");
        List<String> skills = List.of("Arc Maestro", "Long Distance Corner O", "Straight Recovery");
        TrainingDeckReport deckReport = new TrainingDeckReport("Gabriel", deck, skills);

        // 3. Populando os dados do RaceResultsReport
        RaceResultsReport raceReport = new RaceResultsReport("Arima Kinen", 1, "Snow", "Heavy");

        // 4. Criando o "Object Structure" do padrão Visitor
        List<BaseReport> relatoriosParaExportar = new ArrayList<>();
        relatoriosParaExportar.add(statusReport);
        relatoriosParaExportar.add(deckReport);
        relatoriosParaExportar.add(raceReport);

        IReportVisitor docVisitor = new DocVisitor();
        IReportVisitor htmlVisitor = new HtmlVisitor();
        IReportVisitor jsonVisitor = new JsonVisitor();
        IReportVisitor mdVisitor = new MdVisitor();
        IReportVisitor pdfVisitor = new PdfVisitor();
        IReportVisitor xlsVisitor = new XlsVisitor();
        for (BaseReport relatorio : relatoriosParaExportar) {
            relatorio.accept(docVisitor);
            relatorio.accept(htmlVisitor);
            relatorio.accept(jsonVisitor);
            relatorio.accept(mdVisitor);
            relatorio.accept(pdfVisitor);
            relatorio.accept(xlsVisitor);
        }
    }
}
