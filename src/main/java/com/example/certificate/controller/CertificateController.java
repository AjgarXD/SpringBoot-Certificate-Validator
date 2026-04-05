package com.example.certificate.controller;

import com.example.certificate.entity.Certificate;
import com.example.certificate.service.CertificateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @PostMapping("/issue")
    public Certificate issueCertificate(@RequestBody Certificate cert) {
        return service.issueCertificate(cert);
    }

    @GetMapping("/verify/{id}")
    public Certificate verifyCertificate(@PathVariable String id) {
        return service.verifyCertificate(id);
    }
}