package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.domain.Flor;

import java.util.Arrays;
import java.util.List;

public class FlorDTO {
    private Long pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor; //nomes a DTO

    private static final List<String> paisosUE = Arrays.asList("Alemania", "Austria", "Bélgica", "Bulgaria",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia");

    public FlorDTO(){
    }

    public FlorDTO(Long pk_FlorID, String nomFlor, String paisFlor, String tipusFlor){
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.tipusFlor = tipusFlor; //nomes a DTO
    }

    public Long getPk_FlorID(){
        return pk_FlorID;
    }
    public void setPk_FlorID(Long pk_FlorID){
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor(){
        return nomFlor;
    }
    public void setNomFlor(String nomFlor){
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor(){
        return paisFlor;
    }
    public void setPaisFlor(String paisFlor){
        this.paisFlor = paisFlor;
    }

    //nomes a DTO ----------------------------
    public String getTipusFlor(){
        return tipusFlor;
    }
    public void setTipusFlor(String tipusFlor){
        this.tipusFlor = tipusFlor;
    }
    //------------------------------------

    //metodes per pasar de entity a DTO y viceversa
    public static FlorDTO toFlorDTO (Flor flor){
        FlorDTO florDTO = new FlorDTO();

        florDTO.setPk_FlorID(flor.getPk_FlorID());
        florDTO.setNomFlor(flor.getNomFlor());
        florDTO.setPaisFlor(flor.getPaisFlor());
        //se puedeutilizar model mapper para quitar lineas de codigo:


        if (paisosUE.contains(flor.getPaisFlor())){
            florDTO.setTipusFlor("UE");
        } else {
            florDTO.setTipusFlor("FORA UE");
        }
        return florDTO;
    }
    public static Flor toFlor (FlorDTO florDTO){
        Flor flor = new Flor();

        flor.setNomFlor(florDTO.getNomFlor());
        flor.setPaisFlor(florDTO.getPaisFlor());

        return flor;
    }
}
