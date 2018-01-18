/*
Simona
 */
package controller;

import dao.CelebrityDAO;
import domain.Celebrity;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "controllerBean")
@RequestScoped
public class ControllerBean {

    @Inject
    private CelebrityDAO myDAO;

    private int id;
    private String name;
    private String picture;
    private int age;
    private double salary;
    private int votes;
    
    private String password = "objects123";
    private String inputPassword;

    private double lowSal;
    private double highSal;
    private double totSal;

    //private Celebrity celeb;
    private List<Celebrity> celebrityList;
    private List<Celebrity> richestCelebrities;
    private List<Celebrity> poorestCelebrities;
    private List<Celebrity> popularCelebrities;

    private Celebrity celeb = new Celebrity();

    public ControllerBean() {
    }

    public void submit() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);
        
        celeb.setName(name);
        celeb.setAge(age);
        celeb.setSalary(salary);
        celeb.setPicture(picture);
        myDAO.addCeleb(celeb);
        //return "index";
    }

    public CelebrityDAO getMyDAO() {
        return myDAO;
    }

    public void setMyDAO(CelebrityDAO myDAO) {
        this.myDAO = myDAO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getLowSal() {
        return lowSal;
    }

    public void setLowSal(double lowSal) {
        this.lowSal = lowSal;
    }

    public double getHighSal() {
        return highSal;
    }

    public void setHighSal(double highSal) {
        this.highSal = highSal;
    }

    public double getTotSal() {
        return totSal;
    }

    public void setTotSal(double totSal) {
        this.totSal = totSal;

    }

    public List<Celebrity> getCelebrityList() {
        return myDAO.findAllCelebrity();
    }

    public List<Celebrity> getRichestCelebrityList() {
        richestCelebrities = myDAO.findAllCelebrity();
        Collections.sort(richestCelebrities);
        return richestCelebrities;
    }
    
        public List<Celebrity> getPoorestCelebrityList() {
        poorestCelebrities = myDAO.findAllCelebrity();
        Collections.sort(poorestCelebrities);
        Collections.reverse(poorestCelebrities);
        return poorestCelebrities;
    }



    public List<Celebrity> getPopularCelebrityList() {
        popularCelebrities = myDAO.findAllCelebrity();
        Collections.sort(popularCelebrities, (c1, c2) -> c2.getVotes() - c1.getVotes());
        return popularCelebrities;
    }

    public String celebrityListById(int arrayIndex) {
        celebrityList = myDAO.findAllCelebrity();
        return celebrityList.get(arrayIndex).getPicture();
    }

    public void setCelebrityList(List<Celebrity> celebrityList) {
        this.celebrityList = celebrityList;
    }

    public Celebrity getCeleb() {
        return celeb;
    }

    public void setCeleb(Celebrity celeb) {
        this.celeb = celeb;
    }

//    public void loadCelebrityVariables() {
//        celeb = myDAO.findCelebrity(id);
//        this.name = celeb.getName();
//        this.picture = celeb.getPicture();
//        this.salary = celeb.getSalary();
//        this.age = celeb.getAge();
//    }
    public void addCeleb() {
        celeb = new Celebrity(name, age, salary, picture);
        myDAO.addCeleb(celeb);
    }

    public void findCeleb() {
        System.out.println(myDAO.findCelebrity(id));
    }

    public String findCelebById(int id) {
        Celebrity cel = myDAO.findCelebrity(id);
        String pic = cel.getPicture();
//        myDAO.findCelebrity(id).getPicture()
        return pic;
    }

    public void removeCeleb() {
        myDAO.removeCelebrity(celeb);

    }

    
    public String removeCelebById(int id) {
        myDAO.removeCelebrityById(id);
        return "management";
    }

//       public String voteCelebById(int id) {
//       myDAO.findCelebrity(id).;
//               
//        myDAO.voteCelebrityById(id);
//        return "management";
//    }
    public double highSal() {
        highSal = 0;
        for (Celebrity c : myDAO.findAllCelebrity()) {
            if (c.getSalary() > highSal) {
                highSal = c.getSalary();
                name = c.getName();
            }
        }
        return highSal;
    }

    public double lowSalary() {
        lowSal = 100000;
        for (Celebrity c : myDAO.findAllCelebrity()) {
            if (c.getSalary() < lowSal) {
                lowSal = c.getSalary();
                name = c.getName();
            }
        }
        return lowSal;
    }

    public double totSal() {
        for (Celebrity c : myDAO.findAllCelebrity()) {
            totSal += c.getSalary();
        }
        return totSal;
    }

    public String voting(int id) {

        celeb = myDAO.findCelebrity(id);
        int fetchedVotes = celeb.getVotes();
        fetchedVotes++;
        celeb.setVotes(fetchedVotes);

        myDAO.edit(celeb);
        return "voting";
    }

    /*

    public String ArrayDemo() {
        List list = myDAO.findAllCelebrity();
       // String pic = richestCelebrities.get(arrayIndex).getPicture();
      Celebrity cel = myDAO.findCelebrity(id);
      String pic = cel.getPicture();
        
        for (pic : list) {
            
        }

//        // sorting array
//        Arrays.sort(iArr);
//
//        // let us print all the elements available in list
//        System.out.println("The sorted int array is:");
//        for (int number : iArr) {
//            System.out.println("Number = " + number);

            return "xxx";
        }
     */
    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
