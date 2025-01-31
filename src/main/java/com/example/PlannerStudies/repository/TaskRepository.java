package com.example.PlannerStudies.repository;

import com.example.PlannerStudies.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// A anotação @Repository indica que esta interface é um repositório do Spring,
// o que significa que ela será usada para interagir com o banco de dados.
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // O JpaRepository já oferece uma série de métodos para realizar operações no banco de dados, como:
    // - save(): Salvar um novo objeto ou atualizar um existente
    // - findAll(): Buscar todos os objetos da tabela
    // - findById(): Buscar um objeto pelo id
    // - deleteById(): Deletar um objeto pelo id
    // Portanto, não é necessário implementar nenhum método específico aqui, a não ser que você precise de consultas personalizadas.
}
