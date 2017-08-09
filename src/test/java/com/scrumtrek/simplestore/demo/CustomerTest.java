package com.scrumtrek.simplestore.demo;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeNotNull;

public class CustomerTest {
    	Movie movCinderella;
		Movie movStarWars;
		Movie movGladiator;

    @Before
    public void Before()
    {
        // Create movies
		movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
		movStarWars = new Movie("Star Wars", PriceCodes.Regular);
		movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

    }

    @Test
    public void shouldCreatedWithName_WhenCtrRun() {
        // region Given
        String name = "Ivan";
        // endregion

        // region When
        Customer sut = new Customer(name);
        // endregion

        // region Then
        assertNotNull(sut);
        assertTrue(String.format("Expect name %s, but was %s", name, sut.getName()),
                name.equals(sut.getName()));
        // endregion
    }

    @Test
    public void shouldStatementContainsOneRenterPoints_WhenAddOneRentalElement() {
        // region Given
        String movieTitle = "Black";
        int movieDaysRented = 1;
        String name = "Ivan";

        Customer sutCustomer = new Customer(name);
        assumeNotNull(sutCustomer);

        Movie dummyMovie = new Movie(movieTitle, PriceCodes.NewRelease);
        assumeNotNull(dummyMovie);

        Rental dummyRental = new Rental(dummyMovie, movieDaysRented);
        assumeNotNull(dummyRental);

        sutCustomer.addRental(dummyRental);
        // endregion

        // region Wen
        String statementResult = sutCustomer.Statement();
        // endregion

        // region Then
        assertNotNull(statementResult);
        assertFalse(statementResult.isEmpty());
        assertTrue("Result statement was: " + statementResult,
                statementResult.contains("You earned 1 frequent renter points."));
        // endregion
    }
}
