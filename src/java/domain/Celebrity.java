/*
Simona
 */

package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Celebrity implements Serializable, Comparable<Celebrity>  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String picture;
    private int age;
    private double salary;
    private int votes;
    

    public Celebrity() {
    }

    public Celebrity(String name, int age, double salary, String picture) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
      @Override
    public String toString() {
        return "Celebrity{" + "id=" + id + ", name=" + name + ", picture=" + picture + ", age=" + age + ", salary=" + salary + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Celebrity other = (Celebrity) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Celebrity celebrity) {
        int result = (int) (celebrity.salary - this.salary);
        return result;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    

}

