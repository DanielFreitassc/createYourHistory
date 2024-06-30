package br.com.danielfreitassc.backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character")
public class CharacterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int birthplace;
    private String personality;
    private String description;
    
    @OneToOne
    @JoinColumn(name = "weapon_id", referencedColumnName = "id")
    private WeaponEntity weapon;
    
    @OneToMany
    @JoinColumn(name = "character_group_id", referencedColumnName = "id")
    private List<GroupEntity> character_group;

    @OneToMany
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private List<PlaceEntity> favorite_place;

    @OneToMany
    @JoinColumn(name = "relations", referencedColumnName = "id")
    private List<RelationsEntity> relation_id;
    

}
