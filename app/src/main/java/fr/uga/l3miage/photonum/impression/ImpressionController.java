package fr.uga.l3miage.photonum.impression;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.service.ImpressionService;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ImpressionController {

    private final ImpressionService imprService;
    private final ImpressionMapper imprMapper;

    @Autowired
    public ImpressionController(ImpressionService imprService, ImpressionMapper imprMapper) {
        this.imprService = imprService;
        this.imprMapper = imprMapper;
    }

    @GetMapping("/impressions")
    public Collection<ImpressionDTO> impressions(@RequestParam(value = "q", required = false) String query) {
        return null;
    }
}
