package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Flors")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long pk_FlorID;

    @Column(name = "NOM")
    private String nomFlor;

    @Column(name = "PAIS")
    private String paisFlor;


    //constructor complet
    public Flor(Long pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    //constructor sense id
    public Flor(String nomFlor, String paisFlor) {
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    //constructor buit
    public Flor() {
    }


    public Long getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Long pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }


    @Override
    public String toString() {
        return "Flor{" +
                "pk_FlorID='" + pk_FlorID + '\'' +
                ", nomFlor='" + nomFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                '}';
    }
}
