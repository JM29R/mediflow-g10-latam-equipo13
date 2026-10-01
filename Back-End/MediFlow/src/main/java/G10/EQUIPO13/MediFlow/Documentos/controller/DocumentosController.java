package G10.EQUIPO13.MediFlow.Documentos.controller;


import G10.EQUIPO13.MediFlow.Documentos.Service.DocumentosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/documentos")
public class DocumentosController {

    private final DocumentosService documentosService;


    @PreAuthorize("hasRole('ADMIN', 'PERSONAL' , 'AUDITOR')")
    @PostMapping("/analyze/text")
    public DocumentosResponse analyzeText(@RequestBody DocumentosRequest documentosRequest){

        return documentosService.analizeText(documentosRequest);

    }

    @PreAuthorize("hasRole('ADMIN', 'PERSONAL' , 'AUDITOR')")
    @GetMapping("/findall")
    public ResponseEntity<List<DocumentosResponse>> findAll(){

        return ResponseEntity.ok(documentosService.findall());
    }

    @PreAuthorize("hasRole('ADMIN', 'PERSONAL' , 'AUDITOR')")
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<DocumentosResponse> findById(@PathVariable Long id){

        return ResponseEntity.ok(documentosService.findById(id));

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        documentosService.deleteById(id);
        return ResponseEntity.ok().build();

    }



}
