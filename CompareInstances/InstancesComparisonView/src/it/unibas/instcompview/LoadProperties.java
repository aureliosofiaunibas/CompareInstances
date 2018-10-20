package it.unibas.instcompview;


import it.unibas.centrallookup.CentralLookup;
import it.unibas.instcompview.api.ILoadScenario;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author aurelio.sofia
 */
@ServiceProvider(service = ILoadScenario.class)
public class LoadProperties implements ILoadScenario{
    
    private static Logger log = LoggerFactory.getLogger(LoadProperties.class);

    @Override
    public void load(FileObject file){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(FileUtil.toFile(file)));
            Scenario scenario = new Scenario();
            scenario.setDbType(AppConstants.DBTYPE_MAIN_MEMORY_CVS);
            scenario.getLeftDBRetrieveInfo().setSeparator(',');
            scenario.getRightDBRetrieveInfo().setSeparator(',');
            loadScenario(properties, scenario);
            log.debug("PROPERTIES: " + properties.toString());
            CentralLookup.getDefault().add(scenario);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            NotificationDialogs.notifyError("Something occurred with the file\n" + ex);
            return;
        }
    }
    
    private void loadScenario(Properties properties, Scenario scenario){
        try{
            scenario.setScenario(properties.getProperty(AppConstants.SCENARIO));
            scenario.getLeftDBRetrieveInfo().setInstancePath(properties.getProperty(AppConstants.LEFT_DB));
            scenario.getRightDBRetrieveInfo().setInstancePath(properties.getProperty(AppConstants.RIGHT_DB));
            scenario.setFunctional(Boolean.parseBoolean(properties.getProperty(AppConstants.FUNCTIONAL)));
            scenario.setInjective(Boolean.parseBoolean(properties.getProperty(AppConstants.INJECTIVE)));
            scenario.setK(Double.parseDouble(properties.getProperty(AppConstants.K)));
            scenario.setStrategy(properties.getProperty(AppConstants.STRATEGY));
            checkDefault(properties, scenario);
            addScenarioToLookup(scenario);
        } catch(Exception e){
            Exceptions.printStackTrace(e);
        }
        
    }
    
    private void checkDefault(Properties properties, Scenario scenario){
        if(properties.getProperty(AppConstants.TWO_WAY_VALUE_MAPPING) == null){
            scenario.setTwoWayValueMapping(true);
        } else {
            scenario.setTwoWayValueMapping(Boolean.parseBoolean(properties.getProperty(AppConstants.TWO_WAY_VALUE_MAPPING)));
        }
        if(properties.getProperty(AppConstants.STOP_IF_NON_MATCHING_TUPLES) == null){
            scenario.setStopIfNonMatchingTuples(false);
        } else {
            scenario.setStopIfNonMatchingTuples(Boolean.parseBoolean(properties.getProperty(AppConstants.STOP_IF_NON_MATCHING_TUPLES)));
        }
        if(properties.getProperty(AppConstants.BEST_SCORE_THRESHOLD) == null){
            scenario.setBestScoreThreshold(99);
        } else {
            scenario.setBestScoreThreshold(Double.parseDouble(properties.getProperty(AppConstants.BEST_SCORE_THRESHOLD)));
        }
        if(properties.getProperty(AppConstants.CONVERT_SKOLEM_IN_HASH) == null){
            scenario.getLeftDBRetrieveInfo().setConvertSkolemInHash(false);
            scenario.getRightDBRetrieveInfo().setConvertSkolemInHash(false);
            scenario.setConvertSkolemInHash(false);
        } else {
            scenario.getLeftDBRetrieveInfo().setConvertSkolemInHash(Boolean.parseBoolean(properties.getProperty(AppConstants.CONVERT_SKOLEM_IN_HASH)));
            scenario.getRightDBRetrieveInfo().setConvertSkolemInHash(Boolean.parseBoolean(properties.getProperty(AppConstants.CONVERT_SKOLEM_IN_HASH)));
            scenario.setConvertSkolemInHash(Boolean.parseBoolean(properties.getProperty(AppConstants.CONVERT_SKOLEM_IN_HASH)));
        }
        if(properties.getProperty(AppConstants.FORCE_EXAUSTIVE_SEARCH) == null){
            scenario.setForceExaustiveSearch(false);
        } else {
            scenario.setForceExaustiveSearch(Boolean.parseBoolean(properties.getProperty(AppConstants.FORCE_EXAUSTIVE_SEARCH)));
        }
    }

    private void addScenarioToLookup(Scenario scenario) {
        Lookup.Result<Scenario> scenarioResult = CentralLookup.getDefault().lookupResult(Scenario.class);
        List<Scenario> scenarios = new ArrayList(scenarioResult.allInstances());
        if(!scenarios.contains(scenario)){
            CentralLookup.getDefault().add(scenario);
        } else {
            Collections.sort(scenarios);
            Scenario scenarioTmp = scenarios.get(scenarios.size()-1);
            String name = scenarioTmp.getScenario();
            if(name.contains("#")){
                name = name.substring(name.length() - 2);
                int scnDuplicate = Integer.parseInt(name);
                scnDuplicate++;
                
                name = scenarioTmp.getScenario();
                name = name.substring(0, name.length() - 4);
                
                if(scnDuplicate < 10){
                    name = name + " #0" + Integer.toString(scnDuplicate);
                } else {
                    name = name + " #" + Integer.toString(scnDuplicate);
                }
            } else {
                name = name + " #01";
            }
            
            scenario.setScenario(name);
            CentralLookup.getDefault().add(scenario);
        }
    }

}

