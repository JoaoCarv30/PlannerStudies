package com.example.PlannerStudies.services;

import com.example.PlannerStudies.entity.Task;
import com.example.PlannerStudies.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<Task> createTask(Task task) {
       try{
           Task savedTask = taskRepository.save(task); // Salva a tarefa no banco de dados
           return new ResponseEntity<>(savedTask, HttpStatus.CREATED); // Retorna 201 Created
       }catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll(); // Retorna todas as tarefas do banco
    }

    public ResponseEntity<Task> getTaskById(Long id) {
        try {
            Optional<Task> existentTask = taskRepository.findById(id);

            if (existentTask.isPresent()) {
                return new ResponseEntity<>(existentTask.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Task> updateTask(Long id, Task task) {
        try {
            // Buscar a tarefa existente
            Optional<Task> existentTask = taskRepository.findById(id);

            if (existentTask.isPresent()) {
                //Se a porra da tarefa for encontrada
                Task taskToUpdate = existentTask.get();
                taskToUpdate.setTitle(task.getTitle());
                taskToUpdate.setDescription(task.getDescription());
                taskToUpdate.setMatter(task.getMatter());
                taskToUpdate.setCompleted(task.isCompleted());

                // Salvar a tarefa atualizada
                taskRepository.save(taskToUpdate);

                // Retornar a tarefa atualizada com o status 200 OK
                return new ResponseEntity<>(taskToUpdate, HttpStatus.OK);
            } else {
                // Caso a tarefa não seja encontrada
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Caso ocorra algum erro no processo
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteTask(Long id) {
        try {
            // Buscar a tarefa existente
            Optional<Task> existentTask = taskRepository.findById(id);

            if (existentTask.isPresent()) {
                // A tarefa foi encontrada, então a deletamos
                taskRepository.deleteById(id);

                // Retorna 204 No Content, indicando que a tarefa foi deletada com sucesso
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                // Caso a tarefa não seja encontrada
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Caso ocorra algum erro inesperado
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
