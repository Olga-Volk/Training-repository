import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);
        
        if (cache.size() == cacheSize){
            writeEventsFromeCache();
            cache.clear();
        }
    }

    public void writeEventsFromeCache() {
        cache.stream().forEach(super::logEvent);
    }

    public void destroy(){
        if(!cache.isEmpty()) writeEventsFromeCache();
    }
}
