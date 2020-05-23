package br.com.confile.manager;

import br.com.confile.exception.ConFileException;
import br.com.confile.to.PropertieTO;

import java.io.*;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager implements Manager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class.getCanonicalName());

    private File file;
    private Map<Integer, PropertieTO> variables;

    public FileManager() {
        this.variables = new LinkedHashMap<>();
    }

    public void open(String path) throws IOException, ConFileException {
        if(path == null || path.isEmpty()) {
            System.out.println("Argument required PATH not found.");
            return;
//            throw new ConFileException(ConFileErrorCode.PATH_ARG_NOT_FOUND);
        }
        this.file = new File(path);
        if(!this.file.exists()) {
            URL resource = getClass().getResource(path);

            if(resource != null) {
                this.file = new File(resource.getPath());
            }

            if(!this.file.exists()) {
                LOGGER.log(Level.WARNING, "File Not Found: {0}", path);
                throw new FileNotFoundException();
            }
        }

        System.out.println("File open: ".concat(this.file.getName()));
    }

    public void loadProperties() throws IOException {
        if(this.file == null) {
            LOGGER.log(Level.WARNING, "Has no file to load properties.");
            throw new FileNotFoundException();
        }

        FileReader reader = new FileReader(this.file);
        BufferedReader bf = new BufferedReader(reader);
        String line = bf.readLine();
        int i = 1;
        while(line != null) {

            String[] keyValue = line.split("\\.*=\\.*");

            variables.put(i++, new PropertieTO(keyValue[0], keyValue[1]));

            line = bf.readLine();
        }

        reader.close();
        bf.close();

        System.out.println("Properties loaded!");
    }

    public void showProperties() {

        if(this.variables.isEmpty()) {
            System.out.println("No variables to show.");
            return;
        }

        int i = 1;

        StringBuilder line = new StringBuilder();


        for (Map.Entry<Integer, PropertieTO> entry : this.variables.entrySet()) {
            line.append("[");
            line.append(entry.getKey());
            line.append("]");
            line.append("\t");

            if(entry.getValue().getState() == PropertieTO.COMMENTED_STATE) {
                line.append("#");
            }

            line.append(entry.getValue().getKey());
            line.append("=");
            line.append(entry.getValue().getValue());

            System.out.println(line.toString());
            line = new StringBuilder();
        }
    }

    public void commentPropertie(int propertieIndex) {
        if(this.variables.isEmpty()) {
            System.out.println("No variables to comment.");
            return;
        }
        if(this.variables.get(propertieIndex).getState() == PropertieTO.COMMENTED_STATE) {
            this.variables.get(propertieIndex).setState(PropertieTO.INITIAL_STATE);
        } else {
            this.variables.get(propertieIndex).setState(PropertieTO.COMMENTED_STATE);
        }
    }
}
