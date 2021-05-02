package by.antonsh.lesson13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Computers {
    @XmlID
    private String id;
    @XmlAttribute
    private String shopName;
    @XmlElement(name = "ListOfComputers")
    private List<Computer> list=new ArrayList<>();
    public String getShopName(){
        if(shopName==null){
            shopName="Default Value";
        }
        return shopName;
    }
}
