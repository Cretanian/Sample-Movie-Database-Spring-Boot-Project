package com.gmdb.team5.pf7project.bootstrap;

import com.gmdb.team5.pf7project.base.AbstractLogComponent;
import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Role;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class GenerateCastedPerson  extends AbstractLogComponent implements CommandLineRunner {
    private final PersonService personService;
    private final FilmService filmService;

    private Role generateRandomRole(){

        int index  = (new Random()).nextInt(13);
        switch (index) {
            case 1: return Role.Actor;
            case 2: return Role.Director;
            case 3: return Role.Producer;
            case 4: return Role.Writer;
            case 5: return Role.ExecutiveProducer;
            case 6: return Role.AssistantDirector;
            case 7: return Role.FilmEditor;
            case 8: return Role.SoundDesigner;
            case 9: return Role.CostumeDesigner;
            case 10: return Role.CameraOperator;
            case 11: return Role.BoomOperator;
            case 12: return Role.PhotographyDirector;
        }
        return null;
    }

    @Override
    public void run(String... args) {

	// Load customer and create an order by adding/updating/removing content before checking it out
		Film firstFilm = filmService.findByTitle("Pacific Rim");

		// Add item(s) both existing and non-existing
        filmService.addItem(firstFilm, personService.find((long) 1), generateRandomRole());
        filmService.addItem(firstFilm, personService.find((long) 2), generateRandomRole());
        filmService.addItem(firstFilm, personService.find((long) 3), generateRandomRole());
        filmService.addItem(firstFilm, personService.find((long) 4), generateRandomRole());
	/*	// Update item(s)
		orderService.addItem(firstOrder, productService.findBySerial("SN1000-0001"), 1);
		orderService.updateItem(firstOrder, productService.findBySerial("SN1000-0004"), 2);
		// Remove item(s)
		orderService.removeItem(firstOrder, productService.findBySerial("SN1100-0001"));
		// Add some more item(s)
		orderService.addItem(firstOrder, productService.findBySerial("SN1300-0001"), 2);
		// Checkout order
		orderService.checkout(firstOrder, PaymentMethod.CREDIT_CARD);
*//*
		// Second customer and order
		Customer secondCustomer = customerService.findByEmail("john.porter@gmail.com");
		Order secondOrder = orderService.initiateOrder(secondCustomer);
		// Add item(s) to second order
		orderService.addItem(secondOrder, productService.findBySerial("SN1000-0002"), 1);
		orderService.addItem(secondOrder, productService.findBySerial("SN1200-0001"), 1);
		orderService.addItem(secondOrder, productService.findBySerial("SN1200-0001"), 1);
		orderService.addItem(secondOrder, productService.findBySerial("SN1299-0001"), 1);
		// Checkout 2nd order
		orderService.checkout(secondOrder, PaymentMethod.WIRE_TRANSFER);

		// Third customer and order
		Customer thirdCustomer = customerService.findByEmail("malcolm.paker@gmail.com");
		Order thirdOrder = orderService.initiateOrder(thirdCustomer);
		orderService.addItem(thirdOrder, productService.findBySerial("SN1000-0001"), 3);
		orderService.addItem(thirdOrder, productService.findBySerial("SN1000-0002"), 2);
		orderService.addItem(thirdOrder, productService.findBySerial("SN1000-0003"), 1);
		// Checkout 3rd order
		orderService.checkout(thirdOrder, PaymentMethod.CREDIT_CARD);

		// Fourth customer and order
		Customer fourthCustomer = customerService.findByEmail("terry.jones@gmail.com");
		Order fourthOrder = orderService.initiateOrder(fourthCustomer);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1300-0001"), 1);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1400-0001"), 2);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1500-0001"), 1);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1000-0003"), 1);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1000-0004"), 1);
		// Checkout 4th order
		orderService.checkout(fourthOrder, PaymentMethod.CREDIT_CARD);

		// Load
		logger.info("Fourth order: {}.", fourthOrder);
		orderService.deleteById(fourthOrder.getId());

		orderService.findAllLazy().forEach(o -> logger.info("{}", o));

		logger.info("REPORT: Displaying average order cost per customer");
		orderService.findAverageOrderCostPerCustomer().forEach(i -> logger.info("{}", i));

		logger.info("REPORT: Displaying total number of purchases and corresponding cost per customer category");
		orderService.findTotalNumberAndCostOfPurchasesPerCustomerCategory().forEach(
				i -> logger.info("{} was purchased {} times costing in average {}€.", i.getCategory(), i.getPurchases(),
								 i.getCost()));

 */
    }
}
