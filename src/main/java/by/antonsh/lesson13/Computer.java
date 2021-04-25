package by.antonsh.lesson13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Computer {
    @XmlID
    private String id;
    @XmlAttribute(required = true)
    private String name;
    private MotherBoard motherBoard;
    private HDD hdd;
    private VCard vCard;
    private double price;
}
