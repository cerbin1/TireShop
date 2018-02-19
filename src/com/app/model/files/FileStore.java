package com.app.model.files;

import java.io.*;
import java.util.List;

public class FileStore {
    private final String filename;

    public FileStore(String filename) {
        this.filename = filename;
    }

    public void store(List<Serializable> object) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
    }

    public List<Serializable> read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Serializable> object = (List<Serializable>) ois.readObject();
        ois.close();

        return object;
    }
}
