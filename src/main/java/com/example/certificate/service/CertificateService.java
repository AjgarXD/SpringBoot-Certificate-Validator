package com.example.certificate.service;

import com.example.certificate.entity.Certificate;
import com.example.certificate.repository.CertificateRepository;
import com.example.certificate.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    private final CertificateRepository repository;

    public CertificateService(CertificateRepository repository) {
        this.repository = repository;
    }

    public Certificate issueCertificate(Certificate cert) {
        return repository.save(cert);
    }

    public Certificate verifyCertificate(String certId) {
        return repository.findByCertificateId(certId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Certificate ID"));
    }
}