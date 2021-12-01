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

/*
        actorSeed();
        directorSeed();
        userSeed();
        filmSeed();
        filmActorsSeed();
        actorFeedbackSeed();
        directorFeedbackSeed();
        filmFeedbackSeed();
*/

    }

    private void filmFeedbackSeed() {
        String[] feedbacks = {"The Godfather is quite simply a masterful piece of film-making",
                "Shawshank is enthralling, fantastic, intriguing, truly remarkable!",
                "The Dark Knight: The Greatest Superhero Film Ever Made",
                "There's nothing fictional about this movie's high quality.",
                "Possibly the dumbest movie I've seen. Not scary at all."};
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
        String[] feedbacks = {"The story by Francis Ford Coppola is a brilliant conjuring act",
                "There’s not much more that can be said about Frank Darabont’s astonishing 1994 masterpiece",
                "Nolan cements his position as Hollywood's premier purveyor of blockbuster smarts", "All in all, director Quentin Tarantino created a real masterpiece here.",
                "Classic! Incredible work by Stanley Kubrick!"};
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
        String[] feedbacks = {"Marlon Brando gives a great performance as Don Vito Corleone", "This is Tim Robbins' best role",
                "Bale, will most likely be remembered as the greatest dark knight ever to stalk the rooftops of Gotham City.",
                "John Travolta in his best role (relaunching his dead career)", "This is one of Jack Nicholson's finest roles"};
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
        String[] names = {"Marlon", "Tim", "Christian", "John", "Jack"};
        String[] surname = {"Brando", "Robbins", "Bale", "Travolta", "Nicholson"};
        String[] nation = {"American", "American", "English", "American", "American"};
        String[] dobs = {"1924/04/03", "1958/10/16", "1974/01/30", "1954/02/18", "1937/04/22"};
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
        String[] names = {"Francis", "Frank", "Christopher", "Quentin", "Stanley"};
        String[] surname = {"Coppola", "Darabont", "Nolan", "Tarantino", "Kubrick"};
        String[] nation = {"American", "French", "English", "American", "American"};
        String[] dobs = {"1939/04/07", "1959/01/28", "1970/07/30", "1963/03/27", "1928/07/26"};
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
        String[] email = {"Scottish@co.uk", "wfigura@op.pl", "Scottish@yahoo.com", "Romanian@co.uk", "Scottish@wp.pl"};
        String[] pswrd = {"2000/06/17", "1978/07/17", "1983/11/11", "2000/02/10", "2000/12/23"};
        for(int i = 0; i < 5; i++) {
            VladUser user = new VladUser();
            user.setUserName(names[i]);
            user.setEmail(email[i]);
            user.setPassword(pswrd[i]);
            userRepository.save(user);
        }
        System.out.println("Users have been seeded");
    }
    private void filmSeed(){
        String[] title = {"The Godfather", "The Shawshank Redemption", "The Dark Knight", "Pulp Fiction", "The Shining"};
        String[] description ={"The Godfather follows Vito Corleone Don of the Corleone family as he passes the mantel to his son Michael.",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                "A family heads to an isolated hotel for the winter where a sinister presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future."};
        String[] length ={"2 hours 55 minutes", "2 hours 22 minutes", "2 hours 32 minutes", "2 hours 34 minutes", "2 hours 26 minutes"};
      //  int[] release_year = {1972, 1994, 2008, 1994, 1980};
        String[] rating ={"18", "15", "12", "18", "15"};


        for(int i = 0; i < 5; i++) {
            VladFilm vladFilm = new VladFilm();
            vladFilm.setTitle(title[i]);
            vladFilm.setIdDirector(i + 1);
            vladFilm.setDescription(description[i]);
            vladFilm.setLength(length[i]);
            vladFilm.setRating(rating[i]);
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