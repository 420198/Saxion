/**
 * Created by sklar on 12/12/2016.
 */
public class SimulatedFile {
    private String file;

    /**
     * Create new simulated file that has a string
     */
    public SimulatedFile() {
        this.file = new String();
    }

    /**
     * Returns the file
     * @return file
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the file
     * @param file file
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Write to the file
     * @param toWrite writes
     */
    public void writeFile(String toWrite) {
        file += toWrite;
    }
}
