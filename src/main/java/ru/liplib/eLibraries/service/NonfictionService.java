package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.model.NonfictionAcc;
import ru.liplib.eLibraries.repository.NonfictionRepository;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;

@Service
public class NonfictionService {
    @Autowired
    private NonfictionRepository nonfictionRepository;

    public NonfictionAcc save(NonfictionAcc account) {
        NonfictionAcc acc = nonfictionRepository.findByLogin(account.getLogin());
        if (acc == null) {
            account.setEnc_pass(encrypt(account.getPassword()));
            return nonfictionRepository.save(account);
        } else {
            acc.setEnc_pass(encrypt(account.getPassword()));
            return nonfictionRepository.save(acc);
        }
    }

    public NonfictionAcc giveNonfiction(int filial) {
        List<NonfictionAcc> nonfictionAccs = nonfictionRepository.findByIssuedFalseAndValidTrue();

        if (nonfictionAccs == null || nonfictionAccs.size() == 0) {
            return null;
        } else {
            NonfictionAcc acc = nonfictionAccs.get(0);
            acc.setFilial(filial);
            acc.setDateOfIssue(new Date(new java.util.Date().getTime()));
            acc.setIssued(true);

            nonfictionRepository.save(acc);

            return acc;
        }
    }

    public NonfictionAcc getById(Long id) {
        NonfictionAcc acc = nonfictionRepository.findById(id).get();

        return acc;
    }

    public long findByLogin(String login) {
        return nonfictionRepository.findByLogin(login).getId();
    }

    public void encryptAllAccs() {
        List<NonfictionAcc> accList = (List) nonfictionRepository.findAll();

        accList.forEach(NonfictionAcc -> {NonfictionAcc.setEnc_pass(encrypt(NonfictionAcc.getPassword()));
            nonfictionRepository.save(NonfictionAcc);});
    }

    private byte[] encrypt(String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec("p8mncs54f4a9aas6".getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(password.getBytes());
        } catch (NoSuchAlgorithmException e) {

        } catch (NoSuchPaddingException e) {

        } catch (BadPaddingException e) {

        } catch (IllegalBlockSizeException e) {

        } catch (InvalidKeyException e) {

        }

        return null;
    }

    public String decrypt(byte[] pass) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec("p8mncs54f4a9aas6".getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            return new String(cipher.doFinal(pass));
        } catch (NoSuchAlgorithmException e) {

        } catch (NoSuchPaddingException e) {

        } catch (BadPaddingException e) {

        } catch (IllegalBlockSizeException e) {

        } catch (InvalidKeyException e) {

        }

        return null;
    }
}
