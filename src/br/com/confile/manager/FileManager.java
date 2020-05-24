package br.com.confile.manager;

import br.com.confile.to.PropertyTO;
import br.com.confile.utils.HashUtils;

import java.io.*;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager implements Manager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class.getCanonicalName());

    private File file;
    private String fileChecksumMD5;
    private String filePath;
    private Map<Integer, PropertyTO> variables;

    public FileManager() {
        this.variables = new LinkedHashMap<>();
        this.fileChecksumMD5 = "";
        this.filePath = "";
    }

    public void openFile(String path) throws IOException {
        if(path == null || path.isEmpty()) {
            System.out.println("Argument required PATH not found.");
            return;
        }

        this.filePath = path;
        doOpenFile(path);
        this.fileChecksumMD5 = HashUtils.getFileMD5(this.file);
    }

    private void doOpenFile(String path) throws FileNotFoundException {
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

        String checkMD5 = HashUtils.getFileMD5(this.file);
        if(checkMD5 != null && !checkMD5.equals(this.fileChecksumMD5)) {
            System.out.println("File has been changed. Reopen it.");
            return;
        }

        if(this.file == null) {
            LOGGER.log(Level.WARNING, "Has no file to load properties.");
            throw new FileNotFoundException();
        }

        FileReader reader = new FileReader(this.file);
        BufferedReader bf = new BufferedReader(reader);
        String line = bf.readLine();
        int i = 1;
        while(line != null) {
            PropertyTO propertyTO = new PropertyTO();
            if(line.matches(".*=.*")) {
                String[] keyValue = line.split("\\.*=\\.*");

                if (keyValue[0].startsWith("#")) {
                    keyValue[0] = keyValue[0].substring(1);
                    propertyTO.setState(PropertyTO.COMMENTED_STATE);
                }
                propertyTO.setKey(keyValue[0]);
                propertyTO.setValue(keyValue[1]);
                variables.put(i++, propertyTO);

            }
            line = bf.readLine();
        }

        reader.close();
        bf.close();

        System.out.println("Properties loaded!");
    }

    public void showProperties() {

        String checkMD5 = HashUtils.getFileMD5(this.file);
        if(checkMD5 != null && !checkMD5.equals(this.fileChecksumMD5)) {
            System.out.println("File has been changed. Reopen it.");
            return;
        }

        if(this.variables.isEmpty()) {
            System.out.println("No variables to show.");
            return;
        }

        int i = 1;

        StringBuilder line = new StringBuilder();


        for (Map.Entry<Integer, PropertyTO> entry : this.variables.entrySet()) {
            line.append("[");
            line.append(entry.getKey());
            line.append("]");
            line.append("\t");

            if(entry.getValue().getState() == PropertyTO.COMMENTED_STATE) {
                line.append("#");
            }

            line.append(entry.getValue().getKey());
            line.append("=");
            line.append(entry.getValue().getValue());

            System.out.println(line.toString());
            line = new StringBuilder();
        }
    }

    public void commentProperty(int[] properiesIndex) {
        if (this.variables.isEmpty()) {
            System.out.println("No variables to comment.");
            return;
        }

        for (int propertyIdx : properiesIndex) {
            if(this.variables.containsKey(propertyIdx)) {
                if (this.variables.get(propertyIdx).getState() == PropertyTO.COMMENTED_STATE) {
                    this.variables.get(propertyIdx).setState(PropertyTO.INITIAL_STATE);
                } else {
                    this.variables.get(propertyIdx).setState(PropertyTO.COMMENTED_STATE);
                }
            } else {
                System.out.println("Property index "+propertyIdx+" doesn't exists");
            }
        }
    }

    public void findProperties(String searchString) {
        this.variables.forEach((k, v) -> {
            if(v.getKey().contains(searchString) || v.getValue().contains(searchString)) {
                StringBuilder line = new StringBuilder();
                line.append("[");
                line.append(k);
                line.append("]");
                line.append("\t");

                if(v.getState() == PropertyTO.COMMENTED_STATE) {
                    line.append("#");
                }

                line.append(v.getKey());
                line.append("=");
                line.append(v.getValue());

                System.out.println(line.toString());
            }
        });
    }

    public void saveFile() {
        try {
            doSaveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doSaveFile() throws IOException {
        boolean answer = true;
        String checkMD5 = HashUtils.getFileMD5(this.file);
        if(checkMD5 != null && !checkMD5.equals(this.fileChecksumMD5)) {
            System.out.print("\nFile has been changed.\nDo you want to overwrite it? (y/n) > ");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            answer = bf.readLine().toLowerCase().equals("y");
        }

        if(answer) {
            FileOutputStream fous = new FileOutputStream(this.file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fous));

            this.variables.forEach((k, v) -> {
                try {
                    if (v.getState() == PropertyTO.COMMENTED_STATE) {
                        writer.write("#");
                    }
                    writer.write(v.getKey());
                    writer.write("=");
                    writer.write(v.getValue());
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.close();
            fous.close();
        }
    }
}
