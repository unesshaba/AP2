package com.example.activitep2;

import com.example.activitep2.entities.Patient;
import com.example.activitep2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ActiviteP2Application implements CommandLineRunner {

    @Autowired
    PatientRepository   patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(ActiviteP2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0;i<100;i++){
        patientRepository.save(new Patient(null,"youness",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));}
//        patientRepository.save(new Patient(null,"karim",new Date(),true,66));
//        patientRepository.save(new Patient(null,"mediouni",new Date(),false,46));

//        List<Patient> patients=patientRepository.findAll();
        Page<Patient> patients=patientRepository.findAll(PageRequest.of(0,10));
        System.out.println("Toltal de page "+patients.getTotalPages());
        System.out.println("Total d'element "+patients.getTotalElements());
        System.out.println("le nombre de la page "+patients.getNumber());
        patients.getTotalPages();
        patients.getTotalElements();
//        List<Patient>byMalade=patientRepository.findByMalade(false);
        Page<Patient>byMalade=patientRepository.findByMalade(false,PageRequest.of(0,4));
        List<Patient> listPatient=patientRepository.chercherPatient(50);
        listPatient.forEach(p->{
            System.out.println("=====================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.getMalade());

        });
        byMalade.forEach(p->{
            System.out.println("=====================");
            System.out.println(p.getId());
          System.out.println(p.getNom());
          System.out.println(p.getScore());
          System.out.println(p.getDateNaissance());
          System.out.println(p.getMalade());
        });
//        List<Patient>content =patients.getContent();
//        patients.forEach(p->{
//        content.forEach(p->{
//            System.out.println("=====================");
//          System.out.println(p.getId());
//          System.out.println(p.getNom());
//          System.out.println(p.getScore());
//          System.out.println(p.getDateNaissance());
//          System.out.println(p.getMalade());

//        });
        System.out.println("***************");
//        Patient patient =patientRepository.findById(1L).orElse(null);
//        if (patient !=null){
//            System.out.println(patient.getNom());
//            System.out.println(patient.getMalade());
//        }
//        patient.setScore(50);
//        patientRepository.save(patient);
    }
}
