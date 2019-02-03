package net.andy.customer.controllers;

import net.andy.customer.entities.Customer;
import net.andy.customer.entities.Note;
import net.andy.customer.entities.Status;
import net.andy.customer.repository.CustomerRepository;
import net.andy.customer.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/api/customers/{customerId}", method = RequestMethod.GET)
    public Customer get(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.orElse(null);
    }

    @RequestMapping(value = "/api/customers", method = RequestMethod.POST)
    public Customer create(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        Customer result =  customerRepository.save(customer);
        return result;
    }

    @RequestMapping(value = "/api/customers/{customerId}", method = RequestMethod.PUT)
    public Customer updateStatus(@PathVariable Long customerId, @RequestParam String status) {
        Customer customer = customerRepository.getOne(customerId);
        Status newStatus = Status.valueOf(status);
        customer.setStatus(newStatus);
        Customer result =  customerRepository.save(customer);
        return result;
    }

    @RequestMapping(value = "/api/customers/{customerId}/notes", method = RequestMethod.GET)
    public List<Note> listCustomerNote(@PathVariable Long customerId) {
        return noteRepository.findByCustomerId(customerId);
    }

    @RequestMapping(value = "/api/customers/{customerId}/notes/{noteId}", method = RequestMethod.GET)
    public Note getCustomerNote(@PathVariable Long customerId, @PathVariable Long noteId) {
        Note note = noteRepository.getOne(noteId);
        return note;
    }

    @RequestMapping(value = "/api/customers/{customerId}/notes", method = RequestMethod.POST)
    public Note createCustomerNote(@PathVariable Long customerId, @RequestParam String noteString) {
        Note note = new Note(customerId);
        note.setNote(noteString);
        Note result = noteRepository.save(note);
        return result;
    }

    @RequestMapping(value = "/api/customers/{customerId}/notes/{noteId}", method = RequestMethod.PUT)
    public Note updateCustomerNote(@PathVariable Long customerId, @PathVariable Long noteId, @RequestParam String newNote) {
        Optional<Note> note = noteRepository.findById(noteId);

        note.ifPresent((n) -> {
            n.setNote(newNote);
            noteRepository.save(n);
        });

        Optional<Note> updatedNote = noteRepository.findById(noteId);
        return updatedNote.orElse(null);
    }


}
