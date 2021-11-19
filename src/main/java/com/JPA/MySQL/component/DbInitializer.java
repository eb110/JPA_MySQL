package com.JPA.MySQL.component;

import com.JPA.MySQL.model.*;
import com.JPA.MySQL.repository.*;
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
    private FilmActorsRepository filmActorsRepository;
    private ActorFeedbackRepository actorFeedbackRepository;
    private DirectorFeedbackRepository directorFeedbackRepository;
    private FilmFeedbackRepository filmFeedbackRepository;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public DbInitializer(ActorRepository actorRepository, DirectorRepository directorRepository, UserRepository userRepository,
                         FilmRepository filmRepository, FilmActorsRepository filmActorsRepository, FilmFeedbackRepository filmFeedbackRepository,
                         ActorFeedbackRepository actorFeedbackRepository, DirectorFeedbackRepository directorFeedbackRepository){
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.filmActorsRepository = filmActorsRepository;
        this.actorFeedbackRepository = actorFeedbackRepository;
        this.directorFeedbackRepository = directorFeedbackRepository;
        this.filmFeedbackRepository = filmFeedbackRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        actorSeed();
        directorSeed();
        userSeed();
        filmSeed();
        filmActorsSeed();
        actorFeedbackSeed();
        directorFeedbackSeed();
        filmFeedbackSeed();


    }

    private void filmFeedbackSeed() {
        String[] feedbacks = {"This film is great", "Top 5 on the whole world", "I like it", "I love to watch it", "Best film ever"};
        for(int i = 0; i < 5; i++){
            VladFilmFeedback vladFilmFeedback = new VladFilmFeedback();
            vladFilmFeedback.setIdUser(i+1);
            vladFilmFeedback.setIdFilm(5-i);
            vladFilmFeedback.setFeedback(feedbacks[i]);
            filmFeedbackRepository.save(vladFilmFeedback);
        }
        System.out.println("Film feedbacks seeded!");
    }

    private void directorFeedbackSeed() {
        String[] feedbacks = {"This director is such a nice person", "Top 5 on the whole world", "I like it", "I love to watch his movies", "Best director ever"};
        for(int i = 0; i < 5; i++){
            VladDirectorFeedback vladDirectorFeedback = new VladDirectorFeedback();
            vladDirectorFeedback.setIdUser(i+1);
            vladDirectorFeedback.setIdDirector(5-i);
            vladDirectorFeedback.setFeedback(feedbacks[i]);
            directorFeedbackRepository.save(vladDirectorFeedback);
        }
        System.out.println("Director feedbacks seeded!");
    }

    private void actorFeedbackSeed() {
        String[] feedbacks = {"This actor is such a nice person", "Top 5 on the whole world", "I like it", "I love to watch him", "Best actor ever"};
        for(int i = 0; i < 5; i++){
            VladActorFeedback actorFeedback = new VladActorFeedback();
            actorFeedback.setIdUser(i+1);
            actorFeedback.setIdActor(5-i);
            actorFeedback.setFeedback(feedbacks[i]);
            actorFeedbackRepository.save(actorFeedback);
        }
        System.out.println("Actor feedbacks seeded!");
    }

    private void actorSeed(){
        String[] names = {"Zenon", "Romek", "Janek", "Stefan", "Enrike"};
        String[] surname = {"Plech", "Jankowski", "Kmiecik", "Kulczak", "Wazowsky"};
        String[] nation = {"Polish", "Romanian", "Scottish", "Welsh", "French"};
        String[] dobs = {"1996/06/17", "1956/07/27", "1945/11/11", "1959/02/10", "1965/12/23"};
        for(int i = 0; i < 5; i++) {
            VladActor actor = new VladActor();
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
            VladDirector vladDirector = new VladDirector();
            vladDirector.setName(names[i]);
            vladDirector.setSurname(surname[i]);
            Date date = new Date();
            try{
                date = dateFormat.parse(dobs[i]);
            }catch (Exception e){}
            vladDirector.setDob(new Timestamp(date.getTime()));
            vladDirector.setNationality(nation[i]);
            directorRepository.save(vladDirector);
        }
        System.out.println("Directors have been seeded");
    }
    private void userSeed(){
        String[] names = {"Kyle", "eb110", "Gareth", "Andrea", "Lauren"};
        String[] surname = {"Orr", "Bugatti", "theFirst", "bestProgrammer", "bestMathematician"};
        String[] email = {"Scottish@co.uk", "wfigura@op.pl", "Scottish@yahoo.com", "Romanian@co.uk", "Scottish@wp.pl"};
        String[] pswrd = {"2000/06/17", "1978/07/17", "1983/11/11", "2000/02/10", "2000/12/23"};
        for(int i = 0; i < 5; i++) {
            VladUser user = new VladUser();
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
            VladFilm vladFilm = new VladFilm();
            vladFilm.setTitle(title[i]);
            vladFilm.setIdDirector(i + 1);
            filmRepository.save(vladFilm);
        }
        System.out.println("Films have been seeded");
    }

    private void filmActorsSeed(){

        for(int i = 0; i < 5; i++) {
            VladFilmActors vladFilmActors = new VladFilmActors();
            vladFilmActors.setIdFilm(i + 1);
            vladFilmActors.setIdActor(5 - i);
            filmActorsRepository.save(vladFilmActors);
        }
        System.out.println("Film actors have been seeded");
    }
}