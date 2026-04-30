package reports;
import interfaces.IReportVisitor;
import java.util.Map;

public class UmaStatusReport extends BaseReport {
    private String umaName;
    private String finalRank;
    private Map<String, Integer> stats;
    private Map<String, Map<String, Character>> aptitudes;

    public UmaStatusReport(String umaName, String finalRank, Map<String, Integer> stats, Map<String, Map<String, Character>> aptitudes) {
        this.setUmaName(umaName);
        this.setFinalRank(finalRank);
        this.setStats(stats);
        this.setAptitudes(aptitudes);
    }

    public String getUmaName() {
        return this.umaName;
    }

    public void setUmaName(String umaName) {
        this.umaName = umaName;
    }

    public String getFinalRank() {
        return this.finalRank;
    }

    public void setFinalRank(String finalRank) {
        this.finalRank = finalRank;
    }

    public Map<String, Integer> getStats() {
        return this.stats;
    }

    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }

    public Map<String, Map<String, Character>> getAptitudes() {
        return this.aptitudes;
    }

    public void setAptitudes(Map<String, Map<String, Character>> aptitudes) {
        this.aptitudes = aptitudes;
    }

    public void accept(IReportVisitor visitor) {
        visitor.visit(this);
    }
}
