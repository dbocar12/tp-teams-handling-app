package fr.sorbonne.paris.nord.university.api.dto;

import lombok.Data;

@Data
public class PlayerDTO {
    private long id;
    private String name;
    private String number;
    private String position;
}
