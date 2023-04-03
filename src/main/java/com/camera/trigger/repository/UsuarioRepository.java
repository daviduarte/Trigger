package com.camera.trigger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camera.trigger.model.Usuario;

@Repository 
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{   // O repository precisa saber o tipo que está manuseando e o tipo da chave primária, para el poder fazer as convesões necessaŕias
    
}
