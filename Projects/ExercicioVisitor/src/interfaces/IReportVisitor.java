package interfaces;
import reports.RaceResultsReport;
import reports.TrainingDeckReport;
import reports.UmaStatusReport;

public interface IReportVisitor {
    void visit(RaceResultsReport r);
    void visit(TrainingDeckReport r);
    void visit(UmaStatusReport r);
}
