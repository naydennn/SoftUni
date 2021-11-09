package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.mapping.OrderMapper;
import bg.softuni.hateoas.service.OrderService;
import bg.softuni.hateoas.service.StudentService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentService studentService;
    private final OrderService orderService;

    public StudentsController(StudentService studentService, OrderService orderService) {
        this.studentService = studentService;
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>> getStudents() {
        List<StudentDTO> allStudents = studentService.getAllStudents();

        List<EntityModel<StudentDTO>> result = allStudents.stream().
                map(dto -> EntityModel.of(dto, createStudentLinks(dto))).
                collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(result));
    }

    @GetMapping("/{studentId}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDTO>>> getAllOrders(@PathVariable("studentId") Long studentId) {

        List<EntityModel<OrderDTO>> orders = orderService.getOrders(studentId).stream().
                map(EntityModel::of)
                .collect(Collectors.toList());


        return ResponseEntity.ok(CollectionModel.of(orders));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> getStudentById(@PathVariable("id") Long id) {

        StudentDTO student = studentService.findById(id);

        return ResponseEntity.ok(EntityModel.of(student, createStudentLinks(student)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> update(@PathVariable("id") Long id, StudentDTO studentDTO) {
        return ResponseEntity.ok().build();
    }

    private Link[] createStudentLinks(StudentDTO studentDTO) {
        List<Link> links = new ArrayList<>();

        Link selfLink = linkTo(methodOn(StudentsController.class).
                getStudentById(studentDTO.getId())).
                withSelfRel();

        links.add(selfLink);

        Link updateLink = linkTo(methodOn(StudentsController.class).
                update(studentDTO.getId(), studentDTO)).
                withRel("update");

        links.add(updateLink);

        Link ordersLink = linkTo(methodOn(StudentsController.class).
                getAllOrders(studentDTO.getId())).
                withRel("orders");

        links.add(ordersLink);

        return links.toArray(new Link[0]);
    }
}
