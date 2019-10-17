package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.model.LitresAcc;
import ru.liplib.eLibraries.repository.LitresRepository;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class LitresService {
    @Autowired
    private LitresRepository litresRepository;

    public LitresAcc save(LitresAcc account) {
        LitresAcc acc = litresRepository.findByLogin(account.getLogin());
        if (acc == null) {
            account.setEnc_pass(encrypt(account.getPassword()));
            return litresRepository.save(account);
        } else {
            acc.setEnc_pass(encrypt(account.getPassword()));
            return litresRepository.save(acc);
        }
    }

    public LitresAcc giveLitres(int filial) {
        List<LitresAcc> litresAccs = litresRepository.findByIssuedFalseAndValidTrue();

        if (litresAccs == null || litresAccs.size() == 0) {
            return null;
        } else {
            LitresAcc acc = litresAccs.get(0);
            acc.setFilial(filial);
            acc.setDateOfIssue(new Date(new java.util.Date().getTime()));
            acc.setIssued(true);

            litresRepository.save(acc);

            return acc;
        }
    }

    public LitresAcc getById(Long id) {
        LitresAcc acc = litresRepository.findById(id).get();

        return acc;
    }

    public LitresAcc findByLogin(String login) {
        return litresRepository.findByLogin(login);
    }

    public void encryptAllAccs() {
        List<LitresAcc> accList = (List) litresRepository.findAll();

        accList.forEach(litresAcc -> {litresAcc.setEnc_pass(encrypt(litresAcc.getPassword()));
        litresRepository.save(litresAcc);});
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
