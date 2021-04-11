package company.dotin.dto;

import com.sun.istack.NotNull;

public class CategoryElementVO {
    private String persianName;
    private int code;

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
