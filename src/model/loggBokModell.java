package model;

import loggEntryClass.loggEntry;

import javax.swing.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class loggBokModell {
    private ArrayList<loggEntry> loggentrys;
    private File loggfile;
    private Boolean saved = true;

    public loggBokModell() {
        loggfile = new File("loggentryse", ".txt");
        beginModell();
    }

    private void beginModell() {
        if (loggfile.exists()) {
            try {
                ObjectOutputStream ins = new ObjectOutputStream(new FileOutputStream(loggfile));
                loggentrys = ( (ArrayList<loggEntry>) ins.readObject() );
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            loggentrys = new ArrayList<loggEntry>();
            saved = false;
        }
    }

    private void save() {
        try {
            ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(loggfile));
            outs.writeObject(loggentrys);
            outs.flush();
            outs.close();
            saved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveAS() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String curentFile = loggfile.getName();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // test som ser om filens namn fungerar som ett namn på en fill.
        }
        try {
            ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(loggfile));
            outs.writeObject(loggentrys);
            outs.flush();
            outs.close();
            saved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void lode() {}


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
/*
    public void save() {
        try {
            ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(loggfile));
            outs.writeObject(this.loggentrys);
            outs.flush();
            outs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public ArrayList<loggEntry> getLoggentrys() {
        return loggentrys;
    }
}
