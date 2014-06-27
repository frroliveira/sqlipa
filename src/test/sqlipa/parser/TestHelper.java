package test.sqlipa.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class TestHelper {
	
    private HashMap<String, String> parts;
    
    public TestHelper() {
    	parts = new HashMap<String, String>();
      	
    	File[] files = new File("src/test/sqlipa/resources").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".sql");
            }
        });
    	    	
    	for (File file: files) {
			try {
				loadFile(file);
			} catch (IOException e) {
			}
    	}
    }
    
    public String getPart(final String part) {
    	return parts.get(part);
    }

    public String getStmt(final String part) {
    	return parts.get("s_" + part);
    }
    
    public Collection<String> getAll() {
    	return parts.values();
    }
    
    private void loadFile(final File file) throws IOException {
		String name = file.getName().substring(0, file.getName().length() - 4);		
    	BufferedReader reader = new BufferedReader(new FileReader(file));
		
    	int count = 0;
		String sql = null;
		
		while ((sql = reader.readLine()) != null) {
			while (!sql.endsWith(";")) {
				sql += "\n" + reader.readLine();
			}
			count++;
			parts.put(name + count, sql);
		}
		reader.close();
    }
}