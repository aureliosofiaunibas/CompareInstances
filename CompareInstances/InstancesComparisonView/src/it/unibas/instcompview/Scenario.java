package it.unibas.instcompview;

import bart.comparison.InstanceMatchTask;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.Objects;
import speedy.SpeedyConstants;
import speedy.model.database.IDatabase;

/**
 *
 * @author aurelio.sofia
 */
public class Scenario implements Comparable<Scenario>{
    
    private String scenario;
    
    private DBinfo leftDBRetrieveInfo = new DBinfo();
    private DBinfo rightDBRetrieveInfo = new DBinfo();
    
    private IDatabase leftDB;
    private IDatabase rightDB;
    
    private String dbType;
    private String strategy;
    private boolean twoWayValueMapping;
    private boolean functional;
    private boolean injective;
    private boolean stopIfNonMatchingTuples;
    private double K;
    private double bestScoreThreshold;
    private boolean convertSkolemInHash;
    private boolean forceExaustiveSearch;
    
    private InstanceMatchTask result;
    
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Scenario() {
    }
    
    public Scenario(String name, String dbType, String strategy) {
        this.scenario = name;
        this.dbType = dbType;
        this.strategy = strategy;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.pcs.firePropertyChange("scenario", this.scenario, scenario);
        this.scenario = scenario;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.pcs.firePropertyChange("strategy", this.strategy, strategy);
        this.strategy = strategy;
    }

    public boolean isTwoWayValueMapping() {
        return twoWayValueMapping;
    }

    public void setTwoWayValueMapping(boolean twoWayValueMapping) {
        this.pcs.firePropertyChange("twoWayValueMapping", this.twoWayValueMapping, twoWayValueMapping);
        this.twoWayValueMapping = twoWayValueMapping;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.pcs.firePropertyChange("functional", this.functional, functional);
        this.functional = functional;
    }

    public boolean isInjective() {
        return injective;
    }

    public void setInjective(boolean injective) {
        this.pcs.firePropertyChange("injective", this.injective, injective);
        this.injective = injective;
    }

    public boolean isStopIfNonMatchingTuples() {
        return stopIfNonMatchingTuples;
    }

    public void setStopIfNonMatchingTuples(boolean stopIfNonMatchingTuples) {
        this.pcs.firePropertyChange("stopIfNonMatchingTuples", this.stopIfNonMatchingTuples, stopIfNonMatchingTuples);
        this.stopIfNonMatchingTuples = stopIfNonMatchingTuples;
    }

    public double getK() {
        return K;
    }

    public void setK(double K) {
        this.K = K;
    }

    public double getBestScoreThreshold() {
        return bestScoreThreshold;
    }

    public void setBestScoreThreshold(double bestScoreThreshold) {
        this.pcs.firePropertyChange("bestScoreThreshold", this.bestScoreThreshold, bestScoreThreshold);
        this.bestScoreThreshold = bestScoreThreshold;
    }

    public boolean isConvertSkolemInHash() {
        return convertSkolemInHash;
    }

    public void setConvertSkolemInHash(boolean convertSkolemInHash) {
        this.pcs.firePropertyChange("convertSkolemInHash", this.convertSkolemInHash, convertSkolemInHash);
        this.convertSkolemInHash = convertSkolemInHash;
    }

    public boolean isForceExaustiveSearch() {
        return forceExaustiveSearch;
    }

    public void setForceExaustiveSearch(boolean forceExaustiveSearch) {
        this.pcs.firePropertyChange("forceExaustiveSearch", this.forceExaustiveSearch, forceExaustiveSearch);
        this.forceExaustiveSearch = forceExaustiveSearch;
    }

    public DBinfo getLeftDBRetrieveInfo() {
        return leftDBRetrieveInfo;
    }

    public void setLeftDBRetrieveInfo(DBinfo leftDBRetrieveInfo) {
        this.leftDBRetrieveInfo = leftDBRetrieveInfo;
    }

    public DBinfo getRightDBRetrieveInfo() {
        return rightDBRetrieveInfo;
    }

    public void setRightDBRetrieveInfo(DBinfo rightDBRetrieveInfo) {
        this.rightDBRetrieveInfo = rightDBRetrieveInfo;
    }

    public IDatabase getLeftDB() {
        return leftDB;
    }

    public void setLeftDB(IDatabase leftDB) {
        this.leftDB = leftDB;
    }

    public IDatabase getRightDB() {
        return rightDB;
    }

    public void setRightDB(IDatabase rightDB) {
        this.rightDB = rightDB;
    }

    public InstanceMatchTask getResult() {
        return result;
    }

    public void setResult(InstanceMatchTask result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.scenario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scenario other = (Scenario) obj;
        if (!Objects.equals(this.scenario, other.scenario)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Scenario o) {
        return this.scenario.compareTo(o.getScenario());
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
         this.pcs.addPropertyChangeListener(listener);
     }

     public void removePropertyChangeListener(PropertyChangeListener listener) {
         this.pcs.removePropertyChangeListener(listener);
     }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- CONFIGURATION ----\n");
        sb.append(" scenario    :").append(scenario).append("\n");
        sb.append(" funcional    :").append(functional).append("\n");
        sb.append(" injective    :").append(injective).append("\n");
        sb.append(" K            :").append(K).append("\n");
        sb.append(" nullPrefixes :").append(Arrays.asList(SpeedyConstants.getStringSkolemPrefixes())).append("\n");
        sb.append("-----------------------\n");
        sb.append(" forceExaustiveSearch:").append(forceExaustiveSearch).append("\n");
        sb.append(" twoWayValueMapping:").append(twoWayValueMapping).append("\n");
        sb.append(" stopIfNonMatchingTuples:").append(stopIfNonMatchingTuples).append("\n");
        sb.append(" convertSkolemInHash:").append(convertSkolemInHash).append("\n");
        return sb.toString();
    }

}
