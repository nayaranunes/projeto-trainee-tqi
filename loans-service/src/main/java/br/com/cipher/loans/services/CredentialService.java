package br.com.cipher.loans.services;

import br.com.cipher.loans.entities.Credential;
import br.com.cipher.loans.entities.Login;
import br.com.cipher.loans.entities.enums.DocumentType;
import br.com.cipher.loans.error.RequestException;
import br.com.cipher.loans.repositories.CredentialRepository;
import br.com.cipher.loans.requests.CredentialRequest;
import br.com.cipher.loans.responses.CredentialResponse;
import br.com.cipher.loans.validators.CnpjValidator;
import br.com.cipher.loans.validators.CpfValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Component
public class CredentialService {

    private final CredentialRepository credentialRepository;
    private final LoginService loginService;

    @Autowired
    public CredentialService(CredentialRepository credentialRepository, LoginService loginService) {
        this.credentialRepository = credentialRepository;
        this.loginService = loginService;
    }

    public CredentialResponse execute(CredentialRequest credentialRequest) {

        if (credentialRequest.getDocumentType() == DocumentType.CNPJ
                && !(CnpjValidator.isCnpj(credentialRequest.getDocument()))) {
            throw new RequestException("Invalid CNPJ. Try to check your request");
        }

        if (credentialRequest.getDocumentType() == DocumentType.CPF
                && !(CpfValidator.isCpf(credentialRequest.getDocument()))) {
            throw new RequestException("Invalid CPF. Try to check your request");
        }

        if (loginService.getLogin(credentialRequest.getUsername(), credentialRequest.getEmail()).isPresent()) {
            throw new RequestException("Login already exists. Try to recover your password");
        }

        if (credentialRepository.getByDocument(credentialRequest.getDocument()).isPresent()) {
            throw new RequestException("Client already exists. Ops, you are not strange to me!");
        }

        return this.createCredential(credentialRequest);
    }

    private CredentialResponse createCredential(CredentialRequest credentialRequest) {

        Credential credential = new Credential(
                credentialRequest.getName(),
                credentialRequest.getDocument(),
                credentialRequest.getDocumentType(),
                credentialRequest.getScorePoints(),
                credentialRequest.getBirthday(),
                credentialRequest.getPhone(),
                LocalDateTime.now()
        );

        credential = credentialRepository.save(credential);

        Login login = new Login(
                credentialRequest.getUsername(),
                credentialRequest.getEmail(),
                credential,
                true,
                credentialRequest.getPassword()
        );

        loginService.create(login);

        return new ModelMapper().map(credential, CredentialResponse.class);

    }
}
