package com.JPA.MySQL.component;

import com.JPA.MySQL.model.Actor;
import com.JPA.MySQL.model.Director;
import com.JPA.MySQL.model.Film;
import com.JPA.MySQL.model.User;
import com.JPA.MySQL.repository.ActorRepository;
import com.JPA.MySQL.repository.DirectorRepository;
import com.JPA.MySQL.repository.FilmRepository;
import com.JPA.MySQL.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DbInitializer implements CommandLineRunner {

    private ActorRepository actorRepository;
    private DirectorRepository directorRepository;
    private UserRepository userRepository;
    private FilmRepository filmRepository;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public DbInitializer(ActorRepository actorRepository, DirectorRepository directorRepository, UserRepository userRepository,
                         FilmRepository filmRepository){
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        actorSeed();
        directorSeed();
        userSeed();
        filmSeed();
    }

    private void actorSeed(){
        String[] names = {"Zenon", "Romek", "Janek", "Stefan", "Enrike"};
        String[] surname = {"Plech", "Jankowski", "Kmiecik", "Kulczak", "Wazowsky"};
        String[] nation = {"Polish", "Romanian", "Scottish", "Welsh", "French"};
        String[] dobs = {"1996/06/17", "1956/07/27", "1945/11/11", "1959/02/10", "1965/12/23"};
        for(int i = 0; i < 5; i++) {
            Actor actor = new Actor();
            actor.setName(names[i]);
            actor.setSurname(surname[i]);
            Date date = new Date();
            try{
                date = dateFormat.parse(dobs[i]);
            }catch (Exception e){}
            actor.setDob(new Timestamp(date.getTime()));
            actor.setNationality(nation[i]);
            actorRepository.save(actor);
        }
        System.out.println("Actors have been seeded");
    }

    private void directorSeed(){
        String[] names = {"Franc", "Laszlo", "Jurgen", "Hole", "Eustachy"};
        String[] surname = {"Mauer", "Body", "Klinsman", "Maczupikczu", "Rozenstein"};
        String[] nation = {"Polish", "Romanian", "Scottish", "Welsh", "French"};
        String[] dobs = {"1996/06/17", "1956/07/27", "1945/11/11", "1959/02/10", "1965/12/23"};
        for(int i = 0; i < 5; i++) {
            Director director = new Director();
            director.setName(names[i]);
            director.setSurname(surname[i]);
            Date date = new Date();
            try{
                date = dateFormat.parse(dobs[i]);
            }catch (Exception e){}
            director.setDob(new Timestamp(date.getTime()));
            director.setNationality(nation[i]);
            directorRepository.save(director);
        }
        System.out.println("Directors have been seeded");
    }
    private void userSeed(){
        String[] names = {"Kyle", "eb110", "Gareth", "Andrea", "Lauren"};
        String[] surname = {"Orr", "Bugatti", "theFirst", "bestProgrammer", "bestMathematician"};
        String[] email = {"Scottish@co.uk", "wfigura@op.pl", "Scottish@yahoo.com", "Romanian@co.uk", "Scottish@wp.pl"};
        String[] pswrd = {"2000/06/17", "1978/07/17", "1983/11/11", "2000/02/10", "2000/12/23"};
        for(int i = 0; i < 5; i++) {
            User user = new User();
            user.setName(names[i]);
            user.setSurname(surname[i]);
            user.setEmail(email[i]);
            user.setEncryptedPassword(pswrd[i]);
            userRepository.save(user);
        }
        System.out.println("Users have been seeded");
    }
    private void filmSeed(){
        String[] title = {"KyleTitle", "eb110Title", "GarethTitle", "AndreaTitle", "LaurenTitle"};

        for(int i = 0; i < 5; i++) {
            Film film = new Film();
            film.setTitle(title[i]);
            film.setIdDirector(i + 1);
            filmRepository.save(film);
        }
        System.out.println("Films have been seeded");
    }
}
