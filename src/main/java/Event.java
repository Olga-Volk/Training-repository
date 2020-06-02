import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    int id;
    String msg;
    Date date;
    DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat){
        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
