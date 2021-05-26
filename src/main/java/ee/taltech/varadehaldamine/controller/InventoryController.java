package ee.taltech.varadehaldamine.controller;

import ee.taltech.varadehaldamine.model.Person;
import ee.taltech.varadehaldamine.service.InventoryService;
import ee.taltech.varadehaldamine.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("inventory")
@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PersonService personService;

    @PreAuthorize("hasRole('ROLE_ÜksuseJuht')")
    @PostMapping
    public ResponseEntity<Object> createInventory() {
        Person person = personService.getCurrentUser();
        List<String> authorities = personService.getAuthorities();
        if (inventoryService.createInventory(authorities, person.getId()) != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @PreAuthorize("hasRole('ROLE_ÜksuseJuht')")
    @PutMapping("/{inventoryId}")
    public ResponseEntity<Object> endInventory(@PathVariable Long inventoryId) {
        if (inventoryService.endInventory(inventoryId) != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
