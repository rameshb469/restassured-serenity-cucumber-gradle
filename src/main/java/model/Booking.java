package model;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;


/**
 * POJO for Booking API Response
 *
 * 
 */
@Getter
@Setter
public class Booking {
	private String firstname;
	private String lastname;
	private int totalprice;
	private BookingDates bookingdates;
	private boolean depositpaid;
	private String additionalneeds;
	Faker faker = new Faker();

	public Booking() {
		this.firstname = faker.name().firstName();
		this.lastname = faker.name().firstName();
		this.totalprice = faker.number().numberBetween(10, 10000);
		this.bookingdates = new BookingDates(LocalDate.now().toString(), LocalDate.now().plusDays(7).toString());
		this.depositpaid = true;
		this.additionalneeds = faker.food().spice();
	}

	public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingdates,
			String additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates == null ? new BookingDates(LocalDate.now().toString(), LocalDate.now().plusDays(7).toString()) : bookingdates;
		this.additionalneeds = additionalneeds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Booking booking = (Booking) o;
		return totalprice == booking.totalprice && depositpaid == booking.depositpaid
				&& Objects.equals(firstname, booking.firstname) && Objects.equals(lastname, booking.lastname)
				&& Objects.equals(bookingdates, booking.bookingdates)
				&& Objects.equals(additionalneeds, booking.additionalneeds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, lastname, totalprice, bookingdates, depositpaid, additionalneeds);
	}
}
