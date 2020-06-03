import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.CanWriteFileFilter;

public class FileEventLogger implements EventLogger{

    String filename;
    File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(),true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void init() throws IOException {
        this.file = new File(filename);

    }
}
