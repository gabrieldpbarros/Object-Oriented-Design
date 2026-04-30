package reports;
import interfaces.IReportVisitor;

public class RaceResultsReport extends BaseReport {
    private String raceName;
    private int umaPosition;
    private String climaticCondition;
    private String trackCondition;

    public RaceResultsReport(String raceName, int umaPosition, String climaticCondition, String trackCondition) {
        this.setRaceName(raceName);
        this.setUmaPosition(umaPosition);
        this.setClimaticCondition(climaticCondition);
        this.setTrackCondition(trackCondition);
    }

    public String getRaceName() {
        return this.raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getUmaPosition() {
        return this.umaPosition;
    }

    public void setUmaPosition(int umaPosition) {
        this.umaPosition = umaPosition;
    }

    public String getClimaticCondition() {
        return this.climaticCondition;
    }

    public void setClimaticCondition(String climaticCondition) {
        this.climaticCondition = climaticCondition;
    }

    public String getTrackCondition() {
        return this.trackCondition;
    }

    public void setTrackCondition(String trackCondition) {
        this.trackCondition = trackCondition;
    }

    public void accept(IReportVisitor visitor) {
        visitor.visit(this);

    }
}
