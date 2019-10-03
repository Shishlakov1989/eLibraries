package ru.liplib.eLibraries.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncryptionConfig {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}

/*$2a$08$DBv.hvTZ5bgKmrxxtOXn9enZ8.vAk4ikYWgVkJaXTLiM1eTvZbRMC
$2a$08$HklNNXZggLcueEqaIYOFSee5oOth2XU16sHamgjNC/X8PgEbOUEEC
$2a$08$cQtTAzkTfYytVQcOOcG.I.wHx5CQMMnQDrkmr2u1A8DZkxDUuP1DK
$2a$08$VV838IJUUqUhR2LABDFGWeSBoNliNrwSY/aSjNkdrvZ.rM8NpMr/q
$2a$08$QL804P5WQCNSIOE2ncP3jOkliBddolKdf5GahruKgMCcr2tlxvIZ2
$2a$08$C3z7z16mG4tGk.PtU7ZApezJWwR72ao0ftgAzyolPBuU0VVqhAIzW
$2a$08$s3ORN.vUU/hVCKsdh0dC9OA78osjFbkyYbnPRNPkz2hP6M3g/Zsw2*/