package domain;

import java.util.Objects;

public class Angajat extends Entity<Long>{
    private Long id;
    private String nume;
    private String prenume;
    private String post;
    private double salariu;

    public Angajat(Long id, String nume, String prenume, String post, double salariu)
    {this.id = id;
    this.nume = nume;
    this.prenume = prenume;
    this.post = post;
    this.salariu = salariu;}

    public Angajat(String nume, String prenume, String post, double salariu)
    {this.nume = nume;
        this.prenume = prenume;
        this.post = post;
        this.salariu = salariu;}

    public String getNume(){return nume;}

    public void setNume(String nume){this.nume = nume;}

    public String getPrenume(){return prenume;}

    public void setPrenume(String prenume){this.prenume = prenume;}

    public String getPost(){return post;}

    public void setPost(String post){this.post = post;}

    public double getSalariu(){return salariu;}

    public void setSalariu(double salariu){this.salariu = salariu;}

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return Double.compare(angajat.salariu, salariu) == 0 &&
                Objects.equals(id, angajat.id) &&
                Objects.equals(nume, angajat.nume) &&
                Objects.equals(prenume, angajat.prenume) &&
                Objects.equals(post, angajat.post);
    }

    @Override
    public int hashCode(){ return Objects.hash(id, nume, prenume, post, salariu);}

    @Override
    public String toString(){
        return "Angajat{" + "id = " + id + '\s' + "nume = " + nume + '\s' + "prenume = "
                + prenume + '\s' + "post = " + post + '\s' +  "salariu = " + salariu + "}";
    }

    public String pctA(){
        return "Angajat{" + "id = "+ id +'\s' + "nume = " + nume + '\s' + "prenume = "
                + prenume + '}';
    }

    public String pctB(){
        return "Angajat{" + "nume = " + nume + '\s' + "prenume = " + prenume +'\s'+ "post = " + post + '}';
    }

    public String pctC(){
        return "Angajat{" +"id = "+ id + '\s'+  "salariu = " + salariu + '}';
    }
}
