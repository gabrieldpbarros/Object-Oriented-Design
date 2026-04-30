package visitors;
import interfaces.IReportVisitor;
import reports.RaceResultsReport;
import reports.TrainingDeckReport;
import reports.UmaStatusReport;

public class HtmlVisitor implements IReportVisitor {
    public String extensionName = ".html";

    @Override
    public void visit(RaceResultsReport r) {
        System.out.println("Convertendo Resultados de corrida para " + this.extensionName);
        System.out.println("<h1>Resultados " + r.getRaceName() + " / " + r.getUmaPosition() + "º lugar</h1>");
        System.out.println("<h2>Condição climática</h2>");
        System.out.println("<p>" + r.getClimaticCondition() + "</p>");
        System.out.println("<h2>Condição da pista<h2>");
        System.out.println("<p>" + r.getTrackCondition() + "</p>");
    }

    @Override
    public void visit(TrainingDeckReport r) {
        System.out.println("Convertendo deck do treinador para " + this.extensionName);
        System.out.println("<h1>Dados treinador " + r.getTrainerName() + "<h1>");

        System.out.println("<h3>CARTAS<h3>");
        System.out.println("<ul>");
        for (String card : r.getCardDeck())
            System.out.println("<li>" + card + "</li>");
        System.out.println("</ul>");

        System.out.println("<h3>HABILIDADES NOVAS<h3>");
        System.out.println("<ul>");
        for (String skill : r.getSkillsObtained())
            System.out.println("<li>" + skill + "</li>");
        System.out.println("</ul>");
    }

    @Override
    public void visit(UmaStatusReport r) {
        System.out.println("Convertendo status da umamusume para " + this.extensionName);
        System.out.println("<h1>Relatório " + r.getUmaName() + "</h1>");
        System.out.println("<h2>Rank: " + r.getFinalRank() + "</h2>" );

        System.out.println("<h3>STATS DA UMAMUSUME</h3>");
        System.out.println("<ul>");
        var statsDict = r.getStats();
        statsDict.forEach( (stat, ranking) -> {
            System.out.println("<li>" + stat + ": " + ranking + "</li>");
        });
        System.out.println("</ul>");

        System.out.println("<h3>APTIDÕES DA UMAMUSUME</h3>");
        System.out.println("<ol>");
        var aptitudesDict = r.getAptitudes();
        aptitudesDict.forEach( (racing, aptitudes)  -> {
            System.out.println("<li>" + racing + " aptitude:<li>");
            System.out.println("<ul>");
            aptitudes.forEach( (aptitude, ranking) -> {
                System.out.println("<li>" + aptitude + ": " + ranking + "</li>");
            });
            System.out.println("</ul>");
        });
        System.out.println("</ol>");
    }
}
