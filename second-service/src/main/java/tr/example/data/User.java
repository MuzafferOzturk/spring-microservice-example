package tr.example.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//@ApiModel(description = "User details")
public class User {
    private Integer id;
    @Min(3)
//    @ApiModelProperty(notes = "Name should min 3 character")
    private String name;
    @Max(11)
    private String phone;

    public User() {
    }

    public User(Integer id, @Min(3) String name, @Max(11) String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
