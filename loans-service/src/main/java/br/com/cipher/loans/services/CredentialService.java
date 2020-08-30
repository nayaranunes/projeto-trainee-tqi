package br.com.cipher.loans.services;

import br.com.cipher.loans.entities.Credential;
import br.com.cipher.loans.entities.Login;
import br.com.cipher.loans.entities.enums.DocumentType;
import br.com.cipher.loans.error.RequestException;
import br.com.cipher.loans.repositories.CredentialRepository;
import br.com.cipher.loans.requests.CredentialRequest;
import br.com.cipher.loans.responses.CredentialResponse;
import br.com.cipher.loans.validators.CnpjValidator;
import br.com.cipher.loans.validators.ContactValidator;
import br.com.cipher.loans.validators.CpfValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class CredentialService {

    private final CredentialRepository credentialRepository;
    private final LoginService loginService;

    @Autowired
    public CredentialService(CredentialRepository credentialRepository, LoginService loginService) {
        this.credentialRepository = credentialRepository;
        this.loginService = loginService;
    }

    public CredentialResponse create(CredentialRequest credentialRequest) {

        credentialRequest.setDocument(rebuild(credentialRequest.getDocument()));
        credentialRequest.setPhone(rebuild(credentialRequest.getPhone()));
        ContactValidator.email(credentialRequest.getEmail());
        ContactValidator.phone(credentialRequest.getPhone());

        if (credentialRequest.getDocumentType() == DocumentType.CNPJ) {
            CnpjValidator.isCnpj(credentialRequest.getDocument());
        }

        if (credentialRequest.getDocumentType() == DocumentType.CPF) {
            CpfValidator.isCpf(credentialRequest.getDocument());
        }

        if (loginService.getLogin(credentialRequest.getUsername(), credentialRequest.getEmail()).isPresent()) {
            throw new RequestException("Login already exists. Try to recover your password!");
        }

        if (credentialRepository.getByDocument(credentialRequest.getDocument()).isPresent()) {
            throw new RequestException("Client already exists. Ops, you are not strange to me!");
        }

        return this.createCredential(credentialRequest);
    }

    private static String rebuild(String string) {

        string = string.replace("-","");
        string = string.replace("(","");
        string = string.replace(")","");
        string = string.replace(" ","");
        string = string.replace(" ","");
        string = string.replace(".","");
        string = string.replace("-","");
        string = string.replace("/","");

        return string;
    }

    private CredentialResponse createCredential(CredentialRequest credentialRequest) {

        Credential credential = new Credential(
                credentialRequest.getName(),
                credentialRequest.getDocument(),
                credentialRequest.getDocumentType(),
                credentialRequest.getIncome(),
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

        login.setCredentialId(credential.getId());
        loginService.create(login);

        return new ModelMapper().map(credential, CredentialResponse.class);

    }

    public Credential getByDocument(String document) {

        Optional<Credential> credential = credentialRepository.findByDocument(rebuild(document));
        if (!credential.isPresent()) {
            throw new RequestException("Document is incorrect!");
        }
        return credential.get();
    }

    public void setScorePoints(Credential credential, Double scorePoints) {
        if (scorePoints < 0 && scorePoints > 1000) throw new RequestException("Score point is invalid!");
        credential.setScorePoints(scorePoints);
        this.credentialRepository.save(credential);
    }

    public Credential getById(Long credentialId) {

        Optional<Credential> credential = this.credentialRepository.findById(credentialId);
        if (!credential.isPresent()) throw new RequestException("Credential not found!");
        return credential.get();
    }

    public CredentialResponse getByCredentialId(Long id) {
        return new ModelMapper().map(this.getById(id), CredentialResponse.class);
    }

}
