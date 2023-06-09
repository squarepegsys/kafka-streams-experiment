package com.squarepegsystems.kafka.exp

import com.squarepegsystems.kafka.generated.Customer
import spock.lang.Specification

import java.text.SimpleDateFormat

class CustomerMapperTest extends Specification {


   String  sample = "1,DD37Cf93aecA6c,Sheryl,Baxter,Rasmussen Group,East Leonard,Chile,229.077.5154,397.884.0519x718,zunigavanessa@smith.info,2020-08-24,http://www.stephenson.com/"

   String header = "Index,Customer Id,First Name,Last Name,Company,City,Country,Phone 1,Phone 2,Email,Subscription Date,Website"
   CustomerMapper customerMapper = new CustomerMapper()

   SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd")
   def "map customer csv"() {
      when:

      Customer customer = customerMapper.apply(sample)

      then:

      customer.id =='DD37Cf93aecA6c'
      customer.firstName=="Sheryl"
      customer.lastName=="Baxter"
      customer.company=="Rasmussen Group"
      customer.email== "zunigavanessa@smith.info"
      customer.date == df.parse('2020-08-24').toLocalDate()
   }

   def "the header is empty"() {
      when:
      Customer customer = customerMapper.apply(header)

      then:
      customer.id == null
   }
}
