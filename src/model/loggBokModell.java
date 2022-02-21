package model;

import loggEntryClass.loggEntry;

import java.io.*;
import java.util.ArrayList;

public class loggBokModell {
    private ArrayList<loggEntry> loggentrys;
    private File loggfile;

    public loggBokModell() {
        loggfile = new File("loggentryse");
        loadS();
    }

    private void loadS() {
        try {
            ObjectInputStream ins = new ObjectInputStream(new FileInputStream(loggfile));
            this.loggentrys = (ArrayList<loggEntry>) ins.readObject();
            ins.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void load(File loggfile, Boolean saveFurst) {
        if (saveFurst) {
            save(this.loggfile);
        }
        this.loggfile = loggfile;
        this.loggentrys = null;
        loadS();
    }

    public void save(File loggfile) {
        try {
            ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(loggfile));
            outs.writeObject(this.loggentrys);
            outs.flush();
            outs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
