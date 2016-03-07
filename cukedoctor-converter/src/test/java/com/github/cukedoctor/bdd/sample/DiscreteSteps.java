package com.github.cukedoctor.bdd.sample;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by rafael-pestano on 07/03/2016.
 */
public class DiscreteSteps {

  @Given("^the following source code$")
  public void the_following_source_code(String code) throws Throwable {
    //it is just a sample, we are interested in json output report
    assertNotNull(code);
  }

  @Given("^the following table$")
  public void the_following_table(String table) throws Throwable {
    assertNotNull(table);
  }
}
