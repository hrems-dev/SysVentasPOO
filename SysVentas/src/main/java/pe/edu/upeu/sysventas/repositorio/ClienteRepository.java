package pe.edu.upeu.sysventas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.sysventas.modelo.Cliente;

//import ch.qos.logback.core.net.server.Client;

public interface  ClienteRepository extends JpaRepository<Cliente, Long>{

}
