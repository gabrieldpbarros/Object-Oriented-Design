package reports;
import interfaces.IReportVisitor;

abstract public class BaseReport {
    public abstract void accept(IReportVisitor visitor);
}
