package G10.EQUIPO13.MediFlow.Documentos.controller;


import G10.EQUIPO13.MediFlow.Documentos.DocumentosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/documentos")
public class DocumentosController {

    private final DocumentosService documentosService;


    @PostMapping("/analyze/text")
    public DocumentosResponse analyzeText(@RequestBody DocumentosRequest documentosRequest){

        return documentosService.analizeText(documentosRequest);

    }

}
