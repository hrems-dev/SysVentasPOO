package pe.edu.upeu.sysventas.modelo;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data 
@Entity 
@Table(name = "upeu_cliente")
public class Cliente {
@Id
 @Column(name = "dniruc", nullable = false, length = 12) 
 private String dniruc; 
 @Column(name = "nombres", nullable = false, length = 160) 
 private String nombres; 
 @Column(name = "rep_legal", length = 160) 
 private String repLegal; 
 @Column(name = "tipo_documento", nullable = false, length = 12) 
 private String tipoDocumento; 
}
