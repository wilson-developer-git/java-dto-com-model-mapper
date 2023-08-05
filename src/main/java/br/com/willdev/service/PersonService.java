package br.com.willdev.service;

import br.com.willdev.model.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {
    public List<Person> findAll() {
        return getlist();
    }

    public Person findById(Long id) {
        Person personResponse = null;
        for (Person p : getlist()) {
            if (p.getId() == id) {
                personResponse = p;
            }
        }
        return personResponse;
    }

    private List<Person> getlist() {
        var p1 = new Person(1L, "Jose da Silva", "45784554796", "jose@gmail.com", "753963");
        var p2 = new Person(2L, "Maria de Lourdes", "47856932587", "maria@gmail.com", "159852");
        var p3 = new Person(3L, "Antonio Fagundes", "36995125875", "antonio@gmail.com", "147852");
        var p4 = new Person(4L, "Franscisco Cuoco", "75369875214", "franscisco@gmail.com", "369852");
        var p5 = new Person(5L, "Jose de Abreu", "74125896332", "josefa@gmail.com", "789654");
        return Arrays.asList(p1, p2, p3, p4, p5);
    }

}