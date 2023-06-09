package com.squarepegsystems.kafka.exp

import com.squarepegsystems.kafka.generated.Customer
import org.apache.kafka.streams.kstream.ValueMapper

import java.text.SimpleDateFormat

class CustomerMapper implements ValueMapper<String, Customer> {

   private static SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd")
   @Override
   Customer apply(String value) {
      def data = value.split(",")
      if (data[0] == 'Index'){
         return new Customer()
      }
      return new Customer(id: data[1], firstName: data[2],
       lastName: data[3], company: data[4], city: data[5],
         country: data[6], phone1: data[7],phone2: data[8],
         email: data[9], date:df.parse(data[10]).toLocalDate(),
         website: data[10]
      )
   }
}
