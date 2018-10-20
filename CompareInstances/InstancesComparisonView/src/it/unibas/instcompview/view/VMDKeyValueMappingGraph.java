package it.unibas.instcompview.view;

import bart.comparison.ValueMapping;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComponent;
import org.netbeans.api.visual.graph.layout.GridGraphLayout;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.layout.SceneLayout;
import org.netbeans.api.visual.vmd.VMDGraphScene;
import org.netbeans.api.visual.vmd.VMDNodeWidget;
import org.netbeans.api.visual.vmd.VMDPinWidget;
import speedy.model.database.IValue;

/**
 *
 * @author aurelio.sofia
 */
public class VMDKeyValueMappingGraph {
    
    private VMDGraphScene scene;
    private GridGraphLayout<String, String> graphLayout;
    private SceneLayout sceneGraphLayout;
    private ValueMapping leftMap;
    private ValueMapping rightMap;
    
    public VMDKeyValueMappingGraph(ValueMapping leftMap, ValueMapping rightMap){
        scene = new VMDGraphScene();
        graphLayout = new GridGraphLayout();
        sceneGraphLayout = LayoutFactory.createSceneGraphLayout(scene, graphLayout);
        this.leftMap = leftMap;
        this.rightMap = rightMap;
        createTables();
    }
    
    private void createTables(){
        VMDNodeWidget leftKeysTable = (VMDNodeWidget) scene.addNode("LEFT KEYS");
        leftKeysTable.setNodeProperties(null, "LEFT KEYS", "KEYS", null);
        VMDNodeWidget rightKeysTable = (VMDNodeWidget) scene.addNode("RIGHT KEYS");
        rightKeysTable.setNodeProperties(null, "RIGHT KEYS", "KEYS", null);
        VMDNodeWidget valuesTable = (VMDNodeWidget) scene.addNode("VALUES");
        valuesTable.setNodeProperties(null, "VALUES", "VALUES", null);
        Set<String> filter = new HashSet<>();
        populateGraph("LEFT KEYS", leftMap, filter);
        populateGraph("RIGHT KEYS", rightMap, filter);
    }
    
    private void populateGraph(String tableName, ValueMapping map, Set<String> filter){
        for(IValue key : map.getKeys()){
            createRow(tableName, key.getPrimitiveValue().toString());
            
            IValue value = map.getValueMapping(key);
            if(!filter.contains(value.getPrimitiveValue().toString())){
                createRow("VALUES", value.getPrimitiveValue().toString());
                filter.add(value.getPrimitiveValue().toString());
            }
            createEdge("VALUES" + value.getPrimitiveValue().toString(), 
                        tableName + key.getPrimitiveValue().toString());
        }
    }
    
    private void createEdge(String value, String key){
        String edge = key + "-->" + value;
        scene.addEdge(edge);
        scene.setEdgeSource(edge, key);
        scene.setEdgeTarget(edge, value);
    }
    
    private void createRow(String table, String row){
        VMDPinWidget rowWidget = (VMDPinWidget) scene.addPin(table, table+row);
        rowWidget.setPinName(row);
        rowWidget.setLayout(LayoutFactory.
                createHorizontalFlowLayout(LayoutFactory.SerialAlignment.JUSTIFY, 7));
    }
    
    public VMDGraphScene getScene() {
        return scene;
    }
    
    public JComponent createView()   {
        return scene.createView();
    }
    
    public void invokeLayout()   {
        sceneGraphLayout.invokeLayout();
    }
}
