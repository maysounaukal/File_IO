package be.intecbrussel.entities;

import be.intecbrussel.utilities.FilesTools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


/**
 * This class creates an object to manage all
 * the properties of the documents to be copied
 * in the directory "sorted".
 */


public class ObjectFile {


    private Path sortedDirectory = Paths.get("C:/data/sorted");
    private Path completeDirectory;
    private Path completePath;
    private Path sourcePath;
    private String fileName;
    private String extension;
    private boolean writable;
    private boolean readable;
    private boolean hidden;


    /**
     * Only one constructor
     *
     * @param file
     */
    public ObjectFile(File file) {


        this.sourcePath = file.toPath ();
        this.fileName = sourcePath.getFileName ().toFile ().toString ();
        this.extension = FilesTools.getSubString (file.getName ());
        this.completeDirectory = sortedDirectory.resolve (extension);
        this.completePath = completeDirectory.resolve (file.toPath ().getFileName ());
        this.readable = file.canRead ();
        this.writable = (file.canWrite ());
        this.hidden = file.isHidden ();

    }
    public Path getCompletePath() {
        return completePath;
    }

    public Path getSourcePath() {
        return sourcePath;
    }

    public String getExtension() {
        return extension;
    }

    public boolean isWritable() {
        return writable;
    }

    public boolean isReadable() {
        return readable;
    }

    public boolean isHidden() {
        return hidden;
    }

        public String getFileName() {
            return fileName;
        }
    }


