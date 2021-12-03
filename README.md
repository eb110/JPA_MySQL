The application documentation
It is the backend microservice that provides restful API's.
The purpose of the application is to manage a Movie service where users can read about films, actors and directors. Users can read, update, create and delete the feedbacks.
POM dependancies:
- junit for testing purposes
- lombok for better class handling
- springframework for springboot processes
- cucumber for cucumber testing purposes
- amazon for AWS connection purposes
- mysql for data base operations
- selenium for testing purposes
- gson for json operations

Application configuration:
  Requires git secrets for AWS connection purposes
```
cloud:
  aws:
    region:
      static: us-east-1
      auto: false
    credentials:
      access-key: ${aws_access_key}
      secret-key: ${aws_secret_key}

server:
  port: 8080
```
Connection configuration:
```
@Configuration
public class ApplicationConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource(){
        AwsSecrets secrets = getSecret();
        return DataSourceBuilder
                .create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:" + secrets.getEngine() + "://" + secrets.getHost() + ":" + secrets.getPort() + "/usersdb")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }

    private AwsSecrets getSecret() {

        String secretName = "TestingDB";
        String region = "us-east-1";

        AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();

        String secret, decodedBinarySecret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = null;

        try {
            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            throw e;
        }

        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
            return gson.fromJson(secret, AwsSecrets.class);
        }

        return null;
    }

}
```
Data-base seed template

```
@Component
public class DbInitializer implements CommandLineRunner {

    private TempRepository tempRepository;
       public DbInitializer(TempRepository tempRepositoryy){
        this.tempRepository = tempRepository;}
        
           @Override
    public void run(String... args) throws Exception {
    tempSeed();
    }
    
      private void tempSeed() {
           TempSeed tempSeed = new TempSeed();
           ...
            tempRepository.save(tempSeed);
      }
```

Controller template - its purpose is to provide api's

```
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/actor")

public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping("/add")
    public ResponseEntity<VladActor> add(@RequestBody VladActor actor){
        return new ResponseEntity<>(actorService.saveActor(actor), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<VladActor>> getAllActor(){
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<VladActor> getActor(@PathVariable("id") int id){
        return new ResponseEntity<>(actorService.getActor(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        actorService.deleteActor(id);
    }
}
```

Model template

```
@Entity
public class VladActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;

    public VladActor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public List<VladActorFeedback> getActorFeedbackList() {
        return actorFeedbackList;
    }

    public void setActorFeedbackList(List<VladActorFeedback> actorFeedbackList) {
        this.actorFeedbackList = actorFeedbackList;
    }

    public List<VladFilmActors> getFilmActorList() {
        return filmActorList;
    }

    public void setFilmActorList(List<VladFilmActors> filmActorList) {
        this.filmActorList = filmActorList;
    }

    private String nationality;
    private Timestamp dob;

    @OneToMany(targetEntity = VladActorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<VladActorFeedback> actorFeedbackList = new ArrayList<>();

    @OneToMany(targetEntity = VladFilmActors.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<VladFilmActors> filmActorList = new ArrayList<>();
    }
```

Repository template
```
public interface ActorFeedbackRepository extends CrudRepository<VladActorFeedback, Integer> {
}
```

Service - it provides the functionality for api's

Service interface template

```
public interface ActorFeedbackService {
    public VladActorFeedback saveActorFeedback(VladActorFeedback actorFeedback);
    public Iterable<VladActorFeedback> getAllActorFeedbacks();
    public VladActorFeedback getActorFeedback(int id);
    public void deleteActorFeedback(int id);
    public void updateActorFeedback(VladActorFeedback actorFeedback, int id);
}
```

Service template

```
@Service
public class ActorFeedbackServiceImpl implements ActorFeedbackService{

    @Autowired
    ActorFeedbackRepository actorFeedbackRepository;

    @Override
    public VladActorFeedback saveActorFeedback(VladActorFeedback actorFeedback) {
        return actorFeedbackRepository.save(actorFeedback);
    }

    @Override
    public Iterable<VladActorFeedback> getAllActorFeedbacks() {
        return actorFeedbackRepository.findAll();
    }

    @Override
    public VladActorFeedback getActorFeedback(int id) {
        return actorFeedbackRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteActorFeedback(int id) {
        actorFeedbackRepository.deleteById(id);
    }

    @Override
    public void updateActorFeedback(VladActorFeedback actorFeedback, int id) {
        VladActorFeedback updateFeedback = actorFeedbackRepository.findById(id).orElse(null);
        updateFeedback.setId(id);
        updateFeedback.setFeedback(actorFeedback.getFeedback());
        actorFeedbackRepository.save(updateFeedback);
    }
}
```

TESTING

CUCUMBER

Cucumber runner template

```
@RunWith( Cucumber.class )
@CucumberOptions(
        features = "src/test/resources/cucumberFeatures",
        glue = {"com.JPA.MySQL.cucumberTests"}
)

public class CucumberRunnerTest {

}
```

Cucumber step template

```
@SpringBootTest
public class ActorFeedbackSteps {

    @Autowired
    private ActorFeedbackServiceImpl actorFeedbackService;

    VladActorFeedback actorFeedback;
    String feedback;
    int totalNrOfFeedbacks;
    int lastId;
    List<VladActorFeedback> feedbackList;

    @Given("the actor feedback record from the db")
    public void the_actor_feedback_record_from_the_db() {

        actorFeedback = actorFeedbackService.getActorFeedback(1);
    }
    @When("i check its feedback")
    public void i_check_its_feedback() {
        feedback = actorFeedback.getFeedback();
    }
    @Then("the feedback length is bigger then zero")
    public void the_feedback_length_is_bigger_then_zero() {
        Assertions.assertNotEquals(0, feedback.length(), "feedback doesn't exist");
    }
    }
```

Cucumber feature template

```
Feature: Testing the actor

  Scenario: Test getById get request
    Given I have an actor id 1
    When i want to check the name
    Then I receive a "Marlon"

  Scenario: Test the actor object
    Given a new actor
    And post actor into the db
    And then get the count of all actors from db
    And get the last actor from the db
    When i compare both actors
    And they both are the same

  Scenario: Delete te actor by id
    Given the total number of actors
    When i delete the last actor
    Then the total number has to be less by 1
```

UNITY TEST

Unity test template
```
public class VladActorTest {

    VladDirector director = new VladDirector();

    @Test
    public void getId() {
        director.setId(1);
        assertEquals(1, director.getId(), "The id is not correct");
    }

    @Test
    public void setId() {
        director.setId(1);
        assertEquals(1, director.getId(), "The id is not correct");
    }
    }
```