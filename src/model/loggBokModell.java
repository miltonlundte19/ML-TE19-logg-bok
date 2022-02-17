package model;

import loggEntryClass.loggEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class loggBokModell {
    private ArrayList<loggEntry> loggentrys;
    private File loggfile;

    public loggBokModell() {
        loggfile = new File("loggentryse");
        ObjectInputStream ins = null;
        try {
            ins = new ObjectInputStream(new FileInputStream(loggfile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (ins != null) {
            try {
                loggentrys.add((loggEntry) ins.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
