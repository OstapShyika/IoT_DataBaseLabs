package com.iot.sec_yr.iot_jdbc_templete.view;

import com.iot.sec_yr.iot_jdbc_templete.controller.*;
import com.iot.sec_yr.iot_jdbc_templete.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class View {

    @Autowired
    private CountryControler countryControler;

    @Autowired
    private OwnerControler ownerControler;

    @Autowired
    private PlaceControler placeControler;

    @Autowired
    private ReviewControler reviewControler;

    @Autowired
    private TransportControler transportControler;

    @Autowired
    private TripControler tripControler;

    @Autowired
    private UserControler userControler;

    private final Map<String, String> menu;

    private final Map<String, Printable> methodsMenu;

    private final Scanner input = new Scanner(System.in);
    private final Country nullCountry =
            new Country(null, null, null);
    private final Owner nullOwner =
            new Owner(null, null, null);
    private final Place nullPlace = new Place(null, null, null, null);
    private final Review nullReview =
            new Review(null, null, null, null, null);
    private final Transport nullTransport = new Transport(null, null, null, null);
    private final Trip nullTrip = new Trip(null, null, null);
    private final User nullUser = new User(null, null, null);

    public View(){
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all tables");

        menu.put("1", "   1 - Table: Country");
        menu.put("11", "  11 - Create Country");
        menu.put("12", "  12 - Update Country");
        menu.put("13", "  13 - Delete from Country");
        menu.put("14", "  14 - Find all Countries");
        menu.put("15", "  15 - Find Countries by id");

        menu.put("2", "   2 - Table: Review");
        menu.put("21", "  21 - Create Review");
        menu.put("22", "  22 - Update Review");
        menu.put("23", "  23 - Delete from Review");
        menu.put("24", "  24 - Find all Reviews");
        menu.put("25", "  25 - Find Review by ID");
        menu.put("26", "  26 - Find Reviews by rating");

        menu.put("3", "   3 - Table: Owner");
        menu.put("31", "  31 - Create Owner");
        menu.put("32", "  32 - Update Owner");
        menu.put("33", "  33 - Delete from Owner");
        menu.put("34", "  34 - Find all Owners");
        menu.put("35", "  35 - Find Owner by ID");

        menu.put("4", "   4 - Table: Place");
        menu.put("41", "  41 - Create Place");
        menu.put("42", "  42 - Update Place");
        menu.put("43", "  43 - Delete from Place");
        menu.put("44", "  44 - Find all Places");
        menu.put("45", "  45 - Find Place by ID");

        menu.put("5", "   5 - Table: Transport");
        menu.put("51", "  51 - Create Transport");
        menu.put("52", "  52 - Update Transport");
        menu.put("53", "  53 - Delete from Transport");
        menu.put("54", "  54 - Find all Transport");
        menu.put("55", "  55 - Find Transport by ID");

        menu.put("6", "   6 - Table: Trip");
        menu.put("61", "  61 - Create Trip");
        menu.put("62", "  62 - Update Trip");
        menu.put("63", "  63 - Delete from Trip");
        menu.put("64", "  64 - Find all Trip");
        menu.put("65", "  65 - Find Trip by ID");

        menu.put("7", "   7 - Table: User");
        menu.put("71", "  71 - Create User");
        menu.put("72", "  72 - Update User");
        menu.put("73", "  73 - Delete from User");
        menu.put("74", "  74 - Find all Users");
        menu.put("75", "  75 - Find Users by ID");
        menu.put("76", "  76 - Find Users by rating");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAll);

        methodsMenu.put("11", this::createCountry);
        methodsMenu.put("12", this::updateCountry);
        methodsMenu.put("13", this::deleteFromCountry);
        methodsMenu.put("14", this::findAllCountries);
        methodsMenu.put("15", this::findCountryById);

        methodsMenu.put("21", this::createReview);
        methodsMenu.put("22", this::updateReview);
        methodsMenu.put("23", this::deleteFromReview);
        methodsMenu.put("24", this::findAllReview);
        methodsMenu.put("25", this::findReviewById);
        methodsMenu.put("26", this::findReviewByRating);

        methodsMenu.put("31", this::createOwner);
        methodsMenu.put("32", this::updateOwner);
        methodsMenu.put("33", this::deleteFromOwner);
        methodsMenu.put("34", this::findAllOwner);
        methodsMenu.put("35", this::findOwnerById);

        methodsMenu.put("41", this::createPlace);
        methodsMenu.put("42", this::updatePlace);
        methodsMenu.put("43", this::deleteFromPlace);
        methodsMenu.put("44", this::findAllPlace);
        methodsMenu.put("45", this::findPlaceById);

        methodsMenu.put("51", this::createTransport);
        methodsMenu.put("52", this::updateTransport);
        methodsMenu.put("53", this::deleteFromTransport);
        methodsMenu.put("54", this::findAllTransport);
        methodsMenu.put("55", this::findTransportById);

        methodsMenu.put("61", this::createTrip);
        methodsMenu.put("62", this::updateTrip);
        methodsMenu.put("63", this::deleteFromTrip);
        methodsMenu.put("64", this::findAllTrip);
        methodsMenu.put("65", this::findTripById);

        methodsMenu.put("71", this::createUser);
        methodsMenu.put("72", this::updateUser);
        methodsMenu.put("73", this::deleteFromUser);
        methodsMenu.put("74", this::findAllUser);
        methodsMenu.put("75", this::findUserById);
    }

    private void createCountry() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();
        Country country =
                new Country(null, name, description);
        System.out.printf("There are created %d rows\n", countryControler.create(country));
    }

    private void updateCountry() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();
        Country country =
                new Country(null, name, description);
        System.out.printf("There are created %d rows\n", countryControler.update(id, country));
    }

    private void deleteFromCountry() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",countryControler.delete(id));
    }

    private void findAllCountries() {
        List<Country> countries = countryControler.findAll();
        for (Country country : countries) {
            System.out.println(country);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findCountryById() {
        System.out.println("Enter 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Country> country = countryControler.findById(id);
        System.out.println(country.orElse(nullCountry));
    }

    private void createReview() {
        System.out.println("Enter rating:");
        Integer rating = Integer.valueOf(input.nextLine());
        System.out.println("Enter description:");
        String description = input.nextLine();
        System.out.println("Enter user id:");
        Integer user_id = Integer.valueOf(input.nextLine());
        System.out.println("Enter place id:");
        Integer place_id = Integer.valueOf(input.nextLine());
        Review review =
                new Review(null, rating, description, user_id, place_id);
        System.out.printf("There are created %d rows\n", reviewControler.create(review));
    }

    private void updateReview() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter rating:");
        Integer rating = Integer.valueOf(input.nextLine());
        System.out.println("Enter description:");
        String description = input.nextLine();
        System.out.println("Enter user id:");
        Integer user_id = Integer.valueOf(input.nextLine());
        System.out.println("Enter place id:");
        Integer place_id = Integer.valueOf(input.nextLine());
        Review review =
                new Review(null, rating, description, user_id, place_id);
        System.out.printf("There are updated %d rows\n", reviewControler.update(id, review));
    }

    private void deleteFromReview() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",reviewControler.delete(id));
    }

    private void findAllReview() {
        List<Review> reviews = reviewControler.findAll();
        for (Review review : reviews) {
            System.out.println(review);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findReviewById() {
        System.out.println("Enter id: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Review> review = reviewControler.findById(id);
        System.out.println(review.orElse(nullReview));
    }

    private void findReviewByRating() {
        System.out.println("Enter rating: ");
        Integer rating = Integer.valueOf((input.nextLine()));
        Optional<List<Review>> review = reviewControler.getReviewsByRating(rating);
        System.out.println(review.orElse(null));
    }

    private void createOwner() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        Owner owner =
                new Owner(null, name, surname);
        System.out.printf("There are created %d rows\n", ownerControler.create(owner));
    }

    private void updateOwner() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        Owner owner =
                new Owner(null, name, surname);
        System.out.printf("There are created %d rows\n", ownerControler.update(id, owner));
    }

    private void deleteFromOwner() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",ownerControler.delete(id));
    }

    private void findAllOwner() {
        List<Owner> owners = ownerControler.findAll();
        for (Owner owner : owners) {
            System.out.println(owner);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findOwnerById() {
        System.out.println("Enter 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Owner> owner = ownerControler.findById(id);
        System.out.println(owner.orElse(nullOwner));
    }

    private void createPlace() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter country id:");
        Integer country_id = Integer.valueOf(input.nextLine());
        System.out.println("Enter pricing:");
        Integer pricing = Integer.valueOf(input.nextLine());
        Place place =
                new Place(null, name, country_id, pricing);
        System.out.printf("There are created %d rows\n", placeControler.create(place));
    }

    private void updatePlace() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter country id:");
        Integer country_id = Integer.valueOf(input.nextLine());
        System.out.println("Enter pricing:");
        Integer pricing = Integer.valueOf(input.nextLine());
        Place place =
                new Place(null, name, country_id, pricing);
        System.out.printf("There are created %d rows\n", placeControler.update(id, place));
    }

    private void deleteFromPlace() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",placeControler.delete(id));
    }

    private void findAllPlace() {
        List<Place> places = placeControler.findAll();
        for (Place place : places) {
            System.out.println(place);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findPlaceById() {
        System.out.println("Enter 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Place> place = placeControler.findById(id);
        System.out.println(place.orElse(nullPlace));
    }

    private void createTransport() {
        System.out.println("Enter type:");
        String type = input.nextLine();
        System.out.println("Enter route:");
        String route = input.nextLine();
        System.out.println("Enter place id: ");
        Integer place_id = Integer.valueOf((input.nextLine()));
        Transport transport =
                new Transport(null, type, route, place_id);
        System.out.printf("There are created %d rows\n", transportControler.create(transport));
    }

    private void updateTransport() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter type:");
        String type = input.nextLine();
        System.out.println("Enter route:");
        String route = input.nextLine();
        System.out.println("Enter place id: ");
        Integer place_id = Integer.valueOf((input.nextLine()));
        Transport transport =
                new Transport(null, type, route, place_id);
        System.out.printf("There are created %d rows\n", transportControler.update(id, transport));
    }

    private void deleteFromTransport() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",transportControler.delete(id));
    }

    private void findAllTransport() {
        List<Transport> transports = transportControler.findAll();
        for (Transport transport : transports) {
            System.out.println(transport);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findTransportById() {
        System.out.println("Enter 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Transport> transport = transportControler.findById(id);
        System.out.println(transport.orElse(nullTransport));
    }

    private void createTrip() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter user id:");
        Integer user_id = Integer.valueOf(input.nextLine());
        Trip trip =
                new Trip(null, name, user_id);
        System.out.printf("There are created %d rows\n", tripControler.create(trip));
    }

    private void updateTrip() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter user id:");
        Integer user_id = Integer.valueOf(input.nextLine());
        Trip trip =
                new Trip(null, name, user_id);
        System.out.printf("There are created %d rows\n", tripControler.update(id, trip));
    }

    private void deleteFromTrip() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",tripControler.delete(id));
    }

    private void findAllTrip() {
        List<Trip> trips = tripControler.findAll();
        for (Trip trip : trips) {
            System.out.println(trip);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findTripById() {
        System.out.println("Enter 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Trip> trip = tripControler.findById(id);
        System.out.println(trip.orElse(nullTrip));
    }

    private void createUser() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();
        User user =
                new User(null, name, email);
        System.out.printf("There are created %d rows\n", userControler.create(user));
    }

    private void updateUser() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();
        User user =
                new User(null, name, email);
        System.out.printf("There are created %d rows\n", userControler.update(id, user));
    }

    private void deleteFromUser() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",userControler.delete(id));
    }

    private void findAllUser() {
        List<User> users = userControler.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findUserById() {
        System.out.println("Enter 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<User> user = userControler.findById(id);
        System.out.println(user.orElse(nullUser));
    }

    private void selectAll() {
        findAllCountries();
        findAllOwner();
        findAllPlace();
        findAllReview();
        findAllTransport();
        findAllTrip();
        findAllUser();
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Select menu point");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Select menu point");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

}
