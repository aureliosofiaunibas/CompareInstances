package it.unibas.instcompview;

/**
 *
 * @author aurelio.sofia
 */
public class DBinfo {
    
    //MAIN MEMORY
    //loadCSVDatabase
    private String instancePath;
    private char separator;
    private Character quoteCharacter;
    private boolean convertSkolemInHash;
    private boolean header;
    
    //loadXMLDatabase
    private String schemaFile;
    private String instanceFile;
    
    //DBMS
    private String driver;
    private String uri;
    private String schemaName;
    private String username;
    private String password;
    
    public DBinfo(){}
    
    //loadCSVDatabase WITH header
    public DBinfo(String instancePath, char separator, Character quoteCharacter, boolean convertSkolemInHash) {
        this.instancePath = instancePath;
        this.separator = separator;
        this.quoteCharacter = quoteCharacter;
        this.convertSkolemInHash = convertSkolemInHash;
    }
    
    //loadCSVDatabase WITHOUT header
    public DBinfo(String instancePath, char separator, Character quoteCharacter, boolean convertSkolemInHash, boolean header) {
        this.instancePath = instancePath;
        this.separator = separator;
        this.quoteCharacter = quoteCharacter;
        this.convertSkolemInHash = convertSkolemInHash;
        this.header = header;
    }
    
    //loadXMLDatabase
    public DBinfo(String schemaFile, String instanceFile) {
        this.schemaFile = schemaFile;
        this.instanceFile = instanceFile;
    }
    
    //loadDatabase DBMS
    public DBinfo(String driver, String uri, String schemaName, String username, String password) {
        this.driver = driver;
        this.uri = uri;
        this.schemaName = schemaName;
        this.username = username;
        this.password = password;
    }

    public String getInstancePath() {
        return instancePath;
    }

    public void setInstancePath(String instancePath) {
        this.instancePath = instancePath;
    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public Character getQuoteCharacter() {
        return quoteCharacter;
    }

    public void setQuoteCharacter(Character quoteCharacter) {
        this.quoteCharacter = quoteCharacter;
    }

    public boolean isConvertSkolemInHash() {
        return convertSkolemInHash;
    }

    public void setConvertSkolemInHash(boolean convertSkolemInHash) {
        this.convertSkolemInHash = convertSkolemInHash;
    }

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public String getSchemaFile() {
        return schemaFile;
    }

    public void setSchemaFile(String schemaFile) {
        this.schemaFile = schemaFile;
    }

    public String getInstanceFile() {
        return instanceFile;
    }

    public void setInstanceFile(String instanceFile) {
        this.instanceFile = instanceFile;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
