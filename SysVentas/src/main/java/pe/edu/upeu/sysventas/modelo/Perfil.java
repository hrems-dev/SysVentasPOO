package pe.edu.upeu.sysventas.modelo;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data 
@Entity 
@Table(name = "upeu_perfil")
public class Perfil {
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) 
 @Basic(optional = false) 
 @Column(name = "id_perfil", nullable = false) 
 private Long idPerfil; 
 @Size(max = 20) 
 private String nombre; 
 @Size(max = 6) 
 private String codigo; 
}
