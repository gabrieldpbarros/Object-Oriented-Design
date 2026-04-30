package reports;
import interfaces.IReportVisitor;
import java.util.List;

public class TrainingDeckReport extends BaseReport {
    private String trainerName;
    private List<String> cardDeck;
    private List<String> skillsObtained;

    public TrainingDeckReport(String trainerName, List<String> cardDeck, List<String> skillsObtained) {
        this.setTrainerName(trainerName);
        this.setCardDeck(cardDeck);
        this.setSkillsObtained(skillsObtained);
    }

    public String getTrainerName() {
        return this.trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public List<String> getCardDeck() {
        return this.cardDeck;
    }

    public void setCardDeck(List<String> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public List<String> getSkillsObtained() {
        return this.skillsObtained;
    }

    public void setSkillsObtained(List<String> skillsObtained) {
        this.skillsObtained = skillsObtained;
    }


    public void accept(IReportVisitor visitor) {
        visitor.visit(this);
    }
}
