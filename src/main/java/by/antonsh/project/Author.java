package by.antonsh.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Author")
public class Author {
    private String soname;
    private String name;

    public Author() {
    }

    public Author(String soname, String name) {
        this.soname = soname;
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "soname='" + soname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
