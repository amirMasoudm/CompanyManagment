package company.dotin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public class Common implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Version
    private int c_version;
    @Column
    private boolean c_activation;
    @Column
    private LocalDateTime c_modification_Date_Time;
    public Common(int id, int c_version, boolean c_activation, LocalDateTime c_modification_Date_Time) {
        this.id = id;
        this.c_version = c_version;
        this.c_activation = c_activation;
        this.c_modification_Date_Time = c_modification_Date_Time;
    }

    public Common(int id, int c_version, boolean c_activation) {
        this.id = id;
        this.c_version = c_version;
        this.c_activation = c_activation;
    }

    public Common() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getC_version() {
        return c_version;
    }

    public void setC_version(int c_version) {
        this.c_version = c_version;
    }

    public boolean getC_activation() {
        return c_activation;
    }

    public void setC_activation(boolean c_activation) {
        this.c_activation = c_activation;
    }

    public boolean isC_activation() {
        return c_activation;
    }

    public LocalDateTime getC_modification_Date_Time() {
        return c_modification_Date_Time;
    }

    public void setC_modification_Date_Time(LocalDateTime c_modification_Date_Time) {
        this.c_modification_Date_Time = c_modification_Date_Time;
    }
}
